<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    $(function () {
        //定义保存按钮
        var named = "";
        var name = "";
        $("#auditPerson").combobox({
            prompt: '请输入或选择审核人员',
            url: '${pageContext.request.contextPath}/manager/getManagerByName?name=' + name,
            filter: function (q, row) {
                var opts = $(this).combobox('options');
                return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配
            },
            onSelect: function (rec) {
                $("#managerId").val(rec.id);
                named = rec.name;
            }
        })
        $("#rightType").combobox({
            onSelect: function (rec) {
                if (rec.value != "1") {
                    $("#workType").val("---");
                    $("#workTyper").attr("hidden", "hidden");
                } else {
                    $("#workTyper").removeAttr("hidden");
                }
            }
        })

        $("#confirmuserAddRightDistribution").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/rightDistribution/addRightAuditPerson",
                    data: {
                        "distributionName": named,
                        "rightType": $("#rightType").val(),
                        "workType": $("#workType").val(),
                        "managerId": $("#managerId").val()
                    },
                    dataType: "json",
                    success: function () {
                        $("#addRightDistributionInfo").dialog("close");
                        $("#dbRightDistribution").datagrid("reload");
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
    <form id="addRightDistributionForm" method="post">
        <table>
            <tr>
                <td>
                    <input id="managerId" type="hidden" class="easyui-validatebox" name="managerId"
                           value="" data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    权利类型:
                </td>
                <td>
                    <select id="rightType" class="easyui-combobox" name="rightType" style="width:200px;"
                            data-options="required:true,panelHeight: 90">
                        <option value="1">著作权</option>
                        <option value="2">名誉权/肖像权</option>
                        <option value="3">其他权利</option>
                    </select>
                </td>
            </tr>
            <tr id="workTyper">
                <td>
                    作品类型:
                </td>
                <td>
                    <select id="workType" class="easyui-combobox" name="workType" style="width:100px;"
                            data-options="required:true,panelHeight: 90">
                        <option value="视频">视频</option>
                        <option value="电影">电影"</option>
                        <option value="电视剧">电视剧</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    审核人员:
                </td>
                <td>
                    <select id="auditPerson" type="text" class="easyui-combobox" style="width:200px;"
                            name="distributionName"
                            data-options="valueField: 'name',
                             textField: 'name',
                            "></select>
                </td>
            </tr>
        </table>
    </form>
    <p>
        <a id="confirmuserAddRightDistribution" class="easyui-linkbutton">确定</a>
    </p>
</div>
