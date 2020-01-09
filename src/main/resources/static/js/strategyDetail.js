$(function () {
    layui.use(['element','laytpl','util','layer'], function () {
        var element = layui.element;
        var laytpl = layui.laytpl;
        var util = layui.util;
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(strategyComment)', function(data){
            layer.msg('展开状态：'+ data.show);
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

        //固定块
        util.fixbar({
            bar1: "&#xe63a;"
            ,bar2: "&#xe6c6;"
            ,css: {right: 50, bottom: 100}
            // ,bgcolor: '#393D49'
            ,click: function(type){
                if(type === 'bar1'){
                    location.href = "#comment_section";
                } else if(type === 'bar2') {
                    layer.msg('两个bar都可以设定是否开启')
                }
            }
        });

        //监听导航点击
        element.on('nav(headerLikeIndex)', function (elem) {
            console.log(elem)
        });

    });

    //设置目录的滚动固定
    //获取要定位元素距离浏览器顶部的距离
    var navH = $(".strategyDetail_catalogue").offset().top;
    // console.log(navH);
    //滚动条事件
    $(window).scroll(function(){
        //获取滚动条的滑动距离
        var scroH = $(this).scrollTop();
        // console.log(scroH);
        var scrollHeight = $(document).height();
        // console.log(scrollHeight);
        //滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
        if(scroH>=navH && scrollHeight-scroH>=966){
            $(".strategyDetail_catalogue").css({"position":"fixed","top":0,"width":"300px"});
        }else if(scroH<navH || scrollHeight-scroH<=920){
            $(".strategyDetail_catalogue").css({"position":"static"});
        }
    })

});

/**
 * 获取当前攻略详情
 */
function getDetail() {
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        var strategyData = new FormData();
        var strategyId = sessionStorage.getItem("strategyId");
        strategyData.append("strategyId", strategyId);
        $.ajax({
            url: "/rwx/strategy/getDetail",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategyData,
            async: false,
            success: function (res) {
                console.log(res);
                res.strategy.publishTime = resolvingDate(res.strategy.publishTime);

                var data = res;
                var getStrategyTpl = strategyDemo.innerHTML
                    , strategyView = document.getElementById('strategyView');
                laytpl(getStrategyTpl).render(data, function (html) {
                    strategyView.innerHTML = html;
                });

                $(".infoTitle").html(res.strategy.strategyTitle);
                $(".commentNum").html(res.strategy.commentNum);
                $(".collectNum").html(res.strategy.collectNum);
                $(".praiseNum").html(res.strategy.praiseTimes);

                //鼠标移入攻略区的标题颜色变化
                $(".strategy_info").on('mouseover mouseout', function (e) {
                    if (e.type === "mouseover") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'coral';
                    } else if (e.type === "mouseout") {
                        this.getElementsByClassName('strategy_partmain_title')[0].style.color = 'black';
                    }
                });

                selectCollect(res.strategy.strategyId,$(".userId").val());

                selectPraise(res.strategy.strategyId,$(".userId").val());

                unReadNum();

                getHotAdvice(res.strategy.strategyTitle);

                getComment(res.strategy.strategyId);

                historyAdd(res.strategy.strategyId,$(".userId").val(),res.strategy.strategyTitle,res.strategy.firstImg);
            }
        });
    });
}
getDetail();

/**
 * 查询用户是否收藏过该文章
 */
