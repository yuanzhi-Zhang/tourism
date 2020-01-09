layui.use(['element','util'], function(){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    var util = layui.util;

    //监听导航点击
    element.on('nav(demo)', function(elem){
        //console.log(elem)
        layer.msg(elem.text());
    });

    //固定块
    util.fixbar({

    });

    $("#header_destiny").removeClass("layui-this");
    $("#header_index").removeClass("layui-this");
    $("#header_strategy").removeClass("layui-this");
    $("#header_goHiking").removeClass("layui-this");
    $("#header_flight").removeClass("layui-this");
    $("#header_hotel").removeClass("layui-this");
    $("#header_notification").removeClass("layui-this");
    $("#header_self").removeClass("layui-this");
    $("#header_company").addClass("layui-this");

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

    $("#_j_together_mdd_search").click(function () {
        $(".drop-place").removeClass("hide");
        $("._j_time_list").addClass("hide");
        $("._j_time_list").removeClass("focus");
        $("#_j_together_mdd_search").css("border","1px solid coral");
        $("._j_time_input").css("border","0");
    });
    $("._j_time_input").click(function () {
        $("._j_time_list").removeClass("hide");
        $("._j_time_list").addClass("focus");
        $(".drop-place").addClass("hide");
        $("._j_time_input").css("border","1px solid coral");
        $("#_j_together_mdd_search").css("border","0");
        /**
         * 获取出发时间在今天，一个月内，一到三个月，三个月以上的结伴数
         */
        $.ajax({
            url: "/rwx/company/selectWithUserTypeNum",
            type: "post",
            contentType: false,
            processData: false,
            async: false,
            success: function (res) {
                console.log(res);
                $(".todayNum").html(res.companyTodayNum);
                $(".monthNum").html(res.companyMonthNum);
                $(".threeMonthNum").html(res.companyThreeMonthNum);
                $(".moreThreeMonthNum").html(res.companyMoreThreeMonthNum);
            }
        });

    });
    //控制点击input以外的区域会触发input的blur事件
    $(document).mouseup(function (e) {
        var con1 = $("._j_time_list");   // 设置目标区域
        var con2 = $(".drop-place");   // 设置目标区域
        if (!con1.is(e.target) && con1.has(e.target).length === 0) {
            con1.addClass("hide");
            // $("#_j_together_mdd_search").css("border","1px solid #d6d6d6");
        }
        if (!con2.is(e.target) && con2.has(e.target).length === 0) {
            con2.addClass("hide");
            // $("#_j_time_input").css("border","1px solid #d6d6d6");
        }
    });
    $("#flag2").click(function () {
       $("#flag2").addClass("on");
       $("#flag1").removeClass("on");
       $("#flag3").removeClass("on");
       $("._j_time_input").val("");
    });
    $("#flag1").click(function () {
       $("#flag1").addClass("on");
       $("#flag2").removeClass("on");
       $("#flag3").removeClass("on");
       $("._j_time_input").val("");
    });
    $("#flag3").click(function () {
       $("#flag3").addClass("on");
       $("#flag1").removeClass("on");
       $("#flag2").removeClass("on");
       $("._j_time_input").val("");
    });

    //设置目录的滚动固定
    //获取要定位元素距离浏览器顶部的距离
    var navH = $("._j_filter").offset().top;
    console.log(navH);
    //滚动条事件
    $(window).scroll(function(){
        //获取滚动条的滑动距离
        var scroH = $(this).scrollTop();
        // console.log(scroH);
        var scrollHeight = $(document).height();
        // console.log(scrollHeight);
        //滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
        if(scroH>=navH){
            $("._j_filter").css({"position":"fixed","top":0,"z-index": 999,"width":'100%'});
        }else if(scroH<navH){
            $("._j_filter").css({"position":"static"});
        }
    })

    unReadNum();

});

/**
 * 获取所有的结伴
 */
