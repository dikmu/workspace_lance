function init_category(){
    $.ax("get", "jobTemplate/jobCategory", null, function(data){
        var len = data.length, i = 0, str = "";
        for(i=0;i<len;i++){
            str += '<option value="'+data[i].Uuid+'">'+(data[i].NameCn ? data[i].NameCn : data[i].NameEn)+'</option>';
        }
        $("#cate-lev1").append(str);
        
        $("#tmp_cate").append(str);
    }, function(){
        netWorkError();
    });

    $("#cate-lev1").change(function () {
        var value = $(this).val();
        if (value != -1) {
            //ajax level2
            $("#cate-lev2").append('<option class="tmp" selected="selected">请稍后...</option>');
            $.ax("get", "jobTemplate/jobSubCategory/" + value, null, function(data){
                var len = data.length, i = 0, str = "";
                for(i=0;i<len;i++){
                    str += '<option value="'+data[i].Uuid+'">'+(data[i].NameCn ? data[i].NameCn : data[i].Name)+'</option>';
                }
                $("#cate-lev2 option").not(".mod").remove();
                $("#cate-lev2").append(str);
            }, function(){
                netWorkError();
            });
        } else {
            $("#inp_key_cate").attr("disabled", true).val("请先选择上面的工作分类");
        }
    });
    $("#cate-lev2").change(function () {
        var value = $(this).val();
        if (value != -1) {
            //ajax list
            $("#inp_key_cate").attr("disabled", false).val("");
        } else {
            $("#inp_key_cate").attr("disabled", true).val("请先选择上面的工作分类");
        }
    });
}

function postJobLocation(){
    $.ax("get", "location/province", null, function(data){
        var len = data.length, i = 0, str = "";
        for(i=0;i<len;i++){
            str += '<option value="'+data[i].Uuid+'">'+data[i].ProvinceName+'</option>';
        }
        $("#sel_province").html(str);
        $("#sel_province").change();
    }, function(){});
    
    $(".sel-location").hide();
    $("#job_yc").click(function(){
        if($(this)[0].checked){
            $(".sel-location").slideUp();
        }
    });
    $("#job_xc").click(function(){
        if($(this)[0].checked){
            $(".sel-location").slideDown();
        }
    });
    
    $("#sel_province").change(function(){
        var v = $(this).val();
        if(v != -1){
            $("#sel_city").html('<option>请稍后...</option>');
            $.ax("get", "location/cityByProvince/"+v, null, function(data){
                 var len = data.length, i = 0, str = "";
                for(i=0;i<len;i++){
                    str += '<option value="'+data[i].Uuid+'">'+data[i].CityName+'</option>';
                }
                $("#sel_city").html(str);
            }, function(){});
        }
    });
}

var sel_skills = "", sel_count = 0;;
function initSearchSkills(){
    $("#inp_key_cate").postInputSearch(function(data){
        if(data != null){
            var ul = $("#inp_key_cate").closest(".post-container").find(" ul"),len = data.length, i = 0, str = "";
            for(i=0;i<len;i++){
                str += '<li><a>'+data[i].Name+'</a></li>';
            }
            ul.html(str);
        }
    });
    
    $(".list-search").on("click", "li", function(){
        var str = $(this).text();
        if(sel_count < 5 && sel_skills.indexOf(str) < 0){
            sel_skills += str + ",";
            $(".list-sel-skill").append('<span data-str="'+str+'" class="bold-text">'+str+'<span class="cls glyphicon glyphicon-remove"></span></span>');
            sel_count ++;
        }
    });
    
    $(".list-sel-skill").on("click", ".cls", function(){
        var pa = $(this).closest(".bold-text"), str = pa.attr("data-str") + ",";
        sel_skills = sel_skills.replace(str, "");
        pa.fadeOut(function(){pa.remove();sel_count--;});
    });
}

function init_workArrange(){
    $(".sel-arrange").change(function(){
        var value = $(this).val(), pa = $(this).parent();
        if(value == 'hourly'){
            pa.find(".smlp").show();
            pa.find(".lbl-money").html("时薪范围：");
        }else{
            pa.find(".smlp").hide();
            pa.find(".lbl-money").html("固定价格：");
            $(".er-work").html("");
        }
    });
}

var basicRes = {
    "title" : false,
    "content" : false,
    "cate" : false,
    "scate" : false,
    "money" : false,
    "date" : false
};

