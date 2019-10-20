$(function() {
    // 生成从minNum到maxNum的随机数
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

    // 随机生成背景图片以及随机改变背景图中的你知道么的颜色
    var backPic = ["images/321079.jpg", "images/323266.jpg",
        "images/321926.jpg", "images/322188.jpg", "images/319967.jpg",
        "images/322433.jpg", "images/323256.jpg", "images/323280.jpg",
        "images/322746.jpg"];
    var colorList = ["coral", "coral", "purple", "white", "white", "coral",
        "white", "blue", "coral"];
    var backPic_i = randomNum(0, 8);
    $("#login_back").attr("src", backPic[backPic_i]);
    $(".hope-word").css('color', colorList[backPic_i]);
    $(".register_jump a").css('color', colorList[backPic_i]);

    // 账号密码框的焦点变化
    // $("#accout").focus(function () {
    //     $("#accout").css('border', '1px coral solid');
    // })
    layui.use("form",function () {
        var form = layui.form;
        var $ = layui.$;

        form.on("submit(register)",function (data) {
            var inputCheckCode = $("#checkCode").val();
            if (inputCheckCode == checkCode){
                $.ajax({
                    url:"/rwx/regist",
                    type:"POST",
                    data:data.field,
                    async:false,
                    success:function (text) {
                        if ("ok" == text){
                            layer.alert("注册成功",function () {
//                                window.location.href = "/";
                            });
                        }else{
                            layer.alert("注册失败");
                        }
                    }
                });
            } else{
                layer.msg("验证码输入错误");
            }
            return false;
        });

        //验证码
        var checkCode = "";

        $("#sendCheckCode").click(function () {
            var email = $("#email").val();
            if (email == null || email == ""){
                layer.msg("请输入邮箱！！！");
                return;
            }
            var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
            if(!myReg.test(email)){
                layer.msg("邮箱格式不对！！！");
                return;
            }
            var index = layer.open({
                type:3,
                content:"邮件发送中..."
            });

            $.ajax({
                url:"/rwx/getCheckCode?email="+email,
                type:"get",
                success:function (text) {
                    if (text != null && text != ""){
                        layer.close(index);
                        layer.msg("已发送");
                        checkCode = text;
                        countDown();
                    } else{
                        layer.alert("获取失败，请重新获取")
                    }
                }
            });
        });

        var maxTime = 60;
        function countDown(){
            if (maxTime == 0){
                checkCode = "";
                $("#sendCheckCode").removeClass("layui-btn-disabled");
                $("#sendCheckCode").removeAttr("disabled")
                $("#sendCheckCode").html("获取验证码");
                maxTime = 60;
            }else{
                $("#sendCheckCode").attr("disabled","disabled");
                $("#sendCheckCode").addClass("layui-btn-disabled");
                form.render();
                $("#sendCheckCode").html(maxTime+"秒后重新获取");
                maxTime--;
                setTimeout(countDown,1000);
            }
        }

    });

})