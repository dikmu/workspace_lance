$(function(){
    if(!User.logined || User.UserName != Data.User.User.UserName){
        $(".btn-edit,.btn-xs").remove();
        $(".lan-main-left").remove();
        $(".lan-main-right").removeClass("col-md-9").addClass("col-md-12").css("border-left", "none");
    }
});

//init functions
function InitLicenMod(dat){
    var pa = $(".licens .list-jobs"), tmp = null;
    if(dat.StartDate){
        dat.StartDate = dat.StartDate.split(' ')[0];
    }
    if(dat.EndDate){
        dat.EndDate = dat.EndDate.split(' ')[0];
    }
    if(!dat.RegAddress){
        dat.RegAddress = "#";
    }
    tmp = pa.find(".hidemod").clone().removeClass("hidemod").data("data", dat);
    tmp.attr("id", "licen_" + dat.Uuid);
    tmp.find(".licen-name").html(dat.Name).attr("href", dat.RegAddress);
    tmp.find(".licen-time").html(dat.StartDate + '&nbsp;&nbsp;至&nbsp;&nbsp;' + dat.EndDate);
    tmp.find(".licen-org").html("认证机构：" + dat.RegOrganization);
    tmp.find(".licen-loc").html("认证号码：" + dat.RegNumber);
    tmp.find(".txt").html(dat.Content);
    pa.append(tmp);
}
function UpdateLicenMod(dat){
    var cur_mod = $("#licen_" + dat.Uuid);
    cur_mod.find(".progress").show().find(".progress-bar").animate({"width" : "100%"}, 500);
    setTimeout(function(){
        cur_mod.find(".progress").fadeOut(function(){
            $(this).find(".progress-bar").css("width", "0%")
        });
        
        cur_mod.find(".licen-name").html(dat.Name).attr("href", dat.RegAddress);
        cur_mod.find(".licen-time").html(dat.StartDate + '&nbsp;&nbsp;至&nbsp;&nbsp;' + dat.EndDate);
        cur_mod.find(".licen-org").html("认证机构：" + dat.RegOrganization);
        cur_mod.find(".licen-loc").html("认证号码：" + dat.RegNumber);
        cur_mod.find(".txt").html(dat.Content);
    }, 1100);
}
function DeleteLicenMod(dat){
    var cur_mod = $("#licen_" + dat.Uuid);
    cur_mod.find(".progress").show().find(".progress-bar").animate({"width" : "100%"}, 500);
    setTimeout(function(){
        cur_mod.slideUp();
    }, 1100);
}

