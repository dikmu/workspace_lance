$(function(){
    if(User.logined){
    alert('12');
        $("#top_bc").html(template('bc-cnt-sp1',{'logined' : 'true',"userName":User.UserName}));
    }else{
        $("#top_bc").html(template('bc-cnt-sp1',{'logined' : 'false'}));
    }
});