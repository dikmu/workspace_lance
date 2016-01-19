<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>邮件订阅</title>
        <meta name="keywords" content="高薪招聘,独立顾问,自由顾问,兼职">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link type="text/css" href="/lance/resources/css/bootstrap.min.css" rel="stylesheet"/>
        <link type="text/css" href="/lance/resources/css/common.css" rel="stylesheet"/>
        <link type="text/css" href="/lance/resources/css/main.css" rel="stylesheet"/>
        <!--[if lt IE 9]>
          <script src="/lance/resources/js/html5shiv.js"></script>
          <script src="/lance/resources/js/respond.js"></script>
        <![endif]-->
        <script>
            var User=${user};
            var Data=${data};
        </script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/common/TopBar.jsp"/>
        
        
        
        <div id="waiting">
            <img src="/lance/resources/image/bloading.gif" alt=""/>
            <span class="bold-text">加载中...</span>
        </div>
        <script src="/lance/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="/lance/resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="/lance/resources/js/jquery.json-2.4.js"></script>
        <script src="/lance/resources/js/core.js" type="text/javascript"></script>
        <jsp:include page="/WEB-INF/common/BottomBar.jsp"/>
    </body> 
</html>