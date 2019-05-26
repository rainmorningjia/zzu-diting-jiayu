<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    $(function () {
        //初始化数据表格
        $("#dbUserComplaintReputationRight").edatagrid({
            toolbar: "#tbUserComplaintReputationRight",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/userComplaint/getUserCompliant?rightType=名誉权/肖像权",
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
                field: "complaintPlatform",
                title: "投诉品台",
                width: 100,

            }, {
                field: "rightName",
                title: "权利名称",
                width: 100,

            }, {
                field: "copyrightType",
                title: "权利类型",
                width: 100,

            }, {
                field: "complaintsUrl",
                title: "投诉链接",
                width: 100,

            }, {
                field: "processState",
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

            }, {
                field: "reason",
                title: "失败原因",
                width: 100,
            }]]
        });
        $("#addUserComplaintReputationRight").linkbutton({
            onClick: function () {
                $("#dialogUserRightComplaint").dialog({
                    title: "添加用户",
                    width: 600,
                    height: 300,
                    closed: false,
                    cache: true,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/usercomplaint/addUserComplaint.jsp",
                    modal: true
                })
            }
        })
        //修改时间
        $("#saveUserComplaintReputationRight").linkbutton({
            onClick: function () {
                $("#dbUserComplaintReputationRight").data('isSave', true).edatagrid('saveRow');
            }
        })
        //导出用户Excle表格
        /*        $("#exportUser").click(function (e) {
                    e.preventDefault();
                    $.ajax({
                        type: "post",
                        url: "/chapter/downT",
                        dataType: "json",
                        data: {},
                        success:function () {
                            $.download("/chapter/exportUser","post","")

                        }
                    })
                })*/
    })
    function doSearch(){
        $('#dbUserComplaintReputationRight').datagrid('load',{
            id: $('#id3').val(),
            rightName: $('#rightNames3').val(),
            complaintUrl: $('#complaintUrl3').val(),
        });
    }
</script>
<div>
    <h1 align="center">名誉权投诉信息</h1>
    <table id="dbUserComplaintReputationRight"></table>
    <div id="tbUserComplaintReputationRight">
        <a id="addUserComplaintReputationRight" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">添加</a>
        <span>ID:</span>
        <input id="id3" style="line-height:26px;border:1px solid #ccc">
        <span>权利名称</span>
        <input id="rightNames3" style="line-height:26px;border:1px solid #ccc">
        <span>投诉链接</span>
        <input id="complaintUrl3" style="line-height:26px;border:1px solid #ccc">
        <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
</div>