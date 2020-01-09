layui.use(['element','laytpl','util','layer','carousel'], function () {
    var element = layui.element;
    var laytpl = layui.laytpl;
    var util = layui.util;
    var layer = layui.layer;
    var carousel = layui.carousel;

    //固定块
    util.fixbar({
        bar1: true
        , bar2: true
        , css: {right: 50, bottom: 100}
        , bgcolor: '#393D49'
        , click: function (type) {
            if (type === 'bar1') {
                layer.msg('icon是可以随便换的')
            } else if (type === 'bar2') {
                layer.msg('两个bar都可以设定是否开启')
            }
        }
    });

    carousel.render({
        elem: '#askAnswerLunBo'
        ,width: '260px' //设置容器宽度
        ,height: '164px'
        ,anim: 'fade' //切换动画方式
        ,autoplay: true
        ,interval: 3000
        ,arrow: 'hover'
    });

//    点击邀请事件
    var flag = 0;
    $("._j_seek_help_new").click(function () {
        if(flag%2 == 0){
            $(".q-invite").removeClass("hide");
            flag++;
        }else if(flag%2 == 1){
            $(".q-invite").addClass("hide");
            flag++;
        }
    })
});