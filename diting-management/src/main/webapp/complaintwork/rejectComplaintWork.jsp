<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var id = "<%=request.getParameter("id").toString()%>";
    console.info(id);
    $(function () {
        //定义保存按钮
        $("#confirmuserRejectComplaintWork").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/complaintsWork/rejectWork",
                    data: {
                        "ids": id,
                        "failType": $("#rejectType2").val(),
                        "reason": $("#reason").val(),
                        "node": 1
                    },
                    dataType: "json",
                    success: function () {
                        $("#dbCopyrightComplaintsWorkProccesing").edatagrid("reload");
                        $("#dbCopyrightComplaintsWorkProccessed").edatagrid("reload");
                        $("#dbOtherRightComplaintsWorkProccesing").edatagrid("reload");
                        $("#dbOtherRightComplaintsWorkProccessed").edatagrid("reload");
                        $("#dbReputationComplaintsWorkProccesing").edatagrid("reload");
                        $("#dbReputationRightComplaintsWorkProccessed").edatagrid("reload");
                        $("#dbComplaintWork").edatagrid("reload");
                        $("#rejectInfo").dialog("close");
                        $.messager.show({
                            title: '提示信息',
                            msg: '操作成功!'
                        });
                    }
                })
            }
        });
    })
</script>
<div>
    <form id="rejectAuthenticationWorkFrom" method="post">
        <table>
            <tr hidden>
                <td>
                    id:
                </td>
                <td>
                    <input id="node2" type="text" class="easyui-validatebox"
                           name="node" value="1"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    驳回类型:
                </td>
                <td>
                    <select id="rejectType2" class="easyui-combobox" name="failType" style="width:100px;"
                            data-options="required:true,panelHeight: 90">
                        <option value="权利信息有误">权利信息有误</option>
                        <option value="投诉涉及内容非侵权">投诉涉及内容非侵权</option>
                        <option value="其他">其他</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    原因:
                </td>
                <td>
                    <input id="reason" type="text" class="easyui-validatebox"
                           name="reason"
                           data-options=""/>
                </td>
            </tr>
        </table>
    </form>
    <p>
        <a id="confirmuserRejectComplaintWork" class="easyui-linkbutton">确定</a>
    </p>
</div>
