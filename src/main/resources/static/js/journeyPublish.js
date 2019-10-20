function selectImg(){
    $("#selectJourneyImg").trigger("click");
}

function getImg(obj) {
    var reader = new FileReader();
    // 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
    reader.readAsDataURL(obj.files[0]);
    reader.addEventListener("load", function () {
        $('#uploadJourMainImg').attr('src', reader.result);
        $(".jourPub_upImg_mainImg span").html("更改游记头图");
    }, false);
}
layui.use(['element','layer','layedit','laydate','upload'], function () {
        var element = layui.element;
        var layer = layui.layer;
        var layedit = layui.layedit;
        var laydate = layui.laydate;
        var upload = layui.upload;

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
            // var title = $("#journeyTitle").val();
            journeyData.append('file', $('#selectJourneyImg')[0].files[0]); //上传文件
            journeyData.append('title', $("#journeyTitle").val());
            journeyData.append('startTime', $("#startTime").val());
            journeyData.append('daysNum', $("#daysNum").val());
            journeyData.append('people', $("#people").val());
            journeyData.append('money', $("#money").val());
            journeyData.append('uid', $("#uid").val());
            var content = layedit.getContent(index); //根据编号获取了编辑器的内容
            journeyData.append('content', content);
            // console.log(journeyData.get("file"));
            var ff = $("#selectJourneyImg").val();
            var type = ff.substring(ff.indexOf(".")).toLowerCase(); //截断"."之前的，得到后缀
            if(ff == null || ff == ""){
                layer.alert("请选择游记的正图",{icon:0});
                $("#selectJourneyImg").val("");
                return;
            } else if(type!=".png"&&type!=".gif"&&type!=".jpg"&&type!=".jpeg"){  //根据后缀，判断是否符合图片格式
                layer.alert("图片类型必须是.gif,jpeg,jpg,png中的一种",{icon:5});
                $("#selectJourneyImg").val("");
                return;
            }
            if($("#journeyTitle").val() == "" || content == ""){
                layer.alert("标题和内容也不可或缺哦！",{icon:0});
            }else {
                $.ajax({
                    url:"/rwx/addJourney",
                    type:"post",
                    data: journeyData,
                    contentType: false,
                    processData: false,
                    async:false,
                    success:function (res) {
                        if (res.success == 1){
                            layer.msg("游记发表成功!");
                            $('#selectJourneyImg').attr('src', res.imgUrl);
                            // window.location.href = "/rwx/self";
                        } else{
                            layer.alert("游记发表失败!")
                        }
                    }
                });
            }
        })
        // 常规用法
        laydate.render({
            elem: '#startTime'
            ,theme: 'molv'
        });
    });