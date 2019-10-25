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
            var allJourney = $(".own_journeys");
            $.ajax({
                url:"/rwx/own/journey",
                type:"POST",
                data:{
                    uid: $("#uid").val()
                },
                async:false,
                success:function (journeys) {
                    var data = { //数据
                        "list":journeys
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
            if($("#uid").val() != null && $("#uid").val() != ""){
                if($(".own_remain_message").val() != null && $(".own_remain_message").val() != ""){
                    $.ajax({
                        url:"/rwx/addRemain",
                        type:"POST",
                        contentType: 'application/json',
                        dataType: "json",
                        data:JSON.stringify({
                            remainReceiverId: $("#uid").val(),
                            remainSenderId: $("#uid").val(),
                            remainContent: $(".own_remain_message").val()
                        }),
                        async:false,
                        success:function (remains) {
                            $(".own_remain_message").val("");
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
                    layer.msg("留言不能为空哦 ~");
                }
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

    layui.use('upload',function () {
        //执行实例,更换背景图
        layui.upload.render({
            elem: '#changeBackPic' //绑定元素
            ,url: '/rwx/changeBackPic' //上传接口
            ,field:'projectImg'
            ,method: 'POST'
            ,data: {uid:$("#uid").val()}
            ,before: function(obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#own_backPic').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //上传完毕回调
                layer.msg("上传成功");
                $('#own_backPic').attr('src', res.imgUrl);
                // parent.location.reload();
            }
            ,error: function(res){
                //请求异常回调
                layer.msg("上传失败",{icon: 0});
                console.log(res);
            }
        });
        //更换个人头像
        layui.upload.render({
            elem: '#changeAvator' //绑定元素
            ,url: '/rwx/uploadImg' //上传接口
            ,field:'projectImg'
            ,method: 'POST'
            ,data: {uid:$("#uid").val()}
            ,before: function(obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('.self_img').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //上传完毕回调
                layer.msg("头像更换成功");
                $('.self_img').attr('src', res.imgUrl);
                $('.layui-nav-img').attr('src', res.imgUrl);
                // parent.location.reload();
            }
            ,error: function(res){
                //请求异常回调
                layer.msg("上传失败",{icon: 0});
                console.log(res);
            }
        });

    })

    //个人头像特效
    $(".self_img").mouseover(function () {
        $(".camera").css('display', 'block');
        $(".self_img").css('opacity', '0.7');
    })
    $(".self_img").mouseout(function () {
        $(".camera").css('display', 'none');
        $(".self_img").css('opacity', '1');
    })
    $(".camera").mouseover(function () {
        $(".camera").css('display', 'block');
        $(".self_img").css('opacity', '0.7');
    })
    $(".camera").mouseout(function () {
        $(".camera").css('display', 'none');
        $(".self_img").css('opacity', '1');
    })

    //个人简介按钮颜色变化以及点击事件
    $(".own_show_self").mouseover(function () {
        $(".own_show_self").addClass("layui-btn-warm");
        $(".own_show_self").css("color", "white");
    })
    $(".own_show_self").mouseout(function () {
        $(".own_show_self").removeClass("layui-btn-warm");
        $(".own_show_self").css("color", "black");
    })
    $(".own_show_self").click(function () {
        $(".own_show_self").css("display", "none");
        $(".own_self_edit").css("display", "block");
        $(".own_self_edit_save").css("display", "block");
    })
    $(".own_self_edit_save").mouseover(function () {
        $(".own_self_edit_save").addClass("layui-btn-warm");
        $(".own_self_edit_save").css("color", "white");
    })
    $(".own_self_edit_save").mouseout(function () {
        $(".own_self_edit_save").removeClass("layui-btn-warm");
        $(".own_self_edit_save").css("color", "black");
    })

    //添加或修改自我介绍
    $(".own_self_edit_save").click(function () {
        if($("#uid").val() != null && $("#uid").val() != "") {
            var oldSelfInfo = $("#selfHide").val();
            var selfInfo = $(".own_self_edit").val();
            if(selfInfo == null || selfInfo == ""){
                layer.msg("自我介绍不能为空哦~");
                return;
            }
            if(oldSelfInfo != selfInfo){
                var data = new FormData();
                data.append("id",$("#uid").val());
                data.append("selfInfo",selfInfo);
                $.ajax({
                    url: "/rwx/selfInfo",
                    type: "POST",
                    data: data,
                    async: false,
                    contentType: false,
                    processData: false,
                    success: function (text) {
                        if ("ok" == text) {
                            $(".own_show_self").val(selfInfo);
                            layer.msg("介绍成功");
                        }
                    }
                })
            }else {
                layer.msg("改动后才可以保存哦！")
            }
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
        $(".own_self_edit").css("display", "none");
        $(".own_show_self").css("display", "block");
        $(".own_self_edit_save").css("display", "none");
    })

    //我的关注按钮变化
    // $(".own_haveAttended").mouseover(function () {
    //     document.getElementsByClassName("own_haveAttended").value = "取消关注"
    // })
    // $(".own_haveAttended").mouseout(function () {
    //     document.getElementsByClassName("own_haveAttended").value = "已关注"
    // })
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

//根据出生日期计算年龄

function jsGetAge(strBirthday) {

    var returnAge;

    var strBirthdayArr = strBirthday.split("-");

    var birthYear = strBirthdayArr[0];

    var birthMonth = strBirthdayArr[1];

    var birthDay = strBirthdayArr[2];



    var d = new Date();

    var nowYear = d.getFullYear();

    var nowMonth = d.getMonth() + 1;

    var nowDay = d.getDate();



    if (nowYear == birthYear) {

        returnAge = 0;//同年 则为0岁  

    } else {

        var ageDiff = nowYear - birthYear; //年之差  

        if (ageDiff > 0) {

            if (nowMonth == birthMonth) {

                var dayDiff = nowDay - birthDay;//日之差  

                if (dayDiff < 0) {

                    returnAge = ageDiff - 1;

                } else {

                    returnAge = ageDiff;

                }

            } else {

                var monthDiff = nowMonth - birthMonth;//月之差  

                if (monthDiff < 0) {

                    returnAge = ageDiff - 1;

                } else {

                    returnAge = ageDiff;

                }

            }

        } else {

            returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天  

        }

    }



    return returnAge;//返回周岁年龄  

}