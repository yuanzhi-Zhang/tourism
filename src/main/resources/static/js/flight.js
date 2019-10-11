$(function () {

    layui.use('element', function () {
        var element = layui.element;

        //…
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