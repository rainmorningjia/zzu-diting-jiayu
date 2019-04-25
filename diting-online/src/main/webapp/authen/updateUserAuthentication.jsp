<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<body>
<script>
    $(function () {
        $("#userAuthenticationInfoForm").form("load", "${pageContext.request.contextPath}/userAuthentication/userAuthenticationInfo"
        )
        $("#userAuthenticationInfoForm").form({
                onLoadSuccess: function (data) {
                    if (data.type == 1) {
                        document.getElementById("person").style.display = "block";
                        document.getElementById("organization").style.display = "none";
                        $("#certificatePositiveP").prop("src", data.certificatePositiveUrl);
                        $("#certificateOppositeP").prop("src", data.certificateOppositeUrl)
                        $("#certificateHandofP").prop("src", data.certificateHandofUrl)
                    } else {

                        document.getElementById("person").style.display = "none";
                        document.getElementById("organization").style.display = "block";
                        $("#certificatePositiveC").prop("src", data.certificatePositiveUrl);
                    }

                }
            }
        )
        //定义保存按钮
        $("#confirmuserAuthen").linkbutton({
            iconCls: "icon-save",
            //单击保存按钮触发关闭对话框事件
            onClick: function () {
                //关闭表单事件
                $("#addAuthenDia").dialog("close");
            }


        })
    })

</script>
<div>
    <div><p style="font-size: large">用户认证详情</p></div>
    <div>
        <form id="userAuthenticationInfoForm" method="post">
            <table style="display: block" id="person">
                <tr>
                    <td>
                        <input id="type1" type="hidden" class="easyui-validatebox" name="type"
                               value="0" data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        真实姓名:
                    </td>
                    <td>
                        <input id="realNameP" type="text" class="easyui-validatebox" name="realName"
                               data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        手机号:
                    </td>
                    <td>
                        <input id="phoneNumberP" type="text" class="easyui-validatebox" name="phoneNumber"
                               data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        邮箱:
                    </td>
                    <td>
                        <input id="emailP" type="text" class="easyui-validatebox" name="email"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        省份:
                    </td>
                    <td>
                        <input id="signP" type="text" class="easyui-validatebox" name="province"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        城市:
                    </td>
                    <td>
                        <input id="cityP" type="text" class="easyui-validatebox" name="city"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        地区:
                    </td>
                    <td>
                        <input id="areaP" type="text" class="easyui-validatebox" name="area"
                               data-options=""/>
                    </td>
                </tr>

                <tr>
                    <td>
                        证件类型:
                    </td>
                    <td>
                        <input id="certificateTypeP" type="text" class="easyui-validatebox" name="certificateType"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        证件号码:
                    </td>
                    <td>
                        <input id="certificateNumberP" type="text" class="easyui-validatebox" name="certificateNumber"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        身份证正面照:
                    </td>
                    <td><img id="certificatePositiveP" src="" style="width: 120px;height: 200px"></td>

                </tr>
                <tr>
                    <td>
                        身份证反面照:
                    </td>
                    <td>
                        <img id="certificateOppositeP" src="" style="width: 120px;height: 200px">
                    </td>
                </tr>
                <tr>
                    <td>
                        身份证手持照:
                    </td>
                    <td>
                        <img id="certificateHandofP" src="" style="width: 120px;height: 200px">
                    </td>
                </tr>
                <tr>
                    <td>
                        地址:
                    </td>
                    <td>
                        <input id="addressP" type="text" class="easyui-validatebox" name="address"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        邮编:
                    </td>
                    <td>
                        <input id="zipP" type="text" class="easyui-validatebox" name="zip"
                               data-options=""/>
                    </td>
                </tr>
            </table>
            <table style="display: none" id="organization">
                <tr>
                    <td>
                        <input id="type2" type="hidden" class="easyui-validatebox" name="type"
                               value="1" data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        组织名称:
                    </td>
                    <td>
                        <input id="organizationNameC" type="text" class="easyui-validatebox" name="organizationName"
                               data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        省份:
                    </td>
                    <td>
                        <input id="provinceC" type="text" class="easyui-validatebox" name="province"
                               data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        城市:
                    </td>
                    <td>
                        <input id="cityC" type="text" class="easyui-validatebox" name="city"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        地区:
                    </td>
                    <td>
                        <input id="areaC" type="text" class="easyui-validatebox" name="area"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        手机号:
                    </td>
                    <td>
                        <input id="phoneNumberC" type="text" class="easyui-validatebox" name="phoneNumber"
                               data-options="validType:'name',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        邮箱:
                    </td>
                    <td>
                        <input id="emailC" type="text" class="easyui-validatebox" name="email"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        证件类型:
                    </td>
                    <td>
                        <input id="certificateType" type="text" class="easyui-validatebox" name="certificateType"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        证件号码:
                    </td>
                    <td>
                        <input id="certificateNumber" type="text" class="easyui-validatebox" name="certificateNumber"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        证件正面照:
                    </td>
                    <td><img id="certificatePositive" src="" style="width: 120px;height: 200px"></td>
                </tr>
                <tr>
                    <td>
                        机构名:
                    </td>
                    <td>
                        <input id="corporationName" type="text" class="easyui-validatebox" name="corporationName"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        地址:
                    </td>
                    <td>
                        <input id="address" type="text" class="easyui-validatebox" name="address"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        邮编:
                    </td>
                    <td>
                        <input id="zip" type="text" class="easyui-validatebox" name="zip"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        电话:
                    </td>
                    <td>
                        <input id="tel" type="text" class="easyui-validatebox" name="tel"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        fas:
                    </td>
                    <td>
                        <input id="fas" type="text" class="easyui-validatebox" name="fas"
                               data-options=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        relationName:
                    </td>
                    <td>
                        <input id="relationName" type="text" class="easyui-validatebox" name="relationName"
                               data-options=""/>
                    </td>
                </tr>
            </table>
        </form>
        <p>
            <a id="confirmuserAuthen" class="easyui-linkbutton">关闭</a>
        </p>
    </div>
</div>
</body>