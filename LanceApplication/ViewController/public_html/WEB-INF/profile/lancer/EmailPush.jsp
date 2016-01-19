<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <script>
            var User=${user};
            var Data=${data};
            </script>
             <!-- Bootstrap -->
            <link href="/lance/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
            <link href="/lance/resources/css/common/common.css" rel="stylesheet" type="text/css" />
            <link href="/lance/resources/css/control/main.css" rel="stylesheet" type="text/css" />
            <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>
              <script src="/lance/resources/js/html5shiv.js" type="text/javascript"></script>
              <script src="/lance/resources/js/respond.js" type="text/javascript"></script>
            <![endif]-->
        
    </head>
    <body>
     <jsp:include page="/WEB-INF/common/TopBar.jsp" />
    <div class="container">
        <div class="row" id="t_con">
           <div class="col-md-3 lan-main-left">

                <br /><br />
                <ul class="nav nav-stacked">
                    <li role="presentation"><a href="./Profile">个人主页</a></li>
                    <li role="presentation"><a href="./EditBasic">基本信息</a></li>
                    <li role="presentation"><a href="./EditContact">联系信息</a></li>
                    <li role="presentation"><a href="./EditSkill">我的技能</a></li>
                    <li role="presentation" class="active"><a href="./EmailPush">邮件设置</a></li>
                </ul>
            </div>
            <div class="col-md-9 lan-main-right">
                <div class="page-header">
                    <h1><small>邮件推送设置</small></h1>
                </div>
                <div class="alert alert-info" role="alert">
                    系统会推送具有相应技能需求的工作信息到您的邮箱。<br />
                </div>
                <br />
                <label for="exampleInputEmail1" class="control-label">
                            新工作机会邮件推送频率：</label><br />
                            <div class="radio">
                                <label>
                                    <input id="epush_day" name="epush" type="radio" value=""  checked="checked"/>
                                     每天一次
                                </label>
                            </div>
                            
                            <div class="radio">
                                <label>
                                    <input id="epush_week" name="epush" type="radio" value=""/>
                                    每周一次
                                </label>
                            </div>
                            
                            <div class="radio">
                                <label>
                                    <input type="radio" name="epush" id="epush_no">
                                    不接收任何工作信息推送
                                </label>
                            </div>
                            
                            <div class="checkbox" id="EPush_">
                                <label>
                                    <input id="epush_freq" type="checkbox" value="" checked="checked" />
                                    工作信息更新后可重新推送
                 </label>
                 </div>
                 <br>
                 
                 
                 <button autocomplete="off" data-loading-text="保存中..." id="btn_save" type="button" class="btn btn-primary">确定</button>
               </div>     
                            


        </div>
    </div>
            
    <jsp:include page="/WEB-INF/common/BottomBar.jsp" />

     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/lance/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/lance/resources/js/bootstrap.min.js" type="text/javascript"></script>
    
    <script src="/lance/resources/js/core.js" type="text/javascript"></script>
    <script src="/lance/resources/js/control/lan_check.js" type="text/javascript"></script>
    <script type="text/javascript" src="/lance/resources/js/page/emailpush.js"></script>

    </body>
</html>