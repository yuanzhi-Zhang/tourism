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
        case ("01"): month = "Jan."; break;
        case ("02"): month = "Feb."; break;
        case ("03"): month = "Mar."; break;
        case ("04"): month = "Apr."; break;
        case ("05"): month = "May."; break;
        case ("06"): month = "Jun."; break;
        case ("07"): month = "Jul."; break;
        case ("08"): month = "Aug."; break;
        case ("09"): month = "Sep."; break;
        case ("10"): month = "Oct."; break;
        case ("11"): month = "Nov."; break;
        case ("12"): month = "Dec."; break;
        default: break;
    }
    document.getElementById("des_day").innerHTML = year + '.' + month + strDate;

    // 地图
    var map = new BMap.Map("container");
    // 创建地图实例  
    var point = new BMap.Point(116.404, 39.915);
    // 添加地图控件
    var opts = { type: BMAP_NAVIGATION_CONTROL_ZOOM }  //表示只显示控件的缩放部分功能
    map.addControl(new BMap.NavigationControl(opts));
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.MapTypeControl());
    // 创建点坐标  
    // 初始化地图，设置中心点坐标和地图级别 
    map.centerAndZoom(point, 15);
    //开启鼠标滚轮缩放
    map.enableScrollWheelZoom(true);

    //获取当前位置
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function (r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
            var mk = new BMap.Marker(r.point);
            map.addOverlay(mk);
            map.panTo(r.point);
        }
        else {
            alert("位置获取失败！");
        }
    });
    function myFun(result) {
        var cityName = result.name;
        map.setCenter(cityName);
        layer.alert("您当前所处城市:" + cityName,{icon:6});
    }
    var myCity = new BMap.LocalCity();
    myCity.get(myFun);

    //全景图
    var stCtrl = new BMap.PanoramaControl(); //构造全景控件
    stCtrl.setOffset(new BMap.Size(20, 60));
    map.addControl(stCtrl);//添加全景控件
    //路线导航
    var ro = [BMAP_DRIVING_POLICY_LEAST_TIME,
        BMAP_DRIVING_POLICY_LEAST_DISTANCE,
        BMAP_DRIVING_POLICY_AVOID_HIGHWAYS];
    $("#result").click(function () {
        var start = $("#start").val();
        var end = $("#end").val();
        //清掉之前的路线
        map.clearOverlays();
        var i = $("#dri_way select").val();
        search(start, end, ro[i]);
        //定义方法
        function search(start, end, rou) {
            //自动调整地图区域
            var dri = new BMap.DrivingRoute(map, {
                renderOptions: { map: map, autoViewport: true },
                polity: rou
            });
            dri.search(start, end);
        }
    })
    $("#chaxun").click(function () {
        var city = document.getElementById("cityName").value;
        if (city != "") {
            map.centerAndZoom(city, 15);      // 用城市名设置地图中心点
        }
    })

})