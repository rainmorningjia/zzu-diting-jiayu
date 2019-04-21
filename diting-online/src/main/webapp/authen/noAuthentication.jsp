<%--
  Created by IntelliJ IDEA.
  User: 14046
  Date: 2019/4/20
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    $(function () {
        //添加认证信息
        console.info("出来")
        $("#addAuthen").linkbutton({
            onClick: function () {
                $("#addAuthenDia").dialog({
                    title: "添加认证信息",
                    width: 500,
                    height: 600,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/authen/addUserAuthentication.jsp",
                    modal: true,
                    buttons: [{
                        text: "保存",
                        onClick: function () {
                            $("#albumFormAdd").form("submit", {
                                url: "${pageContext.request.contextPath}/userAuthentication/addUserAuthentication",
                                onSubmit: function () {
                                    return true;
                                },
                                success: function () {
                                    $("#addAlbumDia").dialog("close");
                                    $.messager.show({
                                        title: "添加成功",
                                        msg: "恭喜！填写认证信息成功，请等待审核！"
                                    });
                                }
                            })
                        }
                    },
                        {
                            text: "取消",
                            handler: function () {
                                $("#addAuthenDia").dialog("close")
                            }
                        }]
                })
            }
        })
    })
</script>
<div>
    <p align="center" style="color: red;font-family: Arial, Verdana, Sans-serif;font-size: large">
        抱歉，您还未认证&nbsp;&nbsp;</p>
    <div id="tb" align="center">
        <a id="addAuthen" href="#" style="color: blue"
           class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">前往认证</a>
    </div>
    <div id="addAuthenDia"></div>
</div>

