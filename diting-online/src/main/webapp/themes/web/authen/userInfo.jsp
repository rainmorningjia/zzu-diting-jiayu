<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<body>
<script>
    $(function () {
        $("#userForm").form("load", "${pageContext.request.contextPath}/user/getUserInfo"
        )
         $("#userForm").form({
                onLoadSuccess:function (data) {
                    $("#src").prop("src",data.headIconUrl);
            }
            }

        )
    })

</script>
<div align="center">
    <div><p style="font-size: large">用户详情</p></div>
    <div>
        <form id="userForm" method="post">
            <table>
                <tr>
                    <td>
                        姓名:
                    </td>
                    <td><input name="userName" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        性别:
                    </td>
                    <td><input name="sex" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        头像:
                    </td>
                    <  <td><img id="src" src="" style="width: 120px;height: 200px"></td>
                </tr>
                <tr>
                    <td>
                        年龄:
                    </td>
                    <td><input name="age" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        邮箱:
                    </td>
                    <td><input name="email" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        电话:
                    </td>
                    <td><input name="phone" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        地址:
                    </td>
                    <td><input name="sign" type="text" readonly="true"/></td>
                </tr>
                <tr>
                    <td>
                        签名:
                    </td>
                    <td><input name="count" type="text" readonly="true"/></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>