function InitJobMod(dat){
    var pa = $(".jobs .list-jobs"), tmp = null;
    if(dat.StartDate){
        dat.StartDate = dat.StartDate.split(' ')[0];
    }
    if(dat.EndDate){
        dat.EndDate = dat.EndDate.split(' ')[0];
    }
    if(!dat.ProjectAddress){
        dat.ProjectAddress = "#";
    }
    tmp = pa.find(".hidemod").clone().removeClass("hidemod").data("data", dat);
    tmp.attr("id", "job_" + dat.Uuid);
    
    if(dat.StartDate){
        tmp.find(".job-time").html(dat.StartDate + '&nbsp;&nbsp;至&nbsp;&nbsp;' + dat.EndDate);
    }
    tmp.find(".job-name").html(dat.Name).attr("href", dat.ProjectAddress);
    tmp.find(".job-title").html(dat.Title);
    tmp.find(".txt").html(dat.Content);
    pa.append(tmp);
}
function UpdateJobMod(dat){
    var cur_mod = $("#job_" + dat.Uuid);
    cur_mod.find(".progress").show().find(".progress-bar").animate({"width" : "100%"}, 500);
    setTimeout(function(){
        cur_mod.find(".progress").fadeOut(function(){
            $(this).find(".progress-bar").css("width", "0%")
        });
        
        if(dat.StartDate){
            cur_mod.find(".job-time").html(dat.StartDate + '&nbsp;&nbsp;至&nbsp;&nbsp;' + dat.EndDate);
        }
        cur_mod.find(".job-name").html(dat.Name).attr("href", dat.ProjectAddress);
        cur_mod.find(".job-title").html(dat.Title);
        cur_mod.find(".txt").html(dat.Content);
    }, 1100);
}
function DeleteJobMod(dat){
    var cur_mod = $("#job_" + dat.Uuid);
    cur_mod.find(".progress").show().find(".progress-bar").animate({"width" : "100%"}, 500);
    setTimeout(function(){
        cur_mod.slideUp();
    }, 1100);
}
function InitEduMod(dat){
    var pa = $(".edus .list-jobs"), tmp = null;
    if(dat.StartDate){
        dat.StartDate = dat.StartDate.split(' ')[0];
    }
    if(dat.EndDate){
        dat.EndDate = dat.EndDate.split(' ')[0];
    }
    tmp = pa.find(".hidemod").clone().removeClass("hidemod").data("data", dat);
    tmp.attr("id", "edu_" + dat.Uuid);
    tmp.find(".edu-school").html(dat.InstitutionName);
    if(dat.StartDate){
        tmp.find(".edu-date").html(dat.StartDate + '&nbsp;&nbsp;至&nbsp;&nbsp;' + dat.EndDate);
    }
    tmp.find(".edu-dre").html(dat.DegreeType);
    tmp.find(".txt").html(dat.Description);
    pa.append(tmp);
}
function UpdateEduMod(dat){
    var cur_mod = $("#edu_" + dat.Uuid);
    cur_mod.find(".progress").show().find(".progress-bar").animate({"width" : "100%"}, 500);
    setTimeout(function(){
        cur_mod.find(".progress").fadeOut(function(){
            $(this).find(".progress-bar").css("width", "0%")
        });
        cur_mod.find(".edu-school").html(dat.InstitutionName);
        if(dat.StartDate){
            cur_mod.find(".edu-date").html(dat.StartDate + '&nbsp;&nbsp;至&nbsp;&nbsp;' + dat.EndDate);
        }
        cur_mod.find(".edu-dre").html(dat.DegreeType);
        cur_mod.find(".txt").html(dat.Description);
    }, 1100);
}
function DeleteEduMod(dat){
    var cur_mod = $("#edu_" + dat.Uuid);
    cur_mod.find(".progress").show().find(".progress-bar").animate({"width" : "100%"}, 500);
    setTimeout(function(){
        cur_mod.slideUp();
    }, 1100);
}
function InitWorkMod(dat){
    var pa = $(".works .list-jobs"), tmp = null;
    if(dat.StartDate){
        dat.StartDate = dat.StartDate.split(' ')[0];
    }
    if(dat.EndDate){
        dat.EndDate = dat.EndDate.split(' ')[0];
    }
    tmp = pa.find(".hidemod").clone().removeClass("hidemod").data('data', dat);
    tmp.attr("id", "work_" + dat.Uuid);
    tmp.find(".com-name").html(dat.Name);
    if(dat.StartDate){
        tmp.find(".com-time").html(dat.StartDate + '&nbsp;&nbsp;至&nbsp;&nbsp;' + dat.EndDate);
    }else{
        tmp.find(".com-time").html('尚未填写时间');
    }
    tmp.find(".com-zw").html(dat.Title);
    tmp.find(".com-loc").html(dat.WorkArea);
    tmp.find(".txt").html(dat.Content);
    pa.append(tmp);
}
function UpdateWorkMod(dat){
    var cur_mod = $("#work_" + dat.Uuid);
    cur_mod.find(".progress").show().find(".progress-bar").animate({"width" : "100%"}, 500);
    setTimeout(function(){
        cur_mod.find(".progress").fadeOut(function(){
            $(this).find(".progress-bar").css("width", "0%")
        });
        cur_mod.find(".com-name").html(dat.Name);
        if(dat.StartDate){
            cur_mod.find(".com-time").html(dat.StartDate + '&nbsp;&nbsp;至&nbsp;&nbsp;' + dat.EndDate);
        }else{
            cur_mod.find(".com-time").html('尚未填写时间');
        }
        cur_mod.find(".com-zw").html(dat.Title);
        cur_mod.find(".com-loc").html(dat.WorkArea);
        cur_mod.find(".txt").html(dat.Content);
    }, 1100);
}
function DeleteWorkMod(dat){
    var cur_mod = $("#work_" + dat.Uuid);
    cur_mod.find(".progress").show().find(".progress-bar").animate({"width" : "100%"}, 500);
    setTimeout(function(){
        cur_mod.slideUp();
    }, 1100);
}

