<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="/lance/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="/lance/resources/css/common/common.css" rel="stylesheet" type="text/css" />
        <link href="/lance/resources/css/control/main.css" rel="stylesheet" type="text/css" />
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
     
     <div class="lan-search">
        <div class="container">
            <div class="row">
                <div class="col-md-offset-3 col-md-9 search-form">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" id="inputSuccess5" aria-describedby="inputSuccess5Status">
                        <span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true"></span>
                        <span id="inputSuccess5Status" class="sr-only">(success)</span>
                    </div>
                    <div>
                        <button data-cls="persons" data-title="所有的自由人" type="button" class="btn btn-link lan-font-black lan-font-16 sel-tab-type">自由人</button>
                        <button data-cls="jobs" data-title="所有的工作" type="button" class="btn btn-link lan-font-black lan-font-16 sel-tab-type select">工作</button>
                        <button data-cls="jobs" data-title="所有的工作" type="button" class="btn btn-link lan-font-black lan-font-16 sel-tab-type">作品展示</button>
                        
                        <button type="button" class="btn btn-success btn-middle pull-right">发布工作信息</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <dl class="lan-dl">
                    <dt><a class="btn btn-link">类型</a></dt>
                    <dd><a class="btn btn-link">个人</a></dd>
                    <dd><a class="btn btn-link">公司</a></dd>
                </dl>
                
                <dl class="lan-dl">
                    <dt><a class="btn btn-link">工作分类</a></dt>
                    <dd><a class="btn btn-link">IT & Programming</a></dd>
                    <dd><a class="btn btn-link">Design & Multimedia</a></dd>
                    <dd><a class="btn btn-link">Writing & Translation</a></dd>
                    <dd><a class="btn btn-link">Sales & Marketing</a></dd>
                    <dd><a class="btn btn-link">Admin Support</a></dd>
                </dl>
            </div>
            
            <div class="col-md-9 rg-result">
                <span><b class="lbl-search-title">所有的工作</b>（13869437 个）</span>
                <p class="bg-info sea-result-info">
                    'df' 的搜索结果    共 359 个
                </p>
                <div class="jobs">
                    <div class="mod">
                        <p class="title">
                            <a class="btn btn-link">网页制作中的CSS+DIV:dl,dt,dd分别表示什么意思啊?请说..._百度知道</a>
                            <button type="button" class="btn btn-success btn-sm pull-right">申请</button>
                        </p>
                        <div>
                            <span><b>价格：不确定</b></span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>开始时间：2015年4月15日</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>结束时间：2015年10月1日</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>申请人数：9</span>
                            <br class="clearfix" />
                            <p class="txt">
                                爱词霸权威在线词典,为您提供proposal的中文意思,proposal的用法讲解,proposal的读音,proposal的同义词,proposal的反义词,proposal的例句等英语服务。爱词霸权威在线词典,为您提供proposal的中文意思,proposal的用法讲解,proposal的读音,proposal的同义词,proposal的反义词,proposal的例句等英语服务。爱词霸权威在线词典,为您提供proposal的中文意思,proposal的用法讲解,proposal的读音,proposal的同义词,proposal的反义词,proposal的例句等英语服务。
                            </p>
                            <span>工作分类：第一大类</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>工作分类：第二大类</span>&nbsp;&nbsp;|&nbsp;&nbsp;
                        </div>
                        <div>
                            <table class="job-table" border="0">
                                <tr>
                                    <td width="50px"><b>类型</b></td>
                                    <td width="100px">固定价格</td>
                                    <td width="50px"><b>技能</b></td>
                                    <td><a class="btn btn-info btn-xs">PHP</a><a class="btn btn-info btn-xs">JAVA</a><a class="btn btn-info btn-xs">HTML</a><a class="btn btn-info btn-xs">JAVASCRIPT</a></td>
                                </tr>
                                <tr>
                                    <td><b>评级</b></td>
                                    <td><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span></td>
                                    <td><b>地点</b></td>
                                    <td>不需要下现场办公</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                
                    
                    <div class="mod">
                        <p class="title">
                            <a class="btn btn-link">网页制作中的CSS+DIV:dl,dt,dd分别表示什么意思啊?请说..._百度知道</a>
                            <button type="button" class="btn btn-success btn-sm pull-right">申请</button>
                        </p>
                        <div>
                            <span><b>价格：不确定</b></span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>开始时间：2015年4月15日</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>结束时间：2015年10月1日</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>申请人数：9</span>
                            <br class="clearfix" />
                            <p class="txt">
                                爱词霸权威在线词典,为您提供proposal的中文意思,proposal的用法讲解,proposal的读音,proposal的同义词,proposal的反义词,proposal的例句等英语服务。爱词霸权威在线词典,为您提供proposal的中文意思,proposal的用法讲解,proposal的读音,proposal的同义词,proposal的反义词,proposal的例句等英语服务。爱词霸权威在线词典,为您提供proposal的中文意思,proposal的用法讲解,proposal的读音,proposal的同义词,proposal的反义词,proposal的例句等英语服务。
                            </p>
                            <span>工作分类：第一大类</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>工作分类：第二大类</span>&nbsp;&nbsp;|&nbsp;&nbsp;
                        </div>
                        <div>
                            <table class="job-table" border="0">
                                <tr>
                                    <td width="50px"><b>类型</b></td>
                                    <td width="100px">固定价格</td>
                                    <td width="50px"><b>技能</b></td>
                                    <td><a class="btn btn-info btn-xs">PHP</a><a class="btn btn-info btn-xs">JAVA</a><a class="btn btn-info btn-xs">HTML</a><a class="btn btn-info btn-xs">JAVASCRIPT</a></td>
                                </tr>
                                <tr>
                                    <td><b>评级</b></td>
                                    <td><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span></td>
                                    <td><b>地点</b></td>
                                    <td>不需要下现场办公</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="persons" style="display:none;">
                    <div class="mod">
                        <div class="pull-left">
                            <a href="#" class="thumbnail">
                                <img class="media-object" src="/lance/resources/image/pic/download.jpg" width="64px" height="64px" alt="...">
                            </a>
                        </div>
                        <div class="uinfo">
                            <p>
                                <a class="btn btn-link">Media heading</a>
                                <button type="button" class="btn btn-success btn-sm pull-right">雇佣</button>
                            </p>
                            <p>
                                <span class="lan-font-14">专业PHP工程师</span><br />
                                <span>所在地：北京市-通州区-XXXX</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>薪水要求：￥100</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>参加过 49 个工作</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>总共获得 ￥890989</span>&nbsp;&nbsp;|&nbsp;&nbsp;
                                <span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span>
                            </p>
                            <p class="txt">
                                我是一名应届毕业生，来自湖北武汉，农村生活铸就了我淳朴、诚实、善良的性格，培养了我不怕困难挫折，不服输的奋斗精神。我深知学习机会来之不易，在校期间非常重视计算机基础知识的学习，取得了良好的成绩。
    基本上熟悉了pc机的原理与构造，能熟练地应用各种机床操作系统，通过了劳动部《模具设计师》高级级认证。在学习专业知识的同时，还十分重视培养自己的动手实践能力，利用暑假参加了长江融达企业给予的宝贵实习机会，了解的各式机床的操作，以及简单数控机床的编程及操作。
                            </p>
                            <p class="skills">
                                <span>技能：<a class="btn btn-info btn-xs">PHP</a><a class="btn btn-info btn-xs">JAVA</a><a class="btn btn-info btn-xs">HTML</a><a class="btn btn-info btn-xs">JAVASCRIPT</a></span>
                            </p>
                        </div>
                    </div>
                    <div class="mod">
                        <div class="pull-left">
                            <a href="#" class="thumbnail">
                                <img class="media-object" src="/lance/resources/image/pic/download.jpg" width="64px" height="64px" alt="...">
                            </a>
                        </div>
                        <div class="uinfo">
                            <p>
                                <a class="btn btn-link">Media heading</a>
                                <button type="button" class="btn btn-success btn-sm pull-right">雇佣</button>
                            </p>
                            <p>
                                <span class="lan-font-14">专业PHP工程师</span><br />
                                <span>所在地：北京市-通州区-XXXX</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>薪水要求：￥100</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>参加过 49 个工作</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>总共获得 ￥890989</span>&nbsp;&nbsp;|&nbsp;&nbsp;
                                <span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span>
                            </p>
                            <p class="txt">
                                我是一名应届毕业生，来自湖北武汉，农村生活铸就了我淳朴、诚实、善良的性格，培养了我不怕困难挫折，不服输的奋斗精神。我深知学习机会来之不易，在校期间非常重视计算机基础知识的学习，取得了良好的成绩。
    基本上熟悉了pc机的原理与构造，能熟练地应用各种机床操作系统，通过了劳动部《模具设计师》高级级认证。在学习专业知识的同时，还十分重视培养自己的动手实践能力，利用暑假参加了长江融达企业给予的宝贵实习机会，了解的各式机床的操作，以及简单数控机床的编程及操作。
                            </p>
                            <p class="skills">
                                <span>技能：<a class="btn btn-info btn-xs">PHP</a><a class="btn btn-info btn-xs">JAVA</a><a class="btn btn-info btn-xs">HTML</a><a class="btn btn-info btn-xs">JAVASCRIPT</a></span>
                            </p>
                        </div>
                    </div>
                </div>               
                
                
                
                <button autocomplete="off" data-loading-text="获取数据中..." type="button" class="btn btn-default btn-lg btn-block get-more">点击加载更多</button>
                
            </div>
        </div>
    </div>
       
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/lance/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/lance/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/lance/resources/js/core.js" type="text/javascript"></script>
    <script src="/lance/resources/js/control/lan_check.js" type="text/javascript"></script>
    <script type="text/javascript" src="/lance/resources/js/page/search.js"></script>
    <script src="/lance/resources/js/searchjob.js" type="text/javascript"></script>
    <jsp:include page="/WEB-INF/common/BottomBar.jsp"/>
    </body>
</html>