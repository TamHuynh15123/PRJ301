<%-- 
    Document   : example04
    Created on : 10/02/2025, 10:31:04 AM
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
        <% for(int i = 2; i<=9;i++){
            %>
            <span style="font-style: italic">
                <span style="color: blue">Bang cuu chuong <%=i%></span>
            </span><br/>

            <% for(int j =1; j<=10;j++){
                int a=i*j;
                %>
                <%=i%> * <%=j%> = <%=a%><br/>
                <%
            }
        }
%>
    </body>
</html>
