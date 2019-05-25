function getByteLen(obj,val,obj2) {
    var len = 0;
    var word = '';
    for (var i = 0; i < val.length; i++) {
        var a = val.charAt(i);
        if (a.match(/[^\x00-\xff]/ig) != null) {
            len += 2;
        }
        else {
            len += 1;
        }
        if(len<=20){
            word += a;
        }
    }
    if(len>=20){
        obj.val(word);
    }
    obj2.find('span').text(word);
    return len;
}
function isFocus(obj,num){
    var searVal = obj.val();
    if(num==1){
        if(searVal.length>0){
            obj.siblings('.fansTip,.fansInputTip,.fansRank').addClass('hide').siblings('#fansSearch-btn').removeClass('hide');
        }
    }
}
$(function(){
    $('#fansSearch').bind('input propertychange', function() {
        isFocus($(this),1);
        var newTagVal = $(this).val();
        if(getByteLen( $(this),newTagVal,$('#fansSearch-btn'))>=20){
            $(this).parents('.newTag').prev().find('.evenTag').removeClass('hide').text('每个标签最多输入10个字符');
        }
    });
    $('#fansSearch').focus(function(){
        $(this).siblings('.fansTip,.fansInputTip').addClass('hide').siblings('#fansSearch-btn').removeClass('hide');
    });
    $('#fansSearch').blur( function () {
        isFocus($(this),2);
    });

    //创建文章搜索下载任务
    $("#create_task").click(function () {
        var params = getParams();
        if ((!params.keyword) || (!params.title && !params.content && !params.wx)) {
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/tool/ajaxarccreatetask',
            dataType: 'json',
            data: params,
            success: function (data) {
                if (data.error === 0) {
                    $(document).modalll({
                        title: "<span class='title fs16'>下载</span>",
                        width: 500,
                        content:"下载任务添加完成，请在个人中心导出记录中查看",
                        enter: "确定",
                        closeHide: true,
                        callback: function () {
                            location.reload();
                        }
                    });
                } else {
                    alert(data.error_msg);
                }
            },
            error: function (xhr, status, error) {
                alert(error);
            }
        });
    });




});


//获取文章搜索统计个数
function checkform(){
    var params = getParams();
    if ((!params.keyword) || (!params.title && !params.content && !params.wx)) {
        return;
    }
    $.ajax({
        type: 'POST',
        url: '/tool/ajaxarccount',
        dataType: 'json',
        data: params,
        success: function (data) {
            if (data.error === 0) {
                showResult();
                $("#arc_result").text(data.data);
            } else {
                $(".seach-result").addClass('hide');
                alert(data.error_msg);
            }
            screenHeight();
        },
        error: function (xhr, status, error) {
            alert(error);
        }
    });

}
//获取文章搜索参数
function getParams(){
    var keyword = $('#fansSearch').val();
    var copyright = $('.col-xs-10 .active a').html();
    var title = $("input[name='range_title']:checked").val();
    var content = $("input[name='range_content']:checked").val();
    var wx = $("input[name='range_wx']:checked").val();
    var startTime = $('#startTime').val();
    var endTime = $('#endTime').val();

    var params = {};
    if (keyword)
        params.keyword = keyword;
    if (copyright == '不限'){
        params.copyright = 0;
    }else if(copyright == '原创'){
        params.copyright = 1;
    }

    if (title != undefined)
        params.title = title;
    if (content != undefined)
        params.content = content;
    if (wx != undefined)
        params.wx = wx;
    if (startTime)
        params.startTime = startTime;
    if (endTime)
        params.endTime = endTime;
    return params;
}
$(document).keypress(function(e){
    if (!e)
        e = window.event;
    if ((e.keyCode || e.which) == 13) {
        checkform();

    }
});
//微信文章 搜索筛选
$('.wxpromot-group li a').on('click',function(){
    $(this).parent('li').addClass('active').siblings('li').removeClass('active');

});
//显示搜索部分
function showSearch() {
    $(".search").removeClass('hide');
    $(".search-result").addClass('hide');
}

//显示结果部分
function showResult() {
    $(".search").addClass('hide');
    $(".search-result").removeClass('hide');
}