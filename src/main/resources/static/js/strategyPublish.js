function selectImg1(){
    $("#selectJourneyImg1").trigger("click");
}
function selectImg2(){
    $("#selectJourneyImg2").trigger("click");
}
function selectImg3(){
    $("#selectJourneyImg3").trigger("click");
}

function getImg1(obj) {
    var reader = new FileReader();
    // 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
    reader.readAsDataURL(obj.files[0]);
    reader.addEventListener("load", function () {
        $('#uploadJourMainImg1').attr('src', reader.result);
        $("#strategyPub_upImg_mainImg1 span").html("更改攻略头图");
    }, false);
}
function getImg2(obj) {
    var reader = new FileReader();
    // 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
    reader.readAsDataURL(obj.files[0]);
    reader.addEventListener("load", function () {
        $('#uploadJourMainImg2').attr('src', reader.result);
        $("#strategyPub_upImg_mainImg2 span").html("更改攻略头图");
    }, false);
}
function getImg3(obj) {
    var reader = new FileReader();
    // 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
    reader.readAsDataURL(obj.files[0]);
    reader.addEventListener("load", function () {
        $('#uploadJourMainImg3').attr('src', reader.result);
        $("#strategyPub_upImg_mainImg3 span").html("更改攻略头图");
    }, false);
}
layui.use(['element','layer','layedit','laydate','upload'], function () {
    var element = layui.element;
    var layer = layui.layer;
    var layedit = layui.layedit;
    var laydate = layui.laydate;
    var upload = layui.upload;

    $("#header_destiny").removeClass("layui-this");
    $("#header_index").removeClass("layui-this");
    $("#header_strategy").removeClass("layui-this");
    $("#header_goHiking").removeClass("layui-this");
    $("#header_flight").removeClass("layui-this");
    $("#header_hotel").removeClass("layui-this");
    $("#header_notification").removeClass("layui-this");
    $("#header_self").removeClass("layui-this");
    $("#header_company").removeClass("layui-this");

    //上传图片,必须放在 创建一个编辑器前面
    layedit.set({
        uploadImage: {
            url: '/rwx/editImg' //接口url
            ,type: 'post' //默认post
        }
    });
    //执行实例
    if($("#uid").val() == "" || $("#uid").val() ==null){
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
    //建立编辑器  // 编号，该编辑器的编号。
    var index = layedit.build('journeyPub_content',{
        height: 340  //设置编辑器高度
    });
    $("#publishJour").click(function () {
        var journeyData = new FormData();
        journeyData.append('file1', $('#selectJourneyImg1')[0].files[0]); //上传文件
        journeyData.append('file2', $('#selectJourneyImg2')[0].files[0]); //上传文件
        journeyData.append('file3', $('#selectJourneyImg3')[0].files[0]); //上传文件
        journeyData.append('title', $("#journeyTitle").val());
        journeyData.append('strategy_info', $(".strategy_info").val());
        journeyData.append('uid', $("#uid").val());
        var content = layedit.getContent(index); //根据编号获取了编辑器的内容
        journeyData.append('content', content);
        var ff1 = $("#selectJourneyImg1").val();
        var ff2 = $("#selectJourneyImg2").val();
        var ff3 = $("#selectJourneyImg3").val();
        var type = ff1.substring(ff1.indexOf(".")).toLowerCase(); //截断"."之前的，得到后缀
        if(ff1 == null || ff1 == ""){
            layer.alert("请选择攻略的正图",{icon:0});
            $("#selectJourneyImg").val("");
            return;
        } else if(type!=".png"&&type!=".gif"&&type!=".jpg"&&type!=".jpeg"){  //根据后缀，判断是否符合图片格式
            layer.alert("图片类型必须是.gif,jpeg,jpg,png中的一种",{icon:5});
            $("#selectJourneyImg").val("");
            return;
        }
        if(getBytes(content) > 20000){
            layer.alert("内容太长啦！",{icon:0});
            return;
        }
        if($("#journeyTitle").val() == "" || content == ""){
            layer.alert("标题和内容也不可或缺哦！",{icon:0});
        }else {
            $.ajax({
                url:"/rwx/strategy/add",
                type:"post",
                data: journeyData,
                contentType: false,
                processData: false,
                async:false,
                success:function (res) {
                    if (res.success == 1){
                        layer.msg("攻略发表成功!");
                        /*$('#selectJourneyImg1').attr('src', res.imgUrl1);
                        $(".strategy_info").val() == '';
                        $("#journeyTitle").val() == "";
                        layedit.getContent(index) == '';*/
                        location.refresh();
                        // window.location.href = "/rwx/self";
                    } else{
                        layer.alert("攻略发表失败!")
                    }
                }
            });
        }
    })

    unReadNum();
});

function getBytes(str) {
    var byteLen = 0;
    for ( var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) > 255) {
            byteLen += 2;
        } else {
            byteLen += 1;
        }
    }
    return byteLen;
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