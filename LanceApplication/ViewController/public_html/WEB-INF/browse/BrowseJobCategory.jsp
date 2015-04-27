<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width; initial-scale=1.0" />

       <!-- Bootstrap -->
        <link href="\lance\resources\css\bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="\lance\resources\css\common\common.css" rel="stylesheet" type="text/css" />
        <link href="\lance\resources\css\control\main.css" rel="stylesheet" type="text/css" />
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
    <jsp:include page="/WEB-INF/common/TopBar.jsp"/>
        <div class="container">
         <div class="row">
            <div class="lan-tab">
                <div class="btn-group" data-toggle="buttons">
                    <label class="btn btn-link active" data-type="ljob">
                        <input type="radio" name="options" id="option1" autocomplete="off" checked>工作分类
                    </label>
                    <label class="btn btn-link" data-type="lskil">
                        <input type="radio" name="options" id="option2" autocomplete="off">技能分类
                    </label>
                </div>
            </div>
            
            <div class="borwser list">
                <dl class="col-md-3 mod hidemod" style="float:none;vertical-align:top;">
                    <dt>Research</dt>
                </dl>
            </div>
            
        </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="\lance\resources\js\jquery-1.9.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="\lance\resources\js\bootstrap.min.js" type="text/javascript"></script>
    
    <script src="\lance\resources\js\core.js" type="text/javascript"></script>
    <script src="\lance\resources\js\control\lan_check.js" type="text/javascript"></script>
    <script type="text/javascript" src="\lance\resources\js\page\browser.js"></script>
    <jsp:include page="/WEB-INF/common/BottomBar.jsp"/>
    </body>
</html>