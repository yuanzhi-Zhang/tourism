$(function () {
    layui.use('element', function () {
        var element = layui.element;

        //监听导航点击
        element.on('nav(headerLikeIndex)', function (elem) {
            console.log(elem)
        });
    });

    //设置目录的滚动固定
    //获取要定位元素距离浏览器顶部的距离
    var navH = $(".strategyDetail_catalogue").offset().top;
    // console.log(navH);
    //滚动条事件
    $(window).scroll(function(){
        //获取滚动条的滑动距离
        var scroH = $(this).scrollTop();
        // console.log(scroH);
        var scrollHeight = $(document).height();
        // console.log(scrollHeight);
        //滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
        if(scroH>=navH){
            $(".strategyDetail_catalogue").css({"position":"fixed","top":0});
        }else if(scroH<navH){
            $(".strategyDetail_catalogue").css({"position":"static"});
        }
    })
})