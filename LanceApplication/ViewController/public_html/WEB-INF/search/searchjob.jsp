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
                        
                        <a type="button" class="btn btn-success btn-middle pull-right" href="/lance/pages/jobs/PostNewJob">发布工作信息</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="progress sea-progress">
            <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                <span class="sr-only"></span>
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
                    
                    <dl class="lan-dl" data-pa="skill">
                        <dt><a class="btn btn-link sel">所有技能</a></dt>
                        <dd>
                            <select id="jbskill" style="width:200px;margin-left:12px;">
                            </select>
                        </dd>
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
                        <dd class="dd-speloc" style="display:none;">
                            <select id="sel_province" style="width:100px;margin-left:12px;">
                            </select>
                            <select id="sel_city" style="width:100px;">
                            </select>
                        </dd>
                    </dl>
                    
                    <dl class="lan-dl" data-pa="skill">
                        <dt><a class="btn btn-link sel" id="allskil">所有技能</a></dt>
                        <dd><a class="btn btn-link" id="speskil">指定技能</a></dd>
                        <dd class="dd-speskil" style="display:none;">
                            <select id="sel_skill" style="width:204px;margin-left:12px;">
                            </select>
                        </dd>
                    </dl>
                    
                    <dl class="lan-dl" data-pa="budget">
                        <dt><a class="btn btn-link sel" id="alljg">所有价格</a></dt>
                        <dd><a class="btn btn-link" id="spejg">指定价格区间</a></dd>
                        <dd class="dd-spejg" style="display:none;">
                            <span>￥</span><input id="smoney" type="text" value="" />&nbsp;<span>到</span>
                            <input type="text" value="" id="emoney" />
                            <input type="button" class="btn btn-default" id="but_cmoney" value="确定" />
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
                    '' 的搜索结果    共 0 个
                </p>
                <div class="jobs">
                    <div class="mod hidemod">
                        <p class="title">
                            <a href="#" class="btn btn-link title-in"></a>
                            <a type="button" class="btn btn-success btn-sm pull-right">申请</a>
                        </p>
                        <div>
                            <span><b class="price">价格：不确定</b></span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="stime">开始时间：2015年4月15日</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="etime">结束时间：2015年10月1日</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="acount">申请人数：0</span>
                            <br class="clearfix" />
                            <p class="txt">
                                
                            </p>
                            <span class="cate1">工作分类：</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="cate2">工作分类：</span>&nbsp;&nbsp;|&nbsp;&nbsp;
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
                                    <!--<td><b>评级</b></td>
                                    <td class="score"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span></td>-->
                                    <td><b>地点</b></td>
                                    <td class="location"></td>
                                    <td></td>
                                    <td></td>
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
                                <a type="button" class="btn btn-success btn-sm pull-right">雇佣</a>
                            </p>
                            <p>
                                <span class="lan-font-14 title"></span><br />
                                <span class="location">所在地：</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="order">薪水要求：</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="jobin">参加过 0 个工作</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="earn">总共获得 0</span>&nbsp;&nbsp;|&nbsp;&nbsp;
                                <span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star lan-font-yellow"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span>
                            </p>
                            <p class="txt">
                                
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