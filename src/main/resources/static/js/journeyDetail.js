$(function () {
    layui.use(['element','layer'], function () {
        var element = layui.element;
        layer = layui.layer

        //…
    });

    //
    // $(".jour_detail_main_img").mouseover(function () {
    //     $(".jour_detail_main_img_contrl").css("display","block");
    // })
    // $(".jour_detail_main_img").mouseout(function () {
    //     $(".jour_detail_main_img_contrl").css("display","none");
    // })
    // $(".jour_detail_main_img_contrl").mouseover(function () {
    //     $(".jour_detail_main_img_contrl").css("display","block");
    // })
    // $(".jour_detail_main_img_contrl").mouseout(function () {
    //     $(".jour_detail_main_img_contrl").css("display","none");
    // })

    $(".jour_detail_main_div").on('mouseover mouseout', function (e) {
        if (e.type === "mouseover") {
            this.getElementsByClassName('jour_detail_main_img_contrl')[0].style.display = 'block';
        } else if (e.type === "mouseout") {
            this.getElementsByClassName('jour_detail_main_img_contrl')[0].style.display = 'none';
        }
    })

    //设置目录的滚动固定
    //获取要定位元素距离浏览器顶部的距离
    var navH = $(".catalogue_and_tab").offset().top;
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
            $(".catalogue_and_tab").css({"position":"fixed","top":0});
        }else if(scroH<navH || scrollHeight-scroH<=960){
            $(".catalogue_and_tab").css({"position":"static"});
        }
    })
})

/**
 * 提交回复
 */
function post() {
    var journeyId = $("#journey_id").val();
    var content = $("#comment_content").val();
    var userId = $("#uid").val();
    if(userId == null || userId == ""){
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
        comment2target(journeyId, 1,userId, content);
    }
}

function comment2target(targetId, type, userId, content) {
    if (!content) {
        layer.alert("不能回复空内容哦！！！",{icon:0})
        return;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "userId" : userId,
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=2859958f9f059979ed3a&redirect_uri=" + document.location.origin + "/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    var userId = $("#uid").val();
    if(userId == null || userId == ""){
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
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);

    // 获取一下二级评论的展开状态
    var collapse = e.getAttribute("data-collapse");
    if (collapse) {
        // 折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    } else {
        var subCommentContainer = $("#comment-" + id);
        if (subCommentContainer.children().length != 1) {
            //展开二级评论
            comments.addClass("in");
            // 标记二级评论展开状态
            e.setAttribute("data-collapse", "in");
            e.classList.add("active");
        } else {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {
                    var mediaLeftElement = $("<div/>", {
                        "class": "media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-rounded",
                        "src": comment.user.avatarUrl
                    }));

                    var mediaBodyElement = $("<div/>", {
                        "class": "media-body"
                    }).append($("<h5/>", {
                        "class": "media-heading",
                        "html": comment.user.name
                    })).append($("<div/>", {
                        "html": comment.content
                    })).append($("<div/>", {
                        "class": "menu"
                    }).append($("<span/>", {
                        "class": "pull-right",
                        "html": moment(comment.gmtCreate).format('YYYY-MM-DD')
                    })));

                    var mediaElement = $("<div/>", {
                        "class": "media"
                    }).append(mediaLeftElement).append(mediaBodyElement);

                    var commentElement = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments"
                    }).append(mediaElement);

                    subCommentContainer.prepend(commentElement);
                });
                //展开二级评论
                comments.addClass("in");
                // 标记二级评论展开状态
                e.setAttribute("data-collapse", "in");
                e.classList.add("active");
            });
        }
    }
}