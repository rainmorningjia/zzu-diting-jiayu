<%@page contentType="text/html;charset=utf-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>用户注册</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
		<script type="text/javascript">
			$(function () {
				$("#captchaImage").click(function () {//点击更换验证码
					$("#captchaImage").prop("src", "${pageContext.request.contextPath}/img/createImg?time=" + new Date());
				});
			})
		</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2019/4/14
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="${pageContext.request.contextPath}/login.jsp">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="${pageContext.request.contextPath}/user/addUser" enctype="multipart/form-data" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="userName" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									手机号:
								</td>
								<td valign="middle" align="left">
									<input type="phone" class="inputgri" name="phone" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									头像
								</td>
								<td valign="middle" align="left">
									<input type="file" class="inputgri" name="file" value="上传" />				
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									邮箱
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="email" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别
								</td>
								<td valign="middle" align="left">
									<select name="sex">
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									地址
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="address" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									签名
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="sign" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/img/createImg"
										 title="点击更换验证码"/>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="code" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
