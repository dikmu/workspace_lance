<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>找回密码</title>
        <link type="text/css" href="/lance/resources/css/bootstrap.min.css" rel="stylesheet" />
        <link href="/lance/resources/css/common/common.css" rel="stylesheet" type="text/css" />
        <link href="/lance/resources/css/control/main.css" rel="stylesheet" type="text/css" />
        <link type="text/css" href="/lance/resources/css/main.css" rel="stylesheet" />
        <!--[if lt IE 9]>
          <script src="resources/js/html5shiv.js"></script>
          <script src="resources/js/respond.js"></script>
        <![endif]-->
         <script>
            var User=${user};
            var Data=${data};
        </script>
    </head>
    <body>
        <div class="container-fluid chfont">
          <div id="t_con" class="row">
             <jsp:include page="/WEB-INF/common/TopBar.jsp"/>
             <div id="content" class="min-width">
                <div style="padding-left:15%;font-weight: bold;">找回密码</div>
                <div class="page-header">
                    <h1 class="step-xh" style="padding-left:20%;">
                       <span class="step_sp2 one"></span>
                    </h1>
                </div>
                <form class="step1 basic-form col-md-6" style="padding-left:23%;" role="form" method="post" action="#">
                    <div class="input-group input-group-sm">
                        <label for="inp_uname" class="control-label">账户名(请输入用户名或者你已验证的邮箱)</label>
                        <input type="text" class="form-control" placeholder="用户名/邮箱" id="inp_uname"/>
                    </div>
                    <div class="input-group input-group-sm">
                        <label for="inp_code" class="control-label">验证码(请输入验证码)</label><br/>
                        <input type="text" class="form-control" style="width:52%;display:inline-block;" placeholder="请输入验证码" id="inp_code"/>
                        <img src="/lance/authimageservlet" alt="" id="code_img"/>&nbsp;<a id="change_img">看不清?</a>
                    </div>
                    <div>
                    <br/>
                        <button data-val="posted" autocomplete="off" data-loading-text="提交中..." type="button" id="step1_c" class="btn btn-xs btn-info">提交</button>
                    </div>
                    <span class="lan-font-red lan-font-12 err-tip pull-right"></span>
                </form>
                <form class="step2 basic-form col-md-6" style="padding-left:23%;display: none;" role="form" method="post" action="#">
                    <div id="msg-cnt" style="color:#71b247"></div>
                </form>
                <form class="step3 basic-form col-md-6" style="padding-left:23%;display: none;" role="form" method="post" action="#">
                    <div class="input-group input-group-sm">
                        <label for="inp_uname" class="control-label">新登录密码</label>
                        <input type="password" class="form-control" placeholder="用户名/邮箱" id="inp_pass"/>
                    </div>
                    <div class="input-group input-group-sm">
                        <label for="inp_uname" class="control-label">确认新密码</label>
                        <input type="password" class="form-control" placeholder="用户名/邮箱" id="inp_cpass"/>
                    </div>
                     <div>
                    <br/>
                       <button data-val="posted" autocomplete="off" data-loading-text="提交中..." type="button" id="step2_c" class="btn btn-xs btn-info">提交</button>
                    </div>
                </form>
                <form class="step4 basic-form col-md-6" style="padding-left:23%;display: none;" role="form" method="post" action="#">
                    <div style="color:#71b247">新登录密码已设置成功，请前往登录页面<a href="/lance/login.htm">登录</a>吧！</div>
                </form>
                <form class="expire basic-form col-md-6" style="padding-left:23%;display: none;" role="form" method="post" action="#">
                    <div style="color:red">验证邮件已过期，重新<a href="/lance/pages/profile/retrieve">填写账户名?</a></div>
                </form>
             </div>
          </div>
        </div>
        <script src="/lance/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="/lance/resources/js/jquery.json-2.4.js" type="text/javascript"></script>
        <script src="/lance/resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="/lance/resources/js/core.js" type="text/javascript"></script>
        <script src="/lance/resources/js/control/lan_check.js" type="text/javascript"></script>
        <script src="/lance/resources/js/control/common.js" type="text/javascript"></script>
        <script src="/lance/resources/js/page/retrieve.js" type="text/javascript"></script>
        <jsp:include page="/WEB-INF/common/BottomBar.jsp"/>
    </body>
</html>