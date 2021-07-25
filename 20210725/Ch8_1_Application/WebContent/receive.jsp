<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>接收訊息</title>

<script>
setInterval(() => {
	// 重新整理頁面
	location.reload(true);
	// 單位是毫秒
}, 2000);

</script>

</head>
<body>
	<h1>	
	<%String msg = (String)application.getAttribute("msg"); %>
	<%=msg == null?"無訊息":msg %>
	</h1>
	<input type="text">
</body>
</html>