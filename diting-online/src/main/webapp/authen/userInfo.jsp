<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<body>
<script>
    $(function () {
        $("#userForm").form("load", "${pageContext.request.contextPath}/user/getUserInfo"
        );
        $("#userForm").form({
                onLoadSuccess: function (data) {
                    $("#src").prop("src", data.headIconUrl);
                }
            }
        );
        $("#updateUserInfo").linkbutton({
            onClick: function () {
                $("#pass").removeAttr("hidden");
                $("#conf").removeAttr("hidden");
                $("#s2").attr("value", "");
                $("#s3").removeAttr("readonly");
                $("#s4").removeAttr("readonly");
                $("#s5").removeAttr("readonly");
                $("#s6").removeAttr("readonly");
                $("#s7").removeAttr("readonly");
                $("#s8").removeAttr("readonly");
                $("#s9").removeAttr("readonly");
                $("#cancles").removeAttr("hidden");
                $("#updateUserInfos").attr("hidden", "hidden");
                $("#file").removeAttr("hidden");
                $("#src").attr("hidden", "hidden");
            }
        });
        $("#cancle").linkbutton({
            onClick: function () {
                $("#updateUserInfos").removeAttr("hidden");
                $("#src").removeAttr("hidden");
                $("#file").attr("hidden", "hidden");
                $("#pass").attr("hidden", "hidden");
                $("#conf").attr("hidden", "hidden");
                $("#cancles").attr("hidden", "hidden");
                $("#s3").attr("readonly", "true");
                $("#s4").attr("readonly", "true");
                $("#s5").attr("readonly", "true");
                $("#s6").attr("readonly", "true");
                $("#s7").attr("readonly", "true");
                $("#s8").attr("readonly", "true");
                $("#s9").attr("readonly", "true");
            }
        });
        $("#confirmUserInfo").linkbutton({
            onClick: function () {
                $("#userForm").form('submit', {
                    url: "${pageContext.request.contextPath}/user/updateUserInfo",
                    onSubmit: function () {
                        // do some check
                        // return false to prevent submit;
                        return true;
                    },
                    success: function (data) {
                        var d = JSON.parse(data);
                        $("#userForm").form("load", "${pageContext.request.contextPath}/user/getUserInfo"
                        );
                        $("#userForm").form({
                                onLoadSuccess: function (data) {
                                    $("#src").prop("src", data.headIconUrl);
                                    $("#src").removeAttr("hidden");
                                    $("#file").attr("hidden", "hidden");
                                }
                            }
                        );
                        if (d.code == 0) {
                            $("#updateUserInfos").removeAttr("hidden");
                            $("#pass").attr("hidden", "hidden");
                            $("#conf").attr("hidden", "hidden");
                            $("#cancles").attr("hidden", "hidden");
                            $("#s3").attr("readonly", "true");
                            $("#s4").attr("readonly", "true");
                            $("#s5").attr("readonly", "true");
                            $("#s6").attr("readonly", "true");
                            $("#s7").attr("readonly", "true");
                            $("#s8").attr("readonly", "true");
                            $("#s9").attr("readonly", "true");
                            $.messager.show({
                                title: "修改成功",
                                msg: "恭喜！修改成功！",

                            });
                        }
                    },
                    onLoadError: function () {
                        $("#updateUserInfos").removeAttr("hidden");
                        $("#pass").attr("hidden", "hidden");
                        $("#conf").attr("hidden", "hidden");
                        $("#cancles").attr("hidden", "hidden");
                        $("#s3").attr("readonly", "true");
                        $("#s4").attr("readonly", "true");
                        $("#s5").attr("readonly", "true");
                        $("#s6").attr("readonly", "true");
                        $("#s7").attr("readonly", "true");
                        $("#s8").attr("readonly", "true");
                        $("#s9").attr("readonly", "true");
                        $.messager.show({
                            title: "修改失败",
                            msg: "修改信息失败！",

                        });
                    }
                });
            }
        })

    })

</script>
<div align="center">
    <div><p style="font-size: large">用户详情</p></div>
    <div>
        <form id="userForm" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>
                        姓名:
                    </td>
                    <td><input id="s1" name="userName" type="text" readonly="true"/></td>
                </tr>
                <tr id="pass" hidden>
                    <td>
                        密码:
                    </td>
                    <td><input id="s2" name="password" type="text"  value=""/></td>
                </tr>
                <tr>
                    <td>
                        性别:
                    </td>
                    <td><input id="s3" name="sex" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        头像:
                    </td>
                    <td id="s4"><img id="src" src="" style="width: 120px;height: 200px">
                        <input id="file" name="file" type="file" hidden>
                    </td>
                </tr>
                <tr>
                    <td>
                        年龄:
                    </td>
                    <td><input id="s5" name="age" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        邮箱:
                    </td>
                    <td><input id="s6" name="email" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        电话:
                    </td>
                    <td><input id="s7" name="phone" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        地址:
                    </td>
                    <td><input id="s8" name="address" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        签名:
                    </td>
                    <td><input id="s9" name="sign" type="text" readonly="true"/></td>
                </tr>
            </table>
        </form>
        <span id="updateUserInfos">
        <a id="updateUserInfo" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-edit',plain:true">修改用户信息</a>
            </span>
        <span id="cancles" hidden>
        <a id="cancle" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">取消</a>
        </span>
        <span id="conf" hidden>
        <a id="confirmUserInfo" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">确定修改</a>
        </span>
    </div>
</div>
</body>