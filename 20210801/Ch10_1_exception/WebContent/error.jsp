<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2><%=request.getAttribute("errorMsg") %></h2></br>
		<img alt="" src="images/<%=request.getAttribute("errorImage") %>">
</body>
</html>