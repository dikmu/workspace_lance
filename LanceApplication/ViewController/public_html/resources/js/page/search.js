function setJobModel(title, price, stime, etime, acount, detail, cate1, cate2, form, skills, score, location){
    var item = $(".jobs .hidemod").clone().removeClass("hidemod");
    item.find(".title-in").html(title);
    item.find(".price").html(price == "" ? '价格：不确定' : '价格：' + price);
    item.find(".stime").html('开始时间：' + stime);
    item.find(".etime").html('结束时间：' + etime);
    item.find(".acount").html('申请人数：' + acount);
    item.find(".txt").html(detail);
    item.find(".cate1").html('工作分类：' + cate1);
    item.find(".cate2").html('工作分类：' + cate2);
    
    item.find(".form").html(form == 'hourly' ? '时新' : '固定价格');
    item.find(".location").html(location);
    
    var arr = skills.split(";"), i = 0, len = arr.length, strskills = '';
    for(i=0;i<len;i++){
        if(arr[i] != ""){
            strskills += '<a class="btn btn-info btn-xs">' + arr[i] + '</a>';
        }
    }
    item.find(".skills").html(strskills);
    
    item.find(".score .glyphicon:lt(" + score + ")").addClass("lan-font-yellow");
    return item;
}
function setPersonModel(uname, title, location, money, acount, earn, txt, skills){
    var item = $(".persons .hidemod").clone().removeClass("hidemod");
    item.find(".uname").html(uname);
    item.find(".title").html(title);
    item.find(".location").html('所在地：' + location);
    item.find(".order").html('薪水要求：￥' + money);
    item.find(".jobin").html('参加过 ' + acount + ' 个工作');
    item.find(".earn").html('总共获得 ￥' + earn);
    item.find(".txt").html(txt);
    
    var arr = skills.split(';');
    $.each(arr, function(i, dom){
        if(dom != ''){
            item.find('.liss').append('<a class="btn btn-info btn-xs">' + dom + '</a>');
        }
    });
    return item;
}

