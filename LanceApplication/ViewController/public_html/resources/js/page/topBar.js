$(function(){
    if(User.logined){
        $("#top_bc").html(template('bc-cnt-sp1',{'logined' : 'true',"userName":User.UserName,"u_noti":User.notification}));
    }else{
        $("#top_bc").html(template('bc-cnt-sp1',{'logined' : 'false'}));
    }
});



$(function(){
    $(".sea-type").on("click", ".dropdown-menu li", function(){
        var txt = $(this).find("a").html();
        $(".sea-type .input-group-addon").html(txt + '<span class="caret"></span>');
    });
});

$(function(){
    $(".ico_fk").click(function(){
        var feek = $(".feedback");
        if($(this).hasClass("sel")){
            feek.animate({"width" : "0px"}, 500);
            $(this).removeClass("sel");
        }else{
            feek.animate({"width" : "220px"}, 500);
            $(this).addClass("sel");
        }
    });

    var url = window.location.href;
    //$("#fb_url").val(url);
    
    $("#btn_fb").click(function(){
        var con = $("#fb_conct"), content = $("#fb_content"), err = $("#fb_err");
        if(con.val() == ""){
            err.html("请输入您的联系方式");
        }else if(content.val() == ""){
            err.html("请输入您的建议");
        }else{
            err.html("");
            param = {
                "Content" : content.val(),
                "PageUrl" : url,
                "Contact" : con.val()
            };
            $.ax("post", "lance/discuss ", param, function(){
                $.ae("您的建议已经发送成功！");
                con.val("");
                content.val("");
            }, function(){}, "text");
        }
    });
    
    
});