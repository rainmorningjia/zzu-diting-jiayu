<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var data;
    $(function () {
        //初始化数据表格
        $("#dbOtherRightWorkProccessing").edatagrid({
            toolbar: "#tbOtherRightWorkProccessing",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/rightWork/getTable?rightType=3&tableType=1",
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
        $("#adoptOtherRightWorkProccessing").linkbutton({
            onClick: function () {
                var s=$("#dbOtherRightWorkProccessing").edatagrid("getSelected");
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/rightWork/adopt",
                    data: {
                        "id": s.id,
                    },
                    dataType: "json",
                    success: function () {
                        $("#dbOtherRightWorkProccessing").edatagrid("reload");
                        $("#dbOtherRightWorkProccesed").edatagrid("reload");
                        $.messager.show({
                            title: '提示信息',
                            msg: '操作成功!'
                        });
                    }
                })
            }
        });
        $("#rejectOtherRightWork").linkbutton({
            onClick: function () {
                var s=$("#dbOtherRightWorkProccessing").edatagrid("getSelected");
                $("#rejectInfo").dialog({
                    title: "驳回信息",
                    width: 300,
                    height: 200,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/rightwork/rejectRightWork.jsp?id=" + s.id,
                    modal: true,
                    buttons: [
                        {
                            text: "关闭",
                            handler: function () {
                                $("#rejectInfo").dialog("close")
                            }
                        }]
                })

            }
        })
    })
    function doSearch(){
        $('#dbOtherRightWorkProccessing').datagrid('load',{
            id: $('#Idr4').val(),
            rightName: $('#rightName4').val(),
            name: $('#rightPerson4').val()
        });
    }
</script>
<div>
    <h1 align="center">已处理肖像权/名誉权工单信息</h1>
    <table id="dbOtherRightWorkProccessing"></table>
    <div id="tbOtherRightWorkProccessing">
        <a id="adoptOtherRightWorkProccessing" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">通过</a>
        <a id="rejectOtherRightWork" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-edit',plain:true">驳回</a>
        <span>ID:</span>
        <input id="Idr4" style="line-height:26px;border:1px solid #ccc">
        <span>权利名称</span>
        <input id="rightName4" style="line-height:26px;border:1px solid #ccc">
        <span>权利人</span>
        <input id="rightPerson4" style="line-height:26px;border:1px solid #ccc">
        <a  class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true,size:'large'" onclick="doSearch()">搜索</a>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
</div>