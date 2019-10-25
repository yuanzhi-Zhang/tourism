$(function () {

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

        if($("#uid").val() != null && $("#uid").val() != ""){
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
            })

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
            })
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
                        }
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
        "images/321079.jpg",
        "images/323266.jpg",
        "images/321999.jpg",
        "images/311403.jpg",
        "images/319967.jpg",
        "images/322058.jpg",
        "images/323256.jpg",
        "images/323572.jpg",
        "images/322746.jpg"
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
    })
    $(".own_notAttend").on('mouseover mouseout', function (e) {
        if (e.type === "mouseover") {
            this.value = "关注"
        } else if (e.type === "mouseout") {
            this.value = "未关注"
        }
    })

    //留言按钮变化
    $(".own_remain_message_save").mouseover(function () {
        $(".own_remain_message_save").addClass("layui-btn-warm");
        $(".own_remain_message_save").css("color", "white");
    })
    $(".own_remain_message_save").mouseout(function () {$
        $(".own_remain_message_save").removeClass("layui-btn-warm");
        $(".own_remain_message_save").css("color", "black");
    })

})

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
                }
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
                var data = { //数据
                    "list":remains
                }
                var getRemainTpl = remainDemo.innerHTML
                    ,remainView = document.getElementById('remainView');
                laytpl(getRemainTpl).render(data, function(html){
                    remainView.innerHTML = html;
                });
            }
        })
    })
}

//删除留言
function deleteRemain(e) {
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        var remainId = e.getAttribute("data-id");
        $.ajax({
            url:"/rwx/deleteRemain",
            type:"POST",
            data:{
                remainId: remainId,
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
        })
    })
}