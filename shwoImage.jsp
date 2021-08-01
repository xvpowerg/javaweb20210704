<%-- 
    Document   : shwoImage
    Created on : 2019/8/7, 下午 08:55:30
    Author     : howard
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tw.com.bean.Image,java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%! 
                boolean test1(int value1,int value2){                   
                     return value1 > value2;
               }                
            %>
        
        <% int i =1;        
        for(;i<=2;i++){       
            //JspWriter 等同於 PrintWriter               
        %>
        
        <h1>Hello World!<%=i%> </h1>
        <% } %>
           
        <% 
           List<Image>  list = 
                   ( List<Image> )session.getAttribute("imageList");           
          for(Image im :list){         
        %>
        <img src='imags/<%=im.getName()%>'  alt='<%=im.getAlt()%>' />"
        
        <%}%>
        <h1><%=test1(1,5)%></h1>
        	<%=pageContext.findAttribute("value1") %>
    </body>
</html>
