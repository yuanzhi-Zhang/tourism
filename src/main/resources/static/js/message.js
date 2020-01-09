layui.use(['element','laytpl','util'], function () {
    var element = layui.element;
    var laytpl = layui.laytpl;
    var util = layui.util;

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

});