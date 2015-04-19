<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showUser.jsp' starting page</title>
    
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
  <s:debug></s:debug>
    <table border="1px">
    	<tr>
    		<td>用户ID</td>
    		<td>用户名</td>
    		<td>密码</td>
    		<td>年龄</td>
    		<td>性别</td>
    		<td>修改</td>
    		<td>删除</td>
    	</tr>
    	<s:iterator value="#session.allUser">
    		<tr>
    		<td><s:property value="userId"/></td>
    		<td><s:property value="username"/></td>
    		<td><s:property value="password"/></td>
    		<td><s:property value="age"/></td>
    		<td><s:property value="sex"/></td>
    		<td><a href="#">修改</a></td>
    		<td><a href="deleteUser?userId=${userId }">删除</a></td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
