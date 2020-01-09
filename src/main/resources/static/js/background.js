$(function () {
    layui.use(['element','laypage', 'layer', 'laytpl','util'], function () {
        var element = layui.element;
        var laypage = layui.laypage;
        var layer = layui.layer;
        var util = layui.util;
        var laytpl = layui.laytpl;

        //监听导航点击
        element.on('nav(headerLikeIndex)', function(elem){
            console.log(elem)
        });
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

        $.ajax({
            url:"/rwx/scene/select",
            type:"GET",
            contentType:"application/json;charset=UTF-8",
            async:false,
            success:function (res) {
                console.log(res);
                res.data[0].scenePics = res.data[0].scenePics.split(",");
                var data = { //数据
                    "list":res
                };
                var getSceneTpl = sceneDemo.innerHTML
                    ,sceneView = document.getElementById('sceneView');
                laytpl(getSceneTpl).render(data, function(html){
                    sceneView.innerHTML = html;
                });
            }
        });

        unReadNum();

        getWithView();

        getHotAdvice();

        getHotSimilarStrategy();

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
    /*$(".search").mouseover(function () {
        $(".search").style.color = "black";
    })*/

});

function toScene(e) {
    var sid = e.getAttribute("data-id");
    window.location.href = "/rwx/scene/" + sid + ".html";
}

function addHistory(e) {
    console.log(111);
    var typeId = e.getAttribute("data-id");
    $.ajax({
        url:"/rwx/history/add",
        type:"POST",
        contentType:"application/json;charset=UTF-8",
        data: json.stringify({
            userId: $("#uid").val(),
            type: 1,
            typeId: typeId
        }),
        async:false,
        success:function (res) {
            console.log(res);

        }
    });
}

function search() {
    var content = $("#searchAll").val();
    if(content == ''){
        layer.msg("请不要搜索空内容~");
    }else {
        sessionStorage.setItem("searchContent",content);
        window.location.href = "/rwx/search";
    }
}

function unReadNum() {
    var notice = new FormData();
    notice.append("userId",$("#uid").val());
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
                $(".unReadNumIndex").css("display","none");
                $("#unReadNumIndex").css("display","none");
            }
            $("#unReadNumIndex").html(res.unReadNum);
            // getAll();
        }
    });
}

/**
 * 获取粉丝最多的八个用户
 */
function getHotAdvice() {
    layui.use(['laytpl'], function () {
        var laytpl = layui.laytpl;

        $.ajax({
            url: "/rwx/user/selectHotUser",
            async: true,
            type: "post",
            contentType: "application/json",
            dataType: 'json',
            success: function (res) {
                console.log(res);

                var data = {
                    "list": res
                };
                var getHotAdviceTpl = userDemo.innerHTML
                    , hotAdviceView = document.getElementById('userView');
                laytpl(getHotAdviceTpl).render(data, function (html) {
                     hotAdviceView.innerHTML = html;
                });

            }
        })
    })
}

/**
 * 相册推荐
 */
function getWithView() {
    layui.use(['laytpl'], function () {
        var laytpl = layui.laytpl;

        $.ajax({
            url: "/rwx/album/getWithView",
            async: true,
            type: "post",
            contentType: "application/json",
            dataType: 'json',
            success: function (res) {
                console.log(res);
                for(var i=0; i<res.albumList.length; i++){
                    res.albumList[i].publishtime = resolvingDate(res.albumList[i].publishtime);
                }

                var data = {
                    "list": res
                };
                var getAlbumTpl = albumDemo.innerHTML
                    , albumView = document.getElementById('albumView');
                laytpl(getAlbumTpl).render(data, function (html) {
                    albumView.innerHTML = html;
                });

            }
        })
    })
}

/**
 * 跳转到他人中心页面
 * @param e
 */
function toOthers(e) {
    var uid = e.getAttribute("data-id");
    if(uid == $(".userId").val()){
        window.location.href = "/rwx/self";
    }else {
        window.location.href = "/rwx/u/" + uid;
    }
}

/**
 * 推荐热门结伴
 */
