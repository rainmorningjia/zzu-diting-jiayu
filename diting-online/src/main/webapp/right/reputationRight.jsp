<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    $(function () {

        //初始化数据表格
        $("#dbReputationRight").edatagrid({
            toolbar: "#tbReputationRight",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/right/userRightInfo?rightType=名誉权/肖像权",
            <%--updateUrl:"${pageContext.request.contextPath}/user/updataUser",--%>
            pagePosition: "bottom",
            pagination: true,
            pageSize: 8,
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
                field: "rightName",
                title: "权利名称",
                width: 100,

            }, {
                field: "rightType",
                title: "权利类型",
                width: 100,

            }, {
                field: "isEntrustedProtection",
                title: "是否被维权委托",
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
                field: "auditResult",
                title: "审核状态",
                width: 100,

            }, {
                field: "reason",
                title: "失败原因",
                width: 100,
            },{
                field: "ss",
                title: "操作",
                width: 100,
                formatter: function (value, row, index) {
                    var id = row.id;
                    var tt=2;
                    if (row.auditResult=="审核中"){
                        return '<a  style="color:blue"  onclick="recall(' + id + ',' + tt + ')' + '">' + '撤回' + '</a>'
                    }
                    if (row.auditResult=="驳回"||row.auditResult=="审核未通过"||row.auditResult=="关闭"){
                        return '<a  style="color:blue"  onclick="resumbit(' + id + ',' + tt + ')' + '">' + '重新发起' + '</a>'
                    }

                }
            }]],
            view: detailview,
            onExpandRow: function (rowIndex, rowData) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/right/getRightDetail?id=" + rowData.id + "&type=" + rowData.rightType,
                    type: "GET",
                    dataType: "json",
                    cache: false,
                    success: function (message) {
                        data = message;
                        $("#proofMaterialUrls2"+ rowData.id).attr("src", message.proofMaterialUrl);

                        $("#ss4" + rowData.id).text("是否被委托维权: " + message.isRightEntrusted);
                        if (message.isRightEntrusted == "是") {
                            $("#ss5" + rowData.id).text("维权属性: " + message.attorneyAttribute);
                            $("#certificate2"+ rowData.id).attr("src", message.attorneyPowerUrl);
                            console.info( message.attorneyPowerUrl);
                            $("#ss7" + rowData.id).text("起始日: " + message.entrustedProtectionStartdate);
                            $("#ss8" + rowData.id).text("结合日: " + message.entrustedProtectionEnddate);
                        } else {
                            $("#ss5" + rowData.id).remove();
                            $("#ss6" + rowData.id).remove();
                            $("#ss7" + rowData.id).remove();
                            $("#ss8" + rowData.id).remove();
                        }

                    }
                })
            },
            //细节展示表
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    /*    '<td rowspan=2 style="border:0"><img src="/imageslun/' + rowData.imagepath + '" style="height:200px;"></td>' + */
                    '<p id="ss3' + rowData.id + '"  style="font-size:20px">证明材料文件' + '<img id="proofMaterialUrls2' + rowData.id + '" src="" style="width: 200px;height: 200px" />' + '</p>' +'</td>'+'</tr>'+'<tr>'+'<td >'+
                    '<p id="ss4' + rowData.id + '"  style="font-size:20px">是否被委托维权: ' + '</p>' +'</td>'+'</tr>'+'<tr>'+'<td >'+
                    '<p id="ss5' + rowData.id + '"  style="font-size:20px">维权属性: ' + '</p>' +'</td>'+'</tr>'+'<tr>'+'<td >'+
                    '<p id="ss6' + rowData.id + '"  style="font-size:20px">委托维权文件' + '<img id="certificate2' + rowData.id + '" src="" style="width: 200px;height: 200px" />' + '</p>' +'</td>'+'</tr>'+'<tr>'+'<td >'+
                    '<p id="ss7' + rowData.id + '"  style="font-size:20px">起始日: ' + '</p>' +'</td>'+'</tr>'+'<tr>'+'<td >'+
                    '<p id="ss8' + rowData.id + '"  style="font-size:20px">结束日: ' + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        $("#addReputationRight").linkbutton({
            onClick: function () {
                $("#dialogReputationRight").dialog({
                    title: "添加用户",
                    width: 600,
                    height: 700,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/right/addUserReRightInfo.jsp",
                    modal: true
                })
            }
        })
        //修改时间
        $("#saveReputationRight").linkbutton({
            onClick: function () {
                $("#dbReputationRight").data('isSave', true).edatagrid('saveRow');
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
        $('#dbReputationRight').datagrid('load',{
            rightId: $('#rightId2').val(),
            rightName: $('#rightName2').val()
        });
    }
</script>
<div>
    <h1 align="center">权利管理</h1>
    <table id="dbReputationRight"></table>
    <div id="tbReputationRight">
        <a id="addReputationRight" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">添加</a>
        <span>ID:</span>
        <input id="rightId2" style="line-height:26px;border:1px solid #ccc">
        <span>权利名称</span>
        <input id="rightName2" style="line-height:26px;border:1px solid #ccc">
        <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
    <div id="dialogReputationRight"></div>
</div>