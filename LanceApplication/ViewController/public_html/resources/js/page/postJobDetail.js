$(function () {
    var jobId = Data.jobId;
    if(jobId == null){
       return;
    }
    initPostJobData(jobId);
    
    $("#entry_d").datepicker({dateFormat : "yy-mm-dd"});
});

//初始化招聘信息数据
function initPostJobData(jobId){
  jQuery.ajax({
        url : '/lance/res/postJob/'+ jobId+'?random='+Math.random(), type : 'get', success : function (data) {
            $(".jobtitle").html(data.Name);
            $("#job-msg-area").html(template('job-msg-sp1',{'status' : data["Postform"]}));
            var skills=new Array();
            var attrs =new Array("A","B","C","D","E","F","G");
            var i = 0;
            for(var t=0;t<attrs.length;t++){
                if(data["SpecificSkill"+attrs[t]] != null){
                    skills[i]=data["SpecificSkill"+attrs[t]];
                    i++;
                }
            }
            $("#skill-cnt").html(template('skill-cnt-sp1',{'list' : skills}));
            if(data.hasOwnProperty("IndexLocation") && data["IndexLocation"] != null){
                data["IndexLocation"] = data["IndexLocation"].replace(";"," ")
            }
            if(data.hasOwnProperty("FixedLocation")){
               if("Y" == data["FixedLocation"]){
                   data["FixedLocation"] = data["FixedLocation"].replace("Y","现场办公");
               }else{
                   data["FixedLocation"] = data["FixedLocation"].replace("N","远程办公")
               }
            }
            if(data.hasOwnProperty("Img")){
               $("#thu-img").attr("src","/lance/resources/image/avatar/"+data["Img"]+".png");
            }
            if(data.hasOwnProperty("DurationMin")){
                var dur = data["DurationMin"];
                if(data.hasOwnProperty("DurationMax")){
                    dur = dur +"~"+ data["DurationMax"]+"周";
                }
                $("#Duration").html(dur);
            }
            
            if(data.hasOwnProperty("HourlyPayMin")){
                var dur1 = data["HourlyPayMin"];
                if(data.hasOwnProperty("HourlyPayMax")){
                    dur1 = "￥"+dur1 +"~"+ data["HourlyPayMax"]+"元/小时";
                }
                $("#hourly-Pay").html(dur1);
            }
            
            if(data.hasOwnProperty("FixedPayMin")){
                var pay = data["FixedPayMin"];
                if(data.hasOwnProperty("FixedPayMax")){
                    dur = "￥"+pay +"~"+ data["FixedPayMax"]+"元";
                }
                $("#Fixed-Pay").html(dur);
            }
           
           if(data.hasOwnProperty("WeeklyHours")){
                $("#Weekly-Hours").html(data["WeeklyHours"]+"小时");
            }
           if(data.hasOwnProperty("Location") && !("" == data["Location"])){
                $("#client-location").html(" | "+data["Location"]);
           }
           if(data.hasOwnProperty("WorkCategory")){
               $("#cat_name").html(data["CatName"]);
               $("#cat_name").attr("href","/lance/pages/search?type=category&val="+data["WorkCategory"]);
           }
           if(data.hasOwnProperty("WorkCategory")){
               $("#subcat_name").html(data["SubCatName"]);
           }
            for(var key in data){
                if($("#"+key).length > 0){
                    if("Brief" == key){
                       $("#"+key).html("<pre>"+data[key]+"</pre>"); 
                    }else{
                       $("#"+key).html(data[key]); 
                    }
                }
            }
            //判断按钮加载
            var role = null;
            if(User.logined && User.UserName == data["CreateBy"]){
                $("#btn-area").show();
                $("#btn-area").html(template('btn-area-sp1',{'show' : (data["Status"]=='deleted'?"deleted":"N")}));
                $("#radio-area").html(template('radio-area-sp1',{'pid' : "client","u_sta":!User.logined}));
                stat(jobId,"client");
                role = "client";
                $("#inf-cnt").html("查看哪些自由职业者对您的项目感兴趣。<br/>" +
                "对申请人 进行回复留言、加入备选、同意申请的操作后，您的联系信息才会开放给申请人。");
                $("#cu-cnt").html("<a href='/lance/pages/profile/Overview?uid="+data["CreateBy"]+"'>客户信息</a>");
            }else{
                if(User.logined){
                    $("#btn-area").show();
                    $("#btn-area").html(template('btn-area-sp1',{'show' : (data["Status"]=='deleted'?"deleted":"Y")}));
                    $("#radio-area").html(template('radio-area-sp1',{'pid' : "lancer","u_sta":!User.logined}));
                    stat(jobId,"lancer");
                    role = "lancer";
                    $("#inf-cnt").html("您可在此查看及申请工作，还可向发布信息者进行提问。<br/>" +
                    "您可在申请时提出自己认为合理的价格和可以进入项目的时间。<br/>" +
                    "只有信息发布者能够查看您的报价信息。<br/>" +
                    "为保护隐私，您的用户名、公司名信息将在第一次回复后显示给被回复者。");
                    if(data.hasOwnProperty("viewGrant") && "true"==data["viewGrant"]){
                        $("#cu-cnt").html("<a href='/lance/pages/profile/Overview?uid="+(data['CreateBy'])+"'>客户信息</a>");
                    }
                }
            }
            quesSubmit(data["Status"],jobId,data["CreateBy"]);
            replaySubmit(data["Status"],jobId,data["CreateBy"]);
            disDel(data["Status"],jobId,data["CreateBy"],role);
            jfjgChange(data["Status"],jobId,true,data["CreateBy"]);
            submitApply(data["Status"],jobId,data["CreateBy"]);
            initPostDiscussData(data["Status"],jobId,data["CreateBy"]);
            optionApply(data["Status"],jobId,data["CreateBy"]);
            agree(data["Status"],jobId,data["CreateBy"]);
            cancel(data["Status"],jobId,data["CreateBy"]);
        },
        error : function (msg) {
        }
   });
}

