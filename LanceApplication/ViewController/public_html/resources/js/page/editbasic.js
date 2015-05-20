//basic
$(function(){
    Lancer.profile.getBasicInfo(function(data){
        var user = data.User;
        
        $("#inp_uname").val(user.TrueName);
        $("#inp_dname").val(user.DisplayName);
        $("#inp_tagline").val(user.Tagline);
        $("#inp_hour").val(user.HourlyRate ? user.HourlyRate : "");
        $("#inp_hour2").val(user.ChargeRate ? user.ChargeRate : "");
        $("#inp_website").val(user.WebsiteUrl ? user.WebsiteUrl : "");
        $("#inp_over").val(user.Overview ? user.Overview : "");
        $("#inp_service").val(user.ServiceDescription ? user.ServiceDescription : "");
        $("#inp_payment").val(user.PaymentTerms ? user.PaymentTerms : "");
        $("#inp_keywords").val(user.Keywords ? user.Keywords : "");
    });
    
    var basicRes = {
        "uname" : false,
        "tagline" : false,
        "hour" : false,
        "overview" : false,
        "dname":false
    };
    
    var checkBasic = function(){
        
        var uname = $("#inp_uname");
        uname.blur(function(){
            uname.popover("hide");
            uname.closest(".form-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
            
            if(uname.lanCheck('chineseCharIntLine')){
                uname.closest(".form-group").addClass("has-success").addClass("has-feedback");
                basicRes.uname = true;
            }else{
                uname.attr("data-content", "请输入正确的用户名").popover("show");
                uname.closest(".form-group").addClass("has-error");
                basicRes.uname = false;
            }
        });
        
        var tagline = $("#inp_tagline");
        tagline.blur(function(){
            tagline.popover("hide");
            tagline.closest(".form-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
            
            if(tagline.lanCheck('notEmpty')){
                tagline.closest(".form-group").addClass("has-success").addClass("has-feedback");
                basicRes.tagline = true;
            }else{
                tagline.attr("data-content", "请输入座右铭").popover("show");
                tagline.closest(".form-group").addClass("has-error");
                basicRes.tagline = false;
            }
        });
        
        var hour = $("#inp_hour"), hour2 = $("#inp_hour2");
        hour.blur(function(){
            hour.popover("hide");
            hour.closest(".form-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
            
            if(hour.lanCheck('onlyNumber')){
                hour.closest(".form-group").addClass("has-success").addClass("has-feedback");
                var strjg = hour.val() * 1 + "";
                if(strjg.indexOf(".") >= 0){
                    hour2.val(strjg.substring(0, strjg.indexOf(".") + 3));
                }else{
                    hour2.val(strjg);
                }
                basicRes.hour = true;
            }else{
                hour.attr("data-content", "请输入正确的价格").popover("show");
                hour.closest(".form-group").addClass("has-error");
                basicRes.hour = false;
            }
        });
        
        var ovw = $("#inp_over");
        ovw.blur(function(){
            ovw.popover("hide");
            ovw.closest(".form-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
            
            if(ovw.lanCheck('notEmpty')){
                ovw.closest(".form-group").addClass("has-success").addClass("has-feedback");
                basicRes.overview = true;
            }else{
                ovw.attr("data-content", "请输入个人介绍").popover("show");
                ovw.closest(".form-group").addClass("has-error");
                basicRes.overview = false;
            }
        });
        
        var dname = $("#inp_dname");
        dname.blur(function(){
            dname.popover("hide");
            dname.closest(".form-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
            
            if(dname.lanCheck('chineseCharIntLine')){
                dname.closest(".form-group").addClass("has-success").addClass("has-feedback");
                basicRes.dname = true;
            }else{
                dname.attr("data-content", "请输入正确的用户显示名").popover("show");
                dname.closest(".form-group").addClass("has-error");
                basicRes.dname = false;
            }
        });
    };
    
    checkBasic();
    
    $("#btn_save").click(function(){
        var btn = $(this);
        $("#inp_uname,#inp_dname,#inp_over,#inp_hour,#inp_tagline").blur();
        if(basicRes.uname && basicRes.dname && basicRes.tagline && basicRes.hour && basicRes.overview){
            var param = {
                "Keywords" : $("#inp_keywords").val(),
                "Overview" : $("#inp_over").val(),
                "PaymentTerms" : $("#inp_payment").val(),
                "ServiceDescription" : $("#inp_service").val(),
                "Tagline" : $("#inp_tagline").val(),
                "UserName" : User.UserName,
                "DisplayName" : $("#inp_dname").val(),
                "TrueName" : $("#inp_uname").val(),
                "ChargeRate" : $("#inp_hour2").val(),
                "HourlyRate" : $("#inp_hour").val()
            };
            btn.button('loading');
            
            $.ax("post", "user/update/" + User.UserName, param, function(){
                $.ae("保存成功!");
                btn.button("reset");
            }, function(){
                netWorkError();
                btn.button("reset");
            }, "text");
        }
        
        
    });
});