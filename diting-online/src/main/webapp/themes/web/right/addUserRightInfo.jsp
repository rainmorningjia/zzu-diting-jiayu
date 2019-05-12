<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<body>
<script type="text/javascript">
    function show1() {

        document.getElementById("copyright").style.display = "block";

        document.getElementById("reputation").style.display = "none";
        document.getElementById("otherRight").style.display = "none";

    }

    function show2() {

        document.getElementById("copyright").style.display = "none";
        document.getElementById("otherRight").style.display = "none";
        document.getElementById("reputation").style.display = "block";

    }

    function show3() {

        document.getElementById("copyright").style.display = "none";
        document.getElementById("reputation").style.display = "none";
        document.getElementById("otherRight").style.display = "block";

    }

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
        $("#confirmuserAuthen").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发表单提交事件
            onClick: function () {
                //提交表单事件
                $("#addUserAuthenForm").form("submit", {
                    url: "${pageContext.request.contextPath}/userAuthentication/addUserAuthentication",
                    onSubmit: function () {
                        //进行验证
                        return true
                    },
                    success: function (data) {
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
                    $("#copyrightRegistrationFileUrlt1").removeAttr("hidden");
                } else {
                    $("#copyrightRegistrationNumbert1").attr("hidden","hidden");
                    $("#copyrightRegistrationFileUrlt1").attr("hidden","hidden");
                }
            }
        });

    })
</script>

<div>
    <h1>
        添加用户权利信息:
    </h1>
    <button type="button" style="color: salmon" onclick=show1()>著作权</button>
    <button type="button" onclick=show2()>名誉权</button>
    <button type="button" onclick=show3()>其他权利</button>
    <form id="addUserAuthenForm" method="post" enctype="multipart/form-data">
        <table style="display: block" id="copyright">
            <tr>
                <td>
                    <input id="type1" type="hidden" class="easyui-validatebox" name="type"
                           value="1" data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr >
                <td>
                    选择作品类型:
                </td>
                <td>
                    <input id="worksType1" type="text" class="easyui-validatebox" name="worksType"
                           data-options="validType:'name',required:true"/>
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
            <tr id="copyrightRegistrationFileUrlt1" hidden>
                <td >
                    著作权的登记文件:
                </td>
                <td>
                    <input id="copyrightRegistrationFileUrl1" type="file" class="easyui-validatebox"
                           name="copyrightRegistrationFileUrl"
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
                    著作权登记日:
                </td>
                <td>
                    <input id="copyrightRegisterDate1" type="text" class="easyui-validatebox"
                           name="copyrightRegisterDate"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    著作权截止日:
                </td>
                <td>
                    <input id="copyrightVld1" type="text" class="easyui-validatebox" name="copyrightVld"
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
                    <input id="isDistribution1" type="text" class="easyui-validatebox" name="isDistribution"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    著作权属性:
                </td>
                <td>
                    <input id="copyrightAttribute1" type="text" class="easyui-validatebox" name="copyrightAttribute"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    著作权人类型:
                </td>
                <td>
                    <input id="copyrightPersonType1" type="text" class="easyui-validatebox" name="copyrightPersonType"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    证件类型:
                </td>
                <td>
                    <input id="certificateType1" type="text" class="easyui-validatebox" name="certificateType"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    证件号码:
                </td>
                <td>
                    <input id="certificateNumber1" type="text" class="easyui-validatebox" name="certificateNumber"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    身份证正面照:
                </td>
                <td>
                    <input id="certificatePositiveUrl1" type="text" class="easyui-validatebox"
                           name="certificatePositiveUrl"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    权利链文件:
                </td>
                <td>
                    <input id="copyrightDocumentChainUrl1" type="text" class="easyui-validatebox"
                           name="copyrightDocumentChainUrl"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    是否被维权委托:
                </td>
                <td>
                    <input id="isRightEntrusted1" type="text" class="easyui-validatebox" name="isRightEntrusted"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    维权属性:
                </td>
                <td>
                    <input id="attorneyAttribute1" type="text" class="easyui-validatebox" name="attorneyAttribute"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    维权起始日:
                </td>
                <td>
                    <input id="entrustedProtectionStartdate1" type="text" class="easyui-datebox"
                           name="entrustedProtectionStartdate"
                           data-options=""/>
                </td>
            </tr>
            <tr>
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
        <table style="display: none" id="reputation">
            <tr>
                <td>
                    <input id="type2" type="hidden" class="easyui-validatebox" name="type"
                           value="2" data-options="validType:'name',required:true"/>
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
                    <input id="proofMaterialUrl2" type="file" class="easyui-validatebox" name="proofMaterialUrl"
                           data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    是否被维权委托:
                </td>
                <td>
                    <input id="isRightEntrusted2" type="text" class="easyui-validatebox" name="isRightEntrusted"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    维权属性:
                </td>
                <td>
                    <input id="attorneyAttribute2" type="text" class="easyui-validatebox" name="attorneyAttribute"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    委托维权起始日:
                </td>
                <td>
                    <input id="entrustedProtectionStartdate2" type="text" class="easyui-validatebox"
                           name="entrustedProtectionStartdate"
                           data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    委托维权截止日:
                </td>
                <td>
                    <input id="entrustedProtectionEnddate2" type="text" class="easyui-validatebox"
                           name="entrustedProtectionEnddate"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    委托文件:
                </td>
                <td>
                    <input id="attorneyPowerUrl2" type="text" class="easyui-validatebox" name="attorneyPowerUrl"
                           data-options=""/>
                </td>
            </tr>
        </table>
        <table style="display: none" id="otherRight">
            <tr>
                <td>
                    <input id="type3" type="hidden" class="easyui-validatebox" name="type"
                           value="3" data-options="validType:'name',required:true"/>
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
                    <input id="country" type="text" class="easyui-validatebox" name="country"
                           data-options="validType:'name',required:true"/>
                </td>
                <td>
                    <input id="province" type="text" class="easyui-validatebox" name="province"
                           data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    知识产权证书:
                </td>
                <td>
                    <input id="intellctualPropertyCertificatesUrl" type="file" class="easyui-validatebox"
                           name="intellctualPropertyCertificatesUrl"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    是否被维权委托:
                </td>
                <td>
                    <input id="proofMaterialUrl3" type="text" class="easyui-validatebox" name="proofMaterialUrl"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    维权属性:
                </td>
                <td>
                    <input id="attorneyAttribute3" type="text" class="easyui-datebox" name="attorneyAttribute"
                           data-options="validType:'name',required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    委托维权起始日:
                </td>
                <td>
                    <input id="entrustedProtectionStartdate3" type="text" class="easyui-datebox"
                           name="entrustedProtectionStartdate"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    委托维权截止日:
                </td>
                <td>
                    <input id="entrustedProtectionEnddate3" type="text" class="easyui-datebox"
                           name="entrustedProtectionEnddate"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    委托文件:
                </td>
                <td>
                    <input id="attorneyPowerUrl3" type="text" class="easyui-validatebox" name="attorneyPowerUrl"
                           data-options=""/>
                </td>
            </tr>
        </table>
        <p>
            <a id="confirmuserAuthen" class="easyui-linkbutton">保存</a>
        </p>
    </form>
</div>
</body>