function getHotCompany(values) {
    layui.use(['element','carousel','laytpl'], function () {
        var carousel = layui.carousel;
        var laytpl = layui.laytpl;

        var ins = carousel.render({
            elem: '#hotAdviceLunBo'
            ,width: '100%' //设置容器宽度
            ,height: '460px'
            ,anim: 'fade' //切换动画方式
            ,autoplay: true
            ,interval: 3000
            ,arrow: 'hover'
            ,indicator: 'none'
        });

        $.ajax({
            url: "/rwx/company/adviceSimilar",
            async: true,
            type: "post",
            data: JSON.stringify({
                values: values,
            }),
            contentType: "application/json",
            dataType: 'json',
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
                var getHotAdviceTpl = hotAdviceDemo.innerHTML
                    , hotAdviceView = document.getElementById('hotAdviceView');
                laytpl(getHotAdviceTpl).render(data, function (html) {
                    // hotAdviceView.innerHTML = html;
                    $("#hotAdviceLunBo").children("div").html(html);

                    //下面这步很重要
                    ins.reload({elem: '#hotAdviceLunBo'});//重置轮播图
                });

            }
        })
    })
}

/**
 * 推荐热门攻略
 */
function getHotSimilarStrategy() {
    layui.use(['element','carousel','laytpl'], function () {
        var carousel = layui.carousel;
        var laytpl = layui.laytpl;

        var ins = carousel.render({
            elem: '#similarStrategyLunBo'
            ,width: '100%' //设置容器宽度
            ,height: '255px'
            ,anim: 'fade' //切换动画方式
            ,autoplay: true
            ,interval: 2000
            ,arrow: 'hover'
            ,indicator: 'none'
        });

        $.ajax({
            url: "/rwx/strategy/selectThreeMost",
            async: true,
            type: "post",
            contentType: "application/json",
            dataType: 'json',
            success: function (res) {
                console.log(res);

                var data = {
                    "list": res
                };
                var getSimilarStrategyTpl = SimilarStrategyDemo.innerHTML
                    , similarStrategyView = document.getElementById('similarStrategyView');
                laytpl(getSimilarStrategyTpl).render(data, function (html) {
                    // hotAdviceView.innerHTML = html;
                    $("#similarStrategyLunBo").children("div").html(html);

                    //下面这步很重要
                    ins.reload({elem: '#similarStrategyLunBo'});//重置轮播图
                });

            }
        })
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

/**
 * 跳转到相册页面
 * @param e
 * @returns {boolean}
 */
function toAlbumDetail(e) {
    var albumId = e.getAttribute("data-id");
    sessionStorage.setItem("albumId",albumId);
    var star=getCookieById("albumId",albumId);
    if(star==""){
        addCookieById("albumId",albumId,2);
    }else{
        window.location.href = "/rwx/album/" + albumId+ ".html";
        return false;
    }
    $.ajax({
        url: "/rwx/album/incView",
        async: false,
        type: "post",
        data: JSON.stringify({
            albumId: albumId
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function(res){
            console.log(res);
            window.location.href = "/rwx/album/" + albumId+ ".html";
        }
    })
}

/**
 * 进入对应的某篇攻略
 * @param e
 * @returns {boolean}
 */
function toStrategyDetail(e) {
    var strategyId = e.getAttribute("data-id");
    sessionStorage.setItem("strategyId",strategyId);
    var star=getCookieById("strategyId",strategyId);
    if(star==""){
        addCookieById("strategyId",strategyId,2);
    }else{
        window.location.href = "/rwx/strategy/" + strategyId+ ".html";
        return false;
    }
    $.ajax({
        url: "/rwx/strategy/incView",
        async: false,
        type: "post",
        data: JSON.stringify({
            strategyId: strategyId
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function(data){
            window.location.href = "/rwx/strategy/" + strategyId+ ".html";
        }
    })
}

/**
 * 时间格式转换
 * @param date
 * @returns {string}
 */
function resolvingDate(date){
//date是传入的时间
    var d = new Date(date);

    var month = (d.getMonth() + 1) < 10 ? '0'+(d.getMonth() + 1) : (d.getMonth() + 1);
    var day = d.getDate()<10 ? '0'+d.getDate() : d.getDate();
    var hours = d.getHours()<10 ? '0'+d.getHours() : d.getHours();
    var min = d.getMinutes()<10 ? '0'+d.getMinutes() : d.getMinutes();
    var sec = d.getSeconds()<10 ? '0'+d.getSeconds() : d.getSeconds();

    var times=d.getFullYear() + '-' + month + '-' + day;

    return times
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

/**
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

/**
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


/**
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