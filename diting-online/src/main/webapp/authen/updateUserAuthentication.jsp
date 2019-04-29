<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<body>
<script>
    $(function () {
        $("#userAuthenticationInfoForm").form("load", "${pageContext.request.contextPath}/userAuthentication/userAuthenticationInfo"
        )
        $("#userAuthenticationInfoForm").form({
                onLoadSuccess: function (data) {
                    if (data.authenticationType != 0) {
                        $("#person").empty();
                        document.getElementById("person").style.display = "none";
                        document.getElementById("organization").style.display = "block";
                        $("#certificatePositive2").prop("src", data.certificatePositiveUrl);
                    } else {
                        document.getElementById("person").style.display = "block";
                        document.getElementById("organization").style.display = "none";
                        $("#certificatePositiveP2").prop("src", data.certificatePositiveUrl);
                        $("#certificateOppositeP2").prop("src", data.certificateOppositeUrl)
                        $("#certificateHandofP2").prop("src", data.certificateHandofUrl)
                        $("#organization").empty();
                    }
                }
            }
        )
        //定义保存按钮
        $("#confirmuserAuthen").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发关闭对话框事件
            onClick: function () {
                //关闭表单事件
                $("#addAuthenDia").dialog("close");
            }


        })
        $("#AuthenUpdate").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                //提交表单事件
                $("#addUserAuthenForm").form("submit", {
                    url: "${pageContext.request.contextPath}/userAuthentication/updateUserAutentication",
                    onSubmit: function () {
                        //进行验证
                        return true
                    },
                    success: function (data) {
                        //关闭对话框
                        $("#addAuthenDia").dialog("close");
                        //调出系统提示框
                        $.messager.show({
                            title: "修改成功",
                            msg: "恭喜！修改非认证信息成功，请等待审核！",

                        });

                    }
                })
            },


        })
    })

</script>
<div>
    <div><p style="font-size: large">用户认证详情</p></div>
    <div>
        <form id="userAuthenticationInfoForm" method="post">
            <table style="display: block" id="person">
                <tr>
                    <td>
                        <input id="type1" type="hidden" class="easyui-validatebox" name="type"
                               value="0" data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        真实姓名:
                    </td>
                    <td>
                        <input id="realNameP" type="text" class="easyui-validatebox" name="realName"
                               readonly   data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        证件类型:
                    </td>
                    <td>
                        <input id="certificateTypeP" type="text" class="easyui-validatebox" name="certificateType"
                               readonly   data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        证件号码:
                    </td>
                    <td>
                        <input id="certificateNumberP2" type="text" class="easyui-validatebox" name="certificateNumber"
                               readonly  data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        身份证正面照:
                    </td>
                    <td><img id="certificatePositiveP2" src="" style="width: 120px;height: 200px"></td>

                </tr>
                <tr>
                    <td>
                        身份证反面照:
                    </td>
                    <td>
                        <img id="certificateOppositeP2" src="" style="width: 120px;height: 200px">
                    </td>
                </tr>
                <tr>
                    <td>
                        身份证手持照:
                    </td>
                    <td>
                        <img id="certificateHandofP2" src="" style="width: 120px;height: 200px">
                    </td>
                </tr>
            </table>
            <table style="display: none" id="organization">
                <tr>
                    <td>
                        <input id="type2" type="hidden" class="easyui-validatebox" name="type"
                               value="1" data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        组织名称:
                    </td>
                    <td>
                        <input id="organizationNameC" type="text" class="easyui-validatebox" name="organizationName"
                               readonly data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        证件类型:
                    </td>
                    <td>
                        <input id="certificateType" type="text" class="easyui-validatebox" name="certificateType"
                               readonly  data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        证件号码:
                    </td>
                    <td>
                        <input id="certificateNumber" type="text" class="easyui-validatebox" name="certificateNumber"
                               readonly  data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        证件正面照:
                    </td>
                    <td><img id="certificatePositive2" src="" style="width: 120px;height: 200px"></td>
                </tr>
                <tr>
                    <td>
                        法人:
                    </td>
                    <td>
                        <input id="corporationName" type="text" class="easyui-validatebox" name="corporationName"
                               readonly  data-options=""/>
                    </td>
                </tr>
            </table>
        </form>
        <p>
            <a id="confirmuserAuthen" class="easyui-linkbutton">关闭</a>

            <a id="AuthenUpdate" class="easyui-linkbutton">保存</a>
        </p>
    </div>
</div>
</body>