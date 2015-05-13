<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
    <meta charset="utf-8">
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
    <jsp:include page="/WEB-INF/common/TopBar.jsp"/>  
    <br />
    <div class="container newjob">
        <div class="row">
            <div class="page-header">
                <h1 class="step-xh">
                    <span class="step_sp one"></span>
                    <!--<small class="lan-font-green">填写工作信息 >> </small>
                    <small>选择发布类型 >> </small>
                    <small>工作信息预览</small>-->
                    
                    <span class="apply_temp btn btn-primary btn-xs pull-right">应用模板</span>
                </h1>
            </div>
            
            <form class="step1 basic-form col-md-6" role="form" method="post" action="#">
                <div class="form-group <!--has-error has-feedback-->">
                    <label for="exampleInputEmail1" class="control-label">
                        工作名称：</label>
                    <input value="" type="text" class="form-control" id="inp_jobname" placeholder=""
                        data-container="body" data-toggle="popover" data-placement="right" 
                        data-content="请输入合法的用户名" data-trigger="manual" data-animation="false"/>
                </div>
                <div class="form-group <!--has-error has-feedback-->">
                    <label for="exampleInputEmail1" class="control-label">
                        工作描述：</label>
                    <span class="btn btn-link pull-right cancle-temp" style="display:none;padding:0px;"><span class="glyphicon glyphicon-share-alt"></span>取消模板</span>
                    <textarea class="form-control" id="inp_detail" rows="3"></textarea>
                </div>
                
                <div class="form-group <!--has-error has-feedback-->">
                    <label for="exampleInputEmail1" class="control-label">
                        选择工作的分类：</label><br />
                    <select id="cate-lev1" class="form-control job_cate">
                        <option value="-1">选择分类</option>
                    </select>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <select id="cate-lev2" class="form-control job_cate">
                        <option value="-1">选择子分类</option>
                    </select>
                </div>
                
                <div class="form-group <!--has-error has-feedback-->">
                    <label for="exampleInputEmail1" class="control-label">
                        选择需要的技能：</label><br /> 
                    
                    <div class="panel panel-default skill-sea post-container">
                        <div class="panel-heading ">
                            <h3 class="panel-title lan-font-12">
                                <input id="inp_key_cate" disabled="disabled" type="text" class="form-control" value="请先选择工作的分类" />
                            </h3>
                        </div>
                        <div class="panel-body list-search">
                            <ul class="list-skills"></ul>
                        </div>
                    </div>
                    <div class="sel-skills">
                        <div class="skl-title">
                            <b>选择的技能</b>（最多5个）
                        </div>
                        <div class="list-sel-skill">
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="form-group <!--has-error has-feedback-->">
                    <label for="exampleInputEmail1" class="control-label">
                        设置工作安排（可选）：</label><br />
                     
                    <select class="form-control lan-dis-iblock sml-sel sel-arrange">
                        <option value="hourly">时薪</option>
                        <option value="fixed">固定价格</option>
                    </select>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="sxfw" style="display:inline-block">
                        <span class="lbl-money">时薪范围：</span>
                        <input value="" type="text" class="form-control sml-inp lan-dis-iblock sx-start control-pd" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="" data-trigger="manual" data-animation="false"/>
                        <span>元&nbsp;&nbsp;-&nbsp;&nbsp;</span>
                        <input value="" type="text" class="form-control sml-inp lan-dis-iblock sx-end control-pd"  placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="" data-trigger="manual" data-animation="false"/>
                        <span>元</span>
                    </div>
                    <br />
                    <br />
                    <div class="smlp">
                        <span>工作时间：</span>
                        <input value="40" type="text" class="form-control sml-inp2 lan-dis-iblock work-hour" id="inp_gdjg" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="" data-trigger="manual" data-animation="false"/>
                        <span>小时/周</span>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <span>工作周期：</span>
                        <input value="" type="text" class="form-control sml-inp lan-dis-iblock work-zq" id="inp_gdjg1" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="" data-trigger="manual" data-animation="false"/>
                        <span>周&nbsp;&nbsp;-&nbsp;&nbsp;</span>
                        <input value="" type="text" class="form-control sml-inp lan-dis-iblock work-zq2" id="inp_gdjg2" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="" data-trigger="manual" data-animation="false"/>
                        <span>周</span>
                    </div>
                    
                    <br />
                    <div class="form-group">
                         <label for="exampleInputEmail1" class="control-label">
                            设置工作地点（可选）：</label><br />
                        <div class="well well-sm lan-ov-hid">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="radvisible" id="jpublic" value="option1" checked>
                                    公开—才才网所有用户都可以看到我的位置信息
                                </label>
                            </div>
                            <div class="checkbox" id="jpublic_chk" style="margin-left:21px;">
                                <label>
                                    <input id="chk_search" type="checkbox" value="" checked="checked" />
                                    搜索引擎可以搜索到我的信息
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="radvisible" id="jprivate" value="option2">
                                    私有— 无法被搜索到，仅我自己和我指定的人可以看到信息
                                </label>
                            </div>
                            
                            <br />
                            <label for="exampleInputEmail1" class="control-label">
                            工作地点：</label><br />
                            <div class="radio">
                                <label>
                                    <input id="job_xc" name="jobloc" type="radio" value="" />
                                    到现场工作
                                </label>
                            </div>
                            <select id="sel_province" class="form-control lan-dis-iblock sml-sel sel-location">
                                <option value="-1">请选择</option>
                            </select>
                            <select id="sel_city" class="form-control lan-dis-iblock sml-sel sel-location">
                                <option value="-1">请选择</option>
                            </select>
                            <br class="sel-location" />
                            <input value="" type="text" class="form-control sel-location" id="inp_locDesc" placeholder="请输入详细的地址"
                            data-container="body" data-toggle="popover" data-placement="right" style="margin-top:5px;"
                            data-content="" data-trigger="manual" data-animation="false"/>
                            
                            <div class="radio">
                                <label>
                                    <input id="job_yc" name="jobloc" type="radio" value="" checked="checked"/>
                                    远程办公
                                </label>
                            </div>
                            
                            <br />
                            <label for="exampleInputEmail1" class="control-label">
                            发布工作的时间：</label><br />
                            <select id="add_days" class="form-control lan-dis-iblock sml-sel">
                                <option value="15">15天</option>
                                <option value="30">30天</option>
                                <option value="45">45天</option>
                                <option value="60">60天</option>
                            </select>
                            
                            <br /><br />
                            <label for="exampleInputEmail1" class="control-label">
                            工作的时间开始时间：</label>
                            <div class="radio">
                                <label>
                                    <input checked="checked" type="radio" name="radtime" id="jim" value="option2">
                                    申请之后立即启动项目
                                </label>
                            </div>
                            <div class="radio pull-left">
                                <label>
                                    <input type="radio" name="radtime" id="jsel" value="option2" />
                                    项目开始会在：
                                </label>
                            </div>
                            <input value="" type="text" class="form-control sml-inp lan-dis-iblock pull-left inp_date" id="startTime" placeholder=""
                                data-container="body" data-toggle="popover" data-placement="right" style="margin-top:-9px;margin-left:10px;height:30px;width:150px;"
                                data-content="" data-trigger="manual" data-animation="false"/>
                            
                        </div>
                    </div>
                    
                </div>
                
                <div>
                    <button data-val="posted" autocomplete="off" data-loading-text="保存中..." type="button" class="btn btn-primary btn_sace">继续</button>
                    <!--<button data-val="draft" autocomplete="off" data-loading-text="保存中..." type="button" class="btn btn-default btn_sace2">保存草稿</button>-->
                </div>
            </form>
            
            <form class="step2 col-md-12" style="margin-top:50px;display:none;" role="form" method="post" action="#">
                <div class="thumbnail col-md-3 lan-bg-f5" style="display:none;">
                    <fieldset disabled="disabled">
                        <div class="caption" align="center">
                            <h3>特色服务</h3>
                            <p class="step-intro">
                                <span class="glyphicon glyphicon-ok lan-font-green" aria-hidden="true"></span> ???? ?? ??? ???? ????? ??????? <br />
                                <span class="glyphicon glyphicon-ok lan-font-green" aria-hidden="true"></span> ??? ??% ???? ????????? <br />
                                <span class="glyphicon glyphicon-ok lan-font-green" aria-hidden="true"></span> ?????? ????????? ?????????? <br />
                                <span class="glyphicon glyphicon-ok lan-font-green" aria-hidden="true"></span> ??????????? ???????
                            </p>
                            <p align="center">
                                <b>￥??</b><br />
                                <a disabled="disabled" data-type="l1" href="#" class="btn btn-default sml-inp btn-select" role="button">选择</a> 
                            </p>
                        </div>
                    </fieldset>
                </div>
                <div class="thumbnail col-md-3" style="height:330px;margin-top:-30px;display:none;">
                    <fieldset disabled="disabled">
                        <div class="caption" align="center">
                            <h3>基础服务</h3>
                            <p class="step-intro">
                                <span class="glyphicon glyphicon-ok lan-font-green" aria-hidden="true"></span> ???? ?? ??? ???? ????? ??????? <br />
                                <span class="glyphicon glyphicon-ok lan-font-green" aria-hidden="true"></span> ??? ??% ???? ????????? <br />
                            </p>
                            <p align="center">
                                <b>￥??</b><br />
                                <a data-type="l2" href="#" class="btn btn-success sml-inp btn-select" role="button">选择</a> 
                            </p>
                        </div>
                    </fieldset>
                </div>
                <div class="thumbnail col-md-3 lan-bg-f5" style="margin-left:440px;">
                    <div class="caption" align="center">
                        <h3>免费服务</h3>
                        <p class="step-intro">
                             <span class="glyphicon glyphicon-ok lan-font-green" aria-hidden="true"></span> 自由职业者/自由顾问可查看及申请您发布的招聘需求
                        </p>
                        <p align="center">
                            <b>Free</b><br />
                            <a data-type="l3" href="#" class="btn btn-default sml-inp btn-select" role="button">选择</a> 
                        </p>
                    </div>
                </div>
            </form>
            
            <form class="step3 col-md-12" style="margin-top:10px;display:none;" role="form" method="post" action="#">
                <table border="0" class="table table-striped job-preview">
                    
                </table>
                
                <button data-val="posted" id="btn_save_job" autocomplete="off" data-loading-text="保存中..." type="button" class="btn btn-primary btn_sace_conf">发布</button>
                <button data-val="draft" id="btn_return_job" autocomplete="off" data-loading-text="保存中..." type="button" class="btn btn-default btn_return">返回编辑</button>
            </form>
            
        </div>
    </div>

    <div id="job-template" class="panel panel-primary">
        <div class="panel-body">
            <b class="chfont">
                所有的工作模板列表
                <span class="glyphicon glyphicon-remove btn-close"></span>
                </b>
                <br />
            <span class="chfont ntxt">使用模板快速建立自己的工作描述。</span>
             <br /> <br />
            <p class="sel-cate">
                <label class="chfont lan-font-green">
                    选择一个工作分类</label><br />
                <select class="chfont" id="tmp_cate">
                    <option value="-1">请选择</option>
                </select>
            </p>
            <div class="pg-list">
                <div class="pg-con list-templates">
                    
                </div>
            </div>

            <div class="tmp-page list-pages">
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
    <script type="text/javascript" src="/lance/resources/js/page/postjob.js"></script>
    <jsp:include page="/WEB-INF/common/BottomBar.jsp"/>
  </body>
</html