layui.use('table', function () {
    var $ = layui.$;
    var table = layui.table;
    //搜索
    var active = {
        reload: function () {
            var leftTableReload = $('#leftTableReload');
            var project = leftTableReload.val();
            //执行重载
            table.reload('profileTable', {
                where: {
                    project: project
                }
            });
        }
    };
    $('.leftTableSearch .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
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

    //监听行工具事件
    table.on('tool(left-profile)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'copy') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.prompt({
                formType: 2,
                value: data.email
            }, function (value, index) {
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });
});