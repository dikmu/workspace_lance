<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>发布工作</title>
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
        <script>
            var User=${user};
            var Data=${data};
        </script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/common/TopBar.jsp" />
        <div class="container newjob">
        <div class="row">
            <div class="page-header" style="overflow:hidden ;">
              <h1 class="lan-font-22 lan-cfmargin pull-left">消息管理</h1>
                <div class="btn-group pull-right" role="group">
                  <button id="btn_unread" type="button" class="btn btn-default btn-sm">标记未读</button>
                  <button id="btn_read" type="button" class="btn btn-default btn-sm">标记已读</button>
                  <button id="btn_del" type="button" class="btn btn-default btn-sm">删除</button>
                </div>
            </div>
            <!-- Usage as a class -->
            <div class="clearfix"></div>
            <div style="padding-left:14px;">
            <table id="mymessage" class="table table-hover table-bordered" >
                <thead>
                    <tr>
                        <th>
                           通知发送人
                        </th>
                        <th>
                           通知标题
                        </th>
                        <th>
                           通知内容
                        </th>
                        <th>
                           状态
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="hidemod">
                        <td class="title">
                        </td>
                        <td class="txt">
                        </td>
                        <td class="type">
                        </td>
                        <td class="read">
                        </td>
                    </tr>
                </tbody>
            </table>
            </div>
        </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/lance/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/lance/resources/js/bootstrap.min.js" type="text/javascript"></script>
    
    <script src="/lance/resources/js/jqueryui/jquery-ui.js" type="text/javascript"></script>
    <script src="/lance/resources/js/jquery.json-2.4.js" type="text/javascript"></script>
    <script src="/lance/resources/js/core.js" type="text/javascript"></script>
    <script src="/lance/resources/js/control/lan_check.js" type="text/javascript"></script>
    <script type="text/javascript" src="/lance/resources/js/page/message.js"></script>
    <jsp:include page="/WEB-INF/common/BottomBar.jsp" />
</body>
</html>