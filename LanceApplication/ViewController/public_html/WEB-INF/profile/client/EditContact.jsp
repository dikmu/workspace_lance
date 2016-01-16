<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <script>
            var User=${user};
            var Data=${data};
        </script>
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
    </head>
    <body>
    <jsp:include page="/WEB-INF/common/TopBar.jsp" />
    <div class="container">
        <div class="row">
            <div class="col-md-3 lan-main-left">

                <br /><br />
                <ul class="nav nav-stacked">
                    <li role="presentation"><a href="./Profile">公司主页</a></li>
                    <li role="presentation"><a href="./EditBasic">基本信息</a></li>
                    <li role="presentation" class="active"><a href="./EditContact">联系信息</a></li>
                    <li role="presentation"><a href="./EditPostJob">已发工作信息</a></li>
                </ul>
            </div>
            <div class="col-md-9 lan-main-right">
                <div class="page-header">
                    <h1><small>基本联系信息</small></h1>
                </div>
                 <form class="basic-form" role="form" method="post" action="#">
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            联系人：</label>
                        <input value="" type="text" class="form-control sml-inp" id="inp_uname" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="请输入合法的用户名" data-trigger="manual" data-animation="false"/>
                    </div>
                    
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            邮箱地址：</label>
                        <input readonly="readonly" value="" type="text" class="form-control sml-inp" id="inp_email" placeholder=""/>
                        <span id="send-cnt">
                             认证邮箱尚未激活!<a href="#" id="send-email">重新发送激活邮件</a>
                            <span id="sending" style="display: none;color:Red;font-size:12px;">
                               <img src="../../resources/image/loading.gif" alt="" height="16" width="16"/>
                                邮件发送中...
                            </span>
                        </span>
                    </div>
                    
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            手机号码：</label>
                        <input value="" type="text" class="form-control sml-inp" id="inp_phone" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="请输入正确的11位手机号码" data-trigger="manual" data-animation="false"/>
                    </div>
                    
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            联系方式：</label><br />
                        QQ:<input value="" type="text" class="form-control sml-inp" id="inp_contact1" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="" data-trigger="manual" data-animation="false"/><br />
                        Email:<input value="" type="text" class="form-control sml-inp" id="inp_contact2" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="" data-trigger="manual" data-animation="false"/><br />
                        Other:<input value="" type="text" class="form-control sml-inp" id="inp_contact3" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="" data-trigger="manual" data-animation="false"/>
                    </div>
                    
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            联系地址：</label>
                        <br />
                        <select id="sel_country">
                            <option value="44">中国</option>
                        </select>
                        <select id="sel_province" data-id="sel_city">
                            <option value="-1">省份</option>
                        </select>
                        <select id="sel_city">
                            <option class="mod" value="-1">城市</option>
                        </select>
                        <br />
                        <input style="margin-top:5px;" value="" type="text" class="form-control sml-inp" id="inp_loc1" placeholder=""
                            data-container="body" data-toggle="popover" data-placement="right" 
                            data-content="" data-trigger="manual" data-animation="false"/>
                    </div>
                    
                 
                    <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            地址显示选项：</label>
                        <div class="radio">
                            <label>
                                <input type="radio" class="address_rads" name="optionloc" id="rad_all" value="all" checked>
                                显示所有的地点信息
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" class="address_rads" name="optionloc" id="rad_city" value="city">
                                仅仅显示城市，地区
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" class="address_rads" name="optionloc" id="rad_no" value="no">
                                不显示地点信息
                            </label>
                        </div>
                    </div>
                    
                     <div class="form-group <!--has-error has-feedback-->">
                        <label for="exampleInputEmail1" class="control-label">
                            联系信息可见性：</label>
                        <div class="radio">
                            <label>
                                <input type="radio" class="contact_rads" name="optionper" id="rad_per_all" value="all" checked>
                                显示所有个人信息
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" class="contact_rads" name="optionper" id="rad_per_city" value="city">
                                显示一般个人信息
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" class="contact_rads" name="optionper" id="rad_per_no" value="no">
                                不显示个人信息
                            </label>
                        </div>
                    </div>
                    
                    
                    <button autocomplete="off" data-loading-text="保存中..." id="btn_save" type="button" class="btn btn-primary">确定</button>
                 </form>
            </div>

        </div>
    </div>

    
    <jsp:include page="/WEB-INF/common/BottomBar.jsp" />
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/lance/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/lance/resources/js/bootstrap.min.js" type="text/javascript"></script>
    
    <script src="/lance/resources/js/core.js" type="text/javascript"></script>
    <script src="/lance/resources/js/control/lan_check.js" type="text/javascript"></script>
    <script type="text/javascript" src="/lance/resources/js/page/editcontact.js"></script>
    </body>
</html>