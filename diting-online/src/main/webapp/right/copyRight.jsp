<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var data;
    $(function () {
        //初始化数据表格
        $("#dbCopyRight").edatagrid({
            toolbar: "#tbCopyRight",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/right/userRightInfo?rightType=著作权",
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
                        $("#ss1" + rowData.id).text("作品类型: " + message.worksType);
                        $("#ss2" + rowData.id).text("证件类型: " + message.certificateType);
                        $("#ss3" + rowData.id).text("导演信息: " + message.directorInfo);
                        $("#ss4" + rowData.id).text("主演信息: " + message.performerMainInfo);
                        $("#ss5" + rowData.id).text("作品属性: " + message.worksAttribute);
                        $("#ss6" + rowData.id).text("作品相关网址: " + message.consultUrl);
                    }
                })
            },
            //细节展示表
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    /*    '<td rowspan=2 style="border:0"><img src="/imageslun/' + rowData.imagepath + '" style="height:200px;"></td>' + */
                    '<td style="border:0">' +
                    '<p id="ss1' + rowData.id + '" style="font-size:20px">作品类型: ' + '</p>' +
                    '<p id="ss2' + rowData.id + '" style="font-size:20px">证件类型: ' + '</p>' +
                    '<p id="ss3' + rowData.id + '"  style="font-size:20px">导演信息: ' + '</p>' +
                    '<p id="ss4' + rowData.id + '"  style="font-size:20px">主演信息: ' + '</p>' +
                    '<p id="ss5' + rowData.id + '"  style="font-size:20px">作品属性: ' + '</p>' +
                    '<p id="ss6' + rowData.id + '"  style="font-size:20px">作品相关网址: ' + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        $("#addCopyRight").linkbutton({
            onClick: function () {
                $("#dialogCopyRight").dialog({
                    title: "添加用户",
                    width: 600,
                    height: 700,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/right/addUserCoRightInfo.jsp",
                    modal: true
                })
            }
        })
        //修改时间
        $("#saveCopyRight").linkbutton({
            onClick: function () {
                $("#dbCopyRight").data('isSave', true).edatagrid('saveRow');
            }
        })
        //点击删除事件
        $("#deleteRight").linkbutton({
            onClick: function () {
                var arr = $('#dbImg').datagrid('getSelections');
                if (arr.length <= 0) {
                    $.messager.show({
                        title: '提示信息',
                        msg: '请选择进行删除操作!'
                    });
                } else {
                    $.messager.confirm('提示信息', '确认删除?', function (r) {
                        if (r) {
                            var ids = '';
                            for (var i = 0; i < arr.length; i++) {
                                ids += arr[i].id + ',';
                            }
                            ids = ids.substring(0, ids.length - 1);
                            $.post('${pageContext.request.contextPath}/image/deleteImage', {ids: ids}, function () {
                                $('#dbImg').datagrid('reload');
                                $.messager.show({
                                    title: '提示信息',
                                    msg: '操作成功!'
                                });
                            });
                        } else {
                            return;
                        }
                    });
                }
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
    <table id="dbCopyRight"></table>
    <div id="tbCopyRight">
        <a id="addCopyRight" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">添加</a>
        <%--        <a id="saveUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <%--        <a id="exportUser" class="easyui-linkbutton" href="#"
                   data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
    <div id="dialogCopyRight"></div>
</div>