$(function(){
    var initHeader = function(){
        $('.hd-name').html(User.DisplayName);
    };
    
    
    var initUser = function(){
        $(".uname").html(User.DisplayName + (Data.User.User.hasOwnProperty("JobTitle") ? '-'+Data.User.User.JobTitle : ''));
        $(".utitle").html(Data.User.User.Tagline);
        $(".uself").html(Data.User.User.Overview);
        
        $("#exp_money").html(Data.User.User.HourlyRate || "尚未确定");
        $("#mysite").html(Data.User.User.WebsiteUrl || "尚未填写");
        $("#tgservice").html(Data.User.User.ServiceDescription || "尚未填写");
        $("#paycondition").html(Data.User.User.PaymentTerms || "尚未填写");
        
        $("#contact_email").html(Data.User.User.ImNumberB || "尚未填写");
        $("#contact_qq").html(Data.User.User.ImNumberA || "尚未填写");
        $("#cellphone").html(Data.User.User.PhoneNumber || "尚未填写");
        $("#contact_other").html(Data.User.User.ImNumberC || "尚未填写");
        
        var locDetail = "";
        if(User.LocationAIndex !=null){
            locDetail+="地址1："+User.LocationAIndex+" "+Data.User.User.LocationADetail+"<br>";
        }
        if(User.LocationBIndex !=null){
            locDetail+="地址2："+User.LocationBIndex+" "+Data.User.User.LocationBDetail;
        }
        if(locDetail){
            locDetail = locDetail.replace(/;/g, ' ');
            $(".uloc").html(locDetail);
        }else{
            $(".uloc").html("您尚未填写位置信息");
        }
        
        var skill = Data.User.Skill;
        
        if(skill.length > 0){
            var i = 0, len = skill.length;
            for(i=0;i<len;i++){
                $(".uskill").append('<span class="label label-primary">' + skill[i].Name +'</span>');
            }
        }else{
            $(".uskill").html('<div class="well well-sm no-add">您还没有添加技术专长</div>');
        }
        
       
        
       
        
    };
    
    initHeader();
    initUser();
    
    $(".jobs .no-add").hover(function(){
        $(this).html("点击添加项目经历");
    }, function(){
        $(this).html("您还没有项目信息");
    });
    
    $(".edus .no-add").hover(function(){
        $(this).html("点击添加教育信息");
    }, function(){
        $(this).html("您还没有添加教育信息");
    });
    
     $(".works .no-add").hover(function(){
        $(this).html("点击添加工作经历");
    }, function(){
        $(this).html("您还没有添加工作经历");
    });
    
     $(".licens .no-add").hover(function(){
        $(this).html("点击添加认证信息");
    }, function(){
        $(this).html("您还没有添加认证信息");
    });
    
    //buttons licens
    $("#btn_add_licen,#no_add_licen").click(function(){
        $(".licens .add-dialog .form-control").val("");
        $(".licens .add-dialog .form-group").removeClass("has-error");
        $(".licens .add-dialog").removeClass("panel-danger");
        
        $(".licens .list-jobs").slideUp();
        $(".licens .add-dialog").slideDown();
        
        $("#btn_add_licen_fin").attr("data-type", "add").html("添加");
    });
    $("#btn_cancel_licen").click(function(){
        $(".licens .list-jobs").slideDown();
        $(".licens .add-dialog").slideUp();
    });
    $(".licens .list-jobs").on("click", ".editlicen", function(){
        $(".licens .list-jobs").slideUp();
        $(".licens .add-dialog").slideDown();
        var pa = $(this).closest('.list-group-item'), data = pa.data('data');
        
        $("#licen_name").val(data.Name);
        $("#licen_com").val(data.RegOrganization);
        $("#licen_url").val(data.RegAddress);
        $("#licen_code").val(data.RegNumber);
        $("#licen_stime").val(data.StartDate);
        $("#licen_etime").val(data.EndDate);
        $("#rzms").val(data.Content);
        
        $("#btn_add_licen_fin").attr("data-type", "edit").data("uuid", data.Uuid).html("修改");
    });
    $(".licens .list-jobs").on("click", ".dellicen", function(){
        var pa = $(this).closest('.list-group-item'), data = pa.data('data');
        $.ae("您确定要删除吗？", function(){
            $.ax("post", "user/license/delete/" + data.Uuid, null, function(data){}, function(data){});
            DeleteLicenMod(data);
        });
    });
    
    //buttons jobs
    $("#btn_add_job,#no_add_job").click(function(){
        $(".jobs .add-dialog .form-control").val("");
        $(".jobs .add-dialog .form-group").removeClass("has-error");
        $(".jobs .add-dialog").removeClass("panel-danger");
        
        $(".jobs .list-jobs").slideUp();
        $(".jobs .add-dialog").slideDown();
        
        $("#btn_add_job_fin").attr("data-type", "add").html("添加");
    });
    $("#btn_cancel_job").click(function(){
        $(".jobs .list-jobs").slideDown();
        $(".jobs .add-dialog").slideUp();
    });
    $(".jobs .list-jobs").on("click", ".editjob", function(){
        $(".jobs .list-jobs").slideUp();
        $(".jobs .add-dialog").slideDown();
        var pa = $(this).closest('.list-group-item'), data = pa.data('data');
        
        $("#job_name").val(data.Name);
        $("#job_address").val(data.ProjectAddress);
        $("#job_stime").val(data.StartDate);
        $("#job_etime").val(data.EndDate);
        $("#xmsm").val(data.Content)
        $("#job_title").val(data.Title);
        
        $("#btn_add_job_fin").attr("data-type", "edit").data("uuid", data.Uuid).html("修改");
    });
    $(".jobs .list-jobs").on("click", ".deljob", function(){
        var pa = $(this).closest('.list-group-item'), data = pa.data('data');
        $.ae("您确定要删除吗？", function(){
            $.ax("post", "user/proj/delete/" + data.Uuid, null, function(data){}, function(data){});
            DeleteJobMod(data);
        });
    });
    
    //edus buttons
    $("#btn_add_edu,#no_add_edu").click(function(){
        $(".edus .add-dialog .form-control").val("");
        $(".edus .add-dialog .form-group").removeClass("has-error");
        $(".edus .add-dialog").removeClass("panel-danger");
        
        $(".edus .list-jobs").slideUp();
        $(".edus .add-dialog").slideDown();
        
        $("#btn_add_edu_fin").attr("data-type", "add").html("添加");
    });
    $("#btn_cancel_edu").click(function(){
        $(".edus .list-jobs").slideDown();
        $(".edus .add-dialog").slideUp();
    });
    $(".edus .list-jobs").on("click", ".editedu", function(){
        $(".edus .list-jobs").slideUp();
        $(".edus .add-dialog").slideDown();
        var pa = $(this).closest('.list-group-item'), data = pa.data('data');
        
        $(".works .add-dialog .form-control").val("");
        $("#edu_title").val(data.InstitutionName);
        $("#edu_stime").val(data.StartDate);
        $("#edu_etime").val(data.EndDate);
        $("#edu_dre").val(data.DegreeType);
        $("#grjj").val(data.Description);
            
        $("#btn_add_edu_fin").attr("data-type", "edit").data("uuid", data.Uuid).html("修改");
    });
    $(".edus .list-jobs").on("click", ".deledu", function(){
        var pa = $(this).closest('.list-group-item'), data = pa.data('data');
        $.ae("您确定要删除吗？", function(){
            $.ax("post", "user/education/delete/"+User.UserName+"/" + data.Uuid, null, function(data){}, function(data){});
            DeleteEduMod(data);
        });
    });
    
    //works buttons
    $("#btn_add_work,#no_add_work").click(function(){
        $(".works .add-dialog .form-control").val("");
        $(".works .add-dialog .form-group").removeClass("has-error");
        $(".works .add-dialog").removeClass("panel-danger");
        
        $(".works .list-jobs").slideUp();
        $(".works .add-dialog").slideDown();
        
        $("#btn_add_work_fin").attr("data-type", "add").html("添加");
    });
    $("#btn_cancel_work").click(function(){
        $(".works .list-jobs").slideDown();
        $(".works .add-dialog").slideUp();
    });
    $(".works .list-jobs").on("click", ".editwork", function(){
        $(".works .list-jobs").slideUp();
        $(".works .add-dialog").slideDown();
        var pa = $(this).closest('.list-group-item'), data = pa.data('data');
        $(".works .add-dialog .form-control").val("");
        
        $("#company").val(data.Name);
        $("#tagline").val(data.Title);
        $("#location").val(data.WorkArea);
        $("#work_stime").val(data.StartDate);
        $("#work_etime").val(data.EndDate);
        $("#zwms").val(data.Content);
        
        $("#btn_add_work_fin").attr("data-type", "edit").data("uuid", data.Uuid).html("修改");
        
    });
    
    $(".works .list-jobs").on("click", ".delwork", function(){
        var pa = $(this).closest('.list-group-item'), data = pa.data('data');
        $.ae("您确定要删除吗？", function(){
            $.ax("post", "user/comp/delete/" + data.Uuid, null, function(data){}, function(data){});
            DeleteWorkMod(data);
        });
    });
    
    $("#work_etime,#work_stime,#edu_etime,#edu_stime,#job_etime,#job_stime,#licen_etime,#licen_stime").datepicker({dateFormat : "yy-mm-dd"});
});



