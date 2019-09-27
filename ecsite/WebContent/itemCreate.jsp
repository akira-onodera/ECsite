<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>商品登録</title>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-damily: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
}

h1 {
	text-align: center;
}

h3 {
	text-align: center;
}

#error {
	color: red;
}

#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: black;
}

#main {
	text-align: center;
	width: 100%;
	height: 500px;
}

#footer {
	clear: both;
	width: 100%;
	height: 80px;
	background-color: black;
}
</style>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>商品登録</p>
		</div>
		<div>
			<div id="error">
				<s:if test="errorMessage !=''">
					<s:property value="errorMessage" escape="false" />
				</s:if>
			</div>
			<table>
				<s:form action="ItemCreateConfirmAction">
					<tr>
						<td><label>商品名:</label></td>
						<td><input type="text" name="itemName" value="" /></td>
					</tr>
					<tr>
						<td><label>価格:</label></td>
						<td><input type="text" name="itemPrice" value="" /></td>
					</tr>
					<tr>
						<td><label>在庫数:</label></td>
						<td><input type="text" name="itemStock" value="" /></td>
					</tr>
					<s:submit value="登録" />
				</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span> <a href='<s:url action="AdminAction"/>'>こちら</a>
			</div>
		</div>
	</div>
	<div>
		<div id="footer">
			<div id="pr"></div>
		</div>
	</div>
</body>
</html>