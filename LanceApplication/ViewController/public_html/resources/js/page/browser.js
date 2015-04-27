$(function(){
    var type = 'job';
    $(".lan-tab .btn").click(function(){
        var type = $(this).attr('data-type');
        if(type == 'ljob'){
            InitJob(Data);
            type = 'category';
        }else if(type == 'lskil'){
            InitJob(Data.Skills);
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
        console.log(datas[n]);
    }
}

function InitJob(datas){
    var tmp = null, md = null;
    $('.borwser .mod').not('.hidemod').remove();
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
    