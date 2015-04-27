$(function(){
    var check_login_param = function(){
        var ckEmail = $("#inp_emil").lanCheck('notEmpty');
        var ckPass = $("#inp_pass").lanCheck('notEmpty');
        
        var paEmail = $("#inp_emil").closest('.form-group');
        var paPass = $("#inp_pass").closest('.form-group');
        
        var err = $(".err-tip");
        
        if(!ckEmail){
            paEmail.addClass("has-error");
            return false;
        }else{
            paEmail.removeClass("has-error");
        }
        
        if(!ckPass){
            paPass.addClass("has-error");
            return false;
        }else{
            paPass.removeClass("has-error");
        }
        return true;
    };
    var vcode = null;
    var go_login = function(pabut){
        if("code" == vcode){
            var paCode = $("#inp_verCode").lanCheck('notEmpty');
            var codePass = $("#inp_verCode").closest('.form-group');
            if(!paCode){
                codePass.addClass("has-error");
                pabut.button('reset');
                return false;
            }else{
                codePass.removeClass("has-error");
            } 
        }
        var lname = $("#inp_emil").val(), lpass = $("#inp_pass").val(),v_code=$("#inp_verCode").val();
        var param={
            name : lname,
            pass : lpass,
            vcode:v_code
        };
        param = JSON.stringify(param);
        $.post("/lance/login", param, function(data){
            if(data.indexOf("ok") >= 0){
                var url = data.split(":")[1];
                window.location.href = url;
            }else if(data.indexOf("vcode") >= 0){
               $("#inp_verCode").closest(".form-group").addClass("has-error");
               $(".err-tip").html("验证码错误");
               pabut.button('reset');
            }else if(data.indexOf("name|pass:vc") >= 0){
               if(vcode == null){
                  $("#code-cnt").html(template('code-cnt-sp1',{'status' : "code"}));
                  vcode = "code";
               }
               $(".err-tip").html("用户名或密码错误");
               pabut.button('reset');
            }else if(data.indexOf("name|pass") >= 0){
               $("#inp_emil,#inp_pass").closest(".form-group").addClass("has-error");
               $(".err-tip").html("用户名或密码错误");
               pabut.button('reset');
            }
        }, "text");
        
    };
    
    $('#btn_login').on('click', function () {
        var obj = $(this);
        if(check_login_param()){
            obj.button('loading');
            go_login(obj);
            
            //$btn.button('reset');
        }
    });
    
    $("#a_regist").click(function(){
        var href = "";
        if($("#afree")[0].checked){
            href = "companyRegist.html";
        }
        if($("#cfree")[0].checked){
            href = "freeRegist.html";
        }
        window.location.href = href;
    });
    
    $("#inp_emil").keydown(function(e){
        if(e.keyCode == 13){
            $("#btn_login").click();
        }
    });
    
    $("#inp_pass").keydown(function(e){
        if(e.keyCode == 13){
            $("#btn_login").click();
        }
    });
   
  $("#code-cnt").on("click", "#change_img", function(){
     $("#code_img").attr("src","/lance/authimageservlet?r="+Math.random());
  });

  jQuery.ajax({
    url : '/lance/res/user/errInp/count?random='+Math.random(), type : 'get', success : function (data) {
        if(data.indexOf("inp:code") >= 0){
            $("#code-cnt").html(template('code-cnt-sp1',{'status' : "code"}));
            vcode = "code";
        }
    },
    error : function (msg) {
    }
   });
});