function selectCollect(typeId,userId) {
    $.ajax({
        url: "/rwx/collect/select",
        async: false,
        type: "post",
        data: JSON.stringify({
            typeId: typeId,
            userId: userId,
            type: 2
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function(res){
            sessionStorage.setItem("status",res.collectSize);
            if(res.collectSize != 0){
                $(".collect").attr("src","/rwx/images/icon/collect2.png");
            }else {
                $(".collect").attr("src","/rwx/images/icon/collect1.png");
            }
        }
    })
}

/**
 * 添加或取消收藏
 */
function collect() {
    layui.use(['layer'], function () {
        var layer = layui.layer;

        var typeId = $("#strategyId").val();
        var userId = $(".userId").val();
        console.log(sessionStorage.getItem("status"));
        if(userId == 0){
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
        }else {
            if(sessionStorage.getItem("status") == 0){
                $.ajax({
                    url: "/rwx/collect/add",
                    async: true,
                    type: "post",
                    data: JSON.stringify({
                        typeId: typeId,
                        userId: userId,
                        type: 2
                    }),
                    contentType: "application/json",
                    dataType: 'json',
                    success: function(res){
                        if(res.code == 200){
                            $(".collect").attr("src","/rwx/images/icon/collect2.png");
                            layer.msg("收藏成功！");
                        }
                        selectCollect(typeId,userId);
                        refreshNum(typeId)
                    }
                })
            }else {
                $.ajax({
                    url: "/rwx/collect/delete",
                    async: true,
                    type: "post",
                    data: JSON.stringify({
                        typeId: typeId,
                        userId: userId,
                        type: 2
                    }),
                    contentType: "application/json",
                    dataType: 'json',
                    success: function(res){
                        if(res.code == 200){
                            $(".collect").attr("src","/rwx/images/icon/collect1.png");
                            layer.msg("已取消收藏~");
                        }
                        selectCollect(typeId,userId);
                        refreshNum(typeId)
                    }
                })
            }
        }
    })
}

/**
 * 查询用户是否已点赞该攻略
 * @param typeId
 * @param userId
 */
function selectPraise(typeId,userId) {
    if(userId == 0){
        return;
    }else {
        $.ajax({
            url: "/rwx/praise/select",
            async: false,
            type: "post",
            data: JSON.stringify({
                typeId: typeId,
                userId: userId,
                type: 2
            }),
            contentType: "application/json",
            dataType: 'json',
            success: function(res){
                sessionStorage.setItem("praiseStatus",res.praiseSize);
                if(res.praiseSize != 0){
                    $(".praise").attr("src","/rwx/images/icon/praise2.png");
                }else {
                    $(".praise").attr("src","/rwx/images/icon/praise1.png");
                }
            }
        })
    }
}

/**
 * 添加历史记录
 * @param companyId
 * @param userId
 */
function historyAdd(companyId,userId,typeName,imgUrl) {
    $.ajax({
        url: "/rwx/history/incTimes",
        async: true,
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            typeId: companyId,
            userId: userId,
            type: 2,
            typeName: typeName,
            imgUrl: imgUrl
        }),
        dataType: 'json',
        success: function(res){

        }
    })
}

/**
 * 点赞或取消点赞
 */
function praise() {
    layui.use(['layer'], function () {
        var layer = layui.layer;

        var typeId = $("#strategyId").val();
        var userId = $(".userId").val();
        if(userId == 0){
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
        }else {
            if(sessionStorage.getItem("praiseStatus") == 0){
                $.ajax({
                    url: "/rwx/praise/add",
                    async: true,
                    type: "post",
                    data: JSON.stringify({
                        typeId: typeId,
                        userId: userId,
                        type: 2
                    }),
                    contentType: "application/json",
                    dataType: 'json',
                    success: function(res){
                        if(res.code == 200){
                            $(".praise").attr("src","/rwx/images/icon/praise2.png");
                            layer.msg("点赞成功！");
                        }
                        selectPraise(typeId,userId);
                        refreshNum(typeId)
                    }
                })
            }else {
                $.ajax({
                    url: "/rwx/praise/delete",
                    async: true,
                    type: "post",
                    data: JSON.stringify({
                        typeId: typeId,
                        userId: userId,
                        type: 2
                    }),
                    contentType: "application/json",
                    dataType: 'json',
                    success: function(res){
                        if(res.code == 200){
                            $(".praise").attr("src","/rwx/images/icon/praise1.png");
                            layer.msg("已取消点赞~");
                        }
                        selectPraise(typeId,userId);
                        refreshNum(typeId)
                    }
                });
            }
        }
    })
}

/**
 * 更新点赞评论收藏等的数量
 * @param typeId
 */
