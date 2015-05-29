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