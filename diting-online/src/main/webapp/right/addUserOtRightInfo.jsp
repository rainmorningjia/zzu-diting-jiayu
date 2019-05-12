<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<body>
<script type="text/javascript">

    $(function () {
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
        $("#confirmUserOtRight").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                //提交表单事件
                $("#addUserOtRightForm").form("submit", {
                    url: "${pageContext.request.contextPath}/right/addUserRightInfo",
                    onSubmit: function () {
                        //进行验证
                        return true
                    },
                    success: function (data) {
                        $('#dbOtherRight').datagrid('reload');
                        //关闭对话框
                        $("#addAuthenDia").dialog("close");
                        //调出系统提示框
                        $.messager.show({
                            title: "添加成功",
                            msg: "恭喜！填写认证信息成功，请等待审核！",

                        });

                    }
                })
            },


        });

        $("#isRightEntrusted3").combobox({
            panelHeight: 50,
            onSelect: function (val) {
                console.info(val)
                if (val.text === "是") {

                    $("#attorneyAttributeT3").removeAttr("hidden");
                    $("#entrustedProtectionStartdateT3").removeAttr("hidden");
                    $("#entrustedProtectionEnddateT3").removeAttr("hidden");
                    $("#attorneyPowerUrlT3").removeAttr("hidden");
                } else {
                    $("#attorneyAttributeT3").attr("hidden", "hidden");
                    $("#entrustedProtectionStartdateT3").attr("hidden", "hidden");
                    $("#entrustedProtectionEnddateT3").attr("hidden", "hidden");
                    $("#attorneyPowerUrlT3").attr("hidden", "hidden");

                }
            }
        });
        $("#province").combobox({
            url: '${pageContext.request.contextPath}/address/province',
            onSelect: function (rec) {
                var url = '${pageContext.request.contextPath}/address/city?name=' + rec.name;
                $('#country').combobox('reload', url);
            }
        })

    })
</script>

<div>
    <h1>
        添加用户其他权利信息:
    </h1>
    <form id="addUserOtRightForm" method="post" enctype="multipart/form-data">
        <table id="otherRight">
            <tr id="typeO">
                <td>
                    <input id="type3" type="hidden" class="easyui-validatebox" name="copyrightType"
                           value="其他权利" data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    权利名称:
                </td>
                <td>
                    <input id="copyrightName3" type="text" class="easyui-validatebox" name="copyrightName"
                           data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    注册地区:
                </td>
                <td>
                    省份： <input id="province" class="easyui-combobox" name="province"
                               data-options="valueField: 'name',
                             textField: 'name',
                            " style="width:100px"/>
                    城市： <input id="country" class="easyui-combobox" name="country" data-options="valueField:'name',textField:'name'"
                               style="width:100px"/>
                </td>
            </tr>
            <tr>
                <td>
                    知识产权证书:
                </td>
                <td>
                    <input id="intellctualPropertyCertificatesUrl" type="file" class="easyui-validatebox"
                           name="intellctualPropertyCertificatesUrlFile"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    是否被维权委托:
                </td>
                <td>
                    <select id="isRightEntrusted3" class="easyui-combobox" name="isRightEntrusted" style="width:100px;"
                            data-options="panelHeight: 50">
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </td>
            </tr>
            <tr id="attorneyPowerUrlT3" hidden>
                <td>
                    维权委托文件:
                </td>
                <td>
                    <input id="attorneyPowerUrl3" type="file" class="easyui-validatebox" name="attorneyPowerUrlFile"
                           data-options=""/>
                </td>
            </tr>
            <tr id="attorneyAttributeT3" hidden>
                <td>
                    维权属性:
                </td>
                <td>
                    <select id="attorneyAttribute3" class="easyui-combobox" name="attorneyAttribute"
                            style="width:100px;" data-options="required:true,panelHeight: 50">
                        <option value="独家">独家</option>
                        <option value="非独家">非独家</option>
                    </select>
                </td>
            </tr>
            <tr id="entrustedProtectionStartdateT3" hidden>
                <td>
                    维权起始日:
                </td>
                <td>
                    <input id="entrustedProtectionStartdate3" type="text" class="easyui-datebox"
                           name="entrustedProtectionStartdate"
                           data-options="" style="width:150px"/>
                </td>
            </tr>
            <tr id="entrustedProtectionEnddateT3" hidden>
                <td>
                    维权截止日:
                </td>
                <td>
                    <input id="entrustedProtectionEnddate3" type="text" class="easyui-datebox"
                           name="entrustedProtectionEnddate"
                           data-options="" style="width:150px"/>
                </td>
            </tr>
        </table>
        <p>
            <a id="confirmUserOtRight" class="easyui-linkbutton">保存</a>
        </p>
    </form>
</div>
</body>
