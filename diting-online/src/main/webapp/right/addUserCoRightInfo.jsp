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
        $("#confirmUserCoRight").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                //提交表单事件
                $("#addUserCoRightForm").form("submit", {
                    url: "${pageContext.request.contextPath}/right/addUserRightInfo",
                    onSubmit: function () {
                        //进行验证
                        return true
                    },
                    success: function (data) {
                        $('#dbCopyRight').datagrid('reload');
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
        $("#isRegister1").combobox({
            panelHeight: 50,
            onSelect: function (val) {
                console.info(val)
                if (val.text === "是") {
                    $("#copyrightRegistrationNumbert1").removeAttr("hidden");
                    $("#copyrightRegisterDatet1").removeAttr("hidden");
                    $("#copyrightVldt1").removeAttr("hidden");
                } else {
                    $("#copyrightRegistrationNumbert1").attr("hidden", "hidden");
                    $("#copyrightRegisterDatet1").attr("hidden", "hidden");
                    $("#copyrightVldt1").attr("hidden", "hidden");
                }
            }
        });

        $("#isDistribution1").combobox({
            panelHeight: 50,
            onSelect: function (val) {
                console.info(val)
                if (val.text === "是") {

                    $("#copyrightAttributeT").removeAttr("hidden");
                    $("#copyrightPersonTypeT").removeAttr("hidden");
                    $("#certificateTypeT").removeAttr("hidden");
                    $("#certificateNumberT").removeAttr("hidden");
                    $("#certificatePositiveUrlT").removeAttr("hidden");
                    $("#copyrightDocumentChainUrlT").removeAttr("hidden");
                } else {
                    $("#copyrightAttributeT").attr("hidden", "hidden");
                    $("#copyrightPersonTypeT").attr("hidden", "hidden");
                    $("#certificateTypeT").attr("hidden", "hidden");
                    $("#certificateNumberT").attr("hidden", "hidden");
                    $("#certificatePositiveUrlT").attr("hidden", "hidden");
                    $("#copyrightDocumentChainUrlT").attr("hidden", "hidden");
                }
            }
        });
        $("#isRightEntrusted1").combobox({
            panelHeight: 50,
            onSelect: function (val) {
                console.info(val)
                if (val.text === "是") {

                    $("#attorneyAttributeT").removeAttr("hidden");
                    $("#entrustedProtectionStartdateT").removeAttr("hidden");
                    $("#entrustedProtectionEnddateT").removeAttr("hidden");
                    $("#attorneyPowerUrlT").removeAttr("hidden");
                } else {
                    $("#attorneyAttributeT").attr("hidden", "hidden");
                    $("#entrustedProtectionStartdateT").attr("hidden", "hidden");
                    $("#entrustedProtectionEnddateT").attr("hidden", "hidden");
                    $("#attorneyPowerUrlT").attr("hidden", "hidden");

                }
            }
        });
        $("#isRightEntrusted2").combobox({
            panelHeight: 50,
            onSelect: function (val) {
                console.info(val)
                if (val.text === "是") {

                    $("#attorneyAttributeT2").removeAttr("hidden");
                    $("#entrustedProtectionStartdateT2").removeAttr("hidden");
                    $("#entrustedProtectionEnddateT2").removeAttr("hidden");
                    $("#attorneyPowerUrlT2").removeAttr("hidden");
                } else {
                    $("#attorneyAttributeT2").attr("hidden", "hidden");
                    $("#entrustedProtectionStartdateT2").attr("hidden", "hidden");
                    $("#entrustedProtectionEnddateT2").attr("hidden", "hidden");
                    $("#attorneyPowerUrlT2").attr("hidden", "hidden");

                }
            }
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
        添加用户著作权利信息:
    </h1>
    <form id="addUserCoRightForm" method="post" enctype="multipart/form-data">
        <table style="display: block" id="copyright">
            <tr class="typeC">
                <td>
                    <input id="type1" type="hidden" class="easyui-validatebox" name="copyrightType"
                           value="著作权" data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    作品名称:
                </td>
                <td>
                    <input id="worksName" type="text" class="easyui-validatebox"
                           name="worksName"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    选择作品类型:
                </td>
                <td>
                    <select id="worksType1" class="easyui-combobox" name="worksType" style="width:100px;"
                            data-options="required:true,panelHeight: 50">
                        <option value="视频">视频</option>
                        <option value="文件">文件</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    作品是否已登记:
                </td>
                <td>
                    <select id="isRegister1" class="easyui-combobox" name="isRegister" style="width:100px;">
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </td>
            </tr>
            <tr id="copyrightRegistrationNumbert1" hidden>
                <td>
                    著作权登记号:
                </td>
                <td>
                    <input id="copyrightRegistrationNumber1" type="text" class="easyui-validatebox"
                           name="copyrightRegistrationNumber"
                           data-options=""/>
                </td>
            </tr>
            <tr id="copyrightRegisterDatet1" hidden>
                <td>
                    著作权登记日:
                </td>
                <td>
                    <input id="copyrightRegisterDate1" type="text" class="easyui-datebox"
                           name="copyrightRegisterDate"
                           data-options=""/>
                </td>
            </tr>
            <tr id="copyrightVldt1" hidden>
                <td>
                    著作权截止日:
                </td>
                <td>
                    <input id="copyrightVld1" type="text" class="easyui-datebox" name="copyrightVld"
                           data-options=""/>
                </td>
            </tr>
            <tr id="copyrightRegistrationFileUrlt1">
                <td>
                    著作权的登记文件:
                </td>
                <td>
                    <input id="copyrightRegistrationFileUrl1" type="file" class="easyui-validatebox"
                           name="copyrightRegistrationFileUrlFile"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    作品名称:
                </td>
                <td>
                    <input id="copyrightName1" type="text" class="easyui-validatebox" name="copyrightName"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    著作权人名称:
                </td>
                <td>
                    <input id="copyrightPersonName1" type="text" class="easyui-validatebox" name="copyrightPersonName"
                           data-options=""/>
                </td>
            </tr>

            <tr>
                <td>
                    导演信息:
                </td>
                <td>
                    <input id="directorInfo1" type="text" class="easyui-validatebox"
                           name="directorInfo"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    主演信息:
                </td>
                <td>
                    <input id="performerMainInfo1" type="text" class="easyui-validatebox"
                           name="performerMainInfo"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    作品属性:
                </td>
                <td>
                    <input id="worksAttribute1" type="text" class="easyui-validatebox" name="worksAttribute"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    作品集数:
                </td>
                <td>
                    <input id="worksNumber1" type="text" class="easyui-validatebox" name="worksNumber"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    作品信息可参考网址:
                </td>
                <td>
                    <input id="consultUrl1" type="text" class="easyui-validatebox" name="consultUrl"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    是否分销获得权利:
                </td>
                <td>
                    <select id="isDistribution1" class="easyui-combobox" name="isDistribution" style="width:100px;">
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </td>
            </tr>
            <tr id="copyrightAttributeT" hidden>
                <td>
                    著作权属性:
                </td>
                <td>
                    <select id="copyrightAttribute1" class="easyui-combobox" name="copyrightAttribute"
                            style="width:100px;"
                            data-options="panelHeight: 50">
                        <option value="独家">独家</option>
                        <option value="非独家">非独家</option>
                    </select>
                </td>
            </tr>
            <tr id="copyrightPersonTypeT" hidden>
                <td>
                    著作权人类型:
                </td>
                <td>
                    <select id="copyrightPersonType1" class="easyui-combobox" name="copyrightPersonType"
                            style="width:100px;"
                            data-options="panelHeight: 50">
                        <option value="个人">个人</option>
                        <option value="企业机构">企业机构</option>
                    </select>
                </td>
            </tr>
            <tr id="certificateTypeT" hidden>
                <td>
                    证件类型:
                </td>
                <td>
                    <select id="certificateType1" class="easyui-combobox" name="certificateType" style="width:100px;"
                            data-options="panelHeight: 50">
                        <option value="身份证">身份证</option>
                        <option value="护照">护照</option>
                    </select>
                </td>
            </tr>
            <tr id="certificateNumberT" hidden>
                <td>
                    证件号码:
                </td>
                <td>
                    <input id="certificateNumber1" type="text" class="easyui-validatebox" name="certificateNumber"
                           data-options=""/>
                </td>
            </tr>
            <tr id="certificatePositiveUrlT" hidden>
                <td>
                    证件正面照:
                </td>
                <td>
                    <input id="certificatePositiveUrl1" type="file" class="easyui-validatebox"
                           name="certificatePositiveUrlFile"
                           data-options=""/>
                </td>
            </tr>
            <tr id="copyrightDocumentChainUrlT" hidden>
                <td>
                    权利链文件:
                </td>
                <td>
                    <input id="copyrightDocumentChainUrl1" type="file" class="easyui-validatebox"
                           name="copyrightDocumentChainUrlFile"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    是否被维权委托:
                </td>
                <td>
                    <select id="isRightEntrusted1" class="easyui-combobox" name="isRightEntrusted" style="width:100px;"
                            data-options="panelHeight: 50">
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </td>
            </tr>
            <tr id="attorneyPowerUrlT" hidden>
                <td>
                    维权委托文件:
                </td>
                <td>
                    <input id="attorneyPowerUrl1" type="file" class="easyui-validatebox" name="attorneyPowerUrlFile"
                           data-options=""/>
                </td>
            </tr>
            <tr id="attorneyAttributeT" hidden>
                <td>
                    维权属性:
                </td>
                <td>
                    <select id="attorneyAttribute1" class="easyui-combobox" name="attorneyAttribute"
                            style="width:100px;" data-options="required:true,panelHeight: 50">
                        <option value="独家">独家</option>
                        <option value="非独家">非独家</option>
                    </select>
                </td>
            </tr>
            <tr id="entrustedProtectionStartdateT" hidden>
                <td>
                    维权起始日:
                </td>
                <td>
                    <input id="entrustedProtectionStartdate1" type="text" class="easyui-datebox"
                           name="entrustedProtectionStartdate"
                           data-options=""/>
                </td>
            </tr>
            <tr id="entrustedProtectionEnddateT" hidden>
                <td>
                    维权截止日:
                </td>
                <td>
                    <input id="entrustedProtectionEnddate1" type="text" class="easyui-datebox"
                           name="entrustedProtectionEnddate"
                           data-options=""/>
                </td>
            </tr>
        </table>
        <p>
            <a id="confirmUserCoRight" class="easyui-linkbutton">保存</a>
        </p>
    </form>
</div>
</body>
