<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>首页</title>
        <!-- Bootstrap -->
        <link href="/lance/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" href="/lance/resources/js/jqueryui/jquery-ui.css" rel="stylesheet" />
        <link href="/lance/resources/css/common/common.css" rel="stylesheet" type="text/css"/>
        <link href="/lance/resources/css/control/main.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" href="/lance/resources/css/postjob.css" rel="stylesheet" />
        <link type="text/css" href="/lance/resources/css/control/report.css" rel="stylesheet" />
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
            <div class="col-md-12 jobDetail">
                <a href="/lance/pages/search"><span aria-hidden="true">&larr;</span> 返回搜索工作列表</a>
                <br /><br />
                
                <div class="alert alert-info" role="alert" id="inf-cnt">
                    您可在此查看及申请工作，还可向发布信息者进行提问。<br/>
                    您可在申请时提出自己认为合理的价格和可以进入项目的时间。<br/>
                    为保护您的隐私，您的用户名、公司名信息将在第一次回复后显示给被回复者
                    只有信息发布者能够查看您的报价信息
                </div>
                
                <div>
                    <h2 class="lan-font-green jobtitle"></h2>
                    <ol class="breadcrumb">
                        <li><a href="#" id="cat_name"></a></li>
                        <li><a href="#" id="subcat_name"></a></li>
                    </ol>
                    
                    <div class="panel panel-default">
                        <div class="panel-body">
                                  <table border="0" width="100%" class="title-info">
                                    <tbody id="job-msg-area">
                                       <script id="job-msg-sp1" type="text/html">
                                        {{if status=="fixed"}}
                                             <tr>
                                                <td>
                                                    <span class="glyphicon glyphicon-time"></span> 项目总价：<span id="Fixed-Pay"></span>
                                                </td>
                                                 <td>
                                                    <span class="glyphicon glyphicon-time"></span> 计费方式：固定价格
                                                </td>
                                                <td>
                                                    <span class="glyphicon glyphicon-time"></span> 工作地点：<span id="IndexLocation"></span>
                                                </td>
                                                 <td>
                                                    <span class="glyphicon glyphicon-time"></span> 发布时间：<span id="CreateOn">2015-01-23</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                  <span class="glyphicon glyphicon-time"></span> 办公方式：<span id="FixedLocation"></span>
                                                </td>
                                                <td>
                                                  <span class="glyphicon glyphicon-time"></span> 项目开始时间：<span id="PostJobDateStart"></span>
                                                </td>
                                                <td>
                                                   <span class="glyphicon glyphicon-time"></span> 项目结束时间：<span id="PostJobDateEnd"></span>
                                                </td>
                                                <td>
                                                   
                                                </td>
                                            </tr>
                                         {{else if status=="hourly"}} 
                                             <tr>
                                                <td>
                                                    <span class="glyphicon glyphicon-time"></span> 价格：<span id="hourly-Pay"></span>
                                                </td>
                                                <td>
                                                    <span class="glyphicon glyphicon-time"></span> 工作周期：<span id="Duration"></span>
                                                </td>
                                                <td>
                                                    <span class="glyphicon glyphicon-time"></span> 工作地点：<span id="IndexLocation"></span>
                                                </td>
                                                <td>
                                                    <span class="glyphicon glyphicon-time"></span> 发布时间：<span id="CreateOn">2015-01-23</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <span class="glyphicon glyphicon-time"></span> 每周工作时间：<span id="Weekly-Hours"></span>
                                                </td>
                                                <td>
                                                    <span class="glyphicon glyphicon-time"></span> 项目开始时间：<span id="PostJobDateStart"></span>
                                                </td>
                                                <td>
                                                    <span class="glyphicon glyphicon-time"></span> 项目结束时间：<span id="PostJobDateEnd"></span>
                                                </td>
                                                <td>
                                                </td>
                                             </tr>
                                           {{/if}}
                                       </script>
                                    </tbody>
                                </table>
                            
                                <hr class="dotline" align="center" />
                                <div class="media lan-bg-f5">
                                    <div class="media-left media-middle">
                                        <a href="#" class="thumbnail">
                                           <img width="64px" height="64px" id="thu-img" src="/lance/resources/image/avatar/normal_1.png" class="media-object" alt="" />
                                        </a>
                                    </div>
                                    <div class="media-body">
                                        <h4 class="media-heading"><span id="cu-cnt">客户信息</span>  <span id="client-location"></span></h4>
                                        <!--<span class="glyphicon glyphicon-star lan-font-yellow"></span>
                                        <span class="glyphicon glyphicon-star lan-font-yellow"></span>
                                        <span class="glyphicon glyphicon-star lan-font-yellow"></span>
                                        <span class="glyphicon glyphicon-star lan-font-yellow"></span>
                                        <span class="glyphicon glyphicon-star-empty lan-font-yellow"></span>-->
                                    </div>
                                </div>
                                
                                <p class="pre-txt">
                                   <span id="Brief"></span>
                                </p>
                                <br /><br /><br />
                                <div class="exp-skill" id="skill-cnt">
                                    <script id="skill-cnt-sp1" type="text/html">
                                        <b>期望的技能：</b>
                                        {{each list as data i}}
                                           <span class="label label-info">{{data}}</span>
                                        {{/each}}
                                     </script>
                                </div>
                            </div>
                        
                        <div class="panel-footer" align="right" id="btn-area">
                            <script id="btn-area-sp1" type="text/html">
                                {{if show=="Y"}} 
                                   <button type="button" class="btn btn-warning btn-sm" name="btn_note">留言</button>
                                   <button type="button" class="btn btn-success btn-sm" name="btn_apply">申请</button>
                                {{else if show=="N"}}
                                   <button type="button" class="btn btn-danger btn-xs" name="btn_del">删除</button>
                                {{else if show=="deleted"}}
                                    <span class="tip-span">该招聘信息已删除</span>
                                {{/if}}
                            </script>
                        </div>
                    </div>
                </div>
                
                <div class="question-list">
                    <div class="lan-bg-e7">
                        <b>提问申请列表</b>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span id="radio-area">
                        <script id="radio-area-sp1" type="text/html">
                             <label class="radio-inline">
                                <input type="radio" name="wtlb" id="rad-all" value="all" checked="checked" > 全部
                            </label>
                            {{if pid=="client"}} 
                                <label class="radio-inline">
                                    <input type="radio" name="wtlb" id="rad-apply" value="apply"/> 只看申请 <span id="span-apply"></span>
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="wtlb" id="rad-sec" value="second"> 查看备选 <span id="span-option"></span>
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="wtlb" id="rad-agree" value="agree"> 已同意的申请 <span id="span-agree"></span>
                                </label>
                            {{else if pid == "lancer"}}
                                <label class="radio-inline">
                                    <input type="radio" name="wtlb" id="rad-owner" value="owner"> 与我相关 <span id="span-owner"></span>
                                </label>
                            {{/if}}
                        </script>
                        </span>
                    </div>
                    
                    <div class="list-mods" id="list-discuss">
                        <script id="list-discuss-sp1" type="text/html"> 
                           {{if list.length == 0}}<div class="media-body qmedia">暂无评论</div>{{/if}}
                           {{each list as data i}}
                             <div class="media">
                                <div class="media-left media-middle list-img">
                                   {{if (data.Img != null && data.Img != "")}}
                                       <a href="#" class="thumbnail">
                                         <img width="64px" height="64px" src="/lance/resources/image/avatar/{{data.Img}}.png" class="media-object" alt="" />
                                       </a>
                                   {{else}}
                                      <a href="#" class="thumbnail">
                                         <img width="64px" height="64px" src="/lance/resources/image/avatar/normal_1.png" class="media-object" alt="" />
                                      </a>
                                   {{/if}}
                                </div>
                                <div class="media-body qmedia">
                                    <h4 class="media-heading lan-font-green">{{data.CreateBy}} 
                                      {{if (data.Location != null && data.Location != "")}} | {{data.Location}} {{/if}} 
                                      {{if data.Status == 'agreed' && (User.UserName==Publisher || User.UserName==data.CreateBy)}}
                                          <span class="tip-span">&nbsp;&nbsp;(接受申请√)</span>
                                      {{else if data.Status == 'option' && (User.UserName==Publisher || User.UserName==data.CreateBy)}}
                                          <span class="tip-span">&nbsp;&nbsp;(备选√)</span>
                                      {{/if}}
                                    </h4>
                                    <span id="u-discuss">&nbsp;&nbsp;{{data.Content}}</span>
                                    <br />
                                    {{if (data.IsApply=='Y')}}
                                        <div class="exa-intro">
                                            <span>申请:{{if data.SignBy=='self'}} 个人承接 {{else}} 公司承接 {{/if}}</span> | 
                                            <span>报价：
                                            {{if (User.UserName==Publisher || User.UserName==data.CreateBy)}}
                                                {{if data.Postform=='hourly'}} 
                                                      {{if data.HourlyPay !=null}} {{data.HourlyPay}}元/小时 
                                                      {{else}} 面议 {{/if}} 
                                                {{else}} 
                                                      {{if data.FixedPayMin != null}} {{data.FixedPayMin}}元~{{data.FixedPayMax}}元 {{else}} 面议 {{/if}} 
                                                {{/if}}
                                            {{else}}
                                                — 
                                            {{/if}}
                                            </span> | {{if data.Postform=='hourly'}} <span>每周工作时间：{{data.WeeklyHours}}小时</span> | {{/if}}
                                            <span>申请时间：{{data.CreateOn}}</span>
                                        </div>
                                    {{/if}}
                                    <div>
                                        {{if status=='posted'}}
                                            {{if (User.UserName==Publisher && data.IsApply=='Y')}}
                                               {{if data.Status == 'display'}}
                                                  <button type="button" name="btn-agree" uuid="{{data.Uuid}}" class="btn btn-success btn-xs">接受</button>
                                                  <button type="button" name="btn-option" uuid="{{data.Uuid}}" class="btn btn-success btn-xs">加入备选</button>
                                                  <button type="button" class="btn btn-danger btn-xs" uuid="{{data.Uuid}}" name="dis-del">删除</button>
                                               {{else if data.Status == 'option'}}
                                                  <button type="button" name="btn-agree" uuid="{{data.Uuid}}" class="btn btn-success btn-xs">接受</button>
                                                  <button type="button" name="btn-cancel-option" uuid="{{data.Uuid}}" class="btn btn-success btn-xs">取消备选</button>
                                                  <button type="button" class="btn btn-danger btn-xs" uuid="{{data.Uuid}}" name="dis-del">删除</button>
                                               {{else if data.Status == 'agreed'}}
                                                  <button type="button" name="btn-cancel-agree" uuid="{{data.Uuid}}" class="btn btn-success btn-xs">取消已接受的申请</button>
                                               {{/if}}
                                            {{else if (User.UserName==Publisher && data.IsApply=='N')}}
                                               {{if data.children.length > 0}}
                                                 <button type="button" class="btn btn-success btn-xs" uuid="{{data.Uuid}}" name="ques-replay">回复</button>
                                               {{else}}
                                                  <button type="button" class="btn btn-danger btn-xs" uuid="{{data.Uuid}}" name="dis-del">删除</button>
                                                  <button type="button" class="btn btn-success btn-xs" uuid="{{data.Uuid}}" name="ques-replay">回复</button>
                                               {{/if}}
                                            {{else if (User.UserName!=Publisher && data.CreateBy==User.UserName && (data.IsApply=='N' || data.IsApply=='Y'))}}
                                                {{if data.children.length == 0}}
                                                   {{if data.Status == 'display'}}
                                                      <button type="button" class="btn btn-danger btn-xs" uuid="{{data.Uuid}}" name="dis-del">删除</button>
                                                   {{/if}}
                                               {{else}}
                                                  <button type="button" class="btn btn-success btn-xs" uuid="{{data.Uuid}}" name="ques-replay">留言</button>
                                               {{/if}}
                                            {{/if}}
                                        {{/if}}
                                    </div>
                                    {{each data.children as cr i}}
                                        <div class="lan-bg-f5 lan-ov-hid">
                                            <span class="pull-left">
                                               {{if (cr.CreateBy == Publisher) }}
                                                    甲方客户&nbsp;回复&nbsp;{{cr.CreateBy}}
                                               {{else}}
                                                    {{cr.CreateBy}}&nbsp;提问&nbsp;甲方客户
                                               {{/if}}
                                            </span>
                                            <span class="pull-right">{{cr.CreateOn}}</span><br/>
                                            &nbsp;&nbsp;&nbsp;&nbsp;{{cr.Content}}
                                            <div style="float:right;">
                                               {{if status=='posted'}}
                                                    {{if ((data.CreateBy==User.UserName || cr.CreateBy==User.UserName) && data.IsApply=='N')}}
                                                        <button type="button" class="btn btn-danger btn-xs" uuid="{{cr.Uuid}}" name="dis-del">删除</button>
                                                    {{else if (data.CreateBy==User.UserName && cr.CreateBy!=User.UserName && data.IsApply=='N')}}
                                                        <button type="button" class="btn btn-success btn-xs" uuid="{{data.Uuid}}" name="ques-replay">回复</button>
                                                    {{/if}}
                                               {{/if}}
                                            </div>
                                        </div>
                                    {{/each}}
                                </div>
                            </div>
                         {{/each}}
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!--回复-->
    <div class="modal fade" id="ques_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">留言回复</h4>
                </div>
                <div class="modal-body">
                    <div class="alert alert-info" role="alert">
                        在此提出关于此项工作的问题<br />
                        提问内容会被公开显示
                    </div>
                     <div class="form-group">
                        <label for="inp_comments" class="control-label">请输入回复内容：</label>
                        <textarea class="form-control" rows="3" id="replay-content"></textarea>
                     </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="replay-submit">确认</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 留言 -->
    <div class="modal fade" id="post_ques" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">提出留言</h4>
                </div>
                <div class="modal-body">
                    <div class="alert alert-info" role="alert">
                        在此提出关于此项工作的问题<br />
                        提问内容会被公开显示
                    </div>
                     <div class="form-group">
                        <label for="inp_comments" class="control-label">请输入问题描述：</label>
                        <textarea class="form-control" rows="3" id="ques-content"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="ques-submit">确认</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 申请 -->
    <div class="modal fade" id="post_apply" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">提出申请</h4>
                </div>
                <div class="modal-body">
                    <div class="alert alert-info" role="alert">
                        申请此项工作。<br />
                        您可在此处提出自己的要求，并提出您所关心的问题。<br /><br />
                        
                        谁能查看我的申请<br />
                        被申请人<br />
                        SVIP账户可查看VIP与普通账户发布的报价信息。<br />
                        VIP账户可查看普通账户发布的报价信息。<br />
                        只有被申请甲方能查看SVIP账户发布的报价信息。<br />
                    </div>
                    
                    <form class="form-inline" action="#" method="post" role="form">
                        <div class="form-group">
                            <label for="inp_name" class="control-label"> 合同签署</label>
                            <br />
                            <label class="radio-inline">
                                <input type="radio" name="htqs" id="grmy-gr" value="self" checked="checked"> 个人名义
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="htqs" id="grmy-gs" value="company"> 所属公司
                            </label>
                            <span id="ht-comments" style="color:red;font-size:12px;"></span>
                        </div>
                        <br />
                        <br />
                        <div class="form-group">
                            <label for="inp_name" class="control-label">
                                结款方式</label>
                            <br />
                            <label class="radio-inline">
                                <input type="radio" name="jkfs" id="asj-jf" value="hourly" checked="checked"> 按时间计费
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="jkfs" id="gdjg-jf" value="fixed"> 固定价格项目
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="jkfs" id="shqd-jf" value="later"> 稍后填写价格
                            </label>
                        </div>
                        <br />
                        <div id="jffs-cnt">
                            <script id="jffs-cnt-sp1" type="text/html">
                                {{if jffs == 'sjjf'}}
                                    <div class="form-group">
                                        <label for="inp_mail" class="control-label">请输入报价</label>
                                        <br />
                                        ￥<input type="text" class="form-control inp-txt" id="HourlyPay" placeholder=""
                                            data-container="body" data-animation="false" />元/小时
                                    </div>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <div class="form-group">
                                        <label for="inp_mail" class="control-label">
                                            请输入每周工作时间</label>
                                        <br />
                                        <input type="text" class="form-control inp-txt" id="Weekly_Hours" placeholder=""
                                            data-container="body" data-toggle="popover" data-placement="right" 
                                            data-content="请输入正确的邮箱格式" data-trigger="manual" data-animation="false" />小时
                                    </div>
                                {{else if jffs == 'gdjg'}}
                                    <div class="form-group">
                                        <label for="inp_mail" class="control-label">请输入项目预算</label>
                                        <br />
                                        从&nbsp;&nbsp;￥<input type="text" class="form-control inp-txt" placeholder=""
                                            data-container="body" id="fixed_pay_min" data-animation="false" />元
                                    </div>
                                    &nbsp;&nbsp;
                                    <div class="form-group">
                                        <label for="inp_mail" class="control-label">
                                            &nbsp;&nbsp</label>
                                        <br />
                                        到&nbsp;&nbsp;￥<input type="text" class="form-control inp-txt" placeholder=""
                                            data-container="body" id="fixed_pay_max" data-trigger="manual" data-animation="false" />元
                                    </div>
                                {{/if}}
                            </script>
                        </div>
                        
                        <br />
                        <div class="form-group">
                            <label for="inp_name" class="control-label">可进入项目时间</label>
                            <br />
                            <label class="radio-inline">
                                <input type="radio" name="jrsj" id="shqd-sj" value="later"> 稍后确定
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="jrsj" value="date" id="zdrq-sj" checked="checked"> 指定日期
                            </label>
                            <span id="sj-span">
                                <input type="text" id="entry_d" class="sml-input" />
                                <span id="err-date" style="color:Red;font-size:12px;"></span>
                            </span>
                        </div>
                        <br />
                        <br />
                        <div class="form-group">
                            <label for="inp_name" class="control-label">附加描述（可选）</label>
                            <br />
                            <textarea class="form-control" id="apply-content" rows="3" style="width:557px;"></textarea>
                        </div>
                    </form>
                </div>
                 <div id="lancerMsg" class="alert alert-warning alert-dismissible" role="alert" style="display:none;">
                   <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                   <strong style="color:Red;">系统提示:</strong><span id="lan-msg" style="color:Red;"></span>
                 </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="apply-submit">确认</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/lance/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/lance/resources/js/jqueryui/jquery-ui.js" type="text/javascript"></script>
    <script type="text/javascript" src="/lance/resources/js/jquery.json-2.4.js"></script>
    <script src="/lance/resources/js/core.js" type="text/javascript"></script>
    <script src="/lance/resources/js/control/lan_check.js" type="text/javascript"></script>
    <script type="text/javascript" src="/lance/resources/js/page/postJobDetail.js"></script>
    <jsp:include page="/WEB-INF/common/BottomBar.jsp"/>
    </body>
</html>