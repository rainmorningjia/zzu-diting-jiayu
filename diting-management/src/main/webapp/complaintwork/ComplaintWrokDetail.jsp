<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var id = "<%=request.getParameter("id").toString()%>";
    $(function () {
        //初始化数据表格
        $("#dbComplaintWork").edatagrid({
            toolbar: "#tbComplaintWork",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/complaintsWork/getComplainWork?id=" + id,
            <%--updateUrl:"${pageContext.request.contextPath}/user/updataUser",--%>
            pagePosition: "bottom",
            pagination: true,
            pageSize: 4,
            cash: false,
            singleSelect: false,
            pageList: [4, 8, 10],
            frozenColumns: [[
                {field: 'ck', checkbox: true}
            ]],
            columns: [[{
                field: "id",
                title: "ID",
                width: 100,
            }, {
                field: "complaintId",
                title: "投诉id",
                width: 100,

            }, {
                field: "complaintUrl",
                title: "投诉链接",
                width: 100,
                formatter: function (value, row, index) {
                    return '<a style="color:blue" href="' + row.complaintUrl + '">' + row.complaintUrl + '</a>';
                }
            }, {
                field: "auditStateOne",
                title: "审核状态",
                width: 100,
            }, {
                field: "handleRank",
                title: "意见",
                width: 150,
                formatter: function (value, row, index) {
                    if (row.handleRank != null) {
                        return '处理等级:' + row.handleRank + '&nbsp;&nbsp;&nbsp;&nbsp;意见:' + row.explanation;
                    } else if (row.rejectTypeOne != null) {
                        return '<p style="color:red">' + row.rejectTypeOne + '&nbsp;&nbsp;&nbsp;&nbsp;' + row.reasonOne+'</p>';
                    }
                }
            }, {
                field: "createTime",
                title: "创建时间",
                width: 100,

            }, {
                field: "updateTime",
                title: "更新时间",
                width: 100,

            }]],
            onLoadSuccess: function (data) {
                $('#dbComplaintWork').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
                if (data.rows.length > 0) {
                    //循环判断操作为新增的不能选择
                    for (var i = 0; i < data.rows.length; i++) {
                        //根据operate让某些行不可选
                        if ("通过" == data.rows[i].auditStateOne || "驳回" == data.rows[i].auditStateOne) {
                            console.info("111")
                            $("input[type='checkbox']")[i + 1].disabled = true;
                        }
                    }
                }
            },
            onClickRow: function (rowIndex, rowData) {
                //加载完毕后获取所有的checkbox遍历
                $("input[type='checkbox']").each(function (index, el) {
                    //如果当前的复选框不可选，则不让其选中
                    if (el.disabled == true) {
                        $('#dbComplaintWork').datagrid('unselectRow', index - 1);
                        $('#dbComplaintWork').datagrid('uncheckRow', index - 1);
                    }
                })
            },
            onCheck: function (index, row) {
                //加载完毕后获取所有的checkbox遍历
                if (row.auditStateOne == "通过" || row.auditStateOne == "驳回") {
                    $('#dbComplaintWork').datagrid('uncheckRow', index);
                }

            }
        });
        $("#adoptComplaintsWork").linkbutton({
            onClick: function () {
                var s = $("#dbComplaintWork").edatagrid("getSelections");
                var ids = [];
                $(s).each(function () {
                    ids.push(this.id);
                });
                $("#rejectInfo").dialog({
                    title: "通过信息",
                    width: 300,
                    height: 200,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/complaintwork/adoptComplaintWork.jsp?id=" +ids,
                    modal: true,
                    buttons: [
                        {
                            text: "关闭",
                            handler: function () {
                                $("#adoptInfo").dialog("close")
                            }
                        }]
                })

            }
        });
        $("#rejectComplaintsWork").linkbutton({
            onClick: function () {
                var s = $("#dbComplaintWork").edatagrid("getSelections");
                var ids = [];
                $(s).each(function () {
                    ids.push(this.id);
                });
                $("#rejectInfo").dialog({
                    title: "驳回信息",
                    width: 300,
                    height: 200,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/complaintwork/rejectComplaintWork.jsp?id=" +ids,
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
    <h1 align="center">投诉集工单详情信息</h1>
    <table id="dbComplaintWork"></table>
    <div id="tbComplaintWork">
        <a id="adoptComplaintsWork" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">通过</a>
        <a id="rejectComplaintsWork" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-edit',plain:true">驳回</a>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
</div>