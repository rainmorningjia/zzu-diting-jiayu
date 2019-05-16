<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var id = "<%=request.getParameter("id").toString()%>";
    console.info(id);
    $(function () {
        $("#id").val(id);
        //定义保存按钮
        $("#confirmuserRejectAuthenWork").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                //提交表单事件
                $("#rejectAuthenticationWorkFrom").form("submit", {
                    url: "${pageContext.request.contextPath}/authenticationWork/rejectWork",
                    onSubmit: function () {
                        //进行验证
                        return true
                    },
                    success: function () {
                        $("#dbAuthenticationWorkProccesing").edatagrid("reload");
                        $("#rejectInfo").dialog("close")
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
    <form id="rejectAuthenticationWorkFrom" method="post">
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
                    <input id="rejectType" type="text" class="easyui-validatebox"
                           name="failType"
                           data-options=""/>
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
        <a id="confirmuserRejectAuthenWork" class="easyui-linkbutton">确定</a>
    </p>
</div>
