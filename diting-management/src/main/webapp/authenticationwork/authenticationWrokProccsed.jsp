<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var data;
    $(function () {
        //初始化数据表格
        $("#dbAuthenticationWrokProccesed").edatagrid({
            toolbar: "#tbAuthenticationWrokProccesed",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/authenticationWork/authenticationTable?state=2&searchType=1",
            <%--updateUrl:"${pageContext.request.contextPath}/user/updataUser",--%>
            pagePosition: "bottom",
            pagination: true,
            pageSize: 4,
            cash: false,
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

            },{
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

    })
    function doSearch(){
        $('#dbAuthenticationWrokProccesed').datagrid('load',{
            id: $('#Id2').val(),
            name: $('#Name1').val()
        });
    }
</script>
<div>
    <h1 align="center">已处理认证工单信息</h1>
    <table id="dbAuthenticationWrokProccesed"></table>
    <div id="tbAuthenticationWrokProccesed">
        <span>ID:</span>
        <input id="Id2" style="line-height:26px;border:1px solid #ccc">
        <span>用户昵称</span>
        <input id="Name1" style="line-height:26px;border:1px solid #ccc">
        <a  class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="doSearch()">搜索</a>
        <%--<a id="addAuthenticationWrokProccesed" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">添加</a>--%>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
</div>