//初始化提问申请列表
function initPostDiscussData(status,jobId,publisher){
    jQuery.ajax({
        url : '/lance/res/postJob/'+jobId+'/discuss?random='+Math.random(), type : 'get', success : function (data) {
           $("#list-discuss").html(template('list-discuss-sp1',{'list' : data,"User":User,"Publisher":publisher,"status":status}));
        },
        error : function (msg) {
        }
   });
}

function isNum1(str){
  var reg =/^[1-9]*[1-9][0-9]*$/;
  return reg.test(str);
}

//初始化提问申请列表
function initPostDiscussData2(status,jobId,publisher,type){
    jQuery.ajax({
        url : '/lance/res/postJob/'+jobId+'/'+type+'/discuss?random='+Math.random(), type : 'get', success : function (data) {
           $("#list-discuss").html(template('list-discuss-sp1',{'list' : data,"User":User,"Publisher":publisher,"Status":status}));
        },
        error : function (msg) {
        }
   });
}

//留言
function quesSubmit(status,jobId,publisher){
  $("#ques-submit").click(function(){
     var ckCt = $("#ques-content").lanCheck('notEmpty');
     var paCt = $("#ques-content").closest('.form-group');
     if(!ckCt){
        paCt.addClass("has-error");
        return false;
    }else{
        paCt.removeClass("has-error");
    }
    var param = {"Content" : $("#ques-content").val(),"IsApply":"N"};
     jQuery.ajax({
          url : '/lance/res/postJob/'+jobId+'/discuss', 
          type : 'post',
          contentType : 'application/json',
          data:jQuery.toJSON(param),
          success: function(data){
             $("#post_ques").modal('hide');
             initPostDiscussData(status,jobId,publisher);
        },error:function(msg){
        }
    });
  });
}

