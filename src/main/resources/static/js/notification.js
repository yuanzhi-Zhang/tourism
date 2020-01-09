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
    $("#header_hotel").removeClass("layui-this");
    $("#header_notification").addClass("layui-this");
    $("#header_self").removeClass("layui-this");
    $("#header_company").removeClass("layui-this");

    //固定块
    util.fixbar({
        bar1: true
        , bar2: true
        , css: {right: 50, bottom: 100}
        // , bgcolor: '#393D49'
        , click: function (type) {
            if (type === 'bar1') {
                layer.msg('icon是可以随便换的')
            } else if (type === 'bar2') {
                layer.msg('两个bar都可以设定是否开启')
            }
        }
    });

    getAll();

    unReadNum();
});

function getAll() {
    layui.use(['element','laytpl'], function () {
        var laytpl = layui.laytpl;
        console.log($(".userId").val());
        var notice = new FormData();
        notice.append("userId", $(".userId").val());
        $.ajax({
            url: "/rwx/notification",
            async: false,
            type: "post",
            data: notice,
            contentType: false,
            processData: false,
            dataType: 'json',
            success: function (res) {
                console.log(res);

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

                $(".totalNewUp").html(res.total_size);
                $(".currNewUp").html(res.current_page);
                $(".pageNumNewUp").html(res.total_page);
            }
        })
    })
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
            layer.msg("已成功回复~");
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
    var type = e.getAttribute("data-name");
    if(content == ''){
        layer.msg("回复内容不能为空哦~");
    }else {
        comment2target(commentId, type, userId, content);
        var noteId = e.getAttribute("data-index");
        console.log(noteId);
        var notice = new FormData();
        notice.append("noteId",noteId);
        $.ajax({
            url: "/rwx/notification/delete",
            async: false,
            type: "post",
            data: notice,
            contentType: false,
            processData: false,
            dataType: 'json',
            success: function (res) {
                console.log(res);

                $("#notices-" + noteId).css("display","none");
                // getAll();
            }
        });
    }
}
function commentStrategy(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#inputStrategy-" + commentId).val();
    var userId = $(".userId").val();
    var type = e.getAttribute("data-name");
    if(content == ''){
        layer.msg("回复内容不能为空哦~");
    }else {
        comment2target(commentId, type, userId, content);
        var noteId = e.getAttribute("data-index");
        console.log(noteId);
        var notice = new FormData();
        notice.append("noteId",noteId);
        $.ajax({
            url: "/rwx/notification/delete",
            async: false,
            type: "post",
            data: notice,
            contentType: false,
            processData: false,
            dataType: 'json',
            success: function (res) {
                console.log(res);

                $("#notices-" + noteId).css("display","none");
                // getAll();
            }
        });
    }
}
function commentCompany(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#inputCompany-" + commentId).val();
    var userId = $(".userId").val();
    var type = e.getAttribute("data-name");
    if(content == ''){
        layer.msg("回复内容不能为空哦~");
    }else {
        comment2target(commentId, type, userId, content);
        var noteId = e.getAttribute("data-index");
        console.log(noteId);
        var notice = new FormData();
        notice.append("noteId",noteId);
        $.ajax({
            url: "/rwx/notification/delete",
            async: false,
            type: "post",
            data: notice,
            contentType: false,
            processData: false,
            dataType: 'json',
            success: function (res) {
                console.log(res);

                $("#notices-" + noteId).css("display","none");
                // getAll();
            }
        });
    }
}
function commentComment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#inputComment-" + commentId).val();
    var userId = $(".userId").val();
    var type = e.getAttribute("data-name");
    if(content == ''){
        layer.msg("回复内容不能为空哦~");
    }else {
        comment2target(commentId, type, userId, content);
        var noteId = e.getAttribute("data-index");
        console.log(noteId);
        var notice = new FormData();
        notice.append("noteId",noteId);
        $.ajax({
            url: "/rwx/notification/delete",
            async: false,
            type: "post",
            data: notice,
            contentType: false,
            processData: false,
            dataType: 'json',
            success: function (res) {
                console.log(res);

                $("#notices-" + noteId).css("display","none");
                // getAll();
            }
        });
    }
}

/**
 * 删除某个通知
 * @param e
 */
function deleteNote(e) {
    var noteId = e.getAttribute("data-id");
    var notice = new FormData();
    notice.append("noteId",noteId);
    $.ajax({
        url: "/rwx/notification/delete",
        async: false,
        type: "post",
        data: notice,
        contentType: false,
        processData: false,
        dataType: 'json',
        success: function (res) {
            console.log(res);

            $("#notices-" + noteId).css("display","none");
            // getAll();
        }
    });
}

/**
 * 标为已读
 * @param e
 */
function changeToRead(e) {
    var noteId = e.getAttribute("data-id");
    var notice = new FormData();
    notice.append("noteId",noteId);
    $.ajax({
        url: "/rwx/notification/upRead",
        async: false,
        type: "post",
        data: notice,
        contentType: false,
        processData: false,
        dataType: 'json',
        success: function (res) {
            console.log(res);

            $("#unRead-" + noteId).css("display","none");
            $("#changeRead-" + noteId).css("display","none");
            // getAll();
            unReadNum();
        }
    });
}

/**
 * 最新发表的分页跳转
 * @param e
 */
function toPageNewUpCompany(e) {
    var url = "/rwx/notification";
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
        var notice = new FormData();
        notice.append("page",page);
        notice.append("userId", $(".userId").val());
        $.ajax({
            url: askUrl,
            async: false,
            type: "post",
            data: notice,
            contentType: false,
            processData: false,
            dataType: 'json',
            success: function (res) {
                console.log(res);

                var data = {
                    "list": res
                };
                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });

                $(".totalNewUp").html(res.total_size);
                $(".currNewUp").html(res.current_page);
                $(".pageNumNewUp").html(res.total_page);
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
