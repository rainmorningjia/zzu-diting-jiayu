﻿<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/menu/getAllUserParentMenu",
                data: {},
                dataType: "json",
                success: function (result) {
                    $.each(result, function (ind, menu) {
                        var htm = '<ul id="tree' + menu.id + '" ></ul>';
                        $("#aa").accordion("add", {

                            title: menu.name,
                            content: htm,
                            selected: false,

                            onExpand: function () {
                                $('#tree' + menu.id).tree({
                                    url: "${pageContext.request.contextPath}/menu/queryAllChildrenMenu?parentId=" + menu.id,
                                    loadFilter: function (data) {
                                        if (data.d) {
                                            return data.d;
                                        } else {
                                            return data;
                                        }
                                    },
                                    onClick: function (node) {
                                        var ex = $('#tt').tabs('exists', node.text);

                                        if (ex == false) {
                                            $('#tt').tabs('add', {
                                                title: node.text,
                                                href: "${pageContext.request.contextPath}/"+node.url,
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

            })

        })
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        谛听版权投诉系统
        欢迎您:<shiro:authenticated>[<shiro:principal/>]</shiro:authenticated>
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#"
                                                                                                              class="easyui-linkbutton"
                                                                                                              data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;谛听 moringrain</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true">

    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(image/shouyehuge.jpeg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
<div id="dialogUserRightComplaint"></div>
</body>
</html>