function checkForm(){
    var uname = $("#inp_jobname");
    uname.blur(function(){
        uname.popover("hide");
        uname.closest(".form-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
        
        if(uname.lanCheck('notEmpty')){
            uname.closest(".form-group").addClass("has-success").addClass("has-feedback");
            basicRes.title = true;
        }else{
            uname.attr("data-content", "例：对外项目，招聘独立IT架构师").popover("show");
            uname.closest(".form-group").addClass("has-error");
            basicRes.title = false;
        }
    });
    
    var udetail = $("#inp_detail");
    udetail.blur(function(){
        udetail.popover("hide");
        udetail.closest(".form-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
        
        if(udetail.val() != "" && udetail.val().length > 10){
            udetail.closest(".form-group").addClass("has-success").addClass("has-feedback");
            basicRes.content = true;
        }else{
            udetail.attr("data-content", "工作内容不能少于10字").popover("show");
            udetail.closest(".form-group").addClass("has-error");
            basicRes.content = false;
        }
    });
    
    var cate = $("#cate-lev1");
    cate.blur(function(){
        cate.popover("hide");
        cate.closest(".form-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
        
        if(cate.lanCheck('notEmpty') && !('-1' == cate.val())){
            cate.closest(".form-group").addClass("has-success").addClass("has-feedback");
            basicRes.cate = true;
        }else{
            cate.attr("data-content", "工作分类大类必须选择!").popover("show");
            cate.closest(".form-group").addClass("has-error");
            basicRes.cate = false;
        }
    });
    
    var cate_s = $("#cate-lev2");
    cate_s.blur(function(){
        cate_s.popover("hide");
        cate_s.closest(".form-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
        if(cate_s.lanCheck('notEmpty') && !('-1' == cate_s.val())){
            cate_s.closest(".form-group").addClass("has-success").addClass("has-feedback");
            basicRes.scate = true;
        }else{
            cate_s.attr("data-content", "工作分类大类必须选择!").popover("show");
            cate_s.closest(".form-group").addClass("has-error");
            basicRes.scate = false;
        }
    });
    
}

function postJobInputCheck(){
    var moneyMin = 10, workHourMin = 0, regular = /^[0-9]+$/;
    $(".sel-arrange").change(function(){
        if($(this).val() == 1){
            moneyMin = 10;
        }else{
            moneyMin = 80;
        }
    });
    
    var checkMonty = function(){
        var start = $(".sx-start"), v = start.val(),
            end = $(".sx-end"), ve = end.val(), n1 = 0, n2 = 0;
        
        var show_err = $(".sx-end");
        show_err.popover("hide");
        show_err.closest(".sxfw").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
            
        //if(v != ""){
            if(!regular.test(v)){
                show_err.attr("data-content", "请输入正确的薪酬").popover("show");
                show_err.closest(".sxfw").addClass("has-error");
                basicRes.money = false;
            }else if(Number(v) < moneyMin){
                show_err.attr("data-content", "薪酬不可小于" + moneyMin +  "元").popover("show");
                show_err.closest(".sxfw").addClass("has-error");
                basicRes.money = false;
            }else{
                show_err.closest(".sxfw").addClass("has-success").addClass("has-feedback");
            }
        //}
        //if(ve != ""){
            if(!regular.test(ve)){
                show_err.attr("data-content", "请输入正确的薪酬").popover("show");
                show_err.closest(".sxfw").addClass("has-error");
                basicRes.money = false;
            }else if(Number(ve) < moneyMin){
                show_err.attr("data-content", "薪酬不可小于" + moneyMin +  "元").popover("show");
                show_err.closest(".sxfw").addClass("has-error");
                basicRes.money = false;
            }else{
                show_err.closest(".sxfw").addClass("has-success").addClass("has-feedback");
            }
        //}
        //if(v != "" && ve != ""){
            n1 = Number(v);
            n2 = Number(ve);
            if(n1 >= n2){
                show_err.attr("data-content", "请输入正确的薪酬范围").popover("show");
                show_err.closest(".sxfw").addClass("has-error");
                basicRes.money = false;
            }else{
                show_err.closest(".sxfw").addClass("has-success").addClass("has-feedback");
                basicRes.money = true;
            }
        //}
    };
    
    $(".sx-start, .sx-end").blur(function(){
        checkMonty();
    });
    
    var checkZhouqi = function(){
        var start = $(".work-zq"), v = start.val(),
            end = $(".work-zq2"), ve = end.val(), n1 = 0, n2 = 0;
            
        end.popover("hide");
        end.closest(".smlp").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
        
        //if(v != ""){
            if(!regular.test(v)){
                end.attr("data-content", "请输入正确的周期").popover("show");
                end.closest(".smlp").addClass("has-error");
                basicRes.date = false;
            }else{
                end.closest(".smlp").addClass("has-success");
            }
        //}
        //if(ve != ""){
            if(!regular.test(ve)){
                end.attr("data-content", "请输入正确的周期").popover("show");
                end.closest(".smlp").addClass("has-error");
                basicRes.date = false;
            }else{
                end.closest(".smlp").addClass("has-success");
            }
        //}
        //if(v != "" && ve != ""){
            n1 = Number(v);
            n2 = Number(ve);
            if(n1 >= n2){
                end.attr("data-content", "请输入正确的周期范围").popover("show");
                end.closest(".smlp").addClass("has-error");
                basicRes.date = false;
            }else{
                end.closest(".smlp").addClass("has-success");
                basicRes.date = true;
            }
        //}
    };
    
    $(".work-zq, .work-zq2").blur(function(){
        checkZhouqi();
    });
    
    $(".work-hour").blur(function(){
        var obj = $(this), v = obj.val();
        
        obj.popover("hide");
        obj.closest(".smlp").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
        
        if(v != ""){
            if(!regular.test(v)){
                obj.attr("data-content", "请输入正确的工作时间").popover("show");
                obj.closest(".smlp").addClass("has-error");
            }else if(Number(v) <= workHourMin){
                obj.attr("data-content", "工作时间不可小于" + workHourMin).popover("show");
            }else{
               obj.closest(".smlp").removeClass("has-error").removeClass("has-success")
            }
        }
    });
    
    $(".work-zq").blur(function(){
        var obj = $(this), v = obj.val();
        if(v != ""){
            if(!regular.test(v)){
                obj.css("border-color", "#f00");
                $(".er-work").html("请输入正确的周期");
            }else if(Number(v) <= workHourMin){
                obj.css("border-color", "#f00");
                $(".er-work").html("周期不可小于" + workHourMin);
            }else{
                obj.css("border-color", "#ccc");
                $(".er-work").html("");
            }
        }
    });
}

var post_job_param = {};
var sel_skills = "", sel_count = 0;;
function init_click(){
    var timeAddDay = function(dd,dadd){  
        var a = dd;
        a = a.valueOf();
        a = a + dadd * 24 * 60 * 60 * 1000;
        a = new Date(a);
        return a.getFullYear() + "-" + (a.getMonth() + 1) + "-" + a.getDate();  
    };

    var getPostDates = function(){
        var result = [];
        if($("#jim")[0].checked){
            var mdate = new Date(), year = mdate.getFullYear(), month = mdate.getMonth() + 1, day = mdate.getDate(), addDay = $("#add_days").val();
            var start = year + "-" + month + "-" + day, end = timeAddDay(mdate, addDay);
            result = [start, end];
        }
        if($("#jsel")[0].checked){
            var start = $("#startTime").val(), addDay = $("#add_days").val(), end = timeAddDay(new Date(start.replace("-", "/")), addDay);
            result = [start, end];
        }
        return result;
    };
    
    var setSpecialSkill = function(m_param){
        var arr_skil = sel_skills.split(",");
        for(var j=0;j<arr_skil.length;j++){
            if(arr_skil[j] != ""){
                if(j == 0){
                    m_param.SpecificSkillA = arr_skil[j];
                }
                if(j == 1){
                    m_param.SpecificSkillB = arr_skil[j];
                }
                if(j == 2){
                    m_param.SpecificSkillC = arr_skil[j];
                }
                if(j == 3){
                    m_param.SpecificSkillD = arr_skil[j];
                }
                if(j == 4){
                    m_param.SpecificSkillE = arr_skil[j];
                }
            }
        }
        return m_param;
    };
    
    var setArrange = function(m_param){
        if(m_param.Postform == "hourly"){//Hourly
            if($(".sx-start").val() != ""){
                m_param.HourlyPayMin = $(".sx-start").val();
            }
            if($(".sx-end").val() != ""){
                m_param.HourlyPayMax = $(".sx-end").val();
            }
            if($(".work-hour").val() != ""){
                m_param.WeeklyHours = $(".work-hour").val();
            }
            if($(".work-zq").val() != ""){
                m_param.DurationMin = $(".work-zq").val();
            }
            if($(".work-zq2").val() != ""){
                m_param.DurationMax = $(".work-zq2").val();
            }
        }else{
            if($(".sx-start").val() != ""){
                m_param.FixedPayMin = $(".sx-start").val();
            }
            if($(".sx-end").val() != ""){
                m_param.FixedPayMax = $(".sx-end").val();
            }
        }
        return m_param;
    };
    
    var setOption = function(m_param){
//        if($("#jpublic")[0].checked){
//            m_param.JobVisibility = "public";
//            if($("#chk_search")[0].checked){
//                m_param.AllowSearchEngines = "Y";
//            }else{
//                m_param.AllowSearchEngines = "N";
//            }
//        }
//        if($("#jprivate")[0].checked){
//            m_param.JobVisibility = "private";
//        }
        //set location
        if($("#job_xc")[0].checked){
            m_param.FixedLocation = "Y";
            m_param.LocationProvince = $("#sel_province").val();
            m_param.LocationCity = $("#sel_city").val();
            m_param.LocationCountry = 44;//default China
            if($("#inp_locDesc").val() != ""){
                m_param.LocationDesc = $("#inp_locDesc").val();
            }
        }else{
            m_param.FixedLocation = 'N';
        }
        //set email frequance
        if($("#epush_day")[0].checked){
            m_param.SubscribeFrequency="week";
        }else if($("#epush_week")[0].checked){
            m_param.SubscribeFrequency="day";
        }else if($("#epush_no")[0].checked){
            m_param.SubscribeFrequency="no";
        }
        if($("#epush_freq")[0].checked){
            m_param.SubscribeUpdate="Y";
        }else {
            m_param.SubscribeUpdate="N";
        }
        
        return m_param;
    };
    
    
    $(".btn_sace,.btn_sace2").click(function(){
        var obj = $(this), type = obj.attr("data-val");
        if(basicRes.title && basicRes.content && basicRes.cate && basicRes.scate && basicRes.money){
//            btn.button('loading');
            var times = getPostDates();
            
            post_job_param.Name = $("#inp_jobname").val();
            post_job_param.Brief = $("#inp_detail").val();
            post_job_param.WorkCategory = $("#cate-lev1").val();
            post_job_param.WorkSubcategory = $("#cate-lev2").val();
            post_job_param.Postform = $(".sel-arrange").val();
            post_job_param.PostJobDateStart = times[0];
            post_job_param.PostJobDateEnd = times[1];
            post_job_param = setSpecialSkill(post_job_param);
            post_job_param = setArrange(post_job_param);
            post_job_param = setOption(post_job_param);
            post_job_param.Status = type;
            if($(".sel-arrange").val() == "hourly"){
                if(basicRes.date){
                    //alert(post_job_param);
                    if(type == 'draft'){
                        postAjax(post_job_param, function(data){
        //                    obj.button("reset");
                        });     
                    }else{  
                        $(".step1").fadeOut(function(){$(".step2").fadeIn();$(".apply_temp").hide();$(".step_sp").removeClass("one").removeClass("two").removeClass("three").addClass("two");});
                        
                        $(".step-xh small").removeClass("lan-font-green");
                        $(".step-xh small:eq(1)").addClass("lan-font-green");
                    }
                }else{
                    $(".work-zq, .work-zq2").blur();
                }
            }else{
                //alert(post_job_param);
                if(type == 'draft'){
                    postAjax(post_job_param, function(data){
    //                    obj.button("reset");
                    });     
                }else{  
                     //alert('---');
                    $(".step1").fadeOut(function(){$(".step2").fadeIn();$(".apply_temp").hide();$(".step_sp").removeClass("one").removeClass("two").removeClass("three").addClass("two");});
                    
                    $(".step-xh small").removeClass("lan-font-green");
                    $(".step-xh small:eq(1)").addClass("lan-font-green");
                }
            }
        }else{
            $("#inp_jobname,#inp_detail,#cate-lev1,#cate-lev1").blur();
            $(".sx-start, .sx-end").blur();
        }
    });
}

function initStep2(){
     $(".btn-select").click(function(){
        var type = $(this).attr("data-type"), trstr = "";
        
        trstr += '<tr><td align="right" class="col1" width="100px"><b>工作名称:</b></td><td class="col2">'+$("#inp_jobname").val()+'</td></tr>';
        trstr += '<tr><td align="right" class="col1"><b>工作描述:</b></td><td class="col2"><pre>'+$("#inp_detail").val()+'</pre></td></tr>';
        trstr += '<tr><td align="right" class="col1"><b>工作类别:</b></td><td class="col2">'+$("#cate-lev1").find("option:selected").text()+' -- '+$("#cate-lev2").find("option:selected").text()+'</td></tr>';
        
        if(sel_skills != ""){
            trstr += '<tr><td align="right" class="col1"><b>特别技能:</b></td><td class="col2">'+sel_skills.replace(/,/g, "<br />")+'</td></tr>';
        }
        
        if(post_job_param.Postform == 1){
            trstr += '<tr><td align="right" class="col1"><b>工作安排:</b></td><td class="col2">时薪</td></tr>';
        }else{
            trstr += '<tr><td align="right" class="col1"><b>工作安排:</b></td><td class="col2">固定薪水</td></tr>';
        }
        if($(".sx-start").val() != ""){
            trstr += '<tr><td align="right" class="col1"><b>薪水范围:</b></td><td class="col2">'+$(".sx-start").val()+' -- ' +$(".sx-end").val()+ '</td></tr>';
        }
        if($(".work-hour").val() != ""){
            trstr += '<tr><td align="right" class="col1"><b>周工作时间:</b></td><td class="col2">'+$(".work-hour").val()+'</td></tr>';
        }
        if($(".work-zq").val() != ""){
            trstr += '<tr><td align="right" class="col1"><b>工作周期:</b></td><td class="col2">'+$(".work-zq").val()+' -- ' +$(".work-zq2").val()+ '</td></tr>';
        }
        trstr += '<tr><td align="right" class="col1"><b>公开情况:</b></td><td class="col2">'+(post_job_param.JobVisibility == 'public' ? '开放给所有驻才网用户' : '不要公开显示，只有被我邀请的候选人才能看到')+'</td></tr>';
        if(post_job_param.JobVisibility == 'public'){
            trstr += '<tr><td align="right" class="col1"><b>是否允许此信息出现在百度、谷歌等搜索引擎上:</b></td><td class="col2">'+(post_job_param.AllowSearchEngines == 1 ? '是' : '否')+'</td></tr>';
        }
        trstr += '<tr><td align="right" class="col1"><b>是否需要到达现场进行工作:</b></td><td class="col2">'+(post_job_param.FixedLocation == 'Y' ? '是' : '否')+'</td></tr>';
        if(post_job_param.FixedLocation == 'Y'){
            trstr += '<tr><td align="right" class="col1"><b>工作地点:</b></td><td class="col2">'+$("#sel_province").find("option:selected").text()+' -- ' +$("#sel_city").find("option:selected").text()+ '<br />' +$("#inp_locDesc").val()+ '</td></tr>';
        }
        trstr += '<tr><td align="right" class="col1"><b>工作起止时间:</b></td><td class="col2">'+post_job_param.PostJobDateStart+' -- ' +post_job_param.PostJobDateEnd+ '</td></tr>';
        
        $(".job-preview").html(trstr);
        $(".step2").fadeOut(function(){$(".step3").show();$(".step_sp").removeClass("one").removeClass("two").removeClass("three").addClass("three");});
        $(".step-xh small").removeClass("lan-font-green");
        $(".step-xh small:eq(2)").addClass("lan-font-green");
    });
}


var postAjax = function(m_param, cback){
    $.ax("post", "postJob", m_param, function(data){
        $.ae("发布成功！");
        $("#btn_return_job,#btn_save_job").hide();
        setTimeout(function(){
            window.location.href = '/lance/pages/jobDetail/'+data.result;
        }, 1500);
        cback(data);
    }, function(){
        netWorkError();
        cback(null);
    });
};

function init_step3(){
    $(".btn_return").click(function(){
        $(".step3").fadeOut(function(){$(".step1").show();$(".apply_temp").show();$(".step_sp").removeClass("one").removeClass("two").removeClass("three").addClass("one");});
        $(".step-xh small").removeClass("lan-font-green");
        $(".step-xh small:eq(0)").addClass("lan-font-green");
    });
    
    
    
    $("#btn_save_job").click(function(){
        var type = 2, obj = $(this);
        post_job_param.Status = "posted";
        
        //obj.button('loading');
        
        postAjax(post_job_param, function(data){
            obj.addClass("clickable").removeClass("btn-load");
            
           // obj.button("reset");
        });
    });
}

function init_template(){
    $(".apply_temp").click(function(){
        $("#job-template").animate({"right" : "100px"}, 500).show();
    });
    
    $("#job-template .btn-close").click(function(){
        $("#job-template").animate({"right" : "-600px"}, 500, function(){
            $(this).hide();
        });
    });
    
    $("#tmp_cate").change(function(){
        var id = $(this).val();
        if(id != -1){
            getTemplates(id)
        }
    });
    
    var selCard = function (callback, obj) {
        var clone = obj.clone().addClass("tmp-card").removeClass("card");
        clone.css({
            "position": "absolute",
            "top": obj.offset().top,
            "left": obj.offset().left,
            "z-index": 9999,
            "opacity": 1
        });
        $("#t_con").append(clone);
        clone.animate({
            "top": "50%",
            "left": "50%",
            "width": "10px",
            "height": "10px",
            "opacity": 0.1
        }, 700, function () {
            clone.remove();
            callback();
        });
    };
    
    var setTemplateInfo = function(pages){
        var i = 0, str = "";
        for(i=0;i<pages;i++){
            if(i == 0){
                str += '<div data-pg="0px" class="pg pgon">1</div>';
            }else{
                str += '<div data-pg="'+(-1*i*320)+'px" class="pg">'+(i+1)+'</div>';
            }
        }
        $(".list-pages").html(str);
        //page change event 
        $(".tmp-page .pg").click(function () {
            var pg = $(this).attr("data-pg");
            $(this).parent().parent().find(".pg-con").animate({ "left": pg }, 300);
            $(this).parent().parent().find(".tmp-page .pg").removeClass("pgon");
            $(this).addClass("pgon");
        });
        //card click event
        $(".tmp-cards .card").click(function () {
            var obj = $(this);
            selCard(function () {
                $(".tmp-cards .card").removeClass("sel");
                obj.addClass("sel");
                //set current selected template
                $(".selected-tmp").html(obj.clone().addClass("sel").append('<div class="remove undo"></div>'));
                $(".selected-title,.selected-tmp").fadeIn();
    
                $("#inp_detail").val(obj.attr("data-desc"));
                //$(".cancle-temp").show();
                //refreash body
                /* $(".original").fadeOut(300, function () {
                    $(".undo").show();
                    $(".original").fadeIn(300, function () {
                        $("#inp_detail").val(obj.attr("data-desc"));
                    });
                }); */
            }, obj);
        });
    };
    $(".cancle-temp").click(function(){
        $("#inp_detail").val("");
        $(this).hide();
    });
    
    var getTemplates = function(id){
        $.ax("get", "jobTemplate/jobTemplate/" + id, null, function(data){
            var len = data.length, i = 0, str = "", page_count = 9, pages = Math.ceil(len / page_count), p = 0, tmplen = page_count, ind = 0;
            for(p=0;p<pages;p++){
                str += ' <div class="tmp-cards f-left">';
                if(p == pages - 1){
                    tmplen = len - page_count * p;
                }
                for(i=0;i<tmplen;i++){
                    ind = page_count * p + i;
                    str += '<div data-desc="'+(data[ind].DescriptionEn ? data[ind].DescriptionEn : '尚未添加')+'" title="'+data[ind].Tips+'" style="width:320px;height:50px;" class="card btn btn-default btn-lg btn-block"><div class="glyphicon glyphicon-lock"></div><div class="txt chfont">';
                    str += ' <b class="title">'+data[ind].NameEn+'</b><br /><span>'+(data[ind].Type == 1 ? '职位' : '项目')+'</span>';
                    str += '</div></div>';
                }
                str += '</div>';
            }
            $(".list-templates").html(str).css("width", pages * 330);
            setTemplateInfo(pages);
            $(".tmp-count").html('模板（'+len+'个）');
        }, function(){});
    };
}

function init_chk(){
    $("#jprivate").click(function(){
        if(this.checked){
            $("#chk_search").attr("disabled", true)[0].checked = false;
        }
    });
    $("#jpublic").click(function(){
        if(this.checked){
            $("#chk_search").attr("disabled", false)[0].checked = true;
        }
    });
}


$(function(){
    init_category();
    
    postJobLocation();
    
    initSearchSkills();
    
    init_workArrange();
    
    $(".inp_date").datepicker({dateFormat : "yy-mm-dd"});
    
    checkForm();
    
    postJobInputCheck();
    
    init_click();
    
    initStep2();
    
    init_step3();
    
    init_template();
    
    init_chk();
});