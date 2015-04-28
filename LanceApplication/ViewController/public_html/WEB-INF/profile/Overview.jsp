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
    <link href="\lance\resources\css\bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="\lance\resources\css\common\common.css" rel="stylesheet" type="text/css" />
    <link href="\lance\resources\css\control\main.css" rel="stylesheet" type="text/css" />
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
                    <li role="presentation" class="active"><a href="./Overview">个人主页</a></li>
                    <li role="presentation"><a href="./EditBasic">基本信息</a></li>
                    <li role="presentation"><a href="./EditContact">联系信息</a></li>
                    <li role="presentation"><a href="./EditSkill">我的技能</a></li>
                </ul>
            </div>
            <div class="col-md-9 lan-main-right">
                <div class="alert alert-info" role="alert">
                    <span class="lan-font-22 lan-font-green uname"></span>
                    <br />
                    <span class="lan-font-16 lan-font-black utitle"></span>
                    <br /><br />
                    <span class="lan-font-14 lan-font-black uloc"></span>
                    <br />
                    <button type="button" class="btn btn-info btn-edit" onclick="redirectPage('./EditBasic')">编辑</button>
                </div>

                <div class="well">
                    <div class="mod">
                        <span class="lan-font-20 lan-font-green">自我介绍</span>
                        <br />
                        <div href="#" class="lan-font-12 uself">
                            
                        </div>
                        <button type="button" class="btn btn-info btn-edit" onclick="redirectPage('./EditBasic')">编辑</button>
                    </div>

                    <div class="sep">
                    </div>

                    <div class="mod">
                        <span class="lan-font-20 lan-font-green">我的专长</span>
                        <br />
                        <div class="lan-font-12 uskill">
                            
                        </div>
                        <button type="button" class="btn btn-info btn-edit" onclick="redirectPage('./EditSkill')">编辑</button>
                    </div>

                    <div class="sep">
                    </div>

                    <div class="mod">
                        <span class="lan-font-20 lan-font-green">工作经历</span>
                        <br />
                        <div class="lan-font-12 jobs">
                            <div class="well well-sm no-add">您还没有添加工作经历</div>
                        </div>
                        <button type="button" class="btn btn-info btn-edit">编辑</button>
                    </div>

                    <div class="sep">
                    </div>
                    
                    <div class="mod">
                        <span class="lan-font-20 lan-font-green">教育经历</span>
                        <br />
                        <div href="#" class="lan-font-12 edus">
                            
                        </div>
                        <button type="button" class="btn btn-info btn-edit">编辑</button>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="\lance\resources\js\jquery-1.9.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="\lance\resources\js\bootstrap.min.js" type="text/javascript"></script>
    
    <script src="\lance\resources\js\core.js" type="text/javascript"></script>
    <script src="\lance\resources\js\control\lan_check.js" type="text/javascript"></script>
    <script type="text/javascript" src="\lance\resources\js\page\main.js"></script>
    <jsp:include page="/WEB-INF/common/BottomBar.jsp" />
    
    <script>
        var redirectPage=function(url){
            location.href=url;
        }
    </script>
    </body>
</html>