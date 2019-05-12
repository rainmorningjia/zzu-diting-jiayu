<%--
  Created by IntelliJ IDEA.
  User: 14046
  Date: 2019/4/20
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    $(function () {
        $("#lookUserAuthenInfo").linkbutton({
            onClick: function () {
                alert("????")
                $("#userAuthenInfo").dialog({
                    title: "用户认证信息",
                    width: 500,
                    height: 600,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/authen/detailUserAuthentication.jsp",
                    modal: true,
                    buttons: [
                        {
                            text: "关闭",
                            handler: function () {
                                $("#userAuthenInfo").dialog("close")
                            }
                        }]
                })
            }
        })
    })
</script>
<div align="center">
<p id="authenNoAdopt" style="color: red;font-family: Arial, Verdana, Sans-serif;font-size: large">认证信息审核中</p>
<a id="lookUserAuthenInfo" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查看认证信息</a>
<div id="userAuthenInfo"></div>
</div>

