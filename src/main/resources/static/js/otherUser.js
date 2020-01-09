$(function () {

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
    layui.use(['element', 'layer', 'laytpl'], function () {
        var element = layui.element;
        var layer = layui.layer;
        var laytpl = layui.laytpl;

        //…
        //获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
        var layid = location.hash.replace(/^#test1=/, '');
        element.tabChange('test1', layid); //假设当前地址为：http://a.com#test1=222，那么选项卡会自动切换到“发送消息”这一项

        //监听Tab切换，以改变地址hash值
        element.on('tab(test1)', function () {
            location.hash = 'test1=' + this.getAttribute('lay-id');
        });

        $("#header_destiny").removeClass("layui-this");
        $("#header_index").removeClass("layui-this");
        $("#header_strategy").removeClass("layui-this");
        $("#header_goHiking").removeClass("layui-this");
        $("#header_flight").removeClass("layui-this");
        $("#header_hotel").removeClass("layui-this");
        $("#header_notification").removeClass("layui-this");
        $("#header_self").addClass("layui-this");
        $("#header_company").removeClass("layui-this");

        if($("#uid").val() != null && $("#uid").val() != ""){
            unReadNum();

            //查询个人发表过的游记
            $.ajax({
                url:"/rwx/own/journey",
                type:"POST",
                data:{
                    uid: $("#uid").val()
                },
                async:false,
                success:function (journeys) {
                    var data = { //数据
                        "title":"Layui常用模块"
                        ,"list":journeys
                    }
                    var getTpl = demo.innerHTML
                        ,view = document.getElementById('view');
                    laytpl(getTpl).render(data, function(html){
                        view.innerHTML = html;
                    });
                }
            });

            //查询个人的留言
            $.ajax({
                url:"/rwx/own/remain",
                type:"POST",
                data:{
                    uid: $("#uid").val()
                },
                async:false,
                success:function (remains) {
                    var data = { //数据
                        "list":remains
                    }
                    var getRemainTpl = remainDemo.innerHTML
                        ,remainView = document.getElementById('remainView');
                    laytpl(getRemainTpl).render(data, function(html){
                        remainView.innerHTML = html;
                    });
                }
            });

            //查询个人的关注信息
            $.ajax({
                url:"/rwx/own/friend",
                type:"POST",
                data:{
                    uid: $("#uid").val(),
                    friendType: 1
                },
                async:false,
                success:function (fans) {
                    $(".attentionNum").text(fans.length);
                    var data = { //数据
                        "list":fans
                    };
                    var getRemainTpl = attentionDemo.innerHTML
                        ,attentionView = document.getElementById('attentionView');
                    laytpl(getRemainTpl).render(data, function(html){
                        attentionView.innerHTML = html;
                    });
                }
            });

            //查询个人的粉丝信息
            $.ajax({
                url:"/rwx/own/friend",
                type:"POST",
                data:{
                    uid: $("#uid").val(),
                    friendType: 2
                },
                async:false,
                success:function (fans) {
                    $(".fansNum").text(fans.length);
                    var data = { //数据
                        "list":fans
                    };
                    var getRemainTpl = fansDemo.innerHTML
                        ,fansView = document.getElementById('fansView');
                    laytpl(getRemainTpl).render(data, function(html){
                        fansView.innerHTML = html;
                    });
                }
            });

            //查询个人的攻略
            var strategy = new FormData();
            strategy.append("page",1);
            strategy.append("size",3);
            strategy.append("uid",$("#uid").val());
            $.ajax({
                url: "/rwx/strategyOwn/getPage",
                type: "POST",
                contentType: false,
                processData: false,
                data: strategy,
                async:false,
                success:function (res) {
                    console.log(res);

                    if(res.strategyList.length == 0){
                        $("#strategyPage").css("display","none");
                    }

                    for(var i=0; i<res.strategyList.length; i++){
                        res.strategyList[i].publishTime = resolvingDate(res.strategyList[i].publishTime);
                    }

                    var data = { //数据
                        "list":res
                    };
                    var getStrategyTpl = strategyDemo.innerHTML
                        ,strategyView = document.getElementById('strategyView');
                    laytpl(getStrategyTpl).render(data, function(html){
                        strategyView.innerHTML = html;
                    });
                    $(".totalStrategy").html(res.total_size);
                    $(".currStrategy").html(1);
                    $(".pageNumStrategy").html(res.total_page);

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

            //查询个人结伴
            getAll();

            //查询个人报名
            getByUser();

            //查询个人足迹
            historyGet($("#uid").val());
        }
        //添加留言
        $(".own_remain_message_save").click(function () {
            if($("#userId").val() != null && $("#userId").val() != ""){
                $.ajax({
                    url:"/rwx/addRemain",
                    type:"POST",
                    contentType: 'application/json',
                    dataType: "json",
                    data:JSON.stringify({
                        remainReceiverId: $("#uid").val(),
                        remainSenderId: $("#userId").val(),
                        remainContent: $(".own_remain_message").val()
                    }),
                    async:false,
                    success:function (remains) {
                        var data = { //数据
                            "list":remains
                        };
                        var getRemainTpl = remainDemo.innerHTML
                            ,remainView = document.getElementById('remainView');
                        laytpl(getRemainTpl).render(data, function(html){
                            remainView.innerHTML = html;
                        });
                    }
                })
            }else {
                layer.msg('您还未登录，是否前往登陆<br>该消息5秒后自动消失', {
                    time: 5000, //20s后自动关闭
                    btn: ['前往登陆', '稍后再说']
                    ,success: function(layero){
                        var btn = layero.find('.layui-layer-btn');
                        btn.find('.layui-layer-btn0').attr({
                            href: '/rwx/account'
                        });
                    }
                });
            }
        })
    });

    //生成从minNum到maxNum的随机数
    function randomNum(minNum, maxNum) {
        switch (arguments.length) {
            case 1:
                return parseInt(Math.random() * minNum + 1, 10);
                break;
            case 2:
                return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10);
                break;
            default:
                return 0;
                break;
        }
    }
    //定义背景图中的你知道么语句
    var doYouKnowList = [
        "你知道么，有个人时时想念着你，惦记你，你含笑的眼睛，象星光闪闪，缀在我的心幕上，夜夜亮晶晶...",
        "你知道么，伸手需要一瞬间，牵手却要很多年，无论你遇见谁，他都是你生命该出现的人，绝非偶然...",
        "你知道么，最好的状态就是，看过了世界的黑暗与痛苦，却依然相信它的单纯与美好...",
        "你知道么，我相信这世界上，有些人有些事有些爱，在见到的第一次，就注定要羁绊一生，就注定像一棵树一样，生长在心里，生生世世...",
        "你知道么，好运会与你不期而遇的，所以无论世界是否待你温柔，请保持住你的善良...",
        "你知道么，或许在某一个地方，会有另外一个你。做着你不敢做的事，过着你想要的生活...",
        "你知道么，你最喜欢的人，一定会在夜空沉睡的时候，像只灵敏的小驯鹿一样带着你最喜欢的满天星出现...",
        "你知道么，我喜欢那些闪光的东西，比如冬日的雪花，天上的星星，还有你的眼睛...",
        "你知道么，我一直希望，你身畔有一人，始终小心护住你的孩子气，爱着你，像深巷传来酒香，闻之即醉..."
    ];
    var i = randomNum(0, 8);
    document.getElementById("doYouKnow").innerHTML = doYouKnowList[i];

    //随机生成背景图片以及随机改变背景图中的你知道么的颜色
    var backPic = [
        "/rwx/images/321079.jpg",
        "/rwx/images/323266.jpg",
        "/rwx/images/321999.jpg",
        "/rwx/images/311403.jpg",
        "/rwx/images/319967.jpg",
        "/rwx/images/322058.jpg",
        "/rwx/images/323256.jpg",
        "/rwx/images/323572.jpg",
        "/rwx/images/322746.jpg"
    ];
    var colorList = [
        "coral", "coral", "mediumorchid", "mediumorchid",
        "white", "coral", "white", "white", "coral"
    ];
    var backPic_i = randomNum(0, 8);
    $(".doYouKnow").css('color', colorList[backPic_i]);
    $("#own_backPicNull").attr("src", backPic[backPic_i]);

    $(".own_haveAttended").on('mouseover mouseout', function (e) {
        if (e.type === "mouseover") {
            this.value = "取消关注"
        } else if (e.type === "mouseout") {
            this.value = "已关注"
        }
    });
    $(".own_notAttend").on('mouseover mouseout', function (e) {
        if (e.type === "mouseover") {
            this.value = "关注"
        } else if (e.type === "mouseout") {
            this.value = "未关注"
        }
    });

    //留言按钮变化
    $(".own_remain_message_save").mouseover(function () {
        $(".own_remain_message_save").addClass("layui-btn-warm");
        $(".own_remain_message_save").css("color", "white");
    });
    $(".own_remain_message_save").mouseout(function () {
        $(".own_remain_message_save").removeClass("layui-btn-warm");
        $(".own_remain_message_save").css("color", "black");
    });

});

//点击我的游记里的游记进入对应的游记详情页面
function toJourneyDetail(e){
    var journeyId = e.getAttribute("data-id");
    window.location.href = "/rwx/journey/" + journeyId;
}

//跳转到他人中心页面
function toOthers(e) {
    var uid = e.getAttribute("data-id");
    window.location.href = "/rwx/u/" + uid;
}

//显示对应页码的游记信息
function toPage(e) {
    var page = e.getAttribute("data-id");
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        $.ajax({
            url: "/rwx/own/journey",
            type: "POST",
            data: {
                uid: $("#uid").val(),
                page: page
            },
            async: false,
            success: function (journeys) {
                var data = { //数据
                    "list": journeys
                };
                var getTpl = demo.innerHTML
                    , view = document.getElementById('view');
                laytpl(getTpl).render(data, function (html) {
                    view.innerHTML = html;
                });
            }
        })
    })
}

//显示对应的留言分页内容
function toPageRemain(e) {
    var page = e.getAttribute("data-id");
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        $.ajax({
            url:"/rwx/own/remain",
            type:"POST",
            data:{
                uid: $("#uid").val(),
                page: page
            },
            async:false,
            success:function (remains) {
                if (remains == null){
                    $(".remainPage").css("display","none");
                }
                var data = { //数据
                    "list":remains
                };
                var getRemainTpl = remainDemo.innerHTML
                    ,remainView = document.getElementById('remainView');
                laytpl(getRemainTpl).render(data, function(html){
                    remainView.innerHTML = html;
                });
            }
        })
    })
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
                $("#unReadNum").css("display","none");
            }
            $("#unReadNum").html(res.unReadNum);
            // getAll();
        }
    });
}

