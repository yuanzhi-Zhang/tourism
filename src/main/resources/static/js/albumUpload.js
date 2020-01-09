layui.use(['element','upload'], function() {
    var element = layui.element;
    var $ = layui.jquery
        , upload = layui.upload;
    //多图片上传
    upload.render({
        elem: '#test2'
        ,url: '/rwx/album/upload'
        ,multiple: true
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
            });
        }
        ,done: function(res){
            //上传完毕
        }
    });

    var imgUrl = [];
    //多文件列表示例
    var demoListView = $('#demoList')
        ,uploadListIns = upload.render({
        elem: '#testList'
        ,url: '/rwx/album/upload'
        ,accept: 'file'
        ,multiple: true
        ,auto: false
        ,bindAction: '#testListAction'
        ,choose: function(obj){
            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
            //读取本地文件
            obj.preview(function(index, file, result){
                /*var type = file.name.substring(file.name.indexOf(".")).toLowerCase();
                if(type==".png"&&type!=".gif"&&type!=".jpg"&&type!=".jpeg"){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td><img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img"></td>'
                        ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));
                }else if(type==".mp4"){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td><video src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img"></td>'
                        ,'<td>'+ (file.size/1014).toFixed(10) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));
                }else {
                    layer.alert("仅支持图片以及MP4格式的视频哦")
                }*/

                var tr = $(['<tr id="upload-'+ index +'">'
                    ,'<td><img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img"></td>'
                    ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                    ,'<td>等待上传</td>'
                    ,'<td>'
                    ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                    ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                    ,'</td>'
                    ,'</tr>'].join(''));
                //单个重传
                tr.find('.demo-reload').on('click', function(){
                    obj.upload(index, file);
                });

                //删除
                tr.find('.demo-delete').on('click', function(){
                    delete files[index]; //删除对应的文件
                    tr.remove();
                    uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                });

                demoListView.append(tr);
            });
        }
        ,done: function(res, index, upload){
            imgUrl.push(res.data.imgUrl);
            console.log(imgUrl);
            if(res.code == 0){ //上传成功
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                tds.eq(3).html(''); //清空操作
                return delete this.files[index]; //删除文件队列已经上传成功的文件
            }
            this.error(index, upload);
        }
        ,error: function(index, upload){
            var tr = demoListView.find('tr#upload-'+ index)
                ,tds = tr.children();
            tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
            tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
        }
    });

    $("#albumUp").click(function () {
        if($(".uid").val() == "0"){
            layer.msg("请先登录哦~");
            return;
        }
        if(imgUrl == null || imgUrl == ""){
            layer.msg("请先选择上传图片哦~");
            return;
        }
        if($("#albumInfo").val() == null || $("#albumInfo").val() == ""){
            layer.msg("相册的描述不可少的哦~");
            return;
        }
        if($("#albumTitle").val() == null || $("#albumTitle").val() == ""){
            layer.msg("相册的标题不可少的哦~");
            return;
        }
        $.ajax({
            url: "/rwx/album/upAlbum",
            type: "POST",
            data: JSON.stringify({
                userId: $(".uid").val(),
                imgUrl: imgUrl,
                albumInfo: $("#albumInfo").val(),
                albumTitle: $("#albumTitle").val()
            }),
            contentType: "application/json",
            dataType: 'json',
            async: false,
            success: function (res) {
                console.log(res);
                location.reload();
            }
        });
    })
});