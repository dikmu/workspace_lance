$(function () {
    var alreadySkill = "", new_add_Str = "", add_post_param = [];
    Lancer.profile.getSkillsInfo(function (data) {
        var len = data.length, i = 0, tmp;
        for (i = 0;i < len;i++) {
            tmp = $("#gridtbody .mod-skill").clone().removeClass("mod-skill").show();
            tmp.find(".xh").html(i + 1);
            tmp.find(".skil").html(data[i].Name);
            tmp.find(".chk-icon").attr("checked", data[i].Display ? true : false);
            tmp.find(".btn-delete").data("id", data[i].Uuid);
            $("#gridtbody").append(tmp);
            alreadySkill += data[i].Name + ",";
        }

    },
null);

    //delete skill
    $("#gridtbody").on("click", ".btn-delete", function () {
        var obj = $(this), id = obj.data("id"), pa = obj.closest("tr");
        $.ae("你确定要删除这个技能吗？", function(){
            $.ax("post", "user/skill/delete/" + User.UserName + "/" + id, null, function (data) {
                pa.fadeOut(300, function () {
                    pa.remove();
                    alreadySkill = alreadySkill.replace(pa.find(".skil").html(), "");
                    $("#gridtbody .xh").each(function (index, ele) {
                        $("#gridtbody .xh")[index].innerHTML = index;
                    });
                });
            },
            function () {
                netWorkError();
            },
"text");
        });
    });

    var checkSkillExist = function(val){
        var arr_skils = alreadySkill.split(','), isExist = false;
        $.each(arr_skils, function(i, dom){
            if(dom != "" && dom == val){
                isExist = true;
            }
        });
        return isExist;
    };

    //add skills
    $("#inp_addnew").keydown(function (e) {
        var obj = $(this);
        if (e.keyCode == 13 || e.keyCode == 9) {
            if (obj.val() != "" && checkSkillExist(obj.val()) == false) {
                tmp = $(".pskills .mod-skill").clone().removeClass("mod-skill").show();
                tmp.data("value", obj.val()).html(obj.val() + '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>');

                $("#inp_addnew").before(tmp);
                alreadySkill += obj.val() + ",";
                new_add_Str += obj.val() + ",";
                obj.val("");
            }
            else {
                $.ae("“" + obj.val() + "”技能已经添加");
            }
        }
    });
    //delete str
    $(".pskills").on("click", ".glyphicon", function () {
        var pa = $(this).closest(".btn-xs"), repstr = pa.data("value") + ",";
        pa.remove();
        alreadySkill = alreadySkill.replace(repstr, "");
        new_add_Str = new_add_Str.replace(repstr, "");
    });

    

    $("#btn_confirm_add").click(function () {
        var arr_names = new_add_Str.split(",");
        len = arr_names.length;
        
        var totalLen = $("#gridtbody tr").length - 1;
        
        add_post_param = [];
        
        for (i = 0;i < len;i++) {
            if (arr_names[i] != "") {
                add_post_param.push( {
                    "Name" : arr_names[i]
                });
                totalLen ++;
            }
        }
        if(totalLen > 10){
            $.ae("技能最多添加10条");
            return;
        }
        if(new_add_Str != ""){
            //ajax
            $.ax("post", "user/skill/batch/" + User.UserName, add_post_param, function (cdata) {
                
                $.ae("添加成功", function(){location.reload();});
                
            },
            function () {
                netWorkError();
            }, "text");
        }
    });

});