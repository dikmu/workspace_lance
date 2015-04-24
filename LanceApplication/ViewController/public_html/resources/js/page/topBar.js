$(function(){
    if(User.logined){
        $("#top_bc").html(template('bc-cnt-sp1',{'logined' : 'true',"userName":User.UserName}));
    }else{
        $("#top_bc").html(template('bc-cnt-sp1',{'logined' : 'false'}));
    }
});