//留言回复
function replaySubmit(status,jobId,publisher){
  var uuid = null;
  $(".panel-footer").on("click", "button[name='btn_note']", function(){
      if(!User.logined){
         $.ae("请登录后留言!", function(evt){
            if(evt){
               window.location.href="/lance/login.htm";
            }
         });
         return;
      }
      var paCt = $("#ques-content").closest('.form-group');
      if(paCt.hasClass("has-error")){
          paCt.removeClass("has-error");
      }
      $("#post_ques").modal('show');
  });
 
  $(".panel-footer").on("click", "button[name='btn_apply']", function(){
      if(!User.logined){
         $.ae("请登录后再发起申请!", function(evt){
            if(evt){
               window.location.href="/lance/login.htm";
            }
         });
         return;
      }
      $("#post_apply").modal('show');
  });
  
  //弹出框
  $("#list-discuss").on("click", "button[name='ques-replay']", function(){
      uuid = $(this).attr("uuid");
      var paCt = $("#replay-content").closest('.form-group');
      if(paCt.hasClass("has-error")){
          paCt.removeClass("has-error");
      }
      $("#ques_modal").modal('show');
  });

  $("#replay-submit").click(function(){
     var ckCt = $("#replay-content").lanCheck('notEmpty');
     var paCt = $("#replay-content").closest('.form-group');
     if(!ckCt){
        paCt.addClass("has-error");
        return false;
    }else{
        paCt.removeClass("has-error");
    }
    if(uuid == null){
        return false;
    }
    var param = {"Content" : $("#replay-content").val(),"IsApply":"N","ParentDiscussId":uuid};
     jQuery.ajax({
          url : '/lance/res/postJob/'+jobId+'/discuss', 
          type : 'post',
          contentType : 'application/json',
          data:jQuery.toJSON(param),
          success: function(data){
             $("#ques_modal").modal('hide');
             initPostDiscussData(status,jobId,publisher);
        },error:function(msg){
        }
    });
  });
  
  $(".panel-footer").on("click", "button[name='btn_del']", function(){
     $.ae("是否确认要删除该招聘信息？", function(evt){
        if(evt){
             jQuery.ajax({
                  url : '/lance/res/postJob/delete/'+jobId, 
                  type : 'post',
                  success: function(data){
                     initPostJobData(jobId);
                },error:function(msg){
                }
            });
        }
     });
  });
}

function disDel(status,jobId,publisher,role){
  if(role == null){
     return;
  }
  var uuid = null;
  $("#list-discuss").on("click", "button[name='dis-del']", function(){
      uuid = $(this).attr("uuid");
      if(uuid != null){
         $.ae("是否确认删除该留言？", function(evt){
               if(evt){
                    jQuery.ajax({
                          url : '/lance/res/postJob/'+jobId+'/discuss/delete/'+uuid, 
                          type : 'post',
                          success: function(data){
                             initPostDiscussData(status,jobId,publisher);
                             stat(jobId,role);
                        },error:function(msg){
                        }
                    });
               }
         });
      }
  });
}

//加入备选
function optionApply(status,jobId,publisher){
  var uuid = null;
  $("#list-discuss").on("click", "button[name='btn-option']", function(){
      uuid = $(this).attr("uuid");
      if(uuid != null){
         jQuery.ajax({
              url : '/lance/res/postJob/'+jobId+'/optionDiscuss/'+uuid, 
              type : 'post',
              success: function(data){
                 if(data.indexOf("ok") >= 0){
                     initPostDiscussData(status,jobId,publisher);
                     stat(jobId,"client");
                 }else{
//                     alert(data.split(":")[1]);
                 }
            },error:function(msg){
            }
        });
      }
  });
}

//同意操作 
function agree(status,jobId,publisher){
  var uuid = null;
  $("#list-discuss").on("click", "button[name='btn-agree']", function(){
      uuid = $(this).attr("uuid");
      if(uuid != null){
         var param={};
         jQuery.ajax({
              url : '/lance/res/postJob/'+jobId+'/agreeDiscuss/'+uuid, 
              type : 'post',
              contentType : 'application/json',
              data:jQuery.toJSON(param),
              success: function(data){
                 if(data.msg.indexOf("ok") >= 0){
                     initPostDiscussData(status,jobId,publisher);
                     stat(jobId,"client");
                 }else{
                     alert(data.msg.split(":")[1]);
                 }
            },error:function(msg){
            }
        });
      }
  });
}

//取消操作 
function cancel(status,jobId,publisher){
  var uuid = null;//btn-cancel-option
  //取消申请
  $("#list-discuss").on("click", "button[name='btn-cancel-agree']", function(){
      uuid = $(this).attr("uuid");
      if(uuid != null){
         $.ae("确认取消该已同意的申请吗？", function(evt){
            if(evt){
               cancelHandle(status,jobId,publisher,uuid);
            }
         });
      }
  });
  //取消备选
  $("#list-discuss").on("click", "button[name='btn-cancel-option']", function(){
      uuid = $(this).attr("uuid");
      if(uuid != null){
         $.ae("确认取消该备选吗？", function(evt){
            if(evt){
               cancelHandle(jobId,publisher,uuid);
            }
         });
      }
  });
  
}

