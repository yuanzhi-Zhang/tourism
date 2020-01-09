layui.use(['element','carousel','util','layer','laytpl'], function(){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    var carousel = layui.carousel;
    var util = layui.util;
    var layer = layui.layer;
    var laytpl = layui.laytpl;

    $("#header_destiny").removeClass("layui-this");
    $("#header_index").removeClass("layui-this");
    $("#header_strategy").removeClass("layui-this");
    $("#header_goHiking").removeClass("layui-this");
    $("#header_flight").addClass("layui-this");
    $("#header_hotel").removeClass("layui-this");
    $("#header_notification").removeClass("layui-this");
    $("#header_self").removeClass("layui-this");
    $("#header_company").removeClass("layui-this");

    //固定块
    util.fixbar({
        bar1: true
        , bar2: true
        , css: {right: 50, bottom: 100}
        // , bgcolor: '#393D49'
        , click: function (type) {
            if (type === 'bar1') {
                layer.msg('icon是可以随便换的')
            } else if (type === 'bar2') {
                layer.msg('两个bar都可以设定是否开启')
            }
        }
    });

    var ins = carousel.render({
        elem: '#localTourLunBo'
        ,width: '100%'
        ,height: '580px'
        ,anim: 'fade' //切换动画方式
        ,autoplay: true
        ,interval: 3000
        ,arrow: 'hover'
    });

    $.ajax({
        url: "/rwx/turn",
        type: "POST",
        data: {
            turnType: 1
        },
        async:false,
        success:function (res) {
            console.log(res);

            var data = {
                "list": res
            };
            var getHotAdviceTpl = hotAdviceDemo.innerHTML
                , hotAdviceView = document.getElementById('hotAdviceView');
            laytpl(getHotAdviceTpl).render(data, function (html) {
                // hotAdviceView.innerHTML = html;
                $("#localTourLunBo").children("div").html(html);

                //下面这步很重要
                ins.reload({elem: '#localTourLunBo'});//重置轮播图
            });
        }
    });
    //监听导航点击
    element.on('nav(demo)', function(elem){
        //console.log(elem)
        layer.msg(elem.text());
    });
    unReadNum();
    getWithView();
});

/**
 * 获取所有景点
 */
function getWithView() {
    layui.use(['laytpl'], function () {
        var laytpl = layui.laytpl;

        $.ajax({
            url: "/rwx/scene/getAll",
            async: true,
            type: "post",
            contentType: "application/json",
            dataType: 'json',
            success: function (res) {
                console.log(res);

                for(var i=0; i<res.sceneList.length; i++){
                    res.sceneList[i].scenePics = res.sceneList[i].scenePics.split(",");
                }

                var data = {
                    "list": res
                };
                var getAlbumTpl = albumDemo.innerHTML
                    , albumView = document.getElementById('albumView');
                laytpl(getAlbumTpl).render(data, function (html) {
                    albumView.innerHTML = html;
                });

                $(".total").html(res.total_size);
                $(".curr").html(1);
                $(".pageNum").html(res.total_page);

            }
        })
    })
}

/**
 * 景点分页
 * @param e
 */
function toPageAlbum(e){
    var page = e.getAttribute("data-id");
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        var strategy = new FormData();
        strategy.append("page",page);
        strategy.append("size",16);
        $.ajax({
            url: "/rwx/scene/getAll",
            type: "POST",
            contentType: false,
            processData: false,
            data: strategy,
            async:false,
            success:function (res) {
                console.log(res);
                for(var i=0; i<res.sceneList.length; i++){
                    res.sceneList[i].scenePics = res.sceneList[i].scenePics.split(",");
                }

                var data = {
                    "list": res
                };
                var getAlbumTpl = albumDemo.innerHTML
                    , albumView = document.getElementById('albumView');
                laytpl(getAlbumTpl).render(data, function (html) {
                    albumView.innerHTML = html;
                });

                $(".total").html(res.total_size);
                $(".curr").html(page);
                $(".pageNum").html(res.total_page);
            }
        });
    })
}

/**
 * 未读通知
 */
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
 * 跳转到景点详情页面
 * @param e
 * @returns {boolean}
 */
/*function toAlbumDetail(e) {
    var sceneId = e.getAttribute("data-id");
    sessionStorage.setItem("sceneId",sceneId);
    var star=getCookieById("sceneId",sceneId);
    if(star==""){
        addCookieById("albumId",sceneId,2);
    }else{
        window.location.href = "/rwx/album/" + sceneId+ ".html";
        return false;
    }
    $.ajax({
        url: "/rwx/album/incView",
        async: false,
        type: "post",
        data: JSON.stringify({
            albumId: albumId
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function(res){
            console.log(res);
            window.location.href = "/rwx/album/" + albumId+ ".html";
        }
    })
}*/
function toScene(e) {
    var sid = e.getAttribute("data-id");
    sessionStorage.setItem("sceneId",sid);
    window.location.href = "/rwx/scene/" + sid + ".html";
}

/**
 * 时间格式转换
 * @param date
 * @returns {string}
 */
function resolvingDate(date){
//date是传入的时间
    var d = new Date(date);

    var month = (d.getMonth() + 1) < 10 ? '0'+(d.getMonth() + 1) : (d.getMonth() + 1);
    var day = d.getDate()<10 ? '0'+d.getDate() : d.getDate();
    var hours = d.getHours()<10 ? '0'+d.getHours() : d.getHours();
    var min = d.getMinutes()<10 ? '0'+d.getMinutes() : d.getMinutes();
    var sec = d.getSeconds()<10 ? '0'+d.getSeconds() : d.getSeconds();

    var times=d.getFullYear() + '-' + month + '-' + day;

    return times
}

/**
 * 获取特定cookie的值
 * @param    cookie键
 * @return   cookie该键对应的值
 * */
function getCookie(cname){
    var name=cname+"=";
    var ca=document.cookie.split(';');
    for(var i=0;i<ca.length;i++){
        var c=ca[i].trim();
        if(c.indexOf(name)==0)
            return c.substring(name.length,c.length);
    }
    return "";
}

/**
 * 判断cookie键中是否有某个资源的id
 * @param    cookie键
 * @param    查询资源id
 * @return   存在返回true，否则返回""
 * */
function getCookieById(cname,id){
    var name=cname+"=";
    var ca=document.cookie.split(';');
    var cValue="";
    for(var i=0;i<ca.length;i++){
        var c=ca[i].trim();
        if(c.indexOf(name)==0)
            cValue=c.substring(name.length,c.length);
    }
    if(cValue!=""){
        var cArray=cValue.split(",");
        for(var i=0;i<cArray.length;i++){
            var c=cArray[i].trim();
            if(c.indexOf(id)==0){
                return true;
            }
        }
    }
    return "";
}


/**
 * 添加某个资源id到cookie键中
 * @param    cookie键名
 * @param    资源id
 * @param    cookie过期时间
 * */
function addCookieById(cname,id,exdays){
    var cvalue=getCookie(cname);
    if(cvalue==""){
        cvalue=id;
    }else {
        var cArray=cvalue.split(",");
        var flag=0;
        for(var i=0;i<cArray.length;i++){
            var c=cArray[i].trim();
            if(c.indexOf(id)==0){
                flag=1;
                break;
            }
        }
        if(flag==0) {
            cvalue += "," + id;
        }
    }

    var d=new Date();
    d.setTime(d.getTime()+(exdays*60*60*1000));
    var expires="expires="+d.toGMTString();
    document.cookie=cname+"="+cvalue+"; "+expires;
}