<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'listAll.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<table width="80%" align="center" border="1">
		<tr>
			<th>username</th>
			<th>password</th>
			<th>age</th>
			<th>registerDate</th>
			<th>update</th>
			<th>delete</th>
		</tr>

		<s:iterator value="#request.list">

			<tr>
				<td><s:a href="getSinglePerson.action?id=1"><s:property value="username"></s:property></s:a></td>
				<td><s:property value="password" /></td>
				<td><s:property value="age" /></td>
				<td><s:property value="registerDate" /></td>
				<td>update</td>
				<td>delete</td>
			</tr>

		</s:iterator>

	</table>

</body>
</html>
