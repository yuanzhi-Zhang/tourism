$(function () {
    layui.use(['element','layer','laytpl','laypage','util'], function () {
        var element = layui.element;
        var layer = layui.layer;
        var laytpl = layui.laytpl;
        var laypage = layui.laypage;
        var util = layui.util;

        $("#header_destiny").removeClass("layui-this");
        $("#header_index").removeClass("layui-this");
        $("#header_strategy").removeClass("layui-this");
        $("#header_goHiking").removeClass("layui-this");
        $("#header_flight").removeClass("layui-this");
        $("#header_hotel").addClass("layui-this");
        $("#header_notification").removeClass("layui-this");
        $("#header_self").addClass("layui-this");
        $("#header_company").removeClass("layui-this");

        //固定块
        util.fixbar({
            bar1: true
            ,bar2: true
            ,css: {right: 50, bottom: 100}
            ,bgcolor: '#393D49'
            ,click: function(type){
                if(type === 'bar1'){
                    layer.msg('icon是可以随便换的')
                } else if(type === 'bar2') {
                    layer.msg('两个bar都可以设定是否开启')
                }
            }
        });

        //…
        //获取当前位置
        /*var geolocation = new BMap.Geolocation();
        function myFun(result) {
            var cityName = result.name;

        }
        var myCity = new BMap.LocalCity();
        myCity.get(myFun);*/

        function dz() {
            var geolocation = new BMap.Geolocation();
            geolocation.getCurrentPosition(function getinfo(position){
                var cityName = position.address.city; //获取城市信息
                sessionStorage.setItem("cityName",cityName);
                layer.alert("您当前所处城市:" + cityName,{icon:6});
                var city = new FormData();
                city.append("localCity",cityName);
                city.append("page",1);
                $.ajax({
                    url: "/rwx/hotel",
                    type: "POST",
                    contentType: false,
                    processData: false,
                    data: city,
                    async:false,
                    success:function (res) {
                        console.log(res);
                        var data = { //数据
                            "list":res
                        };
                        var getHotelTpl = hotelDemo.innerHTML
                            ,hotelView = document.getElementById('hotelView');
                        laytpl(getHotelTpl).render(data, function(html){
                            hotelView.innerHTML = html;
                        });
                        $(".total").html(res.total_size);
                        $(".curr").html(1);
                        $(".pageNum").html(res.total_page);
                    }
                })
            }, function(e) {
                alert("获取百度定位位置信息失败");
            }, {provider: 'baidu'});
        }

        //自动播放
        var hotelImgList = [];
        $.ajax({
            url: "/rwx/turn",
            type: "POST",
            data: {
                turnType: 6
            },
            async:false,
            success:function (res) {
                console.log(res);
                $(".hotel_turnImg_main").attr('src',res.turnList[0].turnUrl);
                for(var i=0; i<res.turnList.length; i++){
                    hotelImgList.push(res.turnList[i].turnUrl);
                }
                var data = { //数据
                    "list":res
                };
                var getTurnTpl = turnDemo.innerHTML
                    ,turnView = document.getElementById('turnView');
                laytpl(getTurnTpl).render(data, function(html){
                    turnView.innerHTML = html;
                });
            }
        });
        var currentNum = 1;
        var interval = setInterval(function () {
            $(".hotel_turnImg_main").attr('src',hotelImgList[currentNum]);
            currentNum++;
            if(currentNum == 5){
                currentNum = 0;
            }
        },3000);
        //焦点图效果
        //点击图片切换图片
        $('.hotelImg').on('mousemove', function() {
            $('.hotelImg').removeClass('cur_img');
            var big_pic = $(this).data('bigpic');
            $('.hotel_turnImg_main').attr('src', big_pic);
            clearInterval(interval );
            $(this).addClass('cur_img');
        });
        $('.hotelImg').on('mouseout', function() {
            interval = setInterval(function () {
                $(".hotel_turnImg_main").attr('src',hotelImgList[currentNum]);
                currentNum++;
                if(currentNum == 5){
                    currentNum = 0;
                }
            },3000);
        });

        unReadNum();

        var cityName = "九江市"; //获取城市信息
        sessionStorage.setItem("cityName",cityName);
        layer.alert("您当前所处城市:" + cityName,{icon:6});
        var city = new FormData();
        city.append("localCity",cityName);
        city.append("page",1);
        $.ajax({
            url: "/rwx/hotel",
            type: "POST",
            contentType: false,
            processData: false,
            data: city,
            async:false,
            success:function (res) {
                console.log(res);
                var data = { //数据
                    "list":res
                };
                var getHotelTpl = hotelDemo.innerHTML
                    ,hotelView = document.getElementById('hotelView');
                laytpl(getHotelTpl).render(data, function(html){
                    hotelView.innerHTML = html;
                });
                $(".total").html(res.total_size);
                $(".curr").html(1);
                $(".pageNum").html(res.total_page);
            }
        })

    });

});

/**
 * 分页跳转
 * @param e
 */
function toPageHotel(e) {
    var page = e.getAttribute("data-id");
    console.log(sessionStorage.getItem("cityName"));
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        var city = new FormData();
        city.append("localCity",sessionStorage.getItem("cityName"));
        city.append("page",page);
        $.ajax({
            url: "/rwx/hotel",
            type: "POST",
            contentType: false,
            processData: false,
            data: city,
            async:false,
            success:function (res) {
                var data = { //数据
                    "list":res
                };
                var getHotelTpl = hotelDemo.innerHTML
                    ,hotelView = document.getElementById('hotelView');
                laytpl(getHotelTpl).render(data, function(html){
                    hotelView.innerHTML = html;
                });
                $(".total").html(res.total_size);
                $(".curr").html(page);
                $(".pageNum").html(res.total_page);
            }
        })
    })
}

function unReadNum() {
    var notice = new FormData();
    notice.append("userId",$(".userId").val());
    $.ajax({
        url: "/rwx/notification/noteNum",
        async: false,
        type: "post",
        data: notice,
        contentType: false,
        processData: false,
        dataType: 'json',
        success: function (res) {
            console.log(res);

            if(res.unReadNum == 0){
                $("#unReadNum").css("display","none");
            }
            $("#unReadNum").html(res.unReadNum);
            // getAll();
        }
    });
}

/**
 * 进入对用的酒店详情页
 * @param e
 */
function toHotelDetail(e) {
    var hotelId = e.getAttribute("data-id");
    // window.location.href = "/rwx/hotel/" + hotelId;
}