function cancelHandle(status,jobId,publisher,uuid){
   jQuery.ajax({
          url : '/lance/res/postJob/cancel/'+jobId+'/'+uuid, 
          type : 'post',
          success: function(data){
             if(data.indexOf("ok") >= 0){
                 initPostDiscussData(status,jobId,publisher);
                 stat(jobId,"client");
             }else{
                 alert(data.split(":")[1]);
             }
        },error:function(msg){
        }
    });
}

function jfjgChange(status,jobId,init,publisher){
   
   $("input[name='jkfs']").change(function(){
        if(this.checked){
             if("asj-jf" == $(this).attr("id")){
                 $("#jffs-cnt").html(template('jffs-cnt-sp1',{'jffs' : "sjjf"}));
                 $("#jffs-cnt").show();
             }else if("gdjg-jf" == $(this).attr("id")){
                $("#jffs-cnt").html(template('jffs-cnt-sp1',{'jffs' : "gdjg"}));
                $("#jffs-cnt").show();
             }else if("shqd-jf" == $(this).attr("id")){
                $("#jffs-cnt").html(template('jffs-cnt-sp1',{'jffs' : "shqd"}));
                $("#jffs-cnt").hide();
             }
        }
    });
    if(init){
        $("#jffs-cnt").html(template('jffs-cnt-sp1',{'jffs' : "sjjf"}));
        $("#jffs-cnt").show();
    }
    
    //是否指定时间效果切换
    $("input[name='jrsj']").change(function(){
        if(this.checked){
            if("shqd-sj" == $(this).attr("id")){
                $("#sj-span").hide();
            }else if("zdrq-sj" == $(this).attr("id")){
                $("#sj-span").show();
            }
        }
    });
    
    $("input[name='wtlb']").change(function(){
        if(this.checked){
            if("all" == $(this).val()){
               initPostDiscussData2(status,jobId,publisher,"all");
            }else if("apply" == $(this).val()){
               initPostDiscussData2(status,jobId,publisher,"apply");
            }else if("second" == $(this).val()){
               initPostDiscussData2(status,jobId,publisher,"second");
            }else if("owner" == $(this).val()){
               initPostDiscussData2(status,jobId,publisher,"owner");
            }else if("agree" == $(this).val()){
               initPostDiscussData2(status,jobId,publisher,"agree");
            }
        }
    });
    //合同签订权限判断
    if(!User.hasOwnProperty("CompanyName")){
        $("#grmy-gs").attr("disabled","disabled");
        $("#ht-comments").html("(注:个人信息中尚未完善所在公司信息,无法以公司名义签署)");
    }else{
         $("input[name='htqs']").change(function(){
         if(this.checked){
             if("grmy-gr" == $(this).attr("id")){
                 $("#ht-comments").html("");
             }else if("grmy-gs" == $(this).attr("id")){
                 $("#ht-comments").html("公司名称:"+User.CompanyName);
             }
          }
        });
    }
}