function refreshNum(typeId) {
    $.ajax({
        url: "/rwx/strategy/refreshNum",
        async: true,
        type: "post",
        data: JSON.stringify({
            typeId: typeId,
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function(res){
            $(".commentNum").html(res.refreshNum.commentNum);
            $(".collectNum").html(res.refreshNum.collectNum);
            $(".praiseNum").html(res.refreshNum.praiseTimes);
        }
    });
}

/**
 * 获取当前攻略的所有主评论
 */
function getComment(strategyId) {
    layui.use(['element','laytpl','layer'], function () {
        var element = layui.element;
        var laytpl = layui.laytpl;
        //监听折叠
        element.on('collapse(strategyComment)', function(data){
            layer.msg('展开状态：'+ data.show);
        });

        $.ajax({
            url: "/rwx/comment/getByType",
            async: true,
            type: "post",
            contentType: "application/json",
            data: JSON.stringify({
                id: strategyId,
                type: 2
            }),
            dataType: 'json',
            success: function(res){
                console.log(res);
                $(".mainComment").html(res.data.length);
                var data = {
                    "list": res
                };
                var getStrategyCommentTpl = strategyCommentDemo.innerHTML
                    , strategyCommentView = document.getElementById('strategyCommentView');
                laytpl(getStrategyCommentTpl).render(data, function (html) {
                    strategyCommentView.innerHTML = html;
                });
            }
        })
    })
}

/**
 * 回复文章（攻略）
 */
function post() {
    var strategyId = $("#strategyId").val();
    var content = $("#comment_content").val();
    var userId = $(".userId").val();
    if(userId == 0){
        layer.msg('登录才能评论哦，是否前往登陆<br>该消息5秒后自动消失', {
            time: 5000, //5s后自动关闭
            btn: ['立即前往', '稍后再说']
            ,success: function(layero){
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').attr({
                    href: '/rwx/account'
                });
            }
        });
    }else {
        comment2target(strategyId, 2,userId, content);
        $("#comment_content").val() == "";
    }
}

/**
 * 回复评论与文章的公共方法
 * @param strategyId
 * @param type
 * @param userId
 * @param content
 */
function comment2target(strategyId, type, userId, content) {
    if (!content) {
        layer.alert("不能回复空内容哦！！！",{icon:0});
        return;
    }

    $.ajax({
        type: "POST",
        url: "/rwx/comment",
        contentType: 'application/json',
        dataType: "json",
        async: true,
        data: JSON.stringify({
            "userId" : userId,
            "parentId":strategyId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if(type == 2){
                getComment(strategyId);
                refreshNum(strategyId);
            }
            else {
                var subCommentContainer = $("#comment-" + strategyId);

                //此处有bug
                subCommentContainer.empty();
                subCommentContainer.append(
                    '<div class="subReply" style="margin-top: 20px;">'+
                    '<input type="text" placeholder="评论一下..." autocomplete="off" id="input-"+ strategyId class="layui-input"'+
                    'style="float: left;width: 85.5%;margin-right: 15px;border-radius: 5px;">'+
                    '<button type="button" class="layui-btn" data-id=strategyId onclick="comment(this)" style="border-radius: 5px;">'+
                    '回复'+
                    '</button>'+
                    '</div>'
                );

                $.getJSON("/rwx/comment/" + strategyId, function (data) {
                    $.each(data.data.reverse(), function (index, comment) {
                        var mediaLeftElement = $("<div/>", {
                            "class": "media-left"
                        }).append($("<img/>", {
                            "class": "media-object",
                            "src": comment.user.imgurl
                        }));

                        var mediaBodyElement = $("<div/>", {
                            "class": "media-body"
                        }).append($("<h4/>", {
                            "class": "media-heading up",
                            "html": comment.user.username +
                            '&ensp;(' + comment.user.address +
                            ')' + '&emsp;<button type="button" class="layui-btn layui-btn-xs layui-btn-radius layui-btn-warm"\n' +
                            ' style="height: 20px;margin-top: -3px;">\n' +
                            ' <i class="layui-icon">&#xe608;</i>关注\n' +
                            ' </button>' + '<br>' +
                            ' <button type="button" class="layui-btn layui-btn-xs layui-btn-normal commentReply"\n' +
                            ' style="height: 20px;margin-top: -5px;float: right;">\n' +
                            ' <i class="layui-icon layui-icon-reply-fill"></i>回复\n' +
                            ' </button>'
                        })).append($("<span/>", {
                            "html": comment.commenttime
                        })).append($("<div/>", {
                            "html": comment.commentcomment
                        })).append($("<div/>", {
                            "class": "menu"
                        }));

                        var mediaElement = $("<div/>", {
                            "class": "media"
                        }).append(mediaLeftElement).append(mediaBodyElement);

                        var commentElement = $("<div/>", {
                            "class": "comments"
                        }).append(mediaElement);

                        subCommentContainer.prepend(commentElement);
                    });
                });
            }
        }
    });
}

/**
 * 回复评论
 * @param e
 */
function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    var userId = $(".userId").val();
    if(userId == 0){
        layer.msg('登录才能评论哦，是否前往登陆<br>该消息5秒后自动消失', {
            time: 5000, //5s后自动关闭
            btn: ['立即前往', '稍后再说']
            ,success: function(layero){
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').attr({
                    href: '/rwx/account'
                });
            }
        });
    }else {
        comment2target(commentId, 5, userId, content);

    }
}

