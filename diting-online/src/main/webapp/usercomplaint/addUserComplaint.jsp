<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<body>
<script type="text/javascript">

    $(function () {
        //定义保存按钮
        $("#confirmUserComplaint").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                console.info("sdfdsfds")
                //提交表单事件
                $("#addUserComplaintForm").form("submit", {

                    url: "${pageContext.request.contextPath}/userComplaint/addUserComplaintInfo",
                    onSubmit: function () {
                        //进行验证
                        return true
                    },
                    success: function (data) {
                        var data1 = JSON.parse(data);
                        if (data1.code == 0) {
                            $('#dbUserCopyRightComplaint').datagrid('reload');
                            $('#dbUserOtherRightComplaint').datagrid('reload');
                            $('#dbUserComplaintReputationRight').datagrid('reload');
                            //关闭对话框
                            $("#dialogUserRightComplaint").dialog("close");
                            //调出系统提示框
                            $.messager.show({
                                title: "添加成功",
                                msg: "恭喜！填写投诉信息成功，一共" + data1.urlTotalNumberDto.totalNumber + "条，已存在" + data1.urlTotalNumberDto.existNumber + "条，成功" + data1.urlTotalNumberDto.successNumber + "请等待审核！",

                            });
                        } else {
                            $.messager.show({
                                title: "添加失败",
                                msg: data.message,
                            });
                        }


                    }
                })
            },


        });
        var rightType = "著作权";
        var name=$("#rightNameCC").val();
        $("#copyrightTypeCC").combobox({
            valueField: 'id',
            textField: 'text',
            url: '${pageContext.request.contextPath}/right/getRightType',
            onSelect: function (rec) {
                var url = '${pageContext.request.contextPath}/right/getRightIDAndName?name=' + name + '&rightType=' + rec.text;
                $('#rightNameCC').combobox('reload', url);
            }
        });

        $("#rightNameCC").combobox({
            prompt: '请输入或选择权利名称',
            url: '${pageContext.request.contextPath}/right/getRightIDAndName?name=' + name + '&rightType=' + rightType,
            filter: function (q, row) {
                var opts = $(this).combobox('options');
                return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配
            },
            onSelect: function (rec) {
                $("#relationRightId").val(rec.id);
                console.info($("#relationRightId").val());
            }
        })

    })
</script>

<div>
    <h1>
        添加用户投诉信息:
    </h1>
    <form id="addUserComplaintForm" method="post" enctype="multipart/form-data">
        <table style="display: block" id="copyright">
            <tr>
                <td>
                    选择投诉类型:
                </td>
                <td>
                    <input id="copyrightTypeCC" class="easyui-combobox" name="copyrightType" style="width:150px;"
                           data-options="valueField: 'name',
                             textField: 'name'," style="width:300px"/>
                </td>
            </tr>
            <tr>
                <td>
                    权利名称:
                </td>
                <td>
                    <input id="rightNameCC" class="easyui-combobox" name="rightName"
                           data-options="valueField: 'name',
                             textField: 'name',
                            " style="width:170px"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input id="relationRightId" type="hidden" class="easyui-validatebox" name="relationRightId"
                           value="" data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    投诉链接:
                </td>
                <td>
                    <input id="complaintsUrl" type="text" class="easyui-validatebox"
                           name="complaintsUrl" style="width:250px;"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    投诉平台:
                </td>
                <td>
                    <input id="complaintPlatform" type="text" class="easyui-validatebox"
                           name="complaintPlatform"
                           data-options=""/>
                </td>
            </tr>
        </table>
        <p>
            <a id="confirmUserComplaint" class="easyui-linkbutton">保存</a>
        </p>
    </form>
</div>
</body>