function getAll(){
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        strategyData.append("page",1);
        strategyData.append("size",12);
        $.ajax({
            url: "/rwx/company/getAll",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                for(var i=0; i< res.companyList.length; i++){
                    var date=new Date(res.companyList[i].companyStartTime)//date日期类型
                    var  time= date.getTime();   //毫秒时间戳
                    res.companyList[i].companyStartTime = getTime(time);
                }
                console.log(res);
                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                var getPageTpl = pageDemo.innerHTML
                    , pageView = document.getElementById('pageView');
                laytpl(getPageTpl).render(data, function (html) {
                    pageView.innerHTML = html;
                });

                $(".total").html(res.total_size);
                $(".curr").html(res.current_page);
                $(".pageNum").html(res.total_page);

                // $("._j_time_input").val("全部出发时间");
            }
        });

        /**
         * 获取结伴总数
         */
        $.ajax({
            url: "/rwx/company/countNum",
            type: "post",
            contentType: false,
            processData: false,
            async: false,
            success: function (res) {
                console.log(res.companyNum);
                $("#companyNum").html(res.companyNum);
                $(".companyNum").html(res.companyNum);
                $(".allTime").html(res.companyNum);
            }
        });

        $("#flag2").removeClass("on");
        $("#flag3").removeClass("on");
        $("#pageHot").css("display","block");
        $("#pageNewUp").css("display","none");
        $("#pageGoing").css("display","none");
        $("#pageMonth").css("display","none");
        $("#pageThreeMonth").css("display","none");
        $("#pageMoreThreeMonth").css("display","none");
        $("#pageToday").css("display","none");
    });
}
getAll();

/**
 * 分页跳转
 * @param e
 */
function toPageCompany(e) {
    var url = "/rwx/company/getAll";
    toCommonPage(e,url);
}

/**
 * 将要出发分类的分页跳转
 * @param e
 */
function toPageGoingCompany(e) {
    var url = "/rwx/company/getAllNew";
    toCommonPage(e,url);
}

/**
 * 分页跳转的公共方法
 * @param e
 * @param askUrl
 */
function toCommonPage(e,askUrl) {
    layui.use(['element', 'laytpl'], function () {
        var laytpl = layui.laytpl;
        var page = e.getAttribute("data-id");
        var strategyData = new FormData();
        strategyData.append("page", page);
        strategyData.append("size", 12);
        $.ajax({
            url: askUrl,
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                console.log(res);
                for (var i = 0; i < res.companyList.length; i++) {
                    var date = new Date(res.companyList[i].companyStartTime)//date日期类型
                    var time = date.getTime();   //毫秒时间戳
                    res.companyList[i].companyStartTime = getTime(time);
                }
                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                $(".total").html(res.total_size);
                $(".curr").html(res.current_page);
                $(".pageNum").html(res.total_page);
            }
        });
    })
}

/**
 * 去除分类的框
 */
function removeClass() {
    $("#flag2").removeClass("on");
    $("#flag1").removeClass("on");
    $("#flag3").removeClass("on");
}

/**
 * 最新发表的分页跳转
 * @param e
 */
function toPageNewUpCompany(e) {
    var url = "/rwx/company/getAllNewUp";
    toCommonPage(e,url);
}

/**
 * 今天将要出发的分页跳转
 * @param e
 */
function toPageTodayCompany(e) {
    var url = "/rwx/company/selectWithUserToday";
    toCommonPage(e,url);
}

/**
 * 一个月内将要出发的分页跳转
 * @param e
 */
function toPageMonthCompany(e) {
    var url = "/rwx/company/selectWithUserMonth";
    toCommonPage(e,url);
}

/**
 * 一到三个月内将要出发的分页跳转
 * @param e
 */
function toPageThreeMonthCompany(e) {
    var url = "/rwx/company/selectWithUserThreeMonth";
    toCommonPage(e,url);
}

/**
 * 三个月以上将要出发的分页跳转
 * @param e
 */
function toPageMoreThreeMonthCompany(e) {
    var url = "/rwx/company/selectWithUserMoreThreeMonth";
    toCommonPage(e,url);
}

/**
 * 获取60天内（即将出发分类）要出发的
 */
function getCompany60New() {
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        strategyData.append("page", 1);
        strategyData.append("size", 12);
        $.ajax({
            url: "/rwx/company/getAllNew",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                console.log(res);
                for (var i = 0; i < res.companyList.length; i++) {
                    var date=new Date(res.companyList[i].companyStartTime)//date日期类型
                    var  time= date.getTime();   //毫秒时间戳
                    res.companyList[i].companyStartTime = getTime(time);
                }
                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                var getPageGoingTpl = pageGoingDemo.innerHTML
                    , pageGoingView = document.getElementById('pageGoingView');
                laytpl(getPageGoingTpl).render(data, function (html) {
                    pageGoingView.innerHTML = html;
                });

                $("#pageHot").css("display","none");
                $("#pageNewUp").css("display","none");
                $("#pageToday").css("display","none");
                $("#pageMonth").css("display","none");
                $("#pageThreeMonth").css("display","none");
                $("#pageMoreThreeMonth").css("display","none");
                $("#pageGoing").css("display","block");
                $(".totalGoing").html(res.total_size);
                $(".currGoing").html(res.current_page);
                $(".pageNumGoing").html(res.total_page);
            }
        });
    })
}

