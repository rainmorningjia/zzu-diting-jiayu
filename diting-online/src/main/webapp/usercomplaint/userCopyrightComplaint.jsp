<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var data;
    $(function () {
        //初始化数据表格
        $("#dbUserCopyRightComplaint").edatagrid({
            toolbar: "#tbUserCopyRightComplaint",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/userComplaint/getUserCompliant?rightType=著作权",
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
                field: "complaintPlatform",
                title: "投诉品台",
                width: 100,

            }, {
                field: "rightName",
                title: "权利名称",
                width: 100,

            }, {
                field: "copyrightType",
                title: "权利类型",
                width: 100,

            }, {
                field: "complaintsUrl",
                title: "投诉链接",
                width: 100,

            }, {
                field: "processState",
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

            }, {
                field: "reason",
                title: "失败原因",
                width: 100,
            }]],

        });
        $("#addUserCopyRightComplaint").linkbutton({
            onClick: function () {
                $("#dialogUserRightComplaint").dialog({
                    title: "添加投诉信息",
                    width: 600,
                    height: 700,
                    closed: false,
                    cache: true,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/usercomplaint/addUserComplaint.jsp",
                    modal: true
                })
            }
        })
    })

</script>
<div>
    <h1 align="center">著作权投诉信息</h1>
    <table id="dbUserCopyRightComplaint"></table>
    <div id="tbUserCopyRightComplaint">
        <a id="addUserCopyRightComplaint" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">添加</a>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
</div>