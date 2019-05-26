<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String ss = (String) request.getSession().getAttribute("userHeadIcon"); %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>谛听系统主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/echarts.min.js"></script>
    <script type="text/javascript" src="../js/china.js"></script>
    <script type="text/javascript">
        <!--菜单处理-->
        $(function () {
            var sss = "<%=ss %>";
            $("#headico").attr("src", sss);
            console.info(sss);
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/menu/getAllUserParentMenu",
                data: {},
                dataType: "json",
                success: function (result) {
                    $.each(result, function (ind, menu) {
                        var htm = '<div title="Language"  style="overflow:auto;padding:10px; height:50px;">' + '<ul  id="tree' + menu.id + '" ></ul>' + '</div>';
                        $("#aa").accordion("add", {
                            title: menu.name,
                            multiple: true,
                            content: htm,
                            selected: false,
                            onExpand: function () {
                                $('#tree' + menu.id).tree({
                                    url: "${pageContext.request.contextPath}/menu/queryAllChildrenMenu?parentId=" + menu.id,
                                    loadFilter: function (data) {
                                        if (data.d) {
                                            return data;
                                        } else {
                                            console.info(data)
                                            return data;
                                        }
                                    },
                                    onClick: function (node) {
                                        var ex = $('#tt').tabs('exists', node.text);

                                        if (ex == false) {
                                            $('#tt').tabs('add', {
                                                title: node.text,
                                                href: "${pageContext.request.contextPath}/" + node.url,
                                                closable: true,
                                            });
                                        } else {
                                            $('#tt').tabs('select', node.text);
                                        }
                                    }
                                });
                            }


                        });

                    })

                }

            });
            $("#updateInfo").linkbutton({
                onClick: function () {
                    var ex = $('#tt').tabs('exists', "用户个人信息");

                    if (ex == false) {
                        $('#tt').tabs('add', {
                            title: "用户个人信息",
                            href: "${pageContext.request.contextPath}/authen/userInfo.jsp",
                            closable: true,
                        });
                    } else {
                        $('#tt').tabs('select', "用户个人信息");
                    }
                }
            })

        })

        function recall(id, t) {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/right/recall",
                data: {
                    id: id,
                    t: t
                },
                dataType: "json",
                success: function (data) {
                    if (data.code == 0) {
                        if (t == 2) {
                            $('#dbReputationRight').datagrid('reload');
                        }
                        if (t == 1) {
                            $('#dbCopyRight').datagrid('reload');
                        }
                        if (t == 3) {
                            $('#dbOtherRight').datagrid('reload');
                        }
                        $.messager.show({
                            title: "撤回成功",
                            msg: "撤回成功，该信息已关闭",

                        });
                    }

                }
            })
        };

        function resumbit(id, t) {
            var url;
            if (t == 1) {
                url = "${pageContext.request.contextPath}/right/updateUserCoRightInfo.jsp?id=" + id;
            }
            if (t == 2) {
                url = "${pageContext.request.contextPath}/right/updateUserReRightInfo.jsp?id=" + id;
            }
            if (t == 3) {
                url = "${pageContext.request.contextPath}/right/updateUserOtRightInfo.jsp?id=" + id;
            }
            $("#updateRight").dialog({
                title: "重新发起信息",
                width: 500,
                height: 400,
                closed: false,
                cache: false,
                iconCls: "icon-add",
                href: url,
                modal: true,
                buttons: [
                    {
                        text: "关闭",
                        handler: function () {
                            $("#updateRight").dialog("close")
                        }
                    }]
            })
        };
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:90px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 450px;float:left;padding-left: 20px;padding-top: 10px">
        谛听版权投诉系统
        欢迎您:<shiro:authenticated>[<shiro:principal/>]</shiro:authenticated>
    </div>
    <div style="width: 300px;float:left;padding-top:10px;padding-left: 10px;">
        <img id="headico" src="" style="width: 70px;height: 70px"/>
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        &nbsp;<a href="#" id="updateInfo" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改信息</a>&nbsp;&nbsp;<a
            href="${pageContext.request.contextPath}/user/exitUser"
            class="easyui-linkbutton"
            data-options="iconCls:'icon-01'">退出系统</a>

    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;谛听 moringrain</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:300px;">
    <div id="aa" class="easyui-accordion" data-options="multiple:true," style="width:500px;">

    </div>
    <%--<div class="easyui-accordion" data-options="multiple:true" style="width:500px;">
        <div title="Language" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
            <p>A programming language is a formal language designed to communicate instructions to a machine, particularly a computer. Programming languages can be used to create programs that control the behavior of a machine and/or to express algorithms precisely.</p>
        </div>
        <div title="Java" style="padding:10px">
            <p>Java (Indonesian: Jawa) is an island of Indonesia. With a population of 135 million (excluding the 3.6 million on the island of Madura which is administered as part of the provinces of Java), Java is the world's most populous island, and one of the most densely populated places in the world.</p>
        </div>
        <div title="C#" style="padding:10px;">
            <p>C# is a multi-paradigm programming language encompassing strong typing, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines.</p>
        </div>
        <div title="Ruby" style="padding:10px">
            <p>A dynamic, reflective, general-purpose object-oriented programming language.</p>
        </div>
        <div title="Fortran" stylep="padding:10px">
            <p>Fortran (previously FORTRAN) is a general-purpose, imperative programming language that is especially suited to numeric computation and scientific computing.</p>
        </div>
    </div>--%>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(image/shouyehuge.jpeg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
<div id="dialogUserRightComplaint"></div>
<div id="updateRight"></div>
</body>
</html>