/**
 * 获取今天要出发的结伴
 */
function getToday() {
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        strategyData.append("page", 1);
        strategyData.append("size", 12);
        $.ajax({
            url: "/rwx/company/selectWithUserToday",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                console.log(res);
                for (var i = 0; i < res.companyList.length; i++) {
                    var date=new Date(res.companyList[i].companyStartTime)//date日期类型
                    var  time= date.getTime();   //毫秒时间戳
                    res.companyList[i].companyStartTime = getTime(time);
                }
                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                if(res.total_size == 0){
                    $("#pageHot").css("display","none");
                    $("#pageNewUp").css("display","none");
                    $("#pageGoing").css("display","none");
                    $("#pageMonth").css("display","none");
                    $("#pageThreeMonth").css("display","none");
                    $("#pageMoreThreeMonth").css("display","none");
                    $("#pageToday").css("display","none");
                }else {
                    var getPageTodayTpl = pageTodayDemo.innerHTML
                        , pageTodayView = document.getElementById('pageTodayView');
                    laytpl(getPageTodayTpl).render(data, function (html) {
                        pageTodayView.innerHTML = html;
                    });

                    $("#pageHot").css("display","none");
                    $("#pageNewUp").css("display","none");
                    $("#pageGoing").css("display","none");
                    $("#pageMonth").css("display","none");
                    $("#pageThreeMonth").css("display","none");
                    $("#pageMoreThreeMonth").css("display","none");
                    $("#pageToday").css("display","block");
                    $(".totalToday").html(res.total_size);
                    $(".currToday").html(res.current_page);
                    $(".pageNumToday").html(res.total_page);
                }

                removeClass();

                $("._j_time_input").val("今天");
            }
        });
    })
}

/**
 * 获取一个月内将要出发的结伴
 */
function getAMonth() {
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        strategyData.append("page", 1);
        strategyData.append("size", 12);
        $.ajax({
            url: "/rwx/company/selectWithUserMonth",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                console.log(res);
                for (var i = 0; i < res.companyList.length; i++) {
                    var date=new Date(res.companyList[i].companyStartTime)//date日期类型
                    var  time= date.getTime();   //毫秒时间戳
                    res.companyList[i].companyStartTime = getTime(time);
                }
                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                var getPageMonthTpl = pageMonthDemo.innerHTML
                    , pageMonthView = document.getElementById('pageMonthView');
                laytpl(getPageMonthTpl).render(data, function (html) {
                    pageMonthView.innerHTML = html;
                });

                $("#pageHot").css("display","none");
                $("#pageNewUp").css("display","none");
                $("#pageGoing").css("display","none");
                $("#pageMonth").css("display","block");
                $("#pageThreeMonth").css("display","none");
                $("#pageMoreThreeMonth").css("display","none");
                $("#pageToday").css("display","none");
                $(".totalMonth").html(res.total_size);
                $(".currMonth").html(res.current_page);
                $(".pageNumMonth").html(res.total_page);

                removeClass();

                $("._j_time_input").val("1个月内");
            }
        });
    })
}

/**
 * 获取一到三个月内将要出发的结伴
 */
function getThreeMonth() {
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        strategyData.append("page", 1);
        strategyData.append("size", 12);
        $.ajax({
            url: "/rwx/company/selectWithUserThreeMonth",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                console.log(res);
                for (var i = 0; i < res.companyList.length; i++) {
                    var date=new Date(res.companyList[i].companyStartTime)//date日期类型
                    var  time= date.getTime();   //毫秒时间戳
                    res.companyList[i].companyStartTime = getTime(time);
                }
                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                var getPageThreeMonthTpl = pageThreeMonthDemo.innerHTML
                    , pageThreeMonthView = document.getElementById('pageThreeMonthView');
                laytpl(getPageThreeMonthTpl).render(data, function (html) {
                    pageThreeMonthView.innerHTML = html;
                });

                $("#pageHot").css("display","none");
                $("#pageNewUp").css("display","none");
                $("#pageGoing").css("display","none");
                $("#pageMonth").css("display","none");
                $("#pageThreeMonth").css("display","block");
                $("#pageMoreThreeMonth").css("display","none");
                $("#pageToday").css("display","none");
                $(".totalThreeMonth").html(res.total_size);
                $(".currThreeMonth").html(res.current_page);
                $(".pageNumThreeMonth").html(res.total_page);

                removeClass();

                $("._j_time_input").val("1-3个月内");
            }
        });
    })
}

