<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
                        <input type="text" class="form-control" id="input_search" aria-describedby="inputSuccess5Status">
                        <span id="search-icon" class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true"></span>
                        <span id="inputSuccess5Status" class="sr-only">(success)</span>
                    </div>
                    <div>
                        <button data-cls="persons" data-title="所有的自由人" type="button" class="btn btn-link lan-font-black lan-font-16 sel-tab-type">自由人</button>
                        <button data-cls="jobs" data-title="所有的工作" type="button" class="btn btn-link lan-font-black lan-font-16 sel-tab-type select">工作</button>
                        <!--<button data-cls="thumbs" data-title="所有的作品" type="button" class="btn btn-link lan-font-black lan-font-16 sel-tab-type">作品展示</button>-->
                        
                        <button type="button" class="btn btn-success btn-middle pull-right">发布工作信息</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="search-dv search-jobs">
                    <dl class="lan-dl" id="cates" data-pa="category">
                        <dt><a class="btn btn-link sel">所有类别</a></dt>
                        
                    </dl>
                    
                    <dl class="lan-dl" data-pa="postform">
                        <dt><a class="btn btn-link sel">所有支付类型</a></dt>
                        <dd><a class="btn btn-link" data-val="hourly">按时间支付</a></dd>
                        <dd><a class="btn btn-link" data-val="fixed">固定价格项目</a></dd>
                    </dl>
                    
                    <dl class="lan-dl" data-pa="budget">
                        <dt><a class="btn btn-link sel" id="allfixed">所有预算范围</a></dt>
                        <dd>
                            <span>￥</span><input id="fix_smoney" type="text" value="" />&nbsp;<span>到</span>
                            <input id="fix_emoney" type="text" value="" />
                            <span type="button" id="btn_fixcon" class="btn btn-default">确定</span>
                        </dd>
                    </dl>
                    
                    <dl class="lan-dl" data-pa="hourlyPay">
                        <dt><a class="btn btn-link sel" id="allhour">时新范围</a></dt>
                        <dd>
                            <span>￥</span><input id="hour_smoney" type="text" value="" />&nbsp;<span>到</span>
                            <input type="text" id="hour_emoney" value="" />
                            <span id="but_hourcon" type="button" class="btn btn-default">确定</span>
                        </dd>
                    </dl>
                </div>
                <div class="search-dv search-persons" style="display:none;">
                    <dl class="lan-dl" data-pa="userType">
                        <dt><a class="btn btn-link sel">所有类型</a></dt>
                        <dd><a class="btn btn-link" data-val="lancer">个人</a></dd>
                        <dd><a class="btn btn-link" data-val="company">供应商</a></dd>
                    </dl>
                    
                    <dl class="lan-dl" data-pa="country">
                        <dt><a class="btn btn-link sel" id="allloc">所有地点</a></dt>
                        <dd><a class="btn btn-link" id="speloc">指定地点</a></dd>
                        <dd>
                            <select disabled="disabled" id="sel_province" style="width:100px;margin-left:12px;">
                            </select>
                            <select disabled="disabled" id="sel_city" style="width:100px;">
                            </select>
                        </dd>
                    </dl>
                    
                    <dl class="lan-dl" data-pa="skill">
                        <dt><a class="btn btn-link sel" id="allskil">所有技能</a></dt>
                        <dd><a class="btn btn-link" id="speskil">指定技能</a></dd>
                        <dd>
                            <select id="sel_skill" disabled="disabled" style="width:204px;margin-left:12px;">
                            </select>
                        </dd>
                    </dl>
                    
                    <dl class="lan-dl" data-pa="budget">
                        <dt><a class="btn btn-link sel" id="alljg">所有价格</a></dt>
                        <dd><a class="btn btn-link" id="spejg">指定价格区间</a></dd>
                        <dd>
                            <span>￥</span><input id="smoney" type="text" value="" />&nbsp;<span>到</span>
                            <input type="text" value="" id="emoney" />
                            <input type="button" class="btn btn-default" id="but_cmoney" disabled="disabled" value="确定" />
                        </dd>
                    </dl>
                    
                    <dl class="lan-dl">
                        <dt><a class="btn btn-link sel">所有评级</a></dt>
                        <dd><a class="btn btn-link">最低5级</a></dd>
                        <dd><a class="btn btn-link">最低4级</a></dd>
                        <dd><a class="btn btn-link">最低3级</a></dd>
                    </dl>
                    
                    <dl class="lan-dl">
                        <dt><a class="btn btn-link sel">已有项目反馈数</a></dt>
                        <dd><a class="btn btn-link">最少5个</a></dd>
                        <dd><a class="btn btn-link">最少4个</a></dd>
                        <dd><a class="btn btn-link">最少3个</a></dd>
                    </dl>
                </div>
            </div>
            
            <div class="col-md-9 rg-result wait" style="text-align:center;padding-top:50px;display:none;">
                <img src="/lance/resources/image/bloading.gif" alt="" />
                <span>数据加载中，请稍候...</span>
            </div>
            
            <div class="col-md-9 rg-result con">
                <span class="all-count"><b class="lbl-search-title">所有的工作</b>（0 个）</span>
                <p class="bg-info sea-result-info" style="display:none;">
                    'df' 的搜索结果    共 359 个
                </p>
                <div class="jobs">
                    <div class="mod hidemod">
                        <p class="title">
                            <a href="#" class="btn btn-link title-in">网页制作中的CSS+DIV:dl,dt,dd分别表示什么意思啊?请说..._百度知道</a>
                            <button type="button" class="btn btn-success btn-sm pull-right">申请</button>
                        </p>
                        <div>
                            <span><b class="price">价格：不确定</b></span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="stime">开始时间：2015年4月15日</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="etime">结束时间：2015年10月1日</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="acount">申请人数：9</span>
                            <br class="clearfix" />
                            <p class="txt">
                                爱词霸权威在线词典,为您提供proposal的中文意思,proposal的用法讲解,proposal的读音,proposal的同义词,proposal的反义词,proposal的例句等英语服务。爱词霸权威在线词典,为您提供proposal的中文意思,proposal的用法讲解,proposal的读音,proposal的同义词,proposal的反义词,proposal的例句等英语服务。爱词霸权威在线词典,为您提供proposal的中文意思,proposal的用法讲解,proposal的读音,proposal的同义词,proposal的反义词,proposal的例句等英语服务。
                            </p>
                            <span class="cate1">工作分类：第一大类</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="cate2">工作分类：第二大类</span>&nbsp;&nbsp;|&nbsp;&nbsp;
                        </div>
                        <div>
                            <table class="job-table" border="0">
                                <tr>
                                    <td width="50px"><b>类型</b></td>
                                    <td width="100px" class="form">固定价格</td>
                                    <td width="50px"><b>技能</b></td>
                                    <td class=" skills"><a class="btn btn-info btn-xs">PHP</a><a class="btn btn-info btn-xs">JAVA</a><a class="btn btn-info btn-xs">HTML</a><a class="btn btn-info btn-xs">JAVASCRIPT</a></td>
                                </tr>
                                <tr>
                                    <td><b>评级</b></td>
                                    <td class="score"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span></td>
                                    <td><b>地点</b></td>
                                    <td class="location">不需要下现场办公</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                
                </div>
                
                <div class="persons" style="display:none;">
                    <div class="mod hidemod">
                        <div class="pull-left">
                            <a href="#" class="thumbnail">
                                <img class="media-object" src="/lance/resources/image/pic/download.jpg" width="64px" height="64px" alt="...">
                            </a>
                        </div>
                        <div class="uinfo">
                            <p>
                                <a class="btn btn-link uname">Media heading</a>
                                <button type="button" class="btn btn-success btn-sm pull-right">雇佣</button>
                            </p>
                            <p>
                                <span class="lan-font-14 title">专业PHP工程师</span><br />
                                <span class="location">所在地：北京市-通州区-XXXX</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="order">薪水要求：￥100</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="jobin">参加过 49 个工作</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="earn">总共获得 ￥890989</span>&nbsp;&nbsp;|&nbsp;&nbsp;
                                <span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span>
                            </p>
                            <p class="txt">
                                我是一名应届毕业生，来自湖北武汉，农村生活铸就了我淳朴、诚实、善良的性格，培养了我不怕困难挫折，不服输的奋斗精神。我深知学习机会来之不易，在校期间非常重视计算机基础知识的学习，取得了良好的成绩。
    基本上熟悉了pc机的原理与构造，能熟练地应用各种机床操作系统，通过了劳动部《模具设计师》高级级认证。在学习专业知识的同时，还十分重视培养自己的动手实践能力，利用暑假参加了长江融达企业给予的宝贵实习机会，了解的各式机床的操作，以及简单数控机床的编程及操作。
                            </p>
                            <p class="skills">
                                <span class="liss">技能：</span>
                            </p>
                        </div>
                    </div>
                    
                </div>               
                
                
                <span style="display:none;" autocomplete="off" data-loading-text="获取数据中..." type="button" class="btn btn-default btn-lg btn-block get-more">点击加载更多</span>
                <span style="display:none;" class="btn btn-default btn-lg btn-block no-more" disabled="disabled">没有更多了</span>
                
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
    <jsp:include page="/WEB-INF/common/BottomBar.jsp"/>
    </body>
</html>