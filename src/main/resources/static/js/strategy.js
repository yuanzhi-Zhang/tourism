$(function () {
    layui.use('element', function () {
        var element = layui.element;

        //监听导航点击
        element.on('nav(headerLikeIndex)', function (elem) {
            console.log(elem)
        });
    });

    //获取当前年月日
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (strDate >= 1 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    switch (month) {
        case (01): month = "Jan."; break;
        case (02): month = "Feb."; break;
        case (03): month = "Mar."; break;
        case (04): month = "Apr."; break;
        case (05): month = "May."; break;
        case (06): month = "Jun."; break;
        case (07): month = "Jul."; break;
        case (08): month = "Aug."; break;
        case (09): month = "Sep."; break;
        case (10): month = "Oct."; break;
        case (11): month = "Nov."; break;
        case (12): month = "Dec."; break;
        default: break;
    }
    document.getElementById("day").innerHTML = strDate;
    document.getElementById("time").innerHTML = month + year;

    //设置目录的滚动固定
    //获取要定位元素距离浏览器顶部的距离
    var navH = $(".strategy_guide").offset().top;
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
            $(".strategy_guide").css({"position":"fixed","top":0});
        }else if(scroH<navH){
            $(".strategy_guide").css({"position":"static"});
        }
    })

    //鼠标移入攻略区的标题颜色变化
    $(".strategy_info").on('mouseover mouseout', function (e) {
        if (e.type === "mouseover") {
            this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'coral';
        } else if (e.type === "mouseout") {
            this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'black';
        }
    })
})