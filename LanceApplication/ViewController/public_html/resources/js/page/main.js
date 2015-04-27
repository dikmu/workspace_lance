$(function(){
    var initHeader = function(){
        $('.hd-name').html(User.DisplayName);
    };
    
    
    var initUser = function(){
        $(".uname").html(User.DisplayName + '-' + Data.User.User.JobTitle);
        $(".utitle").html(Data.User.User.Tagline);
        $(".uself").html(Data.User.User.Overview);
        var locDetail = "";
        if(User.LocationAIndex !=null){
            locDetail+="主要地址："+User.LocationAIndex+" "+Data.User.User.LocationADetail+"<br>";
        }
        if(User.LocationBIndex !=null){
            locDetail+="第二地址："+User.LocationBIndex+" "+Data.User.User.LocationBDetail;
        }
        if(locDetail){
            locDetail = locDetail.replace(/;/g, ' ');
            $(".uloc").html(locDetail);
        }else{
            $(".uloc").html("您尚未填写位置信息");
        }
        
        var skill = Data.User.Skill;
        
        if(skill.length > 0){
            var i = 0, len = skill.length;
            for(i=0;i<len;i++){
                $(".uskill").append('<span class="label label-primary">' + skill[i].Name +'</span>');
            }
        }else{
            $(".uskill").html('<div class="well well-sm no-add">您还没有添加技术专长</div>');
        }
        
        var edu = Data.User.Education;
        if(edu.length > 0){
            //TODO
        }else{
            $('.edus').html('<div class="well well-sm no-add">您还没有添加教育信息</div>');
        }
        
        var job = Data.User.Job;
        if(job && job.length > 0){
            //TODO
        }else{
            $('.jobs').html('<div class="well well-sm no-add">您还没有工作信息</div>');
        }
        
    };
    
    initHeader();
    initUser();
});











