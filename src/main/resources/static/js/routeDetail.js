layui.use('element', function() {
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

    //监听导航点击
    element.on('nav(demo)', function (elem) {
        //console.log(elem)
        layer.msg(elem.text());
    });

    unReadNum();

    //焦点图效果
    //点击图片切换图片
    $('.little_img').on('mousemove', function() {
        $('.little_img').removeClass('cur_img');
        var big_pic = $(this).data('bigpic');
        $('.big_img').attr('src', big_pic);
        $(this).addClass('cur_img');
    });
    //上下切换
    var picindex = 0;
    var nextindex = 4;
    $('.down_img').on('click',function(){
        var num = $('.little_img').length;
        if((nextindex + 1) <= num){
            $('.little_img:eq('+picindex+')').hide();
            $('.little_img:eq('+nextindex+')').show();
            picindex = picindex + 1;
            nextindex = nextindex + 1;
        }
    });
    $('.up_img').on('click',function(){
        var num = $('.little_img').length;
        if(picindex > 0){
            $('.little_img:eq('+(nextindex-1)+')').hide();
            $('.little_img:eq('+(picindex-1)+')').show();
            picindex = picindex - 1;
            nextindex = nextindex - 1;
        }
    });
    //自动播放
    setInterval("auto_play()", 3000);

    $.ajax({
        url: "/rwx/scene/getOneDetail",
        async: true,
        type: "post",
        data: JSON.stringify({
            sceneId: sessionStorage.getItem("sceneId"),
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function (res) {
            console.log(res);
            res.scene[0].scenePics = res.scene[0].scenePics.split(",");
            /*var data = {
                "list": res
            };
            var getAlbumTpl = albumDemo.innerHTML
                , albumView = document.getElementById('albumView');
            laytpl(getAlbumTpl).render(data, function (html) {
                albumView.innerHTML = html;
            });*/

            historyAdd(res.scene.sceneId,$(".userId").val(),res.scene.sceneName,res.scene.scenePics[0]);
        }
    });
});
//自动轮播方法
function auto_play() {
    var cur_index = $('.prosum_left dd').find('a.cur_img').index();
    cur_index = cur_index - 1;
    var num = $('.little_img').length;
    var max_index = 3;
    if ((num - 1) < 3) {
        max_index = num - 1;
    }
    if (cur_index < max_index) {
        var next_index = cur_index + 1;
        var big_pic = $('.little_img:eq(' + next_index + ')').data('bigpic');
        $('.little_img').removeClass('cur_img');
        $('.little_img:eq(' + next_index + ')').addClass('cur_img');
        $('.big_img').attr('src', big_pic);
    } else {
        var big_pic = $('.little_img:eq(0)').data('bigpic');
        $('.little_img').removeClass('cur_img');
        $('.little_img:eq(0)').addClass('cur_img');
        $('.big_img').attr('src', big_pic);
    }
}

function unReadNum() {
    var notice = new FormData();
    notice.append("userId",$(".userId").val());
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

/**
 * 添加历史记录
 * @param companyId
 * @param userId
 */
function historyAdd(companyId,userId,typeName,imgUrl) {
    $.ajax({
        url: "/rwx/history/incTimes",
        async: true,
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            typeId: companyId,
            userId: userId,
            type: 5,
            typeName: typeName,
            imgUrl: imgUrl
        }),
        dataType: 'json',
        success: function(res){

        }
    })
}
