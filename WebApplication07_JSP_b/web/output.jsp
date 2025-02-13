<%-- 
    Document   : output
    Created on : 10/02/2025, 11:06:44 AM
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
        <%--Bang cuu Chuong --%>
        
        <%
            int n = (int) request.getAttribute("n");
        %>
        <h3>Bang Cuu Chuong <%=n%></h3>
        <%
            for (int j = 1; j <= 10; j++) {
        %>
        <%=n%> * <%=j%> = <%=(n * j)%><br/>
        <%
            }
        %>

        <%--Check so chan,le
        <%
            int n = (int) request.getAttribute("n");
            %>
        <%
            if (n % 2 == 0) {
        %>
        <b><%=n%> la so chan!</b>
        <%
        } else {
        %>
        <b><%=n%> la so le</b>
        <%
        }
        %>
        --%>
    </body>
</html>
