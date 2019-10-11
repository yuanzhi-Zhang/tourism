$(function () {
    layui.use('element', function () {
        var element = layui.element;

        //…
    });

    //轮播图
    var hotelImgList = [
        "images/hotel/hotel1.jpg",
        "images/hotel/hotel2.jpg",
        "images/hotel/hotel3.jpg",
        "images/hotel/hotel4.jpg",
        "images/hotel/hotel5.jpg"
    ];
    var currentNum = 0;
    setInterval(function () {
        $(".hotel_turnImg_main").attr('src',hotelImgList[currentNum]);
        // $(".hotelImg")[currentNum].classList.add("border");
        currentNum++;
        // $(".hotelImg")[currentNum-1].classList.remove("border");
        if(currentNum == 5){
            currentNum = 0;
        }
    },3000)
    for(var i=0;i<hotelImgList.length;i++){
        $(".hotelImg")[i].click(function () {
            $(".hotel_turnImg_main").attr('src',hotelImgList[i]);
            $(".hotelImg")[i].classList.add("border");
        })
    }
    $(".hotelImg1").click(function () {
        $(".hotel_turnImg_main").attr('src','images/hotel/hotel1.jpg');
        $(".hotelImg1").classList.add(".border");
    })
    $(".hotelImg2").click(function () {
        $(".hotel_turnImg_main").attr('src','images/hotel/hotel2.jpg');
        $(".hotelImg2").classList.add(".border");
    })
    $(".hotelImg3").click(function () {
        $(".hotel_turnImg_main").attr('src','images/hotel/hotel3.jpg');
    })
    $(".hotelImg4").click(function () {
        $(".hotel_turnImg_main").attr('src','images/hotel/hotel4.jpg');
    })
    $(".hotelImg5").click(function () {
        $(".hotel_turnImg_main").attr('src','images/hotel/hotel5.jpg');
    })
})