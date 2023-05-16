layui.use(['element', 'layer', 'util'], function(){
    const element = layui.element
    , layer = layui.layer, util = layui.util
    , $ = layui.$;

    //头部事件
    util.event('lay-header-event', {
    //左侧菜单事件
    menuLeft: function(othis){
    layer.msg('展开左侧菜单的操作', {icon: 0});
}
    ,menuRight: function(){
    layer.open({
    type: 1
    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
    ,area: ['260px', '100%']
    ,offset: 'rt' //右上角
    ,anim: 5
    ,shadeClose: true
});
}
});

});
    //新闻
    layui.use('table', function(){
    const table = layui.table;
    table.render({
    elem: '#News'
    ,height:800
    ,url: '/readNews'
    ,toolbar: 'default'
    ,editTrigger: 'dblclick'
    ,response: {
    code:0,
    dataName: 'data'
}
    ,cols: [
    [
{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
    ,{field: 'newAuthor', title: '作者', width:100, edit: 'text'}
    ,{field: 'newTitle', title: '标题', width:200,edit: 'text'}
    ,{field: 'newText', title: '新闻内容', width:700, edit: 'text',event: 'setSign'}
    ,{title: '操作', width: 200, templet: '#toolEvent'}
    ]
    ]
});

    table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    layer.msg('ID：'+ data.id + ' 的查看操作');
} else if(obj.event === 'del'){
    layer.confirm('真的删除行么', function(index){
    obj.del();
    $.ajax({
    url:"/delNews",
    data : {
    'id' : data.id
},
    type:'post',
    dataType : "json",
    success : function(data) {
    console.log(data);
    layer.msg(data.msg);
    location.reload(); //删除成功后再刷新
},
});
    layer.close(index);

});
}
    if(obj.event === 'setSign'){
    layer.prompt({
    formType: 2
    ,title: '修改文章'
    ,value: data.newText
}, function(value, index){
    layer.close(index);
    $.ajax({
    url: "/editNews",
    data: {
    'id': data.id,
    'newText':value
},
    type: 'post',
    dataType: "json",
    success: function (data) {
    layer.msg(data.msg);
},
});
    obj.update({
    newText: value
});
});
}

});

});
    //通知公告
    layui.use('table', function(){
    const table = layui.table;
    table.render({
    elem: '#tz'
    ,height:800
    ,url: '/readtz'
    ,toolbar: 'default'
    ,editTrigger: 'dblclick'
    ,response: {
    code:0,
    dataName: 'data'
}
    ,cols: [
    [
{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
    ,{field: 'tzAuthor', title: '作者', width:100, edit: 'text'}
    ,{field: 'tzTitle', title: '标题', width:200,edit: 'text'}
    ,{field: 'tzText', title: '通告内容', width:700, edit: 'text',event: 'setSign'}
    ,{title: '操作', width: 200, templet: '#toolEvent1'}
    ]
    ]
});

    table.on('tool(ts1)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    layer.msg('ID：'+ data.id + ' 的查看操作');
} else if(obj.event === 'del'){
    layer.confirm('真的删除行么', function(index){
    obj.del();
    $.ajax({
    url:"/deltz",
    data : {
    'id' : data.id
},
    type:'post',
    dataType : "json",
    success : function(data) {
    console.log(data);
    layer.msg(data.msg);
    location.reload(); //删除成功后再刷新
},
});
    layer.close(index);

});
}
    if(obj.event === 'setSign'){
    layer.prompt({
    formType: 2
    ,title: '修改通知'
    ,value: data.tzText
}, function(value, index){
    layer.close(index);
    $.ajax({
    url: "/edittz",
    data: {
    'id': data.id,
    'tzText':value
},
    type: 'post',
    dataType: "json",
    success: function (data) {
    layer.msg(data.msg);
},
});
    obj.update({
    tzText: value
});
});
}
});

});
    //政策文件
    layui.use('table', function(){
    const table = layui.table;
    table.render({
    elem: '#zc'
    ,height:800
    ,url: '/readzc'
    ,toolbar: 'default'
    ,editTrigger: 'dblclick'
    ,response: {
    code:0,
    dataName: 'data'
}
    ,cols: [
    [
{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
    ,{field: 'zcAuthor', title: '作者', width:100, edit: 'text'}
    ,{field: 'zcTitle', title: '标题', width:200,edit: 'text'}
    ,{field: 'zcText', title: '政策内容', width:700, edit: 'text',event: 'setSign'}
    ,{title: '操作', width: 200, templet: '#toolEvent2'}
    ]
    ]
});

    table.on('tool(zcw)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    layer.msg('ID：'+ data.id + ' 的查看操作');
} else if(obj.event === 'del'){
    layer.confirm('真的删除行么', function(index){
    obj.del();
    $.ajax({
    url:"/delzc",
    data : {
    'id' : data.id
},
    type:'post',
    dataType : "json",
    success : function(data) {
    console.log(data);
    layer.msg(data.msg);
    location.reload(); //删除成功后再刷新
},
});
    layer.close(index);

});
}
    if(obj.event === 'setSign'){
    layer.prompt({
    formType: 2
    ,title: '修改通知'
    ,value: data.zcText
}, function(value, index){
    layer.close(index);
    $.ajax({
    url: "/editzc",
    data: {
    'id': data.id,
    'zcText':value
},
    type: 'post',
    dataType: "json",
    success: function (data) {
    layer.msg(data.msg);
},
});
    obj.update({
    zcText: value
});
});
}

});

});

    //加入志愿组
    layui.use('table', function(){
    const table = layui.table;
    table.render({
    elem: '#zy'
    ,height:800
    ,url: '/readVM'
    ,toolbar: 'default'
    ,editTrigger: 'dblclick'
    ,response: {
    code:0,
    dataName: 'data'
}
    ,cols: [
    [
{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
    ,{field: 'vmname', title: '志愿名称', width:100, edit: 'text'}
    ,{field: 'phoneName', title: '联系方式', width:200,edit: 'text'}
    ,{field: 'vmtext', title: '志愿内容', width:300, edit: 'text'}
    ,{field: 'vmload', title: '志愿进度', width:300, edit: 'text'}
    ,{field: 'vmtime', title: '志愿时间', width:100, edit: 'text'}
    ,{title: '操作', width: 200, templet: '#toolEvent3'}
    ]
    ]
});

    table.on('tool(zy1)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    layer.msg('ID：'+ data.id + ' 的查看操作');
} else if(obj.event === 'del'){
    layer.confirm('确认加入吗', function(index){
    $.ajax({
    url:"/addVM",
    data : {
    'id' : data.id
},
    type:'post',
    dataType : "json",
    success : function(data) {
    layer.msg("加入成功" ,{
    icon: 1,
    time: 2000,

});
    $("#vis").text("已加入")
    $('#vis').attr('disabled',"true");
    // location.reload();
},
});
    layer.close(index);

});
}
});

});

    //志愿者管理
    layui.use('table', function(){
    const table = layui.table;
    table.render({
    elem: '#zyzlis'
    ,height:800
    ,url: '/readZyz'
    ,toolbar: 'default'
    ,editTrigger: 'dblclick'
    ,response: {
    code:0,
    dataName: 'data'
}
    ,cols: [
    [
{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
    ,{field: 'username', title: '姓名', width:100, edit: 'text'}
    ,{field: 'phoneName', title: '联系方式', width:200,edit: 'text'}
    ,{field: 'password', title: '密码', width:300, edit: 'text',event: 'setSign'}
    ,{field: 'sex', title: '性别', width:300, edit: 'text'}
    ,{field: 'zyz', title: '志愿组', width:100, edit: 'text'}
    ,{title: '操作', width: 200, templet: '#toolEvent4'}
    ]
    ]
});

    table.on('tool(zyz)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    layer.msg('ID：'+ data.id + ' 的查看操作');
} else if(obj.event === 'del'){
    layer.confirm('确认删除吗', function(index){
    $.ajax({
    url:"/delzyz",
    data : {
    'id' : data.id
},
    type:'post',
    dataType : "json",
    success : function(data) {
    location.reload();
},
});
    layer.close(index);

});
}

    if(obj.event === 'setSign'){
    layer.prompt({
    formType: 2
    ,title: '修改密码'
    ,value: data.password
}, function(value, index){
    layer.close(index);
    $.ajax({
    url: "/editpassword",
    data: {
    'id': data.id,
    'password':value
},
    type: 'post',
    dataType: "json",
    success: function (data) {
    layer.msg("修改成功",{
    icon:1,
    time:2000
});
},
});
    obj.update({
    password: value
});
});
}
});



});

    //志愿项目管理
    layui.use('table', function(){
    const table = layui.table;
    table.render({
    elem: '#zyxm1'
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
    ,{field: 'VMname', title: '活动名称', width:100, edit: 'text'}
    ,{field: 'VMT', title: '活动内容', width:200,edit: 'text'}
    ,{field: 'vmAdders', title: '活动地址', width:300, edit: 'text'}
    ,{field: 'vmN', title: '活动发起人', width:300, edit: 'text'}
    ,{field: 'isvm', title: '所属项目组', width:100, edit: 'text'}
    ,{field: 'isuser', title: '项目组成员', width:100, edit: 'text'}
    ,{title: '操作', width: 200, templet: '#toolEvent6'}
    ]
    ]
});

    table.on('tool(zyxm1)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    layer.msg('ID：'+ data.id + ' 的查看操作');
} else if(obj.event === 'del'){
    layer.confirm('确认加入吗', function(index){
    $.ajax({
    url:"/addV",
    data : {
    'id' : data.id,
    'uid': '1'
},
    type:'post',
    dataType : "json",
    success : function(data) {
    layer.msg("加入成功" ,{
    icon: 1,
    time: 2000,

});
    $("#vis").text("已加入")
    $('#vis').attr('disabled',"true");
    // location.reload();
},
});
    layer.close(index);

});
}
});

});
    function tz(){
    $("#Newstables").hide();
}
    function Newstables(){
    $("#tzgg").hide();
    $("#Newstables").toggle();
}


