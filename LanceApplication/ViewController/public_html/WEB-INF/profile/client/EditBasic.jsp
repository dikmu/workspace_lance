<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>编辑基本信息</title>
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
        <div class="row">
            <div class="col-md-3 lan-main-left">

                <br /><br />
                <ul class="nav nav-stacked">
                    <li role="presentation"><a href="./Profile">公司主页</a></li>
                    <li role="presentation" class="active"><a href="./EditBasic">基本信息</a></li>
                    <li role="presentation"><a href="./EditContact">联系信息</a></li>
                    <li role="presentation"><a href="./EditPostJob">已发工作信息</a></li>
                </ul>
            </div>
            <div class="col-md-9 lan-main-right">
                <div class="page-header">
                    <h1><small>公司基本信息</small></h1>
                </div>
                 <form class="basic-form" role="form" method="post" action="#">
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            公司真实名：</label>
                        <input value="" type="text" class="form-control sml-inp" id="inp_uname" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="请输入合法的公司名" data-trigger="manual" data-animation="false"/>
                    </div>
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            公司显示名：</label>
                        <input value="" type="text" class="form-control sml-inp" id="inp_dname" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="请输入合法的显示名" data-trigger="manual" data-animation="false"/>
                    </div>
                    
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            公司网站：</label>
                        <input value="" type="text" class="form-control sml-inp" id="inp_website" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="请输入公司网站" data-trigger="manual" data-animation="false"/>
                    </div>
                    
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            公司描述：</label>
                        <textarea class="form-control" rows="10" id="inp_over"
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="请输入公司描述" data-trigger="manual" data-animation="false"></textarea>
                    </div>
                    
                    <button autocomplete="off" data-loading-text="保存中..." id="btn_save" type="button" class="btn btn-primary">确定</button>
                 </form>
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
    <script type="text/javascript" src="/lance/resources/js/page/editbasic.js"></script>
    </body>
</html>