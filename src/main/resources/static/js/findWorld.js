layui.use(['element','util'], function() {
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    var util = layui.util;

    //固定块
    util.fixbar({

    });
    getWithView();
});

function getWithView() {
    layui.use(['laytpl'], function () {
        var laytpl = layui.laytpl;

        $.ajax({
            url: "/rwx/album/getWithView",
            async: true,
            type: "post",
            contentType: "application/json",
            dataType: 'json',
            success: function (res) {
                console.log(res);
                for(var i=0; i<res.albumList.length; i++){
                    res.albumList[i].publishtime = resolvingDate(res.albumList[i].publishtime);
                }

                var data = {
                    "list": res
                };
                var getAlbumTpl = albumDemo.innerHTML
                    , albumView = document.getElementById('albumView');
                laytpl(getAlbumTpl).render(data, function (html) {
                    albumView.innerHTML = html;
                });

            }
        })
    })
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