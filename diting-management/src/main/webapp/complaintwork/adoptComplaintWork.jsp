<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var ids = "<%=request.getParameter("id").toString()%>";
    console.info(ids);
    $(function () {
        //定义保存按钮
        $("#confirmuserAdpotComplaintWork").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/complaintsWork/adoptWork",
                    data: {
                        "workIds": ids,
                        "handleRank": $("#adoptType").val(),
                        "explanation": $("#explanation").val(),
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
                        $("#adoptInfo").dialog("close");
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
            <tr>
                <td>
                    通过等级:
                </td>
                <td>
                    <select id="adoptType" type="text" class="easyui-combobox" style="width:100px;"
                           data-options="required:true,panelHeight: 90">
                        <option value="P0">P0</option>
                        <option value="P1">P1</option>
                        <option value="P2">P2</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    补充信息:
                </td>
                <td>
                    <input id="explanation" type="text" class="easyui-validatebox"
                           name="explanation"
                           data-options=""/>
                </td>
            </tr>
        </table>
    </form>
    <p>
        <a id="confirmuserAdpotComplaintWork" class="easyui-linkbutton">确定</a>
    </p>
</div>