//设置搜索条件信息
function setCategory(){
    var setCate = function(datas){
        var tmpName = '', str = '';
        $.each(datas, function(i, dom){
            if(i < 5){
                tmpName = dom.NameCn == "" ? dom.NameEn : dom.NameCn;
                str = '<dd><a data-val="' + dom.Uuid + '" class="btn btn-link">' + tmpName + '</a></dd>';
                $('#cates').append(str);
            }
            if(i == 5){
                $('#cates').append('<dd><a class="btn btn-link more">更多...</a></dd>');
            }
            if(i >= 5 && i < 11){
                tmpName = dom.NameCn == "" ? dom.NameEn : dom.NameCn;
                str = '<dd class="hidemod"><a data-val="' + dom.tmpName + '" class="btn btn-link">' + tmpName + '</a></dd>';
                $('#cates .more').parent().before(str);
            }
        });
    };
    
    $("#cates").on("click", '.more', function(){
        $("#cates .hidemod").show();
    });
    
    var setSkills = function(datas){
        var tmpName = '', str = '';
        str += '<option value="-1">请选择</option>';
        $("#sel_skill").append(str);
        $.each(datas, function(i, dom){
            $("#sel_skill").append('<option value="'+(dom.NameCn || dom.Name)+'">' + (dom.NameCn || dom.Name) + '</option>')
        });
    };
    
    //设置地理信息
    $.ax("get", "location/province", null, function(data){
        var len = data.length, i = 0, str = "";
        for(i=0;i<len;i++){
            str += '<option value="'+data[i].ProvinceName+'">'+data[i].ProvinceName+'</option>';
        }
        $("#sel_province").html(str);
        $("#sel_province").change();
    }, function(){});
    
    $("#sel_province").change(function(){
        var v = $(this).val();
        if(v != -1){
            $("#sel_city").html('<option>请稍后...</option>');
            $.ax("get", "location/cityByProvince/"+v, null, function(data){
                 var len = data.length, i = 0, str = "";
                 str += '<option value="-1">请选择</option>';
                for(i=0;i<len;i++){
                    str += '<option value="'+data[i].CityName+'">'+data[i].CityName+'</option>';
                }
                $("#sel_city").html(str);
            }, function(){});
        }
    });
    
    $.ax('get', 'search/left/datas', null, function(data){
        var cates = data.cateory, skills = data.skills, country = data.country;
        
        setCate(cates);
        setSkills(skills);
        
    }, function(){});
}
//全局变量 JOB PEOPLE THUMB
var _STYPE = 'JOB';
var _INITPERSON = null;
var method = '';
//search 
$(function(){
    method = "search/jobs";//"search/postJob/latest";
    
    var clearJobs = function(){
        $(".jobs .mod").not(".hidemod").remove();
    };
    
    var clearPeoples = function(){
        $(".persons .mod").not(".hidemod").remove();
    };
    
    var getDatas = function(param){
        if(param != 'more'){
            $(".wait").show();
            $(".con").hide();
        }
        $('.no-more').hide();
        $(".sea-result-info").hide();
        $.ax("get", method, null, function(data){
            if(param != 'more'){
                $(".wait").hide();
                $(".con").show();
            }
        
            var pa = $(".jobs"), tmp = null, location = '远程办公';
            var curPage = $(".get-more").data("page") || 1;
            
            if(data.count >= 1){
                $(".get-more").show();
                $(".get-more").data("page", curPage + 1);
                
                if(method.indexOf('keyword') > -1){
                    var keyword = $("#input_search").val();
                    $(".sea-result-info").show().html("'" + keyword + "' 的搜索结果    共 " + data.count + " 个");
                }
                
                $.each(data.data, function(i, dom){
                    if(dom.FixedLocation == 'Y'){
                        location = dom.IndexLocation;
                    }
                    tmp = setJobModel(dom.Name, dom.FixedPayMin + '-' + dom.FixedPayMax, dom.PostJobDateStart, dom.PostJobDateEnd, 0, 
                    dom.BriefShort, dom.IndexWorkCategorys.split('>')[0], dom.IndexWorkCategorys.split('>')[1], dom.Postform, 
                    dom.IndexSkills, 5, location);
                    pa.append(tmp);
                });
            }else{
                if(curPage == 1){
                    $(".sea-result-info").show().html("没有找到查询结果。");
                    $('.get-more').hide();
                }else {
                    $('.get-more').hide();
                    $('.no-more').show();
                }
            }
            if(curPage == 1){
                $(".all-count").html('<b class="lbl-search-title">所有的工作</b>（' + data.count + ' 个）');
            }
            
            $("#input_search").val('');
            $(".get-more").button('reset');
        }, function(){});
    };
    
    var getDatasForPeople = function(param){
        if(param != 'more'){
            $(".wait").show();
            $(".con").hide();
        }
        $('.no-more').hide();
        $(".sea-result-info").hide();
        $.ax("get", method, null, function(data){
            if(param != 'more'){
                $(".wait").hide();
                $(".con").show();
            }
            var pa = $(".persons"), tmp = null;
            var curPage = $(".get-more").data("page") || 1;
            
            if(data.count >= 1){
                $(".get-more").show();
                $(".get-more").data("page", curPage + 1);
                
                if(param != '' && method.indexOf('keyword') > -1){
                    var keyword = $("#input_search").val();
                    $(".sea-result-info").show().html("'" + keyword + "' 的搜索结果    共 " + data.count + " 个");
                }
                
                $.each(data.data, function(i, dom){
                
                    tmp = setPersonModel(dom.TrueName, dom.JobTitle, dom.LocationAIndex || '暂未填写', dom.HourlyRate || '暂未填写', 0, 
                    0, dom.Overview || '暂未填写', dom.skills || '');
                    
                    pa.append(tmp);
                });
                
                
            }else{
                if(curPage == 1){
                    $(".sea-result-info").show().html("没有找到查询结果。");
                    $('.get-more').hide();
                }else {
                    $('.get-more').hide();
                    $('.no-more').show();
                }
            }
            if(curPage == 1){
                $(".all-count").html('<b class="lbl-search-title">所有的自由人</b>（' + data.count + ' 个）');
            }
            
            $("#input_search").val('');
            $(".get-more").button('reset');
        }, function(){});
    };
    
    _INITPERSON = getDatasForPeople;
    
    getDatas('');
    
    
    
    //点击获取更多
    $(".get-more").click(function(){
        var btn = $(this);
        btn.button("loading");
        
        var type = 'pageNum', val = $(".get-more").data('page');
        
                
        var arr_methods = method.split(';'), strTmp = '';
        
        $.each(arr_methods, function(i, dom){
             
            if(i == 0){
                strTmp = dom;
            }else if(dom != ""){
                if(dom.indexOf(type) >= 0){
                    if(val){
                        strTmp += ';' + type + '=' + val;
                    }
                }else{
                    strTmp += ';' + dom;
                }
            }
        });
        method = strTmp;
        
        if(method.indexOf(type) < 0){
            method += ';' + type + '=' + val;
        }
        
        if(_STYPE == 'JOB'){
            //var param = ';pageNum=' + $(".get-more").data('page');
            getDatas('more');
        }else if(_STYPE == 'PEOPLE'){
            //var param = ';pageNum=' + $(".get-more").data('page');
            getDatasForPeople('more');
        }else if(_STYPE == 'THUMB'){
            
        }
        
        
    });
    
    //根据关键词搜索
    $("#search-icon").click(function(){
        $(".get-more").data("page", 1);
        if(_STYPE == 'JOB'){
            var keyword = $("#input_search").val();
            method = 'search/jobs' + ';keyword=' + keyword;
            clearJobs();
            getDatas('');
        }else if(_STYPE == 'PEOPLE'){
            var keyword = $("#input_search").val();
            method = 'search/contractors' + ';keyword=' + keyword;
            clearPeoples();
            getDatasForPeople('');
        }else if(_STYPE == 'THUMB'){
            
        }
    });
    $("#input_search").keydown(function(e){
        if(e.keyCode == 13){
            $("#search-icon").click();
        }
    });
    
    
    var getMothodParam = function(type, val){
        var arr_methods = method.split(';'), strTmp = '';
        $.each(arr_methods, function(i, dom){
            if(i == 0){
                strTmp = dom;
            }else if(dom != "" && dom.indexOf('pageNum') < 0 && dom.indexOf('keyword') < 0){
                if(dom.indexOf(type) >= 0){
                    if(val){
                        strTmp += ';' + type + '=' + val;
                    }
                }else{
                    strTmp += ';' + dom;
                }
            }
        });
        return strTmp;
    };
    
     //左侧类别筛选
    $(".lan-dl").on("click", "a.btn-link:not(.more)", function(){
        $(".get-more").data("page", 1);
        
        var pa = $(this).closest(".lan-dl"), type = pa.attr("data-pa");
        pa.find(".btn-link").removeClass("sel");
        $(this).addClass("sel");
        
        method = getMothodParam(type, $(this).attr("data-val"));
        
        if(type == "category" || type == "postform" || type == "userType"){
            if($(this).attr("data-val") && method.indexOf(type) < 0){
                method += ';' + type + '=' + $(this).attr("data-val");
            }
            
            if(_STYPE == 'JOB'){
                clearJobs();
                getDatas('');
            }else if(_STYPE == 'PEOPLE'){
                clearPeoples();
                getDatasForPeople('');
            }else if(_STYPE == 'THUMB'){
                
            }
        }
    });
    //技能筛选
    $("#sel_skill").change(function(){
        if($("#sel_skill").val() == "-1") return;
        var type = 'skill', val = $(this).val();
        method = getMothodParam(type, val);
        if(method.indexOf(type) < 0){
            method += ';' + type + '=' + val;
        }
        if(_STYPE == 'JOB'){
            clearJobs();
            getDatas('');
        }else if(_STYPE == 'PEOPLE'){
            clearPeoples();
            getDatasForPeople('');
        }else if(_STYPE == 'THUMB'){
            
        }
        
    });
    $("#speskil").click(function(){
        $("#sel_skill").change();
        $("#sel_skill").attr("disabled", false);
    });
    $("#allskil").click(function(){
        $("#sel_skill").attr("disabled", true).val(-1);
        
        var type = 'skill', value = $("#sel_skill").val();
        method = getMothodParam(type, null);
        if(_STYPE == 'JOB'){
            clearJobs();
            getDatas('');
        }else if(_STYPE == 'PEOPLE'){
            clearPeoples();
            getDatasForPeople('');
        }else if(_STYPE == 'THUMB'){
            
        }
    });
    //地理信息筛选
    $("#sel_city").change(function(){
        if($("#sel_city").val() == "-1") return;
        var type = 'country', val = '中国>' + $("#sel_province").val() + '>' + $("#sel_city").val();
        method = getMothodParam(type, val);
        if(method.indexOf(type) < 0){
            method += ';' + type + '=' + val;
        }
        if(_STYPE == 'JOB'){
            clearJobs();
            getDatas('');
        }else if(_STYPE == 'PEOPLE'){
            clearPeoples();
            getDatasForPeople('');
        }else if(_STYPE == 'THUMB'){
            
        }
    });
    $("#speloc").click(function(){
        $("#sel_province, #sel_city").attr("disabled", false);
        $("#sel_city").change();
    });
    $("#allloc").click(function(){
        $("#sel_province, #sel_city").attr("disabled", true).val(-1);
        var type = 'country', val = '中国>' + $("#sel_province").val() + '>' + $("#sel_city").val();
        method = getMothodParam(type, null);
        
        if(_STYPE == 'JOB'){
            clearJobs();
            getDatas('');
        }else if(_STYPE == 'PEOPLE'){
            clearPeoples();
            getDatasForPeople('');
        }else if(_STYPE == 'THUMB'){
            
        }
    });
    
    //所有预算范围筛选
    $("#btn_fixcon").click(function(){
         var smon = $("#fix_smoney").val(), emon = $("#fix_emoney").val();
         var val = smon + ',' + emon, type = 'budget';
         method = getMothodParam(type, val);
         if(method.indexOf(type) < 0){
            if(emon <= smon){
                alert('请输入正确的价格范围');
            }else{
                method += ';' + type + '=' + smon + ',' + emon;
            }
            if(_STYPE == 'JOB'){
                clearJobs();
                getDatas('');
            }else if(_STYPE == 'PEOPLE'){
                clearPeoples();
                getDatasForPeople('');
            }else if(_STYPE == 'THUMB'){
                
            }
        }
    });
    //人员信息时新筛选
    $("#but_cmoney").click(function(){
         var smon = $("#smoney").val(), emon = $("#emoney").val();
         var val = smon + ',' + emon, type = 'hourlyPay';
         method = getMothodParam(type, val);
         if(method.indexOf(type) < 0){
            if(emon <= smon){
                alert('请输入正确的价格范围');
                return;
            }else{
                method += ';' + type + '=' + smon + ',' + emon;
            }
         }
         if(_STYPE == 'JOB'){
            clearJobs();
            getDatas('');
        }else if(_STYPE == 'PEOPLE'){
            clearPeoples();
            getDatasForPeople('');
        }else if(_STYPE == 'THUMB'){
            
        }
    });
    $("#spejg").click(function(){
        $("#but_cmoney").attr("disabled", false);
    });
    $("#alljg").click(function(){
        $("#smoney, #emoney").val("");
        $("#but_cmoney").attr("disabled", true);
        var val = null, type = 'hourlyPay';
        method = getMothodParam(type, val);
        if(_STYPE == 'JOB'){
            clearJobs();
            getDatas('');
        }else if(_STYPE == 'PEOPLE'){
            clearPeoples();
            getDatasForPeople('');
        }else if(_STYPE == 'THUMB'){
            
        }
    });
    //时新范围筛选
    $("#but_hourcon").click(function(){
         var smon = $("#hour_smoney").val(), emon = $("#hour_emoney").val();
         var val = smon + ',' + emon, type = 'hourlyPay';
         method = getMothodParam(type, val);
         if(method.indexOf(type) < 0){
            if(emon <= smon){
                alert('请输入正确的价格范围');
            }else{
                method += ';' + type + '=' + smon + ',' + emon;
            }
            if(_STYPE == 'JOB'){
                clearJobs();
                getDatas('');
            }else if(_STYPE == 'PEOPLE'){
                clearPeoples();
                getDatasForPeople('');
            }else if(_STYPE == 'THUMB'){
                
            }
        }
    });
    
    $("#allhour").click(function(){
         var smon = $("#hour_smoney").val(), emon = $("#hour_emoney").val();
         var val = smon + ',' + emon, type = 'hourlyPay';
         method = getMothodParam(type, null);
         
          if(_STYPE == 'JOB'){
            clearJobs();
            getDatas('');
        }else if(_STYPE == 'PEOPLE'){
            clearPeoples();
            getDatasForPeople('');
        }else if(_STYPE == 'THUMB'){
            
        }
    });
    $("#allfixed").click(function(){
         var smon = $("#fix_smoney").val(), emon = $("#fix_emoney").val();
         var val = smon + ',' + emon, type = 'budget';
         method = getMothodParam(type, null);
         
          if(_STYPE == 'JOB'){
            clearJobs();
            getDatas('');
        }else if(_STYPE == 'PEOPLE'){
            clearPeoples();
            getDatasForPeople('');
        }else if(_STYPE == 'THUMB'){
            
        }
    });
    
});

$(function(){
    setCategory();


    $(".sel-tab-type").click(function(){
        $(".sel-tab-type").removeClass("select");
        $(this).addClass("select");
        
        $(".persons,.jobs").hide();
        $("." + $(this).attr("data-cls")).show();
        
        $(".lbl-search-title").html($(this).attr("data-title"));
        
        $(".search-dv").hide();
        $(".search-" + $(this).attr("data-cls")).show();
        
        var type = $(this).attr("data-cls");
        $(".get-more").data('page', 1);
        
        if(type == 'persons'){
            $('.sea-result-info').hide();
            _STYPE = 'PEOPLE';
            method = 'search/contractors';
            _INITPERSON('');
        }else if(type == 'jobs'){
            _STYPE = 'JOB';
            method = 'search/jobs';
        }else if(type == 'thumbs'){
            _STYPE = 'THUMB';
            //TODO
        }
        
    });
    
    $("#fix_smoney, #fix_emoney, #hour_smoney, #hour_emoney").keyup(function(){
        var tmptxt=$(this).val();
        $(this).val(tmptxt.replace(/\D|^0/g,''));
    });
    
   
    
});

