<%-- 
    Document   : search
    Created on : 20/02/2025, 11:45:36 AM
    Author     : HP
--%>

<%@page import="dto.UserDTO"%>
<%@page import="dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%                if (session.getAttribute("user") != null) {
                UserDTO user = (UserDTO) session.getAttribute("user");
        %>
        <h1> Welcome <%=user.getFullName()%> </h1>
        <form action="MainController">
            <input type="hidden" name="action" value="logout"/>
            <input type="submit" value="Logout"/>
        </form>

        <br/>
        <% String searchTerm = request.getAttribute("searchTerm")+"";
           searchTerm = searchTerm.equals("null")?"":searchTerm;
            %>
        <form action="MainController">
            <input type="hidden" name="action" value="search"/>
            Search Books: <input type="text" name="searchTerm" value="<%=searchTerm%>"/>
            <input type="submit" value="Search"/>
        </form>

        <%
            if (request.getAttribute("books") != null) {
                List<BookDTO> books = (List<BookDTO>) request.getAttribute("books");
            
        %>
        <table class="book-table">
            <thead>
                <tr>
                    <th>BookID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>PublishYear</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%            for (BookDTO b : books) {
                %>
                <tr>
                    <td><%=b.getBookID()%></td>
                    <td><%=b.getTitle()%></td>
                    <td><%=b.getAuthor()%></td>
                    <td><%=b.getPublishYear()%></td>
                    <td><%=b.getPrice()%></td>
                    <td><%=b.getQuantity()%></td>
                    <td><a href = "MainController?action=delete
                           &id=<%=b.getBookID()%>">
                            <img src="img/Button-Delete-icon.png" style="height: 25px">
                        </a></td>
                   
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%    }
        } else { %>
        You do not have permission to access this content.
        <%}%>

    </body>
</html>
