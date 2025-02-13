<%-- 
    Document   : example01
    Created on : 10/02/2025, 9:59:17 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! int a=9;%>
        <% 
            double b;
            b=Math.sqrt(a);
        %>
    <h1>Ket qua: sqrt(<%=a%>) = <span style="color:red"><%=b%></span></h1>

    </body>
</html>
