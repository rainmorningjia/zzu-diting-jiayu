<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var data;
    $(function () {
        //初始化数据表格
        $("#dbReputationRightWorkProccessing").edatagrid({
            toolbar: "#tbReputationRightWorkProccessing",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/rightWork/getTable?rightType=2&tableType=1",
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

        });
        $("#adoptReputationRightWorkProccessing").linkbutton({
            onClick: function () {
                var s=$("#dbReputationRightWorkProccessing").edatagrid("getSelected");
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/rightWork/adopt",
                    data: {
                        "id": s.id,
                    },
                    dataType: "json",
                    success: function () {
                        $("#dbReputationRightWorkProccessing").edatagrid("reload");
                        $("#dbReputationRightWorkProccesed").edatagrid("reload");
                        $.messager.show({
                            title: '提示信息',
                            msg: '操作成功!'
                        });
                    }
                })
            }
        });
        $("#rejectReputationRightWork").linkbutton({
            onClick: function () {
                var s=$("#dbReputationRightWorkProccessing").edatagrid("getSelected");
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

</script>
<div>
    <h1 align="center">已处理肖像权/名誉权工单信息</h1>
    <table id="dbReputationRightWorkProccessing"></table>
    <div id="tbReputationRightWorkProccessing">
        <a id="adoptReputationRightWorkProccessing" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">通过</a>
        <a id="rejectReputationRightWork" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-edit',plain:true">驳回</a>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
</div>