layui.use(['element','laytpl'], function() {
    var element = layui.element;
    var laytpl = layui.laytpl;

    $.ajax({
        url: "/rwx/album/getById",
        async: true,
        type: "post",
        data: JSON.stringify({
            albumId: sessionStorage.getItem("albumId"),
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function (res) {
            console.log(res);

            var data = {
                "list": res
            };
            var getAlbumTpl = albumDemo.innerHTML
                , albumView = document.getElementById('albumView');
            laytpl(getAlbumTpl).render(data, function (html) {
                albumView.innerHTML = html;
            });

            historyAdd(sessionStorage.getItem("albumId"),$(".userId").val(),res.album[0].albumtitle,res.album[0].pictureUrl);
        }
    });

});

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
            type: 4,
            typeName: typeName,
            imgUrl: imgUrl
        }),
        dataType: 'json',
        success: function(res){

        }
    })
}