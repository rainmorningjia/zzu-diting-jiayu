<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    $(function () {

        //初始化数据表格
        $("#dbOtherRight").edatagrid({
            toolbar: "#tbOtherRight",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/right/userRightInfo?rightType=其他权利",
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
                        $("#ss1" + rowData.id).text("省份: " + message.province);
                        $("#ss2" + rowData.id).text("城市: " + message.country);
                        $("#intellctualPropertyCertificatesUrl").attr("src", message.intellctualPropertyCertificatesUrl);
                        $("#ss4" + rowData.id).text("是否被委托维权: " + message.isRightEntrusted);
                        if (message.isRightEntrusted == "是") {
                            $("#ss5" + rowData.id).text("维权属性: " + message.attorneyAttribute);
                            $("#certificatePositiveP1").attr("src", message.attorneyPowerUrl);
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
                    '<td style="border:0">' +
                    '<p id="ss1' + rowData.id + '" style="font-size:20px">省份: ' + '</p>' +
                    '<p id="ss2' + rowData.id + '" style="font-size:20px">城市: ' + '</p>' +
                    '<p id="ss3' + rowData.id + '"  style="font-size:20px">知识产权证书' + '<img id="intellctualPropertyCertificatesUrl" src="" />' + '</p>' +
                    '<p id="ss4' + rowData.id + '"  style="font-size:20px">是否被委托维权: ' + '</p>' +
                    '<p id="ss5' + rowData.id + '"  style="font-size:20px">维权属性: ' + '</p>' +
                    '<p id="ss6' + rowData.id + '"  style="font-size:20px">委托维权文件' + '<img id="certificatePositiveP1" src="" />' + '</p>' +
                    '<p id="ss7' + rowData.id + '"  style="font-size:20px">起始日: ' + '</p>' +
                    '<p id="ss8' + rowData.id + '"  style="font-size:20px">结束日: ' + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        $("#addOtherRight").linkbutton({
            onClick: function () {
                $("#dialogRight").dialog({
                    title: "添加用户",
                    width: 600,
                    height: 700,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/right/addUserOtRightInfo.jsp",
                    modal: true
                })
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
    //定义下载函数
    /*    $.download = function (url, method, fileDire) {
            var form = jQuery('<form action="' + url + '" method="' + (method || 'post') + '">' +  // action请求路径及推送方法
                '<input type="text" name="filePath" value="' + fileDire + '"/>' + // 文件路径
                '</form>');
            $(document.body).append(form);
            form.submit().remove();
        }*/
</script>
<div>
    <h1 align="center">权利管理</h1>
    <table id="dbOtherRight"></table>
    <div id="tbOtherRight">
        <a id="addOtherRight" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">添加</a>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
    <div id="dialogRight"></div>
</div>