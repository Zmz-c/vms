layui.use('table', function(obj){
    const table = layui.table;
    table.render({
        elem: '#zylist'
        ,height:800
        ,url: '/readVmsug'
        ,toolbar: 'default'
        ,editTrigger: 'dblclick'
        ,response: {
            code:0,
            dataName: 'data'
        }
        ,cols: [
            [
                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'vmname', title: '活动发起人', width:100, edit: 'text'}
                ,{field: 'vmt', title: '活动内容', width:200,edit: 'text',event: 'setSign'}
                ,{field: 'vmAdders', title: '活动地址', width:300, edit: 'text'}
                ,{field: 'vmN', title: '活动名称', width:300, edit: 'text'}
                ,{field: 'isvm', title: '所属项目组', width:100, edit: 'text'}
                ,{field: 'isuser', title: '项目组成员', width:100, edit: 'text'}
            ]
        ]
    });

    table.on('tool(vmlist)', function(obj){
        var data = obj.data;
        if(obj.event === 'setSign'){
            layer.prompt({
                formType: 2
                ,title: '修改内容'
                ,value: data.vmt
            }, function(value, index){
                layer.close(index);
                $.ajax({
                    url: "/editZYtext",
                    data: {
                        'id': data.id,
                        'vmt':value
                    },
                    type: 'post',
                    dataType: "json",
                    success: function (data) {
                        layer.msg(data.msg);
                    },
                });
                obj.update({
                    vmt: value
                });
            });
        }
    });




});