/**
 * 获取三个月以上的结伴
 */
function getMoreThreeMonth() {
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        strategyData.append("page", 1);
        strategyData.append("size", 12);
        $.ajax({
            url: "/rwx/company/selectWithUserMoreThreeMonth",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                console.log(res);
                for (var i = 0; i < res.companyList.length; i++) {
                    var date=new Date(res.companyList[i].companyStartTime)//date日期类型
                    var  time= date.getTime();   //毫秒时间戳
                    res.companyList[i].companyStartTime = getTime(time);
                }
                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                var getPageMoreThreeMonthTpl = pageMoreThreeMonthDemo.innerHTML
                    , pageMoreThreeMonthView = document.getElementById('pageMoreThreeMonthView');
                laytpl(getPageMoreThreeMonthTpl).render(data, function (html) {
                    pageMoreThreeMonthView.innerHTML = html;
                });

                $("#pageHot").css("display","none");
                $("#pageNewUp").css("display","none");
                $("#pageGoing").css("display","none");
                $("#pageMonth").css("display","none");
                $("#pageThreeMonth").css("display","none");
                $("#pageMoreThreeMonth").css("display","block");
                $("#pageToday").css("display","none");
                $(".totalMoreThreeMonth").html(res.total_size);
                $(".currMoreThreeMonth").html(res.current_page);
                $(".pageNumMoreThreeMonth").html(res.total_page);

                removeClass();

                $("._j_time_input").val("3个月以上");
            }
        });
    })
}

/**
 * 获取最新15天内发表（最新发表分类）的
 */
function getCompanyNewUp() {
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        strategyData.append("page", 1);
        strategyData.append("size", 12);
        $.ajax({
            url: "/rwx/company/getAllNewUp",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                console.log(res);
                for (var i = 0; i < res.companyList.length; i++) {
                    var date=new Date(res.companyList[i].companyStartTime)//date日期类型
                    var  time= date.getTime();   //毫秒时间戳
                    res.companyList[i].companyStartTime = getTime(time);
                }
                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                var getPageNewUpTpl = pageNewUpDemo.innerHTML
                    , pageNewUpView = document.getElementById('pageNewUpView');
                laytpl(getPageNewUpTpl).render(data, function (html) {
                    pageNewUpView.innerHTML = html;
                });

                $("#pageHot").css("display","none");
                $("#pageNewUp").css("display","block");
                $("#pageGoing").css("display","none");
                $("#pageToday").css("display","none");
                $(".totalNewUp").html(res.total_size);
                $(".currNewUp").html(res.current_page);
                $(".pageNumNewUp").html(res.total_page);
            }
        });
    })
}

/**
 * 获取相应目的地结伴
 */
function getByDestiny() {
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        strategyData.append("page", 1);
        strategyData.append("size", 12);
        strategyData.append("destiny", "丽江");
        $.ajax({
            url: "/rwx/company/getByDestiny",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                console.log(res);
                /*for (var i = 0; i < res.companyList.length; i++) {
                    var date=new Date(res.companyList[i].companyStartTime)//date日期类型
                    var  time= date.getTime();   //毫秒时间戳
                    res.companyList[i].companyStartTime = getTime(time);
                }
                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                var getPageNewUpTpl = pageNewUpDemo.innerHTML
                    , pageNewUpView = document.getElementById('pageNewUpView');
                laytpl(getPageNewUpTpl).render(data, function (html) {
                    pageNewUpView.innerHTML = html;
                });

                $("#pageHot").css("display","none");
                $("#pageNewUp").css("display","block");
                $("#pageGoing").css("display","none");
                $("#pageToday").css("display","none");
                $(".totalNewUp").html(res.total_size);
                $(".currNewUp").html(res.current_page);
                $(".pageNumNewUp").html(res.total_page);*/
            }
        });
    })
}

/**
 * 跳转到结伴详情（两小时之内阅读数随之加一）
 * @param e
 * @returns {boolean}
 */
