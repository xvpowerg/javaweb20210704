<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image View</title>
</head>
<body>
		<%
		String imageRoot = application.getInitParameter("image_url_root");
		    List<String> imageList = (List)request.getAttribute("imageList");
		for(String p : imageList){
		%>
			<img height="30%" width="30%" src="/<%=imageRoot%>/<%=p%>"/>
		<%} %>
</body>
</html>