/**
 * 获取个人的所有的结伴
 */
function getAll(){
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        strategyData.append("page",1);
        strategyData.append("size",6);
        strategyData.append("userId",$("#uid").val());
        $.ajax({
            url: "/rwx/company/getAllOwn",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {

                if(res.companyList.length == 0){
                    $("#pageHot").css("display","none");
                }

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

            }
        });
    });
}

/**
 * 获取个人所有报名
 */
function getByUser(){
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        /*strategyData.append("page",1);
        strategyData.append("size",6);
        strategyData.append("userId",$("#uid").val());*/
        $.ajax({
            url: "/rwx/enter/getUserEnter",
            type: "POST",
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify({
                userId: $("#uid").val()
            }),
            async: false,
            success: function (res) {
                /*if(res.companyList.length == 0){
                    $("#pageHot").css("display","none");
                }*/

                for(var i=0; i< res.enterDTOS.length; i++){
                    var date=new Date(res.enterDTOS[i].companyStartTime)//date日期类型
                    var  time= date.getTime();   //毫秒时间戳
                    res.enterDTOS[i].companyStartTime = getTime(time);
                }
                console.log(res);
                var data = {
                    "list": res
                };
                var getEnterTpl = enterDemo.innerHTML
                    , enterView = document.getElementById('enterView');
                laytpl(getEnterTpl).render(data, function (html) {
                    enterView.innerHTML = html;
                });

                /*var getPageTpl = pageDemo.innerHTML
                    , pageView = document.getElementById('pageView');
                laytpl(getPageTpl).render(data, function (html) {
                    pageView.innerHTML = html;
                });

                $(".total").html(res.total_size);
                $(".curr").html(res.current_page);
                $(".pageNum").html(res.total_page);*/

            }
        });
    });
}

