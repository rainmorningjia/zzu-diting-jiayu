<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    $(function () {

        //初始化数据表格
        $("#dbRight").edatagrid({
            toolbar: "#tbRight",
            fitColumns: true,
            url: "${pageContext.request.contextPath}/right/userRightInfo",
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
                sortable: true,

            }, {
                field: "name",
                title: "姓名",
                width: 100,
                sortable: true,
                editor: {
                    type: 'text',
                    options: {
                        required: true,
                        missingMessage: '标题必填!'
                    }
                }
            }, {
                field: "reg_date",
                title: "时间",
                width: 100,
                sortable: true,
            },{
                field:"sign",
                title:"标签",
                width:100,
                editor: {
                    type: 'text',
                    options: {
                        textField:"text"
                    }
                }
            },{
                field:"dharma",
                title:"大师",
                width:100,
                editor:{
                    type:"text",
                    options:{

                    }
                }
            },{
                field:"sex",
                title:"性别",
                width:100,
                formatter:function(value,row,index){
                    if (value==1){
                        return "男";
                    } else {
                        return "女";
                    }
                },
                editor: {
                    type: 'combobox',
                    options: {
                        valueField:"sex",
                        textField:"text",
                        data:[{'text':'男','sex':1},{'text':'女','sex':2}],
                        required: true
                    }
                }
            }, {
                field: "status",
                title: "激活状态",
                width: 100,
                formatter: function (value, row, index) {
                    if (value == 1) {
                        return "已激活";
                    } else {
                        return "未激活";
                    }
                },
                editor:{
                    type:"combobox",
                    options:{
                        valueField:"status",
                        data:[{'text':'未激活','status':0},{'text':'激活','status':1}],
                        required:true
                    }
                }

            }]],
            view: detailview,
            //细节展示表
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                /*    '<td rowspan=2 style="border:0"><img src="/imageslun/' + rowData.imagepath + '" style="height:200px;"></td>' + */
                    '<td style="border:0">' +
                    '<p style="font-size:20px">省份: ' + rowData.province + '</p>' +
                    '<p style="font-size:20px">城市: ' + rowData.city + '</p>' +
                    '<p style="font-size:20px">地址: ' + rowData.address + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        $("#addRight").linkbutton({
            onClick: function () {
                $("#dialogRight").dialog({
                    title: "添加用户",
                    width: 500,
                    height: 300,
                    closed: false,
                    cache: false,
                    iconCls: "icon-add",
                    href: "${pageContext.request.contextPath}/right/addUserRightInfo.jsp",
                    modal: true
                })
            }
        })
        //修改时间
        $("#saveRight").linkbutton({
            onClick:function(){
                $("#dbRight").data('isSave',true).edatagrid('saveRow');
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
    <table id="dbRight"></table>
    <div id="tbRight">
        <a id="addRight" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-add',plain:true">添加</a>
<%--        <a id="saveUser" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-edit',plain:true">保存</a>--%>
        <a id="deleteRight" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-remove',plain:true">删除</a>
<%--        <a id="exportUser" class="easyui-linkbutton" href="#"
           data-options="iconCls:'icon-save',plain:true">导出</a>--%>
    </div>
    <div id="dialogRight"></div>
</div>