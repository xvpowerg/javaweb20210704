<%@page import="tw.com.bean.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>購買清單</title>
</head>
<body>
	<ol>
	<%
	List<Item> list = 
	(List)request.getAttribute("itemList");
	
	for (Item it:list){
	%>
	<li><%=it%></li>
	
	<%} %>
	</ol>
</body>
</html>