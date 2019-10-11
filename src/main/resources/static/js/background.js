$(function () {
    layui.use('element', function () {
        var element = layui.element;

        //监听导航点击
        element.on('nav(headerLikeIndex)', function(elem){
            console.log(elem)
        });
    });
    // $("#video").mouseover(function () {
    //     $("#left-slide").css({ "display": "block" });
    //     $("#right-slide").css({ "display": "block" });
    // });
    // $("#slide").mouseover(function () {
    //     $("#left-slide").css({ "display": "block" });
    //     $("#right-slide").css({ "display": "block" });
    // });
    // $("#video").mouseout(function () {
    //     $("#left-slide").css({ "display": "none" });
    //     $("#right-slide").css({ "display": "none" });
    // });

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

    //让导航栏的input失去底部条
    $(".search").mouseover(function () {
        $(".search").style.color = "black";
    })



})