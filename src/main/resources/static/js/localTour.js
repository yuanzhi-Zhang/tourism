$(function () {
    layui.use(['element','carousel'], function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        var carousel = layui.carousel;

        carousel.render({
            elem: '#localTourLunBo'
            ,width: '95%'
            ,height: '480px'
            ,anim: 'fade' //切换动画方式
            ,autoplay: true
            ,interval: 3000
            ,arrow: 'hover'
        });
        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
});
