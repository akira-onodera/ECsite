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
<title>管理者画面</title>

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

h1 {
	text-align: center;
	margin: 0 auto;
}
h3{
	text-align: center;
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
	text-align:center;
	width: 100%;
	height: 500px;
}

#left{
	border:solid 1px black;
	display: inline-block;
	text-align:right;
}
#right{
	border:solid 1px black;
	display: inline-block;
	text-align:right;
}

#footer {
	clear:both;
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
			<h1>管理者画面</h1>
		</div>
		<div id="left">
			<h3>商品</h3>

			<s:form action="ItemCreateAction">
				<s:submit value="新規登録" />
			</s:form>
			<s:form action="ItemListAction">
				<s:submit value="一覧" />
			</s:form>

		</div>

		<div id="right">
			<h3>ユーザー</h3>

			<s:form action="UserCreateAction">
				<s:submit value="新規登録" />
			</s:form>
			<s:form action="UserListAction">
				<s:submit value="一覧" />
			</s:form>
		</div>
		<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>