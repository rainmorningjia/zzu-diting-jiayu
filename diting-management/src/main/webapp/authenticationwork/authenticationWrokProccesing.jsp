<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var data;
    $(function () {
        //初始化数据表格
        $("#dbAuthenticationWorkProccesing").edatagrid({
            toolbar: "#tbAuthenticationWrokProccesing",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/authenticationWork/authenticationTable?state=1",
            <%--updateUrl:"${pageContext.request.contextPath}/user/updataUser",--%>
            pagePosition: "bottom",
            pagination: true,
            pageSize: 4,
            cash: false,
            singleSelect:true,
            pageList: [4, 8, 10],
            frozenColumns: [[
                {field: 'ck', checkbox: true}
            ]],
            columns: [[{
                field: "id",
                title: "ID",
                width: 100,

            }, {
                field: "userType",
                title: "用户类型",
                width: 100,

            }, {
                field: "userId",
                title: "用户账号id",
                width: 100,

            }, {
                field: "nickname",
                title: "账号昵称",
                width: 100,

            }, {
                field: "realName",
                title: "名称",
                width: 100,

            }, {
                field: "handlePerson",
                title: "当前处理人",
                width: 100,

            }, {
                field: "auditState",
                title: "处理状态",
                width: 100,

            }, {
                field: "createTime",
                title: "创建时间",
                width: 100,
            }, {
                field: "updateTime",
                title: "更新时间",
                width: 100,
            }]],
            onClickRow: function (index, row) {
                $("#userAuthenInfo").dialog({
                    title: "用户认证信息",
                    width: 500,
                    height: 600,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/authenticationwork/detailAuthentication.jsp?id=" + row.id,
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
        });
        $("#adoptAuthenticationWorkProccessing").linkbutton({
            onClick: function () {
               var s=$("#dbAuthenticationWorkProccesing").edatagrid("getSelected");
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/authenticationWork/adoptWork",
                    data: {
                        "id": s.id,
                    },
                    dataType: "json",
                    success: function () {
                        $("#dbAuthenticationWorkProccesing").edatagrid("reload");
                        $.messager.show({
                            title: '提示信息',
                            msg: '操作成功!'
                        });
                    }
                })
            }
        });
        $("#rejectAuthenticationWork").linkbutton({
            onClick: function () {
                var s=$("#dbAuthenticationWorkProccesing").edatagrid("getSelected");
                $("#rejectInfo").dialog({
                    title: "驳回信息",
                    width: 300,
                    height: 200,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/authenticationwork/rejectAuthenticationWork.jsp?id=" + s.id,
                    modal: true,
                    buttons: [
                        {
                            text: "关闭",
                            handler: function () {
                                $("#rejectInfo").dialog("close")
                            }
                        }]
                })

            }
        })
    })
    function doSearch(){
        $('#dbAuthenticationWorkProccesing').datagrid('load',{
            id: $('#Id1').val(),
            name: $('#Name2').val()
        });
    }
</script>
<div>
    <h1 align="center">处理中认证工单信息</h1>
    <div id="tbAuthenticationWorkProccesing">
        <a id="adoptAuthenticationWorkProccessing" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">通过</a>
        <a id="rejectAuthenticationWork" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-edit',plain:true">驳回</a>
        <span>ID:</span>
        <input id="Id1" style="line-height:26px;border:1px solid #ccc">
        <span>用户昵称</span>
        <input id="Name2" style="line-height:26px;border:1px solid #ccc">
        <a  class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="doSearch()">搜索</a>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
    <table id="dbAuthenticationWorkProccesing"></table>
</div>