function toCompanyDetail(e) {
    var companyId = e.getAttribute("data-id");
    sessionStorage.setItem("companyId",companyId);
    console.log(companyId);
    var star=getCookieById("companyId",companyId);
    if(star==""){
        addCookieById("companyId",companyId,2);
    }else{
        window.location.href = "/rwx/company/" + companyId+ ".html";
        return false;
    }
    $.ajax({
        url: "/rwx/company/incView",
        async: false,
        type: "post",
        data: JSON.stringify({
            companyId: companyId
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function(res){
            console.log(res);
            window.location.href = "/rwx/company/" + companyId+ ".html";
        }
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
 * 转换成多少天后的格式
 * @param dateTimeStamp
 * @returns {number}
 */
function getTime(dateTimeStamp) {
    var minute = 1000 * 60;
    var hour = minute * 60;
    var day = hour * 24;
    /*var halfamonth = day * 15;
    var month = day * 30;
    var year = day * 365;*/
    var now = new Date();
    var diffValue = dateTimeStamp - now;
    /*if(diffValue < 0){return;}
    var yearC =diffValue/year;
    var monthC =diffValue/month;
    var weekC =diffValue/(7*day);*/
    var dayC =diffValue/day;
    if(dayC>=1){
        dayC=""+ parseInt(dayC);
    }
    /*var hourC =diffValue/hour;
    var minC =diffValue/minute;
    if(yearC>=1){
        result="" + parseInt(yearC)*365;
    }
    else if(monthC>=1){
        result="" + parseInt(monthC);
    }
    else if(weekC>=1){
        result="" + parseInt(weekC)*30;
    }
    else if(dayC>=1){
        result=""+ parseInt(dayC);
    }
    else if(hourC>=1){
        result=""+ parseInt(hourC);
    }
    else if(minC>=1){
        result=""+ parseInt(minC);
    }else
        result="0";*/
    return dayC;
};

//转换时间格式
function resolvingDate(date){
//date是传入的时间
    var d = new Date(date);

    var month = (d.getMonth() + 1) < 10 ? '0'+(d.getMonth() + 1) : (d.getMonth() + 1);
    var day = d.getDate()<10 ? '0'+d.getDate() : d.getDate();
    /*var hours = d.getHours()<10 ? '0'+d.getHours() : d.getHours();
    var min = d.getMinutes()<10 ? '0'+d.getMinutes() : d.getMinutes();
    var sec = d.getSeconds()<10 ? '0'+d.getSeconds() : d.getSeconds();*/

    var times=d.getFullYear() + '-' + month + '-' + day;

    return times
}

/*
	* 获取特定cookie的值
	* @param    cookie键
	* @return   cookie该键对应的值
	* */
function getCookie(cname){
    var name=cname+"=";
    var ca=document.cookie.split(';');
    for(var i=0;i<ca.length;i++){
        var c=ca[i].trim();
        if(c.indexOf(name)==0)
            return c.substring(name.length,c.length);
    }
    return "";
}

/*
* 判断cookie键中是否有某个资源的id
* @param    cookie键
* @param    查询资源id
* @return   存在返回true，否则返回""
* */
function getCookieById(cname,id){
    var name=cname+"=";
    var ca=document.cookie.split(';');
    var cValue="";
    for(var i=0;i<ca.length;i++){
        var c=ca[i].trim();
        if(c.indexOf(name)==0)
            cValue=c.substring(name.length,c.length);
    }
    if(cValue!=""){
        var cArray=cValue.split(",");
        for(var i=0;i<cArray.length;i++){
            var c=cArray[i].trim();
            if(c.indexOf(id)==0){
                return true;
            }
        }
    }
    return "";
}


/*
* 添加某个资源id到cookie键中
* @param    cookie键名
* @param    资源id
* @param    cookie过期时间
* */
function addCookieById(cname,id,exdays){
    var cvalue=getCookie(cname);
    if(cvalue==""){
        cvalue=id;
    }else {
        var cArray=cvalue.split(",");
        var flag=0;
        for(var i=0;i<cArray.length;i++){
            var c=cArray[i].trim();
            if(c.indexOf(id)==0){
                flag=1;
                break;
            }
        }
        if(flag==0) {
            cvalue += "," + id;
        }
    }

    var d=new Date();
    d.setTime(d.getTime()+(exdays*60*60*1000));
    var expires="expires="+d.toGMTString();
    document.cookie=cname+"="+cvalue+"; "+expires;
}
