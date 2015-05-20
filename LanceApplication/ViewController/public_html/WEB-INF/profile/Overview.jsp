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
                        <span class="lan-font-20 lan-font-green">项目经历</span>
                        <br />
                        <div class="lan-font-12 jobs">
                            <div class="list-group list-jobs">
                                <div href="#" class="list-group-item hidemod">
                                    <div class="progress" style="display:none;">
                                        <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width:0%">
                                            <span class="sr-only"></span>
                                        </div>
                                    </div>
                                    <h4 class="list-group-item-heading"><a target="_blank" class="job-name">百度新员工PORTAL</a>
                                        <a class="btn btn-danger btn-xs pull-right deljob">删除</a>
                                        <a href="#" class="btn btn-success btn-xs pull-right editjob">编辑</a>
                                    </h4>
                                    <p class="list-group-item-text">
                                        <span class="job-time">2013年11月 - 2014年12月</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="job-title">本科生</span><br />
                                        <span class="txt">弯弯角没有供出弯角没有供出弯角没有供出角没有供出弯弯角没有供出弯角没有供出弯角没有供出角没有供出弯弯角没有供出弯角没有供出弯角没有供出角没有供出</span>
                                    </p>
                                </div>
                            </div>
                            <div class="add-dialog panel panel-default" style="display:none;">
                                <div class="panel-heading">添加项目经历</div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label>项目名称</label>
                                        <input class="form-control txt-normal" id="job_name" placeholder="请输入项目名称" />
                                    </div>
                                    <div class="form-group">
                                        <label>项目地址</label>
                                        <input class="form-control txt-normal" id="job_address" placeholder="请输入项目身份" />
                                    </div>
                                    <div class="form-group">
                                        <label>选择身份</label>
                                        <input class="form-control txt-normal" id="job_title" placeholder="请输入项目身份" />
                                    </div>
                                    <div class="form-group">
                                        <label>项目周期</label>
                                        <input class="form-control txt-normal2" id="job_stime" placeholder="开始时间" />
                                        <input class="form-control txt-normal2" id="job_etime" style="margin-left:2%;" placeholder="结束时间" />
                                    </div>
                                    <div class="form-group">
                                        <label class="lan-vt">项目说明</label>
                                        <textarea id="xmsm" class="form-control txt-normal" cols="" rows=""></textarea>
                                    </div>
                                    <div class=" buttons">
                                        <a id="btn_add_job_fin" class="btn btn-primary btn-sm">添加</a>
                                        <a id="btn_cancel_job" class="btn btn-default btn-sm">取消</a>
                                    </div>
                                </div>
                            </div>
                            <div id="no_add_job" class="well well-sm no-add">您还没有添加项目经历</div>
                        </div>
                        <button id="btn_add_job" type="button" class="btn btn-info btn-edit">添加</button>
                    </div>

                    <div class="sep">
                    </div>
                    
                    <div class="mod">
                        <span class="lan-font-20 lan-font-green">教育经历</span>
                        <br />
                        <div href="#" class="lan-font-12 edus">
                            <div class="list-group list-jobs">
                                <div href="#" class="list-group-item hidemod">
                                    <div class="progress" style="display:none;">
                                        <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width:0%">
                                            <span class="sr-only"></span>
                                        </div>
                                    </div>
                                    <h4 class="list-group-item-heading"><span class="edu-school">北京工业大学</span>
                                        <a class="btn btn-danger btn-xs pull-right deledu">删除</a>
                                        <a href="#" class="btn btn-success btn-xs pull-right editedu">编辑</a>
                                    </h4>
                                    <p class="list-group-item-text">
                                        <span class="edu-date">2013年11月 - 2014年12月</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="edu-dre">本科生</span><br />
                                        <span class="txt"></span>
                                    </p>
                                </div>
                            </div>
                            <div class="add-dialog panel panel-default" style="display:none;">
                                <div class="panel-heading">添加教育信息</div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label>学校名称</label>
                                        <input class="form-control txt-normal" id="edu_title" placeholder="请输入学校名称" />
                                    </div>
                                    <div class="form-group">
                                        <label>在校时间</label>
                                        <input class="form-control txt-normal2" id="edu_stime" placeholder="开始时间" />
                                        <input class="form-control txt-normal2" id="edu_etime" style="margin-left:2%;" placeholder="结束时间" />
                                    </div>
                                    <div class="form-group">
                                        <label>获颁学位</label>
                                        <input class="form-control txt-normal" id="edu_dre" placeholder="请输入最高学位" />
                                    </div>
                                    <div class="form-group">
                                        <label class="lan-vt">个人简介</label>
                                        <textarea id="grjj" class="form-control txt-normal" cols="" rows=""></textarea>
                                    </div>
                                    <div class=" buttons">
                                        <a id="btn_add_edu_fin" class="btn btn-primary btn-sm">添加</a>
                                        <a id="btn_cancel_edu" class="btn btn-default btn-sm">取消</a>
                                    </div>
                                </div>
                            </div>
                            
                            <div id="no_add_edu" class="well well-sm no-add">您还没有添加教育信息</div>
                        </div>
                        <button id="btn_add_edu" type="button" class="btn btn-info btn-edit">添加</button>
                    </div>
                    
                    
                    <div class="sep">
                    </div>
                    
                    <div class="mod">
                        <span class="lan-font-20 lan-font-green">工作经历</span>
                        <br />
                        <div href="#" class="lan-font-12 works">
                            <div class="list-group list-jobs">
                                <div href="#" class="list-group-item hidemod">
                                    <div class="progress" style="display:none;">
                                        <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width:0%">
                                            <span class="sr-only"></span>
                                        </div>
                                    </div>
                                    <h4 class="list-group-item-heading"><span class="com-name">公公司名称司名称</span>
                                        <a class="btn btn-danger btn-xs pull-right delwork">删除</a>
                                        <a class="btn btn-success btn-xs pull-right editwork">编辑</a>
                                    </h4>
                                    <p class="list-group-item-text">
                                        <span class="com-time"></span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="com-zw">项目经理</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="com-loc">北京市通州区</span><br />
                                        <span class="txt">个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍</span>
                                    </p>
                                </div>
                            </div>
                            <div class="add-dialog panel panel-default" style="display:none;">
                                <div class="panel-heading">添加工作经历</div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label>公司名称</label>
                                        <input type="email" class="form-control txt-normal" id="company" placeholder="请输入公司名称" />
                                    </div>
                                    <div class="form-group">
                                       <label>职位头衔</label>
                                        <input type="email" class="form-control txt-normal" id="tagline" placeholder="请输入公司名称" />
                                    </div>
                                    <div class="form-group">
                                       <label>工作地区</label>
                                        <input type="email" class="form-control txt-normal" id="location" placeholder="请输入公司名称" />
                                    </div>
                                    <div class="form-group">
                                        <label>在职时间</label>
                                        <input class="form-control txt-normal2" id="work_stime" placeholder="开始时间" />
                                        <input class="form-control txt-normal2" id="work_etime" style="margin-left:2%;" placeholder="结束时间" />
                                    </div>
                                    <div class="form-group">
                                        <label class="lan-vt">职务描述</label>
                                        <textarea id="zwms" class="form-control txt-normal" cols="" rows=""></textarea>
                                    </div>
                                    <div class=" buttons">
                                        <a id="btn_add_work_fin" class="btn btn-primary btn-sm">添加</a>
                                        <a id="btn_cancel_work" class="btn btn-default btn-sm">取消</a>
                                    </div>
                                </div>
                            </div>
                            
                            <div id="no_add_work" class="well well-sm no-add">您还没有添加工作经历</div>
                        </div>
                        <button id="btn_add_work" type="button" class="btn btn-info btn-edit">添加</button>
                    </div>
                    
                    
                    
                    <div class="sep">
                    </div>
                    
                    <div class="mod">
                        <span class="lan-font-20 lan-font-green">认证信息</span>
                        <br />
                        <div href="#" class="lan-font-12 licens">
                            <div class="list-group list-jobs">
                                <div href="#" class="list-group-item hidemod">
                                    <div class="progress" style="display:none;">
                                        <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width:0%">
                                            <span class="sr-only"></span>
                                        </div>
                                    </div>
                                    <h4 class="list-group-item-heading"><a href="#" class="licen-name">认证名称</a>
                                        <a class="btn btn-danger btn-xs pull-right dellicen">删除</a>
                                        <a class="btn btn-success btn-xs pull-right editlicen">编辑</a>
                                    </h4>
                                    <p class="list-group-item-text">
                                        <span class="licen-time"></span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="licen-org">认证公司：</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span class="licen-loc">认证号：</span><br />
                                        <span class="txt">个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍个人介绍</span>
                                    </p>
                                </div>
                            </div>
                            <div class="add-dialog panel panel-default" style="display:none;">
                                <div class="panel-heading">添加认证信息</div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label>认证名称</label>
                                        <input class="form-control txt-normal" id="licen_name" placeholder="请输入认证名称" />
                                    </div>
                                    <div class="form-group">
                                       <label>认证公司</label>
                                        <input class="form-control txt-normal" id="licen_com" placeholder="请输入认证机构" />
                                    </div>
                                    <div class="form-group">
                                       <label>认证网址</label>
                                        <input class="form-control txt-normal" id="licen_url" placeholder="请输入URL" />
                                    </div>
                                    <div class="form-group">
                                       <label>认证号码</label>
                                        <input class="form-control txt-normal" id="licen_code" placeholder="请输入号码" />
                                    </div>
                                    <div class="form-group">
                                        <label>认证时间</label>
                                        <input class="form-control txt-normal2" id="licen_stime" placeholder="开始时间" />
                                        <input class="form-control txt-normal2" id="licen_etime" style="margin-left:2%;" placeholder="结束时间" />
                                    </div>
                                    <div class="form-group">
                                        <label class="lan-vt">认证描述</label>
                                        <textarea id="rzms" class="form-control txt-normal" cols="" rows=""></textarea>
                                    </div>
                                    <div class=" buttons">
                                        <a id="btn_add_licen_fin" class="btn btn-primary btn-sm">添加</a>
                                        <a id="btn_cancel_licen" class="btn btn-default btn-sm">取消</a>
                                    </div>
                                </div>
                            </div>
                            
                            <div id="no_add_licen" class="well well-sm no-add">您还没有添加认证信息</div>
                        </div>
                        <button id="btn_add_licen" type="button" class="btn btn-info btn-edit">添加</button>
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