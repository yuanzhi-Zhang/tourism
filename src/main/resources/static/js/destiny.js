$(function () {
    layui.use('element','layer', function () {
        var element = layui.element;
        layer = layui.layer

        //…
    });
    layui.use('layer', function () {
        var $ = layui.jquery
        layer = layui.layer
    })

    // $("#des_nav").mouseover(function () {
    //     for (var i = 0; i < document.getElementsByClassName("layui-nav-item").length; i++) {
    //         document.getElementsByClassName("layui-nav-item a")[i].style.color = "black";
    //     }
    // })
    // $("#des_nav").mouseout(function () {
    //     for (var i = 0; i < document.getElementsByClassName("layui-nav-item").length; i++) {
    //         document.getElementsByClassName("layui-nav-item a")[i].style.color = "white";
    //     }
    // })

    //显示当前那一天
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
    document.getElementById("des_day").innerHTML = year + '.' + month + strDate;

    // 地图
    // var map = new BMap.Map("container");
    // // 创建地图实例
    // var point = new BMap.Point(116.404, 39.915);
    // // 添加地图控件
    // var opts = { type: BMAP_NAVIGATION_CONTROL_ZOOM }  //表示只显示控件的缩放部分功能
    // map.addControl(new BMap.NavigationControl(opts));
    // map.addControl(new BMap.ScaleControl());
    // map.addControl(new BMap.MapTypeControl());
    // // 创建点坐标
    // // 初始化地图，设置中心点坐标和地图级别
    // map.centerAndZoom(point, 15);
    // //开启鼠标滚轮缩放
    // map.enableScrollWheelZoom(true);
    //
    // //获取当前位置
    // var geolocation = new BMap.Geolocation();
    // geolocation.getCurrentPosition(function (r) {
    //     if (this.getStatus() == BMAP_STATUS_SUCCESS) {
    //         var mk = new BMap.Marker(r.point);
    //         map.addOverlay(mk);
    //         map.panTo(r.point);
    //     }
    //     else {
    //         alert("位置获取失败！");
    //     }
    // });
    // function myFun(result) {
    //     var cityName = result.name;
    //     map.setCenter(cityName);
    //     // layer.alert("您当前所处城市:" + cityName,{icon:6});
    // }
    // var myCity = new BMap.LocalCity();
    // myCity.get(myFun);
    //
    // //全景图
    // var stCtrl = new BMap.PanoramaControl(); //构造全景控件
    // stCtrl.setOffset(new BMap.Size(20, 60));
    // map.addControl(stCtrl);//添加全景控件
    // //路线导航
    // var ro = [BMAP_DRIVING_POLICY_LEAST_TIME,
    //     BMAP_DRIVING_POLICY_LEAST_DISTANCE,
    //     BMAP_DRIVING_POLICY_AVOID_HIGHWAYS];
    // $("#result").click(function () {
    //     var start = $("#start").val();
    //     var end = $("#end").val();
    //     //清掉之前的路线
    //     map.clearOverlays();
    //     var i = $("#dri_way select").val();
    //     search(start, end, ro[i]);
    //     //定义方法
    //     function search(start, end, rou) {
    //         //自动调整地图区域
    //         var dri = new BMap.DrivingRoute(map, {
    //             renderOptions: { map: map, autoViewport: true },
    //             polity: rou
    //         });
    //         dri.search(start, end);
    //     }
    // })
    // $("#chaxun").click(function () {
    //     var city = document.getElementById("cityName").value;
    //     if (city != "") {
    //         map.centerAndZoom(city, 15);      // 用城市名设置地图中心点
    //     }
    // })

    //主题目的地的图片上的鼠标移入移出的变化
    $(".des_themeDes_left").mouseover(function () {
        $(".des_themeDes_left_img_name").css("display","none");
        $(".des_themeDes_left_img_info").css("display","block");
    })
    $(".des_themeDes_left").mouseout(function () {
        $(".des_themeDes_left_img_name").css("display","block");
        $(".des_themeDes_left_img_info").css("display","none");
    })

    // for (var i=1; i<=29; i++){
    //     $(".des_themeDes_right_li")[i].mouseover=function () {
    //         $(".des_themeDes_right_li .name")[i].css("display","none");
    //         $(".des_themeDes_right_li .info")[i].css("display","block");
    //     }
    //     $(".des_themeDes_right_li")[i].mouseout=function () {
    //         $(".des_themeDes_right li .name")[i].css("display","block");
    //         $(".des_themeDes_right li .info")[i].css("display","none");
    //     }
    // }
    $(".des_themeDes_right_li").on('mouseover mouseout', function (e) {
        if (e.type === "mouseover") {
            this.getElementsByClassName('name')[0].style.display = 'none';
            this.getElementsByClassName('info')[0].style.display = 'block';
        } else if (e.type === "mouseout") {
            this.getElementsByClassName('name')[0].style.display = 'block';
            this.getElementsByClassName('info')[0].style.display = 'none';
        }
    })

    // $(".des_themeDes_right_li")[0].onmouseover=function () {
    //     $(".des_themeDes_right_li .name")[0].style.display='none';
    //     $(".des_themeDes_right_li .info")[0].style.display='block';
    // }
    // $(".des_themeDes_right_li")[0].onmouseout=function () {
    //     $(".des_themeDes_right_li .name")[0].style.display='block';
    //     $(".des_themeDes_right_li .info")[0].style.display='none';
    // }
    // $(".des_themeDes_right_li")[1].onmouseover=function () {
    //     $(".des_themeDes_right_li .name")[1].style.display='none';
    //     $(".des_themeDes_right_li .info")[1].style.display='block';
    // }
    // $(".des_themeDes_right_li")[1].onmouseout=function () {
    //     $(".des_themeDes_right_li .name")[1].style.display='block';
    //     $(".des_themeDes_right_li .info")[1].style.display='none';
    // }
    // $(".des_themeDes_right_li")[2].onmouseover=function () {
    //     $(".des_themeDes_right_li .name")[2].style.display='none';
    //     $(".des_themeDes_right_li .info")[2].style.display='block';
    // }
    // $(".des_themeDes_right_li")[2].onmouseout=function () {
    //     $(".des_themeDes_right_li .name")[2].style.display='block';
    //     $(".des_themeDes_right_li .info")[2].style.display='none';
    // }
    // $(".des_themeDes_right_li")[3].onmouseover=function () {
    //     $(".des_themeDes_right_li .name")[3].style.display='none';
    //     $(".des_themeDes_right_li .info")[3].style.display='block';
    // }
    // $(".des_themeDes_right_li")[3].onmouseout=function () {
    //     $(".des_themeDes_right_li .name")[3].style.display='block';
    //     $(".des_themeDes_right_li .info")[3].style.display='none';
    // }
    // $(".des_themeDes_right_li")[4].onmouseover=function () {
    //     $(".des_themeDes_right_li .name")[4].style.display='none';
    //     $(".des_themeDes_right_li .info")[4].style.display='block';
    // }
    // $(".des_themeDes_right_li")[4].onmouseout=function () {
    //     $(".des_themeDes_right_li .name")[4].style.display='block';
    //     $(".des_themeDes_right_li .info")[4].style.display='none';
    // }
    // $(".des_themeDes_right_li")[5].onmouseover=function () {
    //     $(".des_themeDes_right_li .name")[5].style.display='none';
    //     $(".des_themeDes_right_li .info")[5].style.display='block';
    // }
    // $(".des_themeDes_right_li")[5].onmouseout=function () {
    //     $(".des_themeDes_right_li .name")[5].style.display='block';
    //     $(".des_themeDes_right_li .info")[5].style.display='none';
    // }


})