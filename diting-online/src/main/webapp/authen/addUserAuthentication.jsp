<%@page contentType="text/html; charset=UTF-8" %>
<%@page isELIgnored="false" %>
<body>
<script type="text/javascript">
    function show1() {

        document.getElementById("person").style.display = "block";

        document.getElementById("organization").style.display = "none";

    }

    function show2() {

        document.getElementById("person").style.display = "none";

        document.getElementById("organization").style.display = "block";

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


        })

    })
</script>

<div>
    <h1>
        添加用户认证信息:
    </h1>
    <button type="button" style="color: salmon" onclick=show1()>个人</button>
    <button type="button" onclick=show2()>机构</button>
    <form id="addUserAuthenForm" method="post" enctype="multipart/form-data">

        <table style="display: block" id="person">
            <tr>
                <td>
                    <input id="type1" type="hidden"  class="easyui-validatebox" name="authenticationType"
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
                <td>
                    <input id="certificatePositiveP" type="file" class="easyui-validatebox"
                           name="file1"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    身份证反面照:
                </td>
                <td>
                    <input id="certificateOppositeP" type="file" class="easyui-validatebox"
                           name="file2"
                           data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    身份证手持照:
                </td>
                <td>
                    <input id="certificateHandofP" type="file" class="easyui-validatebox" name="file3"
                           data-options=""/>
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
                    <input id="type2" type="hidden"  class="easyui-validatebox" name="authenticationType"
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
                <td>
                    <input id="certificatePositive" type="file" class="easyui-validatebox"
                           name="file1"
                           data-options=""/>
                </td>
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
        <p>
            <a id="confirmuserAuthen" class="easyui-linkbutton">保存</a>
        </p>
    </form>
</div>
</body>