$(function(){
    var init_licens = function(){
        $.ax("get", "user/license/all/"+ User.UserName+"?r="+Math.random(), null, function(data){
            if(data.length > 0){
                $("#no_add_licen").hide();
                $.each(data, function(i, dom){
                    InitLicenMod(dom);
                });
            }else{
                $("#no_add_licen").show();
            }
        });
    };
    init_licens();

    var init_works = function(){
        $.ax("get", "user/comp/all/"+ User.UserName+"?r="+Math.random(), null, function(data){
            if(data.length > 0){
                $("#no_add_work").hide();
                $.each(data, function(i, dom){
                    InitWorkMod(dom);
                });
            }else{
                $("#no_add_work").show();
            }
        });
    };
    init_works();
    
    var init_edus = function(){
        $.ax("get", "user/education/"+ User.UserName+"?r="+Math.random(), null, function(data){
            if(data.length > 0){
                $("#no_add_edu").hide();
                $.each(data, function(i, dom){
                    InitEduMod(dom);
                });
            }else{
                $("#no_add_edu").show();
            }
        });
    };
    init_edus();
    
    var init_jobs = function(){
        $.ax("get", "user/proj/all/" + User.UserName+"?r="+Math.random(), null, function(data){
            if(data.length > 0){
                $("#no_add_job").hide();
                $.each(data, function(i, dom){
                    InitJobMod(dom);
                });
            }else{
                $("#no_add_job").show();
            }
        });
    };
    init_jobs();
    
    
});


