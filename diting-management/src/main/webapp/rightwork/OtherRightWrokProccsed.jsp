<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var data;
    $(function () {
        //初始化数据表格
        $("#dbOtherRightWorkProccesed").edatagrid({
            toolbar: "#tbOtherRightWorkProccesed",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/rightWork/getTable?rightType=3&tableType=2",
            <%--updateUrl:"${pageContext.request.contextPath}/user/updataUser",--%>
            pagePosition: "bottom",
            pagination: true,
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
                field: "jobType",
                title: "类型",
                width: 100,

            }, {
                field: "rightType",
                title: "权利类型",
                width: 100,

            }, {
                field: "worksType",
                title: "作品名称",
                width: 100,

            }, {
                field: "rightName",
                title: "权力名称",
                width: 100,

            }, {
                field: "rightPerson",
                title: "权利人名称",
                width: 100,

            },  {
                field: "failReason",
                title: "失败原因",
                width: 100,

            }, {
                field: "auditState",
                title: "处理状态",
                width: 100,

            }, {
                field: "createTime",
                title: "创建时间",
                width: 100,

            }, {
                field: "updateTime",
                title: "更新时间",
                width: 100,

            }]],
            onClickRow: function (index, row) {
                $("#userRightInfo").dialog({
                    title: "用户权利信息",
                    width: 500,
                    height: 600,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/rightwork/detailRight.jsp?id=" + row.id,
                    modal: true,
                    buttons: [
                        {
                            text: "关闭",
                            handler: function () {
                                $("#userRightInfo").dialog("close")
                            }
                        }]
                })
            }
        });

    })
    function doSearch(){
        $('#dbOtherRightWorkProccesed').datagrid('load',{
            id: $('#Idr3').val(),
            rightName: $('#rightName3').val(),
            name: $('#rightPerson3').val()
        });
    }
</script>
<div>
    <h1 align="center">已处理肖像权/名誉权工单信息</h1>
    <table id="dbOtherRightWorkProccesed"></table>
    <div id="tbOtherRightWorkProccesed">
        <span>ID:</span>
        <input id="Idr3" style="line-height:26px;border:1px solid #ccc">
        <span>权利名称</span>
        <input id="rightName3" style="line-height:26px;border:1px solid #ccc">
        <span>权利人</span>
        <input id="rightPerson3" style="line-height:26px;border:1px solid #ccc">
        <a  class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true,size:'large'" onclick="doSearch()">搜索</a>
        <%--<a id="addAuthenticationWrokProccesed" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">添加</a>--%>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
</div>