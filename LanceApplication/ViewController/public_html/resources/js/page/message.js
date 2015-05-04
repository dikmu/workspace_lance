$(function(){
    var pa = $("#mymessage tbody"), tmp = null;
    if(Data.datas.length <= 0){
        var nomessage = '<tr class="warning"><td colspan="4">暂时没有信息.</td></tr>';
        pa.append(nomessage);
        return;
    }
    $.each(Data.datas, function(i, dom){
        tmp = pa.find(".hidemod").clone().removeClass("hidemod").data("uuid", dom.Uuid);
        tmp.find(".name").html(dom.UserName);
        tmp.find(".title").html(dom.Title);
        tmp.find(".txt").html(dom.Content);
        tmp.find(".type").html(dom.Type);
        if(dom.Read == 'Y'){
            tmp.addClass("active");
        }
        pa.append(tmp);
    });
    
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
            alert("修改 " + ids + " 信息");
        }
    });
    
     $("#btn_read").click(function(){
        var lists = $("#mymessage .info"), ids = '';
        if(lists.length <= 0){
            $.ae("请选择要修改的条目");
        }else{
            $.each(lists, function(i, dom){
                ids += $(dom).data('uuid') + ',';
            });
            alert("修改 " + ids + " 信息");
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
            alert("删除 " + ids + " 信息");
        }
    });
});