//check form
$(function(){
    var checkEmpty = function(obj){
        if(obj.val() == ""){
            obj.closest(".form-group").addClass("has-error");
            return false;
        }
        obj.closest(".form-group").removeClass("has-error");
        return true;
    };
    
    $("#btn_add_licen_fin").click(function(){
        var name = $("#licen_name"), com = $("#licen_com"),
            url = $("#licen_url"), code = $("#licen_code"),
            stime = $("#licen_stime"), etime = $("#licen_etime"),
            rzms = $("#rzms");
        
        var result = false;
        result = checkEmpty(name) && checkEmpty(com) && 
                 checkEmpty(url) && checkEmpty(code) &&
                 checkEmpty(stime) && checkEmpty(etime) &&
                 checkEmpty(rzms);
        
        if(result){
            var pa = $(this).closest(".panel").removeClass("panel-danger");
            pa.find(".panel-heading").html("添加认证信息");
            var param = {
                "Name" : name.val(),
                "RegOrganization" : com.val(),
                "RegNumber" : code.val(),
                "RegAddress" : url.val(),
                "StartDate" : stime.val(),
                "EndDate" : etime.val(),
                "Content" : rzms.val()
            };
            var type = $("#btn_add_licen_fin").attr("data-type");
            if(type == "add"){
                $.ax("post", "user/license/" /*+ User.UserName */ , param, function(rid){
                    param.Uuid = rid;
                    InitLicenMod(param);
                    $("#btn_cancel_licen").click();
                    dynamicDisplay("licen_","no_add_licen");
                }, function(){}, "text");
            }else if(type == "edit"){
                param.Uuid = $("#btn_add_licen_fin").data("uuid");
                $.ax("post", "user/license/update/" /*+ User.UserName */ + param.Uuid, param, function(rid){
                    $("#btn_cancel_licen").click();
                    UpdateLicenMod(param);
                }, function(){}, "text");
            }
            $("#no_add_licen").hide();
        }else{
            var pa = $(this).closest(".panel").addClass("panel-danger");
            pa.find(".panel-heading").html("添加认证信息-请输入完整的信息");
        }
                 
    });
    
    $("#btn_add_job_fin").click(function(){
        var name = $("#job_name"), address = $("#job_address"),
            stime = $("#job_stime"), etime = $("#job_etime"),
            xmsm = $("#xmsm"), title = $("#job_title");
        
        var result = false;
        result = checkEmpty(name) && checkEmpty(stime) && 
                 checkEmpty(etime) && checkEmpty(xmsm) &&
                 checkEmpty(title);
        
        if(result){
            var pa = $(this).closest(".panel").removeClass("panel-danger");
            pa.find(".panel-heading").html("添加项目信息");
            var param = {
                "Name" : name.val(),
                "Title" : title.val(),
                "Content" : xmsm.val(),
                "StartDate" : stime.val(),
                "EndDate" : etime.val(),
                "ProjectAddress" : address.val()
            };
            var type = $("#btn_add_job_fin").attr("data-type");
            if(type == "add"){
                $.ax("post", "user/proj/" /*+ User.UserName */ , param, function(rid){
                    param.Uuid = rid;
                    InitJobMod(param);
                    $("#btn_cancel_job").click();
                }, function(){}, "text");
            }else if(type == "edit"){
                param.Uuid = $("#btn_add_job_fin").data("uuid");
                $.ax("post", "user/proj/update/" /*+ User.UserName */ + param.Uuid, param, function(rid){
                    $("#btn_cancel_job").click();
                    UpdateJobMod(param);
                }, function(){}, "text");
            }
            $("#no_add_job").hide();
        }else{
            var pa = $(this).closest(".panel").addClass("panel-danger");
            pa.find(".panel-heading").html("添加项目信息-请输入完整的信息");
        }
    });
    
    $("#btn_add_edu_fin").click(function(){
        var name = $("#edu_title"), stime = $("#edu_stime"),
            etime = $("#edu_etime"), dre = $("#edu_dre"),
            grjj = $("#grjj");
            
        var result = false;
        result = checkEmpty(name) && checkEmpty(stime) && 
                 checkEmpty(etime) && checkEmpty(dre) && 
                 checkEmpty(grjj);
                 
        if(result){
            var pa = $(this).closest(".panel").removeClass("panel-danger");
            pa.find(".panel-heading").html("添加教育信息");
            var param = {
                "InstitutionName" : name.val(),
                "DegreeType" : dre.val(),
                "Description" : grjj.val(),
                "StartDate" : stime.val(),
                "EndDate" : etime.val()
            };
            var type = $("#btn_add_edu_fin").attr("data-type");
            if(type == "add"){
                $.ax("post", "user/education/" + User.UserName , param, function(rid){
                    param.Uuid = rid;
                    InitEduMod(param);
                    $("#btn_cancel_edu").click();
                }, function(){}, "text");
            }else if(type == "edit"){
                param.Uuid = $("#btn_add_edu_fin").data("uuid");
                $.ax("post", "user/education/update/" + User.UserName + param.Uuid, param, function(rid){
                    $("#btn_cancel_edu").click();
                    UpdateEduMod(param);
                }, function(){}, "text");
            }
            $("#no_add_edu").hide();
        }else{
            var pa = $(this).closest(".panel").addClass("panel-danger");
            pa.find(".panel-heading").html("添加教育信息-请输入完整的信息");
        }
    });

    $("#btn_add_work_fin").click(function(){
        var com = $("#company"),title = $("#tagline"),
        loc = $("#location"),stime = $("#work_stime"),
        etime = $("#work_etime"), zw = $("#zwms");
        
        var result = false;
        result = checkEmpty(com) && checkEmpty(title) && 
                 checkEmpty(loc) && checkEmpty(stime) && 
                 checkEmpty(etime) && checkEmpty(zw);
        if(result){
            var pa = $(this).closest(".panel").removeClass("panel-danger");
            pa.find(".panel-heading").html("添加工作经历");
            //$.ax = function(ptype, path, param, callback, errCallback, jtype)
            var param = {
                "Name" : com.val(),
                "Title" : title.val(),
                "WorkArea" : loc.val(),
                "Content" : zw.val(),
                "Status" : "leave",
                "StartDate" : stime.val(),
                "EndDate" : etime.val()
            };
            var type = $("#btn_add_work_fin").attr("data-type");
            if(type == "add"){
                $.ax("post", "user/comp", param, function(rid){
                    param.Uuid = rid;
                    InitWorkMod(param);
                    $("#btn_cancel_work").click();
                }, function(){}, "text");
            }else if(type == "edit"){
                param.Uuid = $("#btn_add_work_fin").data("uuid");
                $.ax("post", "user/comp/update/" + param.Uuid, param, function(rid){
                    $("#btn_cancel_work").click();
                    UpdateWorkMod(param);
                }, function(){}, "text");
            }
            $("#no_add_work").hide();
        }else{
            var pa = $(this).closest(".panel").addClass("panel-danger");
            pa.find(".panel-heading").html("添加工作经历-请输入完整的信息");
        }
        
    });
});









