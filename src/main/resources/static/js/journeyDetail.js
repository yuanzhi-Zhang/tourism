$(function () {
    layui.use('element','layer', function () {
        var element = layui.element;
        layer = layui.layer

        //…
    });

    //
    // $(".jour_detail_main_img").mouseover(function () {
    //     $(".jour_detail_main_img_contrl").css("display","block");
    // })
    // $(".jour_detail_main_img").mouseout(function () {
    //     $(".jour_detail_main_img_contrl").css("display","none");
    // })
    // $(".jour_detail_main_img_contrl").mouseover(function () {
    //     $(".jour_detail_main_img_contrl").css("display","block");
    // })
    // $(".jour_detail_main_img_contrl").mouseout(function () {
    //     $(".jour_detail_main_img_contrl").css("display","none");
    // })

    $(".jour_detail_main_div").on('mouseover mouseout', function (e) {
        if (e.type === "mouseover") {
            this.getElementsByClassName('jour_detail_main_img_contrl')[0].style.display = 'block';
        } else if (e.type === "mouseout") {
            this.getElementsByClassName('jour_detail_main_img_contrl')[0].style.display = 'none';
        }
    })

    //设置目录的滚动固定
    //获取要定位元素距离浏览器顶部的距离
    var navH = $(".catalogue_and_tab").offset().top;
    // console.log(navH);
    //滚动条事件
    $(window).scroll(function(){
        //获取滚动条的滑动距离
        var scroH = $(this).scrollTop();
        // console.log(scroH);
        var scrollHeight = $(document).height();
        // console.log(scrollHeight);
        //滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
        if(scroH>=navH && scrollHeight-scroH>=966){
            $(".catalogue_and_tab").css({"position":"fixed","top":0});
        }else if(scroH<navH || scrollHeight-scroH<=960){
            $(".catalogue_and_tab").css({"position":"static"});
        }
    })

})