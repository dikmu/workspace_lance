$(function(){
    var pa = $("#mymessage tbody"), tmp = null;
    if(Data.datas.length <= 0){
        var nomessage = '<tr class="warning"><td colspan="4">暂时没有信息.</td></tr>';
        pa.append(nomessage);
        return;
    }
    var initpage=function(data){
        pa = $("#mymessage tbody");
        $.each(data, function(i, dom){
            tmp = pa.find(".hidemod").clone().removeClass("hidemod").data("uuid", dom.Uuid);
            tmp.find(".read").html(dom.Read=='Y' ? '已读' : '未读');
            tmp.find(".title").html(dom.Title);
            tmp.find(".txt").html(dom.Content);
            tmp.find(".type").html(dom.Type);
            if(dom.Read == 'Y'){
                tmp.addClass("active");
            }
            pa.append(tmp);
        });
    }
    
    initpage(Data.datas);
    
    $("#mymessage tbody").on("click", "tr", function(){
        $(this).toggleClass("info");
    });
    
    $("#btn_unread").click(function(){
        var lists = $("#mymessage .info"), ids = '';
        if(lists.length <= 0){
            $.ae("请选择要修改的条目");
        }else{
            $.each(lists, function(i, dom){
                ids += $(dom).data('uuid') + ',';
            });
            $.ax("post", "user/notification/batch/update?ids="+ids+"&read=N", null, function(data){
               if(data.indexOf("ok") >= 0){
                  initdata();
               }else{
                  alert(data.split(":")[1]);
               } 
            }, function(){
                netWorkError();
            }, "text");
        }
    });
    
    var initdata=function(){
        $.ax("get", "user/notification/all?r="+Math.random(), null, function(data){
           $("#mymessage tbody").find("tr").not(".hidemod").remove();
           initpage(JSON.parse(data));
           if(JSON.parse(data).length <= 0){
               var nomessage = '<tr class="warning"><td colspan="4">暂时没有信息.</td></tr>';
               $("#mymessage tbody").append(nomessage);
           }
        }, function(){
           netWorkError();
        }, "text");
    }
    
     $("#btn_read").click(function(){
        var lists = $("#mymessage .info"), ids = '';
        if(lists.length <= 0){
            $.ae("请选择要修改的条目");
        }else{
            $.each(lists, function(i, dom){
                ids += $(dom).data('uuid') + ',';
            });
             $.ax("post", "user/notification/batch/update?ids="+ids+"&read=Y", null, function(data){
               if(data.indexOf("ok") >= 0){
                   initdata();
               }else{
                  alert(data.split(":")[1]);
               } 
             }, function(){
                netWorkError();
             }, "text");
        }
    });
    
     $("#btn_del").click(function(){
        var lists = $("#mymessage .info"), ids = '';
        if(lists.length <= 0){
            $.ae("请选择要修改的条目");
        }else{
            $.each(lists, function(i, dom){
                ids += $(dom).data('uuid') + ',';
            });
            $.ae("您确定要删除吗？", function(){
               $.ax("post", "user/notification/batch/delete?ids="+ids, null, function(data){
                   if(data.indexOf("ok") >= 0){
                       initdata();
                   }else{
                      alert(data.split(":")[1]);
                   } 
                }, function(){
                    netWorkError();
                }, "text");
            });
        }
    });
});