<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var id = "<%=request.getParameter("id").toString()%>";
    $(function () {
        $("#id").val(id);
        //定义保存按钮
        $("#confirmuserRejectRightWork").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                //提交表单事件
                $("#rejectRightWorkFrom").form("submit", {
                    url: "${pageContext.request.contextPath}/rightWork/reject",
                    onSubmit: function () {
                        //进行验证
                        return true
                    },
                    success: function () {
                        $("#rejectInfo").dialog("close")
                        $("#dbCopyRightWorkProccesing").edatagrid("reload");
                        $("#dbOtherRightWorkProccessing").edatagrid("reload");
                        $("#dbReputationRightWorkProccessing").edatagrid("reload");
                        $("#dbCopyRightWorkProccesed").edatagrid("reload");
                        $("#dbOtherRightWorkProccesed").edatagrid("reload");
                        $("#dbReputationRightWorkProccesed").edatagrid("reload");
                        $.messager.show({
                            title: '提示信息',
                            msg: '操作成功!'
                        });
                    }
                })
            },
        });
    })
</script>
<div>
    <form id="rejectRightWorkFrom" method="post">
        <table>
            <tr hidden>
                <td>
                    id:
                </td>
                <td>
                    <input id="id" type="text" class="easyui-validatebox"
                           name="id"
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
                        <option value="信息不符">信息不符</option>
                        <option value="文件不符">文件不符</option>
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
        <a id="confirmuserRejectRightWork" class="easyui-linkbutton">确定</a>
    </p>
</div>