function submitApply(status,jobId,publisher){
  $("#apply-submit").click(function(){
     if(checkApply()){
       var paraStr = "";
       for(var t=0;t<attrs.length;t++){
          if(attrs[t].length == 0){
             continue;
          }
          paraStr+=attrs[t]+":"+datas[t];
          if(t < (attrs.length-1)){
             paraStr+=",";
          }
       }
     var param = "{"+paraStr+"}";
     jQuery.ajax({
          url : '/lance/res/postJob/'+jobId+'/discuss', 
          type : 'post',
          contentType : 'application/json',
          data:param,
          success: function(data){
            initPostDiscussData(status,jobId,publisher);
            $("#post_apply").modal('hide');
        },error:function(msg){
        }
    });
     }
  });
}
var attrs = new Array();
var datas = new Array();
function checkApply(){
  var htqs = $("input[name='htqs']:checked").val();
  var ckHt = $("input[name='htqs']:checked").lanCheck('notEmpty');
  if(!ckHt){
       $("#ht-comments").html("请选择好合同签署方式");
       return false;
   }else{
        attrs[0]="SignBy";
        datas[0]=htqs;
   }
  
  var jkfs = $("input[name='jkfs']:checked").val();
  if("hourly" == jkfs){
        attrs[1]="Postform";
        datas[1]="hourly";
        var ckHp = $("#HourlyPay").lanCheck('notEmpty');
        var paHp = $("#HourlyPay").closest('.form-group');
        if(!ckHp){
            paHp.addClass("has-error");
            return false;
        }else{
           if(!isNum1($("#HourlyPay").val())){
               showWarn("报价必须为正整数!");
               paHp.addClass("has-error");
               return false;
           }
            paHp.removeClass("has-error");
            attrs[2]="HourlyPay";
            datas[2]=$("#HourlyPay").val();
        }
        
        var ckWh = $("#Weekly_Hours").lanCheck('notEmpty');
        var paWh = $("#Weekly_Hours").closest('.form-group');
        if(!ckWh){
            paWh.addClass("has-error");
            return false;
        }else{
            if(!isNum1($("#Weekly_Hours").val())){
               showWarn("每周工作时间必须为正整数!");
               paWh.addClass("has-error");
               return false;
            }else{
               if(parseInt($("#Weekly_Hours").val()) > (7*24)){
                   showWarn("每周工作时间不能超过"+(7*24));
                   paWh.addClass("has-error");
                   return false;
               }
            }
            paWh.removeClass("has-error");
            attrs[3]="WeeklyHours";
            datas[3]=$("#Weekly_Hours").val();
        }
  }else if("fixed" == jkfs){
        attrs[1]="Postform";
        datas[1]="fixed";
        var ckFpn = $("#fixed_pay_min").lanCheck('notEmpty');
        var paFpn = $("#fixed_pay_min").closest('.form-group');
        if(!ckFpn){
            paFpn.addClass("has-error");
            return false;
        }else{
            if(!isNum1($("#fixed_pay_min").val())){
               paFpn.addClass("has-error");
               showWarn("项目预算为正整数!");
               return false;
            }
            paFpn.removeClass("has-error");
            attrs[2]="FixedPayMin";
            datas[2]=$("#fixed_pay_min").val();
        }
        
        var ckFpx = $("#fixed_pay_max").lanCheck('notEmpty');
        var paFpx = $("#fixed_pay_max").closest('.form-group');
        if(!ckFpx){
            paFpx.addClass("has-error");
            return false;
        }else{
            if(!isNum1($("#fixed_pay_max").val())){
               paFpx.addClass("has-error");
               showWarn("项目预算为正整数!");
               return false;
            }else{
               if(parseInt($("#fixed_pay_min").val()) > parseInt($("#fixed_pay_max").val())){
                   paFpx.addClass("has-error");
                   paFpn.addClass("has-error");
                   showWarn("项目预算起始值不能大于预算最大值!");
                   return false;
               }
            }
            paFpx.removeClass("has-error");
            attrs[3]="FixedPayMax";
            datas[3]=$("#fixed_pay_max").val();
        }
  }else{
    attrs[1]="";
    datas[1]="";
    attrs[2]="";
    datas[2]="";
    attrs[3]="";
    datas[3]="";
  }
  
  function showWarn(msg){
    $("#lancerMsg").show();
    $("#lan-msg").html(msg);
  }
  
  var zdrq = $("input[name='jrsj']:checked").val();
  if("date" == zdrq){
    var ckSj = $("#entry_d").lanCheck('notEmpty');
    if(!ckSj){
        $("#err-date").html("制定日期时,日期必须选择!");
        return false;
    }else{
        var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
        if(!reg.test($("#entry_d").val())){
            $("#err-date").html("时间格式错误!");
            return false;
        }else{
            $("#err-date").html("");
            attrs[4]="EnteryDate";
            datas[4]=$("#entry_d").val();
        }
    }
  }else{
    attrs[4]="";
    datas[4]="";
  }
  attrs[5]="IsApply";
  datas[5]="Y";
  attrs[6]="Content";
  datas[6]=$("#apply-content").val();
 return true;
}

function stat(jobId,type){
    jQuery.ajax({
          url : '/lance/res/postJob/'+jobId+'/stat/'+type+'?random='+Math.random(), 
          type : 'get',
          success: function(data){
            if("lancer" == type){
                $("#span-owner").html("("+data.count+")");
            }else if("client" == type){
                $("#span-apply").html("("+data.apply+")");
                if(data.hasOwnProperty("option")){
                    $("#span-option").html("("+data.option+")");
                }else{
                    $("#span-option").html("(0)");
                }
                if(data.hasOwnProperty("agreed")){
                    $("#span-agree").html("("+data.agreed+")");
                }else{
                    $("#span-agree").html("(0)");
                }
            }
        },error:function(msg){
        }
    });
}

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
};