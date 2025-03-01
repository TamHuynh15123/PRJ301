<%-- 
    Document   : bookForm
    Created on : 27/02/2025, 11:13:30 AM
    Author     : HP
--%>

<%@page import="dto.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% BookDTO book = new BookDTO();
            try {
                book = (BookDTO) request.getAttribute("book");
            } catch (Exception e) {
                book = new BookDTO();
            }
            if (book == null) {
                book = new BookDTO();
            }
            String txtBookID_error = request.getAttribute("txtBookID_error") + "";
            txtBookID_error = txtBookID_error.equals("null") ? "" : txtBookID_error;
            String txtTitle_error = request.getAttribute("txtTitle_error") + "";
            txtTitle_error = txtTitle_error.equals("null") ? "" : txtTitle_error;
            String txtQuantity_error = request.getAttribute("txtQuantity_error") + "";
            txtQuantity_error = txtQuantity_error.equals("null") ? "" : txtQuantity_error;
        %>
        <h1>Book Information</h1>
        <form action="Maincontroller" method="post">
            <input type="hidden" name="action" value="add"/>
            <label for="txtBookID">Book ID:</label>
            <input type="text" id="txtBookID" name="txtBookID" value="<%=book.getBookID()%>"/>
            <% if (!txtBookID_error.isEmpty()) {%>
            <%=txtBookID_error%>
            <%}%>

            <label for="txtTitle">Title:</label>
            <input type="text" id="txtTile" name="txtTitle" value="<%=book.getTitle()%>"/>
            <% if (!txtTitle_error.isEmpty()) {%>
            <%=txtTitle_error%>
            <%}%>

            <label for="txtAuthor">Author:</label>
            <input type="text" id="txtAuthor" name="txtAuthor" value="<%=book.getAuthor()%>"/>


            <label for="txtPublishYear">Publish Year:</label>
            <input type="number" id="txtPublishYear" name="txtPublishYear" value="<%=book.getPublishYear()%>"/>

            <label for="txtQuantity">Quantity:</label>
            <input type="number" id="txtQuantity" name="txtQuantity" value="<%=book.getQuantity()%>"/>
            <% if (!txtQuantity_error.isEmpty()) {%>
            <div class="error-message"><%=txtQuantity_error%></div>
            <% }%>

            <input type="submit" value="Save" />
            <input type="reset" value="Reset"/>

        </form>
    </body>
</html>
