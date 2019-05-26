<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>谛听系统主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <script type="text/javascript" src="../JS/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../JS/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../JS/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../JS/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../JS/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../JS/echarts.min.js"></script>
    <script type="text/javascript" src="../JS/china.js"></script>
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
                        var htm = '<div title="Language"  style="overflow:auto;padding:10px; height:150px;">' + '<ul id="tree' + menu.id + '" ></ul>';
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

            })

        })

        function test(id, text) {
            text = "投诉集工单详情";
            var ex = $("#tt").tabs('exists', text);

            if (ex == false) {
                $('#tt').tabs('add', {
                    title: "投诉集工单详情",
                    href: "${pageContext.request.contextPath}/complaintwork/ComplaintWrokDetail.jsp?id=" + id,
                    closable: true,
                });
            } else {
                $('#tt').tabs('select', text);
            }
        }
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        谛听版权投诉系统后台
        欢迎您:<%= request.getSession().getAttribute("name") %>
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

<div data-options="region:'west',title:'导航菜单',split:true" style="width:250px;">
    <div id="aa" class="easyui-accordion" data-options="multiple:true," style="width:500px;">

    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(../images/shouyehuge.jpeg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
<div id="dialogUserRightComplaint"></div>
<div id="userAuthenInfo"></div>
<div id="rejectInfo"></div>
<div id="adoptInfo"></div>
<div id="userRightInfo"></div>
</body>
</html>