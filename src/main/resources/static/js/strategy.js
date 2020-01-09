$(function () {
    layui.use(['element','laytpl','carousel'], function () {
        var element = layui.element;
        var laytpl = layui.laytpl

        //监听导航点击
        element.on('nav(headerLikeIndex)', function (elem) {
            console.log(elem)

        });

        $("#header_destiny").removeClass("layui-this");
        $("#header_index").removeClass("layui-this");
        $("#header_strategy").addClass("layui-this");
        $("#header_goHiking").removeClass("layui-this");
        $("#header_flight").removeClass("layui-this");
        $("#header_hotel").removeClass("layui-this");
        $("#header_notification").removeClass("layui-this");
        $("#header_self").removeClass("layui-this");
        $("#header_company").removeClass("layui-this");

        //轮播图
        var carousel = layui.carousel;
        //建造实例
        var ins = carousel.render({
            elem: '#test1'
            ,width: '100%' //设置容器宽度
            ,height: '570px'
            ,arrow: 'hover' //始终显示箭头
            ,anim: 'fade' //切换动画方式
            ,autoplay: true
        });
        $.ajax({
            url: "/rwx/turn",
            type: "POST",
            data: {
                turnType: 2
            },
            async:false,
            success:function (res) {
                console.log(res);

                var data = {
                    "list": res
                };
                var getHotAdviceTpl = hotAdviceDemo.innerHTML
                    , hotAdviceView = document.getElementById('hotAdviceView');
                laytpl(getHotAdviceTpl).render(data, function (html) {
                    // hotAdviceView.innerHTML = html;
                    $("#test1").children("div").html(html);

                    //下面这步很重要
                    ins.reload({elem: '#test1'});//重置轮播图
                });
            }
        });

        var strategy = new FormData();
        strategy.append("page",1);
        strategy.append("size",7);
        $.ajax({
            url: "/rwx/strategy/getPage",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategy,
            async:false,
            success:function (res) {
                console.log(res);
                var data = { //数据
                    "list":res
                };
                var getStrategyTpl = strategyDemo.innerHTML
                    ,strategyView = document.getElementById('strategyView');
                laytpl(getStrategyTpl).render(data, function(html){
                    strategyView.innerHTML = html;
                });
                $(".total").html(res.total_size);
                $(".curr").html(1);
                $(".pageNum").html(res.total_page);

                //鼠标移入攻略区的标题颜色变化
                $(".strategy_info").on('mouseover mouseout', function (e) {
                    if (e.type === "mouseover") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'coral';
                    } else if (e.type === "mouseout") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'black';
                    }
                })
            }
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
    navH = navH + 600;
    //滚动条事件
    $(window).scroll(function(){
        //获取滚动条的滑动距离
        var scroH = $(this).scrollTop();
         // console.log(scroH);
        var scrollHeight = $(document).height();
         // console.log(scrollHeight);
        //滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
        if(scroH>=navH && scrollHeight-scroH>=966){
            $(".strategy_guide").css({"position":"fixed","top":0});
        }else if(scroH<navH || scrollHeight-scroH<=966){
            $(".strategy_guide").css({"position":"static"});
        }
    })

    unReadNum();

});

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
 * 攻略分页跳转
 * @param e
 */
function toPageStrategy(e) {
    var page = e.getAttribute("data-id");
    console.log(sessionStorage.getItem("cityName"));
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        var strategy = new FormData();
        strategy.append("page",page);
        strategy.append("size",7);
        $.ajax({
            url: "/rwx/strategy/getPage",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategy,
            async:false,
            success:function (res) {
                console.log(res);
                var data = { //数据
                    "list":res
                };
                var getStrategyTpl = strategyDemo.innerHTML
                    ,strategyView = document.getElementById('strategyView');
                laytpl(getStrategyTpl).render(data, function(html){
                    strategyView.innerHTML = html;
                });
                $(".total").html(res.total_size);
                $(".curr").html(1);
                $(".pageNum").html(res.total_page);

                //鼠标移入攻略区的标题颜色变化
                $(".strategy_info").on('mouseover mouseout', function (e) {
                    if (e.type === "mouseover") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'coral';
                    } else if (e.type === "mouseout") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'black';
                    }
                })
            }
        });
    })
}

/**
 * 根据地名获取相应的攻略
 * @param e
 */
function getStrategyLike(e) {
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        var title = e.getAttribute("data-name");
        var strategy = new FormData();
        strategy.append("page",1);
        strategy.append("size",7);
        strategy.append("title",title);
        $.ajax({
            url: "/rwx/strategy/getStrategyLike",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategy,
            async:false,
            success:function (res) {
                console.log(res);
                var data = { //数据
                    "list":res
                };
                var getStrategyTpl = strategyDemo.innerHTML
                    ,strategyView = document.getElementById('strategyView');
                laytpl(getStrategyTpl).render(data, function(html){
                    strategyView.innerHTML = html;
                });
                $(".total").html(res.total_size);
                $(".curr").html(1);
                $(".pageNum").html(res.total_page);

                //鼠标移入攻略区的标题颜色变化
                $(".strategy_info").on('mouseover mouseout', function (e) {
                    if (e.type === "mouseover") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'coral';
                    } else if (e.type === "mouseout") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'black';
                    }
                })
            }
        });
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
 * 搜索对应攻略
 * @param
 */
search = function() {
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        var content = $("#searchVal").val();
        /*var strategy = new FormData();
        strategy.append("page",1);
        strategy.append("size",7);
        strategy.append("content",content);*/
        $.ajax({
            url: "/rwx/search/selectStrategy",
            type: "POST",
            data: JSON.stringify({
                page: 1,
                size: 7,
                content: content,
                userId: $(".userId").val()
            }),
            contentType: "application/json",
            dataType: 'json',
            async:false,
            success:function (res) {
                console.log(res);
                var data = { //数据
                    "list":res
                };
                var getStrategyTpl = strategyDemo.innerHTML
                    ,strategyView = document.getElementById('strategyView');
                laytpl(getStrategyTpl).render(data, function(html){
                    strategyView.innerHTML = html;
                });
                $(".total").html(res.total_size);
                $(".curr").html(1);
                $(".pageNum").html(res.total_page);

                //鼠标移入攻略区的标题颜色变化
                $(".strategy_info").on('mouseover mouseout', function (e) {
                    if (e.type === "mouseover") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'coral';
                    } else if (e.type === "mouseout") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'black';
                    }
                })
            }
        });
    })
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