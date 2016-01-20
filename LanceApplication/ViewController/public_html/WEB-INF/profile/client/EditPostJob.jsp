<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script>
        var User=${user};
        var Data=${data};
    </script>
     <!-- Bootstrap -->
    <link href="/lance/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/lance/resources/css/common/common.css" rel="stylesheet" type="text/css" />
    <link href="/lance/resources/css/control/main.css" rel="stylesheet" type="text/css" />
    <link type="text/css" href="/lance/resources/js/jqueryui/jquery-ui.css" rel="stylesheet" />
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
            <div class="col-md-3 lan-main-left" style="display:none;">
                <br />
                <br />
                <ul class="nav nav-stacked">
                    <li role="presentation"><a href="./Profile">公司主页</a></li>
                    <li role="presentation"><a href="./EditBasic">基本信息</a></li>
                    <li role="presentation"><a href="./EditContact">联系信息</a></li>
                    <li role="presentation" class="active"><a href="./EditPostJob">已发工作信息</a></li>
                </ul>
            </div>
            <div class="col-md-12 lan-main-right">
                

                <div class="well">
                   

                    <div class="sep">
                    </div>

                     建设中<br>
                     您可直接通过URL访问您发布过的需求信息
                     <br>
                    
                </div>
            </div>

        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/lance/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/lance/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/lance/resources/js/jqueryui/jquery-ui.js" type="text/javascript"></script>
    
    <script src="/lance/resources/js/core.js" type="text/javascript"></script>
    <script src="/lance/resources/js/control/lan_check.js" type="text/javascript"></script>
    <script type="text/javascript" src="/lance/resources/js/page/main.js"></script>
    
    <script>
        var redirectPage=function(url){
            location.href=url;
        }
    </script>
    <jsp:include page="/WEB-INF/common/BottomBar.jsp" />
    
    <script>
        var redirectPage=function(url){
            location.href=url;
        }
    </script>
    </body>
</html>