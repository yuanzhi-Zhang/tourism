$(function () {

    layui.use(['element', 'layer'], function () {
        var element = layui.element;
        layer = layui.layer

        //…
        //获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
        var layid = location.hash.replace(/^#test1=/, '');
        element.tabChange('test1', layid); //假设当前地址为：http://a.com#test1=222，那么选项卡会自动切换到“发送消息”这一项

        //监听Tab切换，以改变地址hash值
        element.on('tab(test1)', function () {
            location.hash = 'test1=' + this.getAttribute('lay-id');
        });
    });

    layui.use('layedit', function () {
        var layedit = layui.layedit;
//上传图片,必须放在 创建一个编辑器前面
        layedit.set({
            uploadImage: {
                url: '/rwx/upload' //接口url
                ,type: 'post' //默认post
            }
        });
        //建立编辑器  // 编号，该编辑器的编号。
        var index = layedit.build('content',{
            height: 400  //设置编辑器高度
        });
        $("#publishJour").click(function () {
            var content = layedit.getContent(index); //根据编号获取了编辑器的内容
            if (title == '' || content == '') {
                layer.alert('亲!请将信息补充完整哦!', { icon: 7 })
            } else {
                layer.open({
                    type: 3,
                    content: "游记发表中..."
                })
                $.ajax({
                    url:"/rwx/getCheckCode?title="+title+"&content="+content,
                    type:"post",
                    processData: false,
                    success:function (text) {
                        if (text != null && text != ""){
                            layer.close(index);
                            layer.msg("游记发表成功!");
                            window.location.href = "";
                        } else{
                            layer.alert("获取失败，请重新获取")
                        }
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
        //执行实例
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
    $(".own_self_edit_save").click(function () {
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

    // $(".own_operate img").mouseover(function () {
    //     $(".own_operate ")
    // })

})