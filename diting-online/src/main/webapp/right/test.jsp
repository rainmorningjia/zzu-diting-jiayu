<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22 0022
  Time: 上午 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

$('#dg').datagrid({
fit:false,
border:true,
singleSelect:true,
fitColumns:true,
url : "${pageContext.request.contextPath}/standard/list",
columns : [ [
{
field : 'id',
title : '编号',
width : 100
},
{
field : 'name',
title : '名称',
width : 200
},
{
field : 'minWeight',
title : '最小重量',
width : 200
},
{
field : 'maxWeight',
title : '最大重量',
width : 200
},
{
field : 'minLength',
title : '最小长度',
width : 200
},
{
field : 'maxLength',
title : '最大长度',
width : 200
}

] ],
toolbar:"#tb",

pagination:true,
pageNumber:1,
pageSize:3,
pageList:[3,6,9]
});


$("#standardQueryBtn").click(function(){

$("#dg").datagrid("load",{
"standard.name": $("#qName").val(),
"standard.minWeight": $("#qMinWeight").val(),
"standard.minLength": $("#qMinLength").val()
});

});

});

---------------------
作者：NothiX
来源：CSDN
原文：https://blog.csdn.net/shan165310175/article/details/78378430
版权声明：本文为博主原创文章，转载请附上博文链接！
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
