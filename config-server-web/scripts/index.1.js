layui.use(['jquery', 'laydate', 'util', 'layer', 'table', 'form'], function ($, laydate, util, layer, table, form) {
    var table = layui.table;
    
    //监听左侧单元格编辑
    table.on('edit(left-profile)', function (obj) {
        obj.tr.find('[lay-event="edit"]').removeClass('layui-btn-disabled').removeAttr('disabled');
        var value = obj.value //得到修改后的值
            ,
            data = obj.data //得到所在行所有键值
            ,
            field = obj.field; //得到字段
        layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value);
    });
    
});

test = function(){
}