/**
 * 展开二级评论
 */
function openSub(e) {
    layui.use(['element','laytpl','layer'], function () {
        var element = layui.element;
        var laytpl = layui.laytpl;
        var id = e.getAttribute("data-id");
        // 获取一下二级评论的展开状态
        if ($("#comment-" + id).hasClass("layui-show")) {
            $("#comment-" + id).removeClass("layui-show");
            e.classList.remove("active");
        } else {
            /*$.ajax({
                url: "/rwx/comment/" + id,
                async: true,
                type: "get",
                contentType: "application/json",
                dataType: 'json',
                success: function (res) {
                    console.log(res);
                    var data = {
                        "list": res
                    };
                    var getSubCommentTpl = subCommentDemo.innerHTML
                        , subCommentView = document.getElementById('subCommentView'+id);
                    laytpl(getSubCommentTpl).render(data, function (html) {
                        console.log(html);
                        subCommentView.innerHTML = html;
                    });
                }
            });
            $("#comment-" + id).addClass("layui-show");*/
            var subCommentContainer = $("#comment-" + id);
            // console.log(subCommentContainer.children().length);
            if (subCommentContainer.children().length != 2) {
                //展开二级评论
                $("#comment-" + id).addClass("layui-show");
                e.classList.add("active");
            } else {
                $.getJSON("/rwx/comment/" + id, function (data) {
                    if (data.data.length == 0){
                        subCommentContainer.prepend('<p style="color: #666;">暂时还没有人回复哦，快来抢占沙发吧~</p>');
                    }else {
                        $.each(data.data.reverse(), function (index, comment) {
                            var mediaLeftElement = $("<div/>", {
                                "class": "media-left"
                            }).append($("<img/>", {
                                "class": "media-object",
                                "src": comment.user.imgurl
                            }));

                            var mediaBodyElement = $("<div/>", {
                                "class": "media-body"
                            }).append($("<h4/>", {
                                "class": "media-heading up",
                                "html": comment.user.username +
                                '&ensp;(' + comment.user.address +
                                ')' + '&emsp;<button type="button" class="layui-btn layui-btn-xs layui-btn-radius layui-btn-warm"\n' +
                                ' style="height: 20px;margin-top: -3px;">\n' +
                                ' <i class="layui-icon">&#xe608;</i>关注\n' +
                                ' </button>' + '<br>' +
                                ' <button type="button" class="layui-btn layui-btn-xs layui-btn-normal commentReply"\n' +
                                ' style="height: 20px;margin-top: -5px;float: right;">\n' +
                                ' <i class="layui-icon layui-icon-reply-fill"></i>回复\n' +
                                ' </button>'
                            })).append($("<span/>", {
                                "html": comment.commenttime
                            })).append($("<div/>", {
                                "html": comment.commentcomment
                            })).append($("<div/>", {
                                "class": "menu"
                            }));

                            var mediaElement = $("<div/>", {
                                "class": "media"
                            }).append(mediaLeftElement).append(mediaBodyElement);

                            var commentElement = $("<div/>", {
                                "class": "comments"
                            }).append(mediaElement);

                            subCommentContainer.prepend(commentElement);
                        });
                    }
                    //展开二级评论
                    $("#comment-" + id).addClass("layui-show");
                    e.classList.add("active");
                });
            }
        }
    })

}

