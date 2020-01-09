function selectImg(){
    $("#selectJourneyImg").trigger("click");
}
function getImg(obj) {
    var reader = new FileReader();
    // 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
    reader.readAsDataURL(obj.files[0]);
    $(".file").html($('#selectJourneyImg')[0].files[0].name);
}
layui.use(['element', 'layer','util','layedit','upload'], function () {
    var element = layui.element;
    var layer = layui.layer;
    var util = layui.util;
    var layedit = layui.layedit;
    var upload = layui.upload;
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

    var count = 0;
    $(".btn-interest").click(function () {
        if(count%2==0){
            this.classList.add("on");
        }
        else{
            this.classList.remove("on");
        }
        count=count+1;
    });

    //建立编辑器  // 编号，该编辑器的编号。
    var index = layedit.build('qt-content',{
        height: 180  //设置编辑器高度
        ,tool: [
            ,'face' //表情
        ]
    });

    $("._j_publish").click(function () {
        var userId = $("#uid").val();
        var qtData = new FormData();
        var content = layedit.getContent(index);
        var title = $("._j_title").val();
        var destiny = $("#homecity_name").val();
        if(title === "" || $('#selectJourneyImg')[0].files[0] === ""){
            layer.msg("标题和封面是必不可缺的哦~");
        }else {
            qtData.append("questionCreatorId",userId);
            qtData.append("questionContent",content);
            qtData.append("questionTitle",title);
            qtData.append("questionDestiny",destiny);
            qtData.append("questionImg",$('#selectJourneyImg')[0].files[0]);
            $.ajax({
                url:"/rwx/addQuestion",
                type:"post",
                data:qtData,
                contentType: false,
                processData: false,
                async:false,
                success:function (res) {
                    if (res.success == 1){
                        layer.msg("问题发表成功!");
                    } else{
                        layer.alert("问题发表失败!")
                    }
                }
            });
        }
    });
});