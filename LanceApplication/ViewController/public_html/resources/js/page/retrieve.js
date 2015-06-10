$(function(){
   var v_flag = false;
   $("#step1_c").click(function(){
        var btn = $(this);
        btn.button('loading');
        var ckUname = $("#inp_uname").lanCheck('notEmpty');
        var paUname = $("#inp_uname").closest('.input-group');
        
        var ckCode = $("#inp_code").lanCheck('notEmpty');
        var paCode = $("#inp_code").closest('.input-group');
        var flag = true;
        var msg="";
        if(!ckUname){
           paUname.addClass("has-error");
           msg +="●请输入用户名或已验证的邮箱！";
           flag = false;
        }
        if(!ckCode){
           paCode.addClass("has-error");
           if(msg.length > 0){
              msg +="<br/>";
           }
           msg +="●请输入验证码！";
           flag = false;
        }else{
            vcodeAjax($("#inp_code").val());
           if(!v_flag){
               paCode.addClass("has-error");
               if(msg.length > 0){
                  msg +="<br/>";
               }
               msg +="●验证码错误！";
               flag = false;
           }
        }
        if(!flag){
           $(".err-tip").html(msg);
           btn.button('reset');
           return;
        }
        
       jQuery.ajax({
          url : '/lance/res/user/exist/'+$("#inp_uname").val()+"/"+$("#inp_code").val(), 
          type : 'get',
          success: function(data){
            if(data.indexOf("err")>=0){
                $(".err-tip").html(data.split(":")[1]);
                paUname.addClass("has-error");
                btn.button('reset');
            }else{
                $(".err-tip").html("");
                $(".step_sp2").removeClass("one_2").addClass("two_2");
                $(".step1").hide();
                $(".step2").show();
                $("#msg-cnt").html("<span class='glyphicon glyphicon-ok' style='color:#71b247'></span>" +
                "<font style='color:#71b247;font-size:12px;'>验证邮件已发送，请前往你的邮箱("+data+")查收验证邮件</font><br/>" +
                "<font style='color:black;font-size:11px;'>验证邮件24小时内有效，请尽快登录您的邮箱点击验证链接完成验证。</font>");
            }
        },error:function(msg){
           $.ae("服务器无响应，请稍后再试。");
           btn.button('reset');
        }
     });
 });
 
 var vcodeAjax = function(code){
     jQuery.ajax({
          url : '/lance/res/user/check/'+code, 
          type : 'get',
          async: false,
          success: function(data){
             if(data == "false"){
                v_flag = false;
             }else{
                v_flag = true;
             }
        },error:function(msg){
           $.ae("服务器无响应，请稍后再试。");
        }
     });
};
   
 $("#change_img").click(function(){
    $("#code_img").attr("src","/lance/authimageservlet?r="+Math.random());
 });
 
 var ckresult = {
    psr : false
 };
 if(Data.hasOwnProperty("u-key") && Data.hasOwnProperty("uname") && Data.hasOwnProperty("step")){
      $(".step1").hide();
      $(".step3").show();
      $(".step_sp2").removeClass("one_2").addClass("three_2");
      $("#step2_c").click(function(){
         if(ckresult.psr){
             var param = {"u-key":Data["u-key"],"uname":Data["uname"],"password":$("#inp_pass").val()};
             jQuery.ajax({
                  url : '/lance/res/user/reset/password', 
                  type : 'post',
                  contentType : 'application/json',
                  data:jQuery.toJSON(param),
                  success: function(data){
                     if(data.indexOf("err")>=0){
                         $.ae(data.split(":")[1]);
                     }else{
                         $(".step3").hide();
                         $(".step4").show();
                         $(".step_sp2").removeClass("three_2").addClass("four_2");
                     }
                },error:function(msg){
                   $.ae("服务器无响应，请稍后再试。");
                }
             });
         }else{
            check_pass();
         }
      });
 }else if(Data.hasOwnProperty("expire")){
    $(".step1").hide();
    $(".expire").show();
 }
 
  var check_pass = function(){
        var fpass = $("#inp_pass"),
            spass = $("#inp_cpass");
        
        com_conFocus(fpass, "登录密码");
        
        var mck = function(){
            if(ckresult.psr == false){
                fpass.blur();
                spass.blur();
            }
        };
        
        fpass.blur(function(){
            fpass.closest(".input-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
            fpass.popover("hide");
            
            if(fpass.lanCheck("password")){
                fpass.closest(".input-group").addClass("has-success").addClass("has-feedback");
            }else{
                fpass.closest(".input-group").addClass("has-error");
                fpass.attr("data-content", "请输入8位以上的密码").popover("show");
            }
        });
        
        com_conFocus(spass, "请再次输入密码");
        
        spass.blur(function(){
            spass.closest(".input-group").removeClass("has-error").removeClass("has-success").removeClass("has-feedback");
            spass.popover("hide");
        
            if(spass.lanCheck("password") && spass.val() == fpass.val()){
                spass.closest(".input-group").addClass("has-success").addClass("has-feedback");
                ckresult.psr = true;
            }else{
                spass.closest(".input-group").addClass("has-error");
                spass.attr("data-content", "两次密码输入不一致").popover("show");
            }
        });
        return {ck:mck};
    };
   check_pass();
});