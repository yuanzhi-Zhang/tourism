layui.use(['element','layer','laytpl','laypage','util'], function () {
    var element = layui.element;
    var layer = layui.layer;
    var laytpl = layui.laytpl;
    var laypage = layui.laypage;
    var util = layui.util;
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
    $("#header_destiny").removeClass("layui-this");
    $("#header_index").removeClass("layui-this");
    $("#header_strategy").removeClass("layui-this");
    $("#header_goHiking").removeClass("layui-this");
    $("#header_flight").removeClass("layui-this");
    $("#header_hotel").removeClass("layui-this");
    $("#header_notification").removeClass("layui-this");
    $("#header_self").removeClass("layui-this");
    $("#header_company").removeClass("layui-this");

    var layid = location.hash.replace(/^#type=/, '');
    element.tabChange('type', layid); //假设当前地址为：http://a.com#test1=222，那么选项卡会自动切换到“发送消息”这一项

    //监听Tab切换，以改变地址hash值
    element.on('tab(type)', function () {
        location.hash = 'type=' + this.getAttribute('lay-id') + '&value=' + sessionStorage.getItem("searchContent");
    });

    $.ajax({
        url:"/rwx/search/select",
        type:"POST",
        contentType:"application/json;charset=UTF-8",
        data: JSON.stringify({
            userId: $(".userId").val(),
            content: sessionStorage.getItem("searchContent")
        }),
        async:false,
        success:function (res) {
            console.log(res);
            for (var i=0; i<res.companyList.length; i++){
                res.companyList[i].companyStartTime = resolvingDate(res.companyList[i].companyStartTime);
            }
            for (var i=0; i<res.strategyList.length; i++){
                res.strategyList[i].publishTime = resolvingDate(res.strategyList[i].publishTime);
            }

            var data = { //数据
                "list":res
            };
            var getJourneyTpl = journeyDemo.innerHTML
                ,journeyView = document.getElementById('journeyView');
            laytpl(getJourneyTpl).render(data, function(html){
                journeyView.innerHTML = html;
            });

            var getStrategyTpl = strategyDemo.innerHTML
                ,strategyView = document.getElementById('strategyView');
            laytpl(getStrategyTpl).render(data, function(html){
                strategyView.innerHTML = html;
            });

            var getCompanyTpl = companyDemo.innerHTML
                ,companyView = document.getElementById('companyView');
            laytpl(getCompanyTpl).render(data, function(html){
                companyView.innerHTML = html;
            });
        }
    });

    unReadNum();
});

function search() {
    layui.use(['element','layer','laytpl'], function () {
        var element = layui.element;
        var layer = layui.layer;
        var laytpl = layui.laytpl;
        if ($("#search_content").val() == '') {
            layer.msg("请不要输入空内容哦~");
            return;
        }
        $.ajax({
            url: "/rwx/search/select",
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({
                userId: $(".userId").val(),
                content: $("#search_content").val()
            }),
            async: false,
            success: function (res) {
                console.log(res);
                $("#search_content").val("");

                for (var i = 0; i < res.companyList.length; i++) {
                    res.companyList[i].companyStartTime = resolvingDate(res.companyList[i].companyStartTime);
                }
                for (var i = 0; i < res.strategyList.length; i++) {
                    res.strategyList[i].publishTime = resolvingDate(res.strategyList[i].publishTime);
                }

                var data = { //数据
                    "list": res
                };
                var getJourneyTpl = journeyDemo.innerHTML
                    , journeyView = document.getElementById('journeyView');
                laytpl(getJourneyTpl).render(data, function (html) {
                    journeyView.innerHTML = html;
                });

                var getStrategyTpl = strategyDemo.innerHTML
                    , strategyView = document.getElementById('strategyView');
                laytpl(getStrategyTpl).render(data, function (html) {
                    strategyView.innerHTML = html;
                });

                var getCompanyTpl = companyDemo.innerHTML
                    , companyView = document.getElementById('companyView');
                laytpl(getCompanyTpl).render(data, function (html) {
                    companyView.innerHTML = html;
                });
            }
        });
    })
}

/**
 * 跳转到结伴详情（两小时之内阅读数随之加一）
 * @param e
 * @returns {boolean}
 */
function toCompanyDetail(e) {
    var companyId = e.getAttribute("data-id");
    sessionStorage.setItem("companyId",companyId);
    console.log(companyId);
    var star=getCookieById("companyId",companyId);
    if(star==""){
        addCookieById("companyId",companyId,2);
    }else{
        window.location.href = "/rwx/company/" + companyId+ ".html";
        return false;
    }
    $.ajax({
        url: "/rwx/company/incView",
        async: false,
        type: "post",
        data: JSON.stringify({
            companyId: companyId
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function(res){
            console.log(res);
            window.location.href = "/rwx/company/" + companyId+ ".html";
        }
    })
}

/**
 * 进入对应的某篇攻略页面
 * @param e
 * @returns {boolean}
 */
function toStrategyDetail(e) {
    var strategyId = e.getAttribute("data-id");
    sessionStorage.setItem("strategyId",strategyId);
    var star=getCookieById("strategyId",strategyId);
    if(star==""){
        addCookieById("strategyId",strategyId,2);
    }else{
        window.location.href = "/rwx/strategy/" + strategyId+ ".html";
        return false;
    }
    $.ajax({
        url: "/rwx/strategy/incView",
        async: false,
        type: "post",
        data: JSON.stringify({
            strategyId: strategyId
        }),
        contentType: "application/json",
        dataType: 'json',
        success: function(data){
            window.location.href = "/rwx/strategy/" + strategyId+ ".html";
        }
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
    /*var hours = d.getHours()<10 ? '0'+d.getHours() : d.getHours();
    var min = d.getMinutes()<10 ? '0'+d.getMinutes() : d.getMinutes();
    var sec = d.getSeconds()<10 ? '0'+d.getSeconds() : d.getSeconds();*/

    var times=d.getFullYear() + '-' + month + '-' + day;

    return times
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
    /*var hours = d.getHours()<10 ? '0'+d.getHours() : d.getHours();
    var min = d.getMinutes()<10 ? '0'+d.getMinutes() : d.getMinutes();
    var sec = d.getSeconds()<10 ? '0'+d.getSeconds() : d.getSeconds();*/

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