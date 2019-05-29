<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var data;
    $(function () {
        //初始化数据表格
        $("#dbRightDistribution").edatagrid({
            toolbar: "#tbRightDistribution",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/rightDistribution/getTable",
            pagePosition: "bottom",
            pagination: true,
            queryParams: {
                searchType: 1,
                timeType: 1,
                sortType: 1
            },
            pageSize: 4,
            cash: false,
            pageList: [4, 8, 10],
            frozenColumns: [[
                {field: 'ck', checkbox: true}
            ]],
            columns: [[{
                field: "id",
                title: "ID",
                width: 100,

            }, {
                field: "rightType",
                title: "权利类型",
                width: 100,

            }, {
                field: "workType",
                title: "作品类型",
                width: 100,

            }, {
                field: "distributionName",
                title: "分配员工",
                width: 100,

            }, {
                field: "operatorName",
                title: "操作者",
                width: 100,

            }]],
        });
    })

    function doSearch() {
        $('#dbRightDistribution').datagrid('load', {
            id: $('#Idr1').val(),
            rightName: $('#rightName1').val(),
            name: $('#rightPerson1').val()
        });
    }
</script>
<div>
    <div>
        <h1 align="center">权利审核分配人员</h1>
       <%-- <div style=" position: relative;
        left: 2500px; "><img src="${pageContext.request.contextPath}/images/addRightDistribution.jpg" style="width: 100px;height: 70px;"/><span style="float: top">新增分配人员</span></div>--%>
    </div>
    <table id="dbRightDistribution"></table>
    <div id="tbRightDistribution">
        <%--<a id="addAuthenticationWrokProccesed" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">添加</a>--%>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
</div>