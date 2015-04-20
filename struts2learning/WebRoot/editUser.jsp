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
    
    <title>My JSP 'edit.jsp' starting page</title>
    
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
     <form action="updateUser" method="post">
     	<input type="hidden" name="userId" value="${userId }"/>
   		用户名：<input type="text" name="username" value="${username }"/><br/>
   		   密&nbsp 码：<input type="text" name="password" value="${password}"/><br/>
   		   年&nbsp 龄：<input type="text" name="age" value="${age }"/><br/>
   		   性&nbsp 别：<input type="text" name="sex" value="${sex }"/><br/>
   		<input  type="submit" value="修改"/>
   </form>
  </body>
</html>
