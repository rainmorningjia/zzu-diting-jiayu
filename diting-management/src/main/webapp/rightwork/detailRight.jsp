<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<script>
    var id = "<%=request.getParameter("id").toString()%>";
    $(function () {
        $("#userRight").form("load", "${pageContext.request.contextPath}/rightWork/getDetail?id=" + id
        )
        $("#userRight").form({
                onLoadSuccess: function (data) {
                    if (data.rightType == "著作权") {
                        $("#person").empty();
                        document.getElementById("reputation").style.display = "none";
                        document.getElementById("otherRight").style.display = "none";
                        document.getElementById("copyright").style.display = "block";
                        $("#certificatePositiveUrl1").prop("src", data.certificatePositiveUrl);
                        $("#copyrightDocumentChainUrl1").prop("src", data.copyrightDocumentChainUrl);
                        $("#copyrightRegistrationFileUrl1").prop("src", data.copyrightRegistrationFileUrl);
                        $("#attorneyPowerUrl1").prop("src", data.attorneyPowerUrl);
                        if (data.isRegister === "是") {
                            $("#copyrightRegistrationNumbert1").removeAttr("hidden");
                            $("#copyrightRegisterDatet1").removeAttr("hidden");
                            $("#copyrightVldt1").removeAttr("hidden");
                        } else {
                            $("#copyrightRegistrationNumbert1").attr("hidden", "hidden");
                            $("#copyrightRegisterDatet1").attr("hidden", "hidden");
                            $("#copyrightVldt1").attr("hidden", "hidden");
                        }
                        if (data.isDistribution === "是") {
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
                        if (data.isRightEntrusted === "是") {
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
                    } else if (data.rightType == "其他权利") {
                        if (data.isRightEntrusted === "是") {

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
                        document.getElementById("otherRight").style.display = "block";
                        document.getElementById("reputation").style.display = "none";
                        document.getElementById("copyright").style.display = "none";
                        $("#intellctualPropertyCertificatesUrl").prop("src", data.intellctualPropertyCertificatesUrl);
                        $("#attorneyPowerUrl3").prop("src", data.attorneyPowerUrl);
                    } else {
                        if (data.isRightEntrusted === "是") {
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
                        document.getElementById("reputation").style.display = "block";
                        document.getElementById("otherRight").style.display = "none";
                        document.getElementById("copyright").style.display = "none";
                        $("#proofMaterialUrl2").prop("src", data.proofMaterialUrl);
                        $("#attorneyPowerUrl2").prop("src", data.attorneyPowerUrl);
                    }
                }
            }
        );
        //定义保存按钮
        $("#confirmuserAuthen").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发关闭对话框事件
            onClick: function () {
                //关闭表单事件
                $("#userAuthenInfo").dialog("close");
            }
        })
    })

</script>
<div>
    <div><p style="font-size: large">用户权利详情</p>
        <div>
            <form id="userRight" method="post" enctype="multipart/form-data">
                <table style="display: block" id="copyright">
                    <tr class="typeC">
                        <td>
                            权利类型:
                        </td>
                        <td>
                            <input id="type1" type="text" class="easyui-validatebox" name="copyrightType"
                                   value="著作权" data-options="validType:'name',required:true"/>
                        </td>
                    </tr>
                    <tr >
                        <td>
                            用户类型:
                        </td>
                        <td>
                            <input id="userType1" type="text" class="easyui-validatebox"
                                   name="userType"
                                   data-options=""/>
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
                            作品类型:
                        </td>
                        <td>
                            <input id="worksType1" type="text" class="easyui-validatebox"
                                   name="worksType"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            作品是否已登记:
                        </td>
                        <td>
                            <input id="isRegister1" type="text" class="easyui-validatebox"
                                   name="isRegister"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="copyrightRegistrationNumbert1">
                        <td>
                            著作权登记号:
                        </td>
                        <td>
                            <input id="copyrightRegistrationNumber1" type="text" class="easyui-validatebox"
                                   name="copyrightRegistrationNumber"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="copyrightRegisterDatet1">
                        <td>
                            著作权登记日:
                        </td>
                        <td>
                            <input id="copyrightRegisterDate1" type="text" class="easyui-datebox"
                                   name="copyrightRegisterDate"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="copyrightVldt1">
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
                            <img src="" style="width: 100px;height: 150px" id="copyrightRegistrationFileUrl1">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            作品名称:
                        </td>
                        <td>
                            <input id="copyrightName1" type="text" class="easyui-validatebox" name="rightName"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            著作权人名称:
                        </td>
                        <td>
                            <input id="copyrightPersonName1" type="text" class="easyui-validatebox"
                                   name="copyrightPersonName"
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
                    <tr id="copyrightAttributeT" >
                        <td>
                            著作权属性:
                        </td>
                        <td>
                            <input id="copyrightAttribute1" type="text" class="easyui-validatebox"
                                   name="copyrightAttribute"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="copyrightPersonTypeT">
                        <td>
                            著作权人类型:
                        </td>
                        <td>
                            <input id="copyrightPersonType1" type="text" class="easyui-validatebox"
                                   name="copyrightPersonType"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="certificateTypeT">
                        <td>
                            证件类型:
                        </td>
                        <td>
                            <input id="certificateType1" type="text" class="easyui-validatebox"
                                   name="certificateType"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="certificateNumberT" >
                        <td>
                            证件号码:
                        </td>
                        <td>
                            <input id="certificateNumber1" type="text" class="easyui-validatebox"
                                   name="certificateNumber"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="certificatePositiveUrlT" >
                        <td>
                            证件正面照:
                        </td>
                        <td>
                            <img src="" style="width: 100px;height: 150px" id="certificatePositiveUrl1">
                        </td>
                    </tr>
                    <tr id="copyrightDocumentChainUrlT" >
                        <td>
                            权利链文件:
                        </td>
                        <td>
                            <img src="" style="width: 100px;height: 150px" id="copyrightDocumentChainUrl1">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            是否被维权委托:
                        </td>
                        <td>
                            <input id="isRightEntrusted1" type="text" class="easyui-validatebox"
                                   name="isRightEntrusted"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="attorneyPowerUrlT" >
                        <td>
                            维权委托文件:
                        </td>
                        <td>
                            <img src="" style="width: 100px;height: 150px" id="attorneyPowerUrl1">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            维权属性:
                        </td>
                        <td>
                            <input id="attorneyAttribute1" type="text" class="easyui-validatebox"
                                   name="attorneyAttribute"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="entrustedProtectionStartdateT">
                        <td>
                            维权起始日:
                        </td>
                        <td>
                            <input id="entrustedProtectionStartdate1" type="text" class="easyui-datebox"
                                   name="entrustedProtectionStartdate"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="entrustedProtectionEnddateT">
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
                <table style="display: none" id="otherRight">
                    <tr>
                        <td>
                            权利类型:
                        </td>
                        <td>
                            <input id="type3" type="text" class="easyui-validatebox" name="copyrightType"
                                   value="其他权利" data-options="validType:'name',required:true"/>
                        </td>
                    </tr>
                    <tr >
                        <td>
                            用户类型:
                        </td>
                        <td>
                            <input id="userType3" type="text" class="easyui-validatebox"
                                   name="userType"
                                   data-options=""/>
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
                            省份： <input id="province" class="easyui-validatebox" name="province"
                                       data-options="
                            " style="width:100px"/>
                            城市： <input id="country" class="easyui-validatebox" name="country"
                                       data-options=""
                                       style="width:100px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            知识产权证书:
                        </td>
                        <td>
                            <img src="" id="intellctualPropertyCertificatesUrl" style="width: 100px;height: 120px">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            是否被维权委托:
                        </td>
                        <td>
                            <input id="isRightEntrusted3" type="text" class="easyui-validatebox"
                                   name="isRightEntrusted"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="attorneyPowerUrlT3" >
                        <td>
                            维权委托文件:
                        </td>
                        <td>
                            <img src="" id="attorneyPowerUrl3" style="width: 100px;height: 120px">
                        </td>
                    </tr>
                    <tr id="attorneyAttributeT3" >
                        <td>
                            维权属性:
                        </td>
                        <td>
                            <input id="attorneyAttribute3" type="text" class="easyui-validatebox"
                                   name="attorneyAttribute"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="entrustedProtectionStartdateT3" >
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
                <table style="display: none" id="reputation">
                    <tr class="typeR">
                        <td>
                            权利类型:
                        </td>
                        <td>
                            <input id="type2" type="text" class="easyui-validatebox" name="copyrightType"
                                   value="名誉权/肖像权" data-options="validType:'name',required:true"/>
                        </td>
                    </tr>
                    <tr >
                        <td>
                            用户类型:
                        </td>
                        <td>
                            <input id="userType2" type="text" class="easyui-validatebox"
                                   name="userType"
                                   data-options=""/>
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
                            <img src="" id="proofMaterialUrl2" style="width: 100px;height: 120px">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            是否被维权委托:
                        </td>
                        <td>
                            <input id="isRightEntrusted2" type="text" class="easyui-validatebox"
                                   name="isRightEntrusted"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="attorneyPowerUrlT2" >
                        <td>
                            维权委托文件:
                        </td>
                        <td>
                            <img src="" id="attorneyPowerUrl2" style="width: 100px;height: 120px">
                        </td>
                    </tr>
                    <tr id="attorneyAttributeT2">
                        <td>
                            维权属性:
                        </td>
                        <td>
                            <input id="attorneyAttribute2" type="text" class="easyui-validatebox"
                                   name="attorneyAttribute"
                                   data-options=""/>
                        </td>
                    </tr>
                    <tr id="entrustedProtectionStartdateT2">
                        <td>
                            维权起始日:
                        </td>
                        <td>
                            <input id="entrustedProtectionStartdate2" type="text" class="easyui-datebox"
                                   name="entrustedProtectionStartdate"
                                   data-options="" style="width:150px"/>
                        </td>
                    </tr>
                    <tr id="entrustedProtectionEnddateT2">
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
            </form>
            <p>
                <a id="userRightClose" class="easyui-linkbutton">关闭</a>
            </p>
        </div>
    </div>
</div>