<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<body>
<script type="text/javascript">
    var id = "<%=request.getParameter("id").toString()%>";
    $(function () {
        $("#updateUserReRightForm").form("load", "${pageContext.request.contextPath}/right/getRightDetail?type=名誉权/肖像权&id="+id
        )
        //标题
        var regs = /^[a-zA-Z\/ ]{2,20}$/;
        var reg = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
        //状态
        var sta = /^[0-1]$/;
        //定义标题验证规则
        $.extend($.fn.validatebox.defaults.rules, {
            name: {
                validator: function (value) {
                    var s = true;
                    return s;

                },
                message: "请输入正确格式"
            },
            status: {
                validator: function (value) {
                    return sta.test(value);
                }
            }

        })

        //定义保存按钮
        $("#confirmUpUserReRight").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                //提交表单事件
                $("#updateUserReRightForm").form("submit", {
                    url: "${pageContext.request.contextPath}/right/resubmit",
                    onSubmit: function () {
                        //进行验证
                        return true
                    },
                    success: function (data) {
                        $('#dbReputationRight').datagrid('reload');
                        //关闭对话框
                        $("#updateRight").dialog("close");
                        //调出系统提示框
                        $.messager.show({
                            title: "修改成功",
                            msg: "恭喜！填写修改信息成功，请等待审核！",

                        });

                    }
                })
            },


        });
        $("#isRightEntrusted2").combobox({
            panelHeight: 50,
            onSelect: function (val) {
                if (val.text === "是") {

                    $("#attorneyAttributeT2").removeAttr("hidden");
                    $("#entrustedProtectionStartdateT2").removeAttr("hidden");
                    $("#entrustedProtectionEnddateT2").removeAttr("hidden");
                    $("#attorneyPowerUrlT3").removeAttr("hidden");
                } else {
                    $("#attorneyAttributeT2").attr("hidden", "hidden");
                    $("#entrustedProtectionStartdateT2").attr("hidden", "hidden");
                    $("#entrustedProtectionEnddateT2").attr("hidden", "hidden");
                    $("#attorneyPowerUrlT2").attr("hidden", "hidden");

                }
            }
        });
    })
</script>

<div>
    <h1>
        添加用户名誉权利信息:
    </h1>
    <form id="updateUserReRightForm" method="post" enctype="multipart/form-data">
        <table id="reputation">
            <tr class="typeR">
                <td>
                    <input id="id2" type="hidden" class="easyui-validatebox" name="id"
                            data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr class="typeR">
                <td>
                    <input id="type2" type="hidden" class="easyui-validatebox" name="copyrightType"
                           value="名誉权/肖像权" data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    权利名称:
                </td>
                <td>
                    <input id="copyrightName2" type="text" class="easyui-validatebox" name="copyrightName"
                           data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    证明材料文件:
                </td>
                <td>
                    <input id="proofMaterialUrl2" type="file" class="easyui-validatebox" name="proofMaterialUrlFile"
                           data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    是否被维权委托:
                </td>
                <td>
                    <select id="isRightEntrusted2" class="easyui-combobox" name="isRightEntrusted" style="width:100px;"
                            data-options="panelHeight: 50">
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </td>
            </tr>
            <tr id="attorneyPowerUrlT2" hidden>
                <td>
                    维权委托文件:
                </td>
                <td>
                    <input id="attorneyPowerUrl2" type="file" class="easyui-validatebox" name="attorneyPowerUrlFile"
                           data-options=""/>
                </td>
            </tr>
            <tr id="attorneyAttributeT2" hidden>
                <td>
                    维权属性:
                </td>
                <td>
                    <select id="attorneyAttribute2" class="easyui-combobox" name="attorneyAttribute"
                            style="width:100px;" data-options="required:true,panelHeight: 50">
                        <option value="独家">独家</option>
                        <option value="非独家">非独家</option>
                    </select>
                </td>
            </tr>
            <tr id="entrustedProtectionStartdateT2" hidden>
                <td>
                    维权起始日:
                </td>
                <td>
                    <input id="entrustedProtectionStartdate2" type="text" class="easyui-datebox"
                           name="entrustedProtectionStartdate"
                           data-options="" style="width:150px"/>
                </td>
            </tr>
            <tr id="entrustedProtectionEnddateT2" hidden>
                <td>
                    维权截止日:
                </td>
                <td>
                    <input id="entrustedProtectionEnddate2" type="text" class="easyui-datebox"
                           name="entrustedProtectionEnddate"
                           data-options="" style="width:150px"/>
                </td>
            </tr>
        </table>
        <p>
            <a id="confirmUpUserReRight" class="easyui-linkbutton">保存</a>
        </p>
    </form>
</div>
</body>
