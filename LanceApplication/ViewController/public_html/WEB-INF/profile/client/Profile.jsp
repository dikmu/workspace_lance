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
                <a href="#" class="thumbnail profile-avatar">
                  <img id="useravatar" src="/lance/resources/image/avatar/normal_1.png" alt="...">
                  <span data-toggle="modal" data-target="#modify">修改头像</span>
                </a>
                <br />
                <ul class="nav nav-stacked">
                    <li role="presentation" class="active"><a href="./Profile">公司主页</a></li>
                    <li role="presentation"><a href="./EditBasic">基本信息</a></li>
                    <li role="presentation"><a href="./EditContact">联系信息</a></li>
                    <li role="presentation"><a href="./EditPostJob">已发工作信息</a></li>
                </ul>
            </div>
            <div class="col-md-12 lan-main-right">
                <div class="alert alert-info" role="alert">
                    <span class="lan-font-22 lan-font-green uname"></span>
                    <br />
                    <!--<span class="lan-font-16 lan-font-black utitle"></span>-->
                    <br /><br />
                    <span class="lan-font-14 lan-font-black uloc"></span>
                    <br />
                    <button type="button" class="btn btn-info btn-edit" onclick="redirectPage('./EditBasic')">编辑</button>
                </div>

                <div class="well">
                    <div class="mod">
                        <span class="lan-font-20 lan-font-green">公司介绍</span>
                        <br />
                        <div href="#" class="lan-font-12 uself">
                            
                        </div>
                        <button type="button" class="btn btn-info btn-edit" onclick="redirectPage('./EditBasic')">编辑</button>
                    </div>

                    <div class="sep">
                    </div>

                    
                    <div class="modal fade" id="modify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel">修改个人头像</h4>
                                </div>
                                <div class="modal-body">
                                    <ul id="list-avatar">
                                        <li class="sel">
                                            <a data-src="normal_1" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_1.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_2" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_2.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_3" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_3.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_4" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_4.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_5" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_5.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_6" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_6.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_7" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_7.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_8" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_8.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_9" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_9.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_10" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_10.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_11" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_11.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_12" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_12.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="normal_13" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/normal_13.png" alt="" />
                                            </a>
                                        </li>
                                         <li>
                                            <a data-src="new/s1" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/s1.png" alt="" />
                                            </a>
                                        </li>
                                         <li>
                                            <a data-src="new/s2" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/s2.png" alt="" />
                                            </a>
                                        </li>
                                         <li>
                                            <a data-src="new/s3" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/s3.png" alt="" />
                                            </a>
                                        </li>
                                         <li>
                                            <a data-src="new/th" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th2" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th2.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th3" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th3.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th4" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th4.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th5" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th5.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th6" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th6.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th7" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th7.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th8" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th8.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th9" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th9.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th10" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th10.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th11" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th11.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th12" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th12.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th13" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th13.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th14" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th14.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th15" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th15.png" alt="" />
                                            </a>
                                        </li>
                                        <li>
                                            <a data-src="new/th16" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th16.png" alt="" />
                                            </a>
                                        </li>
                                         <li>
                                            <a data-src="new/th17" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th16.png" alt="" />
                                            </a>
                                        </li>
                                         <li>
                                            <a data-src="new/th18" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th18.png" alt="" />
                                            </a>
                                        </li>
                                         <li>
                                            <a data-src="new/th19" href="#" class="thumbnail">
                                                <img src="/lance/resources/image/avatar/new/th19.png" alt="" />
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button id="save_avatar" type="button" data-loading-text="保存中" autocomplete="off" class="btn btn-primary">保存修改</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
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