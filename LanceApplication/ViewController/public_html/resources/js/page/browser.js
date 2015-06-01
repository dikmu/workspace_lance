$(function(){
    var type = 'job';
    $(".lan-tab .btn").click(function(){
        var type = $(this).attr('data-type');
        if(type == 'ljob'){
            $(".borwser dl").removeClass("col-md-12").addClass("col-md-3");
            InitJob(Data.JobCategories, "job");
            type = 'category';
        }else if(type == 'lskil'){
            $(".borwser dl").removeClass("col-md-3").addClass("col-md-12");
            InitJob(Data.Skills, "skill");
            type = 'skill';
        }
    });
    
    //点击跳转;
    $(".borwser").on("click", "dd a", function(){
        if(!$(this).parent().hasClass('more')){
            var val = $(this).html();
            window.location.href = '/lance/pages/search?type='+type+'&val='+val;
        }
    });
});

function InitSkill(datas){
    var tmp = null, md = null;
    $('.borwser .mod').not('.hidemod').remove();
    for(var n in datas){
        md = $('.borwser .hidemod').clone().removeClass('hidemod').css('display', 'inline-block');
        tmp = datas[n];
        if(!("未分类"==tmp[1])){
            md.find("dt").html(tmp[1]);
        }else{
            md.find("dt").remove();
        }
        if(tmp[2]){
            $.each(tmp[2], function(i, dom){
                md.append('<dd style="float:left;display:inline-block;width:20%;margin:10px 0;" class="fleft"><a>' + (dom[0] || dom[1]) + '</a></dd>');
            });
            $('.borwser').append(md);
        }
    }
}

function InitJob(datas, type){
    var tmp = null, md = null;
    $('.borwser .mod').not('.hidemod').remove();
    if(type == "skill"){
        InitSkill(datas);
    }else{
        for(var n in datas){
            md = $('.borwser .hidemod').clone().removeClass('hidemod').css('display', 'inline-block');
            tmp = datas[n];
            md.find("dt").html(tmp[1]);
            if(tmp[2]){
                $.each(tmp[2], function(i, dom){
                    if(i < 15){
                        md.append('<dd><a>' + (dom[0] || dom[1]) + '</a></dd>');
                    }else{
                        md.append('<dd class="more-dd"><a>' + (dom[0] || dom[1]) + '</a></dd>');
                    }
                    if(i == tmp[2].length - 1){
                        md.append('<dd class="more"><a>更多</a></dd>');
                    }
                });
                $('.borwser').append(md);
            }
        }
    }
}

$(function(){
    $('.borwser').on('click', '.more', function(){
        var pa = $(this).closest('dl');
        pa.find('.more-dd').slideToggle();
        $(this).toggleClass('sw');
        if($(this).hasClass('sw')){
            $(this).html('<a>关闭</a>');
        }else{
            $(this).html('<a>更多</a>');
        }
    });
    InitJob(Data.JobCategories);
});
    