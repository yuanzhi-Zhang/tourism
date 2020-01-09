layui.use(['element','carousel','laytpl','util'], function () {
    var element = layui.element;
    var carousel = layui.carousel;
    var laytpl = layui.laytpl;
    var util = layui.util;

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

    carousel.render({
        elem: '#askAnswerLunBo'
        ,width: '100%' //设置容器宽度
        ,height: '320px'
        ,anim: 'fade' //切换动画方式
        ,autoplay: true
        ,interval: 3000
        ,arrow: 'hover'
    });

    //查询问答
    $.ajax({
        url:"/rwx/askAnswer",
        type:"POST",
        processData: false,
        contentType: false,
        async:false,
        success:function (questions) {
            var data = { //数据
                "list":questions
            };
            var getTpl = askAnswer.innerHTML
                ,view = document.getElementById('view');
            laytpl(getTpl).render(data, function(html){
                view.innerHTML = html;
            });
        }
    });

});

//点击页面翻页
function toPage(e) {
    var page = e.getAttribute("data-id");
    var pages = new FormData();
    pages.append("page",page);
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        $.ajax({
            url:"/rwx/askAnswer",
            type:"POST",
            processData: false,
            contentType: false,
            data:pages,
            async:false,
            success:function (questions) {
                var data = { //数据
                    "list":questions
                };
                var getTpl = askAnswer.innerHTML
                    ,view = document.getElementById('view');
                laytpl(getTpl).render(data, function(html){
                    view.innerHTML = html;
                });
            }
        });
    })
}

/**
* 点击进入相应的问题详情页面
* */
function toDetail(e) {
    var questionId = e.getAttribute("data-id");
    window.location.href = "/rwx/qt/" + questionId;
}