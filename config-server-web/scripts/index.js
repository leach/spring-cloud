layui.use(['jquery', 'laydate', 'util', 'layer', 'table', 'form'], function ($, laydate, util, layer, table, form) {
    var table = layui.table;
    //处理profile数据-start
    var renderProfile = function (data) {
        $.get({
            url: 'http://localhost:8080/props/profile/list',
            data: data,
            success: function (data) {
                var parse = baseUtil.parsedata(data);
                var profileConfig = {
                    elem: '#profileTable',
                    height: 500,
                    limit: 10,
                    page: false,
                    cols: [
                        [{
                                field: 'id',
                                title: 'ID',
                                width: 40,
                                sort: true,
                                align: 'center',
                                fixed: 'left'
                            },
                            {
                                field: 'project',
                                title: '项目',
                                width: 180,
                                edit: 'text'
                            },
                            {
                                field: 'name',
                                title: '环境',
                                width: 120,
                                edit: 'text'
                            },
                            {
                                field: 'remark',
                                title: '备注',
                                width: 120,
                                edit: 'text'
                            },
                            {
                                fixed: 'right',
                                title: '操作',
                                toolbar: '#leftRowToolbar'
                            },
                        ]
                    ],
                    data: parse.data,
                    page: true,
                    limits: [5, 7, 10],
                    done: test
                }
                table.render(profileConfig);
            }
        });
    }
    renderProfile();
    // 新增一条记录
    $('#createNew').click(function () {
        var tableId = 'profileTable';
        var datas = table.cache[tableId];
        datas.push({
            id: -1
        });
        table.reload(tableId, {
            data: datas
        });
    });
    //监听行工具事件
    table.on('tool(profileTableFilter)', function (obj) {
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
        } else if (obj.event === 'save') {
            //保存记录
            baseUtil.postJson($, api.url.saveprofile, data, function (res) {
                if (res.data) {
                    layer.msg('保存成功');
                    var tableId = 'profileTable';
                    var datas = table.cache[tableId];
                    var lastData = datas.pop();
                    lastData.id = res.data.id;
                    datas.push(lastData);
                    profileTable = table.reload(tableId, {
                        data: datas
                    });
                }
            });
        }
    });
    //搜索框
    var active = {
        reload: function () {
            var leftTableReload = $('#leftTableReload');
            var project = leftTableReload.val();
            //执行重载
            renderProfile({
                project: project
            });

        }
    };
    $('.leftTableToolbar .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    //处理profile数据-end
});

test = function () {
    //debugger;
}