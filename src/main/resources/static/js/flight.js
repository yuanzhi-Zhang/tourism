$(function () {

    layui.use('element', function () {
        var element = layui.element;

        //…

        $("#header_destiny").removeClass("layui-this");
        $("#header_index").removeClass("layui-this");
        $("#header_strategy").removeClass("layui-this");
        $("#header_goHiking").removeClass("layui-this");
        $("#header_flight").addClass("layui-this");
        $("#header_hotel").removeClass("layui-this");
        $("#header_notification").removeClass("layui-this");
        $("#header_self").removeClass("layui-this");
        $("#header_company").removeClass("layui-this");
    });
    layui.use('laydate', function() {
        var laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#test1'
            ,theme: 'molv'
        });
        laydate.render({
            elem: '#test2'
            ,theme: 'molv'
        });
    })
})