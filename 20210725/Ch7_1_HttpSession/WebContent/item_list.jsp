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
		List<String> list = (List)session.getAttribute("itemList");
		//for(int i=1;i<=10;i++){
		for(String i : list){
		%>
			<li><%=i%></li>			
		<%} %>
	</ol>
</body>
</html>