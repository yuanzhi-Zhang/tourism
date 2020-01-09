$(function () {
    layui.use('element', function () {
        var element = layui.element;

        //…
    });
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#uploadImg' //绑定元素
            ,url: '/rwx/uploadImg' //上传接口
            ,field:'projectImg'
            ,method: 'POST'
            ,data: {uid:$("#uid").val()}
            ,before: function(obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#imgShow').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //上传完毕回调
                layer.msg("上传成功",{icon: 1});
                console.log(res);
                $('#imgShow').attr('src', res.imgUrl);
                parent.location.reload();
            }
            ,error: function(res){
                //请求异常回调
                layer.msg("上传失败",{icon: 0});
                console.log(res);
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    });
    //让导航栏的input失去底部条
    $(".search").mouseover(function () {
        $(".search").style.color = "black";
    })

    layui.use('form', function(){
        var form = layui.form;
        var $ = layui.$;

        //监听提交
        //设置页面的我的信息的修改提交
        form.on('submit(formDemo)', function(data){
            $.ajax({
                url:"/rwx/userInfo",
                type:"POST",
                contentType:"application/json;charset=UTF-8",
                data:JSON.stringify(data.field),
                async:false,
                success:function (text) {
                    console.log(text);
                    if ("ok" == text){
                        layer.alert("修改成功",function () {
                            location.reload();
                        });
                    }else{
                        layer.alert("修改失败");
                    }
                }
            });
            return false;
        });

        //设置页面的密码的修改提交
        form.on('submit(modifyPwd)', function(data){
            $.ajax({
                url:"/rwx/modifyPwd",
                type:"POST",
                contentType:"application/json",
                data:JSON.stringify(data.field),
                async:false,
                success:function (text) {
                    console.log(text);
                    if ("ok" == text){
                        layer.alert("修改密码成功",function () {
                            location.reload();
                        });
                    }else if("error" == text){
                        layer.alert("原密码错误,请重新输入");
                    }else if("differentError" == text) {
                        layer.alert("前后两次密码不一致");
                    }else {
                        layer.alert("修改密码失败");
                    }
                }
            });
            return false;
        });
    });

    layui.use('laydate', function() {
        var laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#ownBirth'
            ,theme: 'molv'
        });
    });

    unReadNum();
});

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

