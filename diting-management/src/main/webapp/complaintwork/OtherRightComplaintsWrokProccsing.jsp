<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    $(function () {
        //初始化数据表格
        $("#dbOtherRightComplaintsWorkProccesing").edatagrid({
            toolbar: "#tbOtherRightComplaintsWorkProccessing",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/complaintsWork/getComplainsWork?&tableType=1&searchType=1&complaintType=3",
            <%--updateUrl:"${pageContext.request.contextPath}/user/updataUser",--%>
            pagePosition: "bottom",
            pagination: true,
            pageSize: 4,
            cash: false,
            singleSelect:false,
            pageList: [4, 8, 10],
            frozenColumns: [[
                {field: 'ck', checkbox: true}
            ]],
            columns: [[{
                field: "id",
                title: "ID",
                width: 100,
                formatter: function (value, row, index) {
                    var id = row.id;
                    return '<a  style="color:blue"  onclick="test(' + id + ',title)' + '">' + row.id + '(点击查看详情)' + '</a>';
                }
            }, {
                field: "complaintPerson",
                title: "投诉人",
                width: 100,

            }, {
                field: "complaintType",
                title: "投诉类型",
                width: 100,

            }, {
                field: "relationRight",
                title: "涉及权利",
                width: 100,

            }, {
                field: "complaintNumber",
                title: "投诉量",
                width: 100,

            }, {
                field: "processing",
                title: "处理进度",
                width: 100,

            },  {
                field: "node",
                title: "处理节点",
                width: 100,

            }, {
                field: "handlePerson",
                title: "处理人",
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

        });
    })

</script>
<div>
    <h1 align="center">处理中其他权利投诉集工单信息</h1>
    <table id="dbOtherRightComplaintsWorkProccesing"></table>

        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
</div>