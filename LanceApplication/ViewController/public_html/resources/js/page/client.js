$(function(){
    var checkEmpty = function(obj){
        if(obj.val() == ""){
            obj.closest(".form-group").addClass("has-error");
            return false;
        }
        obj.closest(".form-group").removeClass("has-error");
        return true;
    };

    $(".btn-edit").click(function(){
        $(".uself").slideUp();
        $(".add-dialog").slideDown();
        
        $(".add-dialog").removeClass("panel-danger");
        $(".add-dialog .form-group").removeClass("has-error")
        $(".add-dialog").find(".panel-heading").html("修改公司信息");
        $(".form-control .form-control").val("");
        
        
    });
    
    $("#btn_cancel_company").click(function(){
        $(".uself").slideDown();
        $(".add-dialog").slideUp();
    });
    
    $("#btn_add_company_fin").click(function(){
        var name = $("#company_name"), com = $("#gsjj");
        
        var result = false;
        result = checkEmpty(name) && checkEmpty(com);
        if(result){
            var pa = $(this).closest(".panel").removeClass("panel-danger");
            pa.find(".panel-heading").html("修改公司信息");
            
            //TODO: AJAX
            
        }else{
            var pa = $(this).closest(".panel").addClass("panel-danger");
            pa.find(".panel-heading").html("修改公司信息-请输入完整的信息");
        }
    });
    
});