/**
 * 结伴分页跳转
 * @param e
 */
function toPageCompany(e) {
    var url = "/rwx/company/getAllOwn";
    toCommonPage(e,url);
}
function toCommonPage(e,askUrl) {
    layui.use(['element', 'laytpl'], function () {
        var laytpl = layui.laytpl;
        var page = e.getAttribute("data-id");
        var strategyData = new FormData();
        strategyData.append("page", page);
        strategyData.append("size", 6);
        strategyData.append("userId",$("#uid").val());
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
 * 进入对应的某篇攻略页面
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
 * 从足迹跳转到对应的详情页面
 * @param e
 * @returns {boolean}
 */
function toSomeDetail(e) {
    var type = e.getAttribute("data-name");
    var typeId = e.getAttribute("data-id");
    if(type == 1){
        window.location.href = "/rwx/journey/" + typeId;
    }else if(type == 2){
        sessionStorage.setItem("strategyId",typeId);
        var star=getCookieById("strategyId",typeId);
        if(star==""){
            addCookieById("strategyId",typeId,2);
        }else{
            window.location.href = "/rwx/strategy/" + typeId+ ".html";
            return false;
        }
        $.ajax({
            url: "/rwx/strategy/incView",
            async: false,
            type: "post",
            data: JSON.stringify({
                strategyId: typeId
            }),
            contentType: "application/json",
            dataType: 'json',
            success: function(data){
                window.location.href = "/rwx/strategy/" + typeId+ ".html";
            }
        })
    }else if(type == 3){
        sessionStorage.setItem("companyId",typeId);
        console.log(typeId);
        var star=getCookieById("companyId",typeId);
        if(star==""){
            addCookieById("companyId",typeId,2);
        }else{
            window.location.href = "/rwx/company/" + typeId+ ".html";
            return false;
        }
        $.ajax({
            url: "/rwx/company/incView",
            async: false,
            type: "post",
            data: JSON.stringify({
                companyId: typeId
            }),
            contentType: "application/json",
            dataType: 'json',
            success: function(res){
                console.log(res);
                window.location.href = "/rwx/company/" + typeId+ ".html";
            }
        })
    }else if(type == 4){
        sessionStorage.setItem("albumId",typeId);
        console.log(typeId);
        var star=getCookieById("albumId",typeId);
        if(star==""){
            addCookieById("albumId",typeId,2);
        }else{
            window.location.href = "/rwx/album/" + typeId+ ".html";
            return false;
        }
        $.ajax({
            url: "/rwx/album/incView",
            async: false,
            type: "post",
            data: JSON.stringify({
                albumId: typeId
            }),
            contentType: "application/json",
            dataType: 'json',
            success: function(res){
                console.log(res);
                window.location.href = "/rwx/album/" + typeId+ ".html";
            }
        })
    }else if(type == 5){
        sessionStorage.setItem("sceneId",typeId);
        console.log(typeId);
        var star=getCookieById("sceneId",typeId);
        if(star==""){
            addCookieById("sceneId",typeId,2);
        }else{
            window.location.href = "/rwx/scene/" + typeId+ ".html";
            return false;
        }
        window.location.href = "/rwx/scene/" + typeId+ ".html";
    }
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
        strategy.append("size",3);
        strategy.append("uid",$("#uid").val());
        $.ajax({
            url: "/rwx/strategyOwn/getPage",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategy,
            async:false,
            success:function (res) {
                console.log(res);
                for(var i=0; i<res.strategyList.length; i++){
                    res.strategyList[i].publishTime = resolvingDate(res.strategyList[i].publishTime);
                }

                var data = { //数据
                    "list":res
                };
                var getStrategyTpl = strategyDemo.innerHTML
                    ,strategyView = document.getElementById('strategyView');
                laytpl(getStrategyTpl).render(data, function(html){
                    strategyView.innerHTML = html;
                });
                $(".totalStrategy").html(res.total_size);
                $(".currStrategy").html(1);
                $(".pageNumStrategy").html(res.total_page);

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

/**
 * 查询我的足迹
 * @param userId
 */
function historyGet(userId) {
    layui.use(['element', 'laytpl'], function () {
        var laytpl = layui.laytpl;
        var historyData = new FormData();
        historyData.append("page", 1);
        historyData.append("size", 12);
        historyData.append("userId",userId);
        $.ajax({
            url: "/rwx/history/getByUser",
            async: true,
            type: "post",
            contentType: false,
            processData: false,
            data: historyData,
            dataType: 'json',
            success: function (res) {
                console.log(res);

                if(res.notices.length == 0){
                    $("#pageHistory").css("display","none");
                }

                var data = {
                    "list": res
                };
                var getHistoryTpl = historyDemo.innerHTML
                    , historyView = document.getElementById('historyView');
                laytpl(getHistoryTpl).render(data, function (html) {
                    historyView.innerHTML = html;
                });

                var getPageHistoryTpl = pageHistoryDemo.innerHTML
                    , pageHistoryView = document.getElementById('pageHistoryView');
                laytpl(getPageHistoryTpl).render(data, function (html) {
                    pageHistoryView.innerHTML = html;
                });

                $(".totalHistory").html(res.total_size);
                $(".currHistory").html(res.current_page);
                $(".pageNumHistory").html(res.total_page);
            }
        })
    })
}

/**
 * 足迹分页跳转
 * @param e
 */
function toPageHistory(e) {
    layui.use(['element', 'laytpl'], function () {
        var laytpl = layui.laytpl;
        var page = e.getAttribute("data-id");
        var historyData = new FormData();
        historyData.append("page", page);
        historyData.append("size", 12);
        historyData.append("userId",$("#uid").val());
        $.ajax({
            url: "/rwx/history/getByUser",
            async: true,
            type: "post",
            contentType: false,
            processData: false,
            data: historyData,
            dataType: 'json',
            success: function (res) {
                console.log(res);

                var data = {
                    "list": res
                };
                var getHistoryTpl = historyDemo.innerHTML
                    , historyView = document.getElementById('historyView');
                laytpl(getHistoryTpl).render(data, function (html) {
                    historyView.innerHTML = html;
                });

                var getPageHistoryTpl = pageHistoryDemo.innerHTML
                    , pageHistoryView = document.getElementById('pageHistoryView');
                laytpl(getPageHistoryTpl).render(data, function (html) {
                    pageHistoryView.innerHTML = html;
                });

                $(".totalHistory").html(res.total_size);
                $(".currHistory").html(res.current_page);
                $(".pageNumHistory").html(res.total_page);
            }
        })
    })
}