/**
 * 查询用户是否已经点赞过该评论
 * @param typeId
 * @param userId
 */
function selectCommentPraise(typeId,userId) {
    var statu = 1;
    $.ajax({
        url: "/rwx/praise/select",
        async: false,
        type: "post",
        data: JSON.stringify({
            typeId: typeId,
            userId: userId,
            type: 3
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function(res){
            console.log(res.praiseSize);
            statu = res.praiseSize;
            return res.praiseSize;
        }
    });
    return statu;
}

/**
 * 点赞评论
 * @param e
 */
function praiseComment(e) {
    layui.use(['layer'], function () {
        var layer = layui.layer;

        var typeId = e.getAttribute("data-id");
        var userId = $(".userId").val();
        if(userId == 0){
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
        }else {
            var status = selectCommentPraise(typeId,userId);
            console.log(status);
            if(status == 0){
                $.ajax({
                    url: "/rwx/praise/add",
                    async: true,
                    type: "post",
                    data: JSON.stringify({
                        typeId: typeId,
                        userId: userId,
                        type: 3
                    }),
                    contentType: "application/json",
                    dataType: 'json',
                    success: function(res){
                        $(".praise").addClass("praised");
                    }
                })
            }else if(status == 1) {
                $.ajax({
                    url: "/rwx/praise/delete",
                    async: true,
                    type: "post",
                    data: JSON.stringify({
                        typeId: typeId,
                        userId: userId,
                        type: 3
                    }),
                    contentType: "application/json",
                    dataType: 'json',
                    success: function(res){
                        $(".praise").removeClass("praised");
                    }
                });
            }
        }
    })
}

/**
 * 添加关注
 * @param e
 */
function addAttention(e) {
    var friend = new FormData();
    var uid = $(".userId").val();
    var friendId = e.getAttribute("data-id");
    if(uid == friendId){
        layer.alert("不能关注自己哦！！！",{icon:6});
        return;
    }
    friend.append("uid",uid);
    friend.append("friendId",friendId);
    friend.append("friendType",1);
    /*$.ajax({
        url:"/rwx/own/isAttended",
        type:"POST",
        data:JSON.stringify({
            uid: uid,
            friendType: 1,
            friendId: friendId
        }),
        contentType: "application/json",
        dataType: 'json',
        async:false,
        success:function (fans) {
            console.log(fans);
        }
    });*/
    $.ajax({
        url: "/rwx/own/friend/attend",
        type: "POST",
        contentType: false,
        processData: false,
        data: friend,
        async:false,
        success:function (fans) {
            if (fans.code == 2000){
                layer.msg("关注成功");
                $(".attend").css("display","none");
            }else if(fans.code == 2001){
                layer.msg("您已关注过TA了哦");
            }
        }
    })
}

/**
 * 根据用户点击的管理或游记推荐相似的结伴
 */
function getHotAdvice(values) {
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
    /*var hours = d.getHours()<10 ? '0'+d.getHours() : d.getHours();
    var min = d.getMinutes()<10 ? '0'+d.getMinutes() : d.getMinutes();
    var sec = d.getSeconds()<10 ? '0'+d.getSeconds() : d.getSeconds();*/

    var times=d.getFullYear() + '-' + month + '-' + day;

    return times
}

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