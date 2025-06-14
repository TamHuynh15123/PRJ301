<%-- 
    Document   : create
    Created on : 16/03/2025, 12:41:53 PM
    Author     : HP
--%>

<%@page import="dto.ExamCategoriesDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.userDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% if (session.getAttribute("user") != null) {
                userDTO user = (userDTO) session.getAttribute("user");
                if (user.getRole().equals("Instructor")) {
        %>
        <div class="container">
        <h2>Create New Exam</h2>

        <%-- Hiển thị thông báo lỗi nếu có --%>
        <p class="form-error">
            <%= (request.getAttribute("message") != null) ? request.getAttribute("message") : ""%>
        </p>
        <div class="form-container">
        <form action="MainController" method="POST">
            <input type="hidden" name="action" value="createExam">

            <label class="form-label">Exam Title:</label>
            <input class="form-input" type="text" name="examTitle" value="<%= (request.getAttribute("examTitle") != null) ? request.getAttribute("examTitle") : ""%>">
            <span style="color:red;"><%= (request.getAttribute("examTitleError") != null) ? request.getAttribute("examTitleError") : ""%></span>
            <br>

            <label class="form-label">Subject:</label>
            <input class="form-input" type="text" name="subject" value="<%= (request.getAttribute("subject") != null) ? request.getAttribute("subject") : ""%>">
            <span class="form-error""><%= (request.getAttribute("subjectError") != null) ? request.getAttribute("subjectError") : ""%></span>
            <br>

            <label class="form-label">Category:</label>
            <select class="form-input" name="categoryId">
                <option value="">-- Select Category --</option>
                <%
                    List<ExamCategoriesDTO> categories = (List<ExamCategoriesDTO>) request.getAttribute("categories");
                    if (categories != null) {
                        for (ExamCategoriesDTO category : categories) {
                            String selected = (request.getAttribute("categoryId") != null
                                    && request.getAttribute("categoryId").equals(String.valueOf(category.getCategoryId())))
                                    ? "selected" : "";
                %>
                <option value="<%= category.getCategoryId()%>" <%= selected%>><%= category.getCategoryName()%></option>
                <%
                        }
                    }
                %>
            </select>
            <span class="form-error""><%= (request.getAttribute("categoryError") != null) ? request.getAttribute("categoryError") : ""%></span>
            <br>

            <label class="form-label">Total Marks:</label>
            <input class="form-input" type="number" name="totalMarks" min="1" max="10" value="<%= (request.getAttribute("totalMarks") != null) ? request.getAttribute("totalMarks") : ""%>">
            <span class="form-error"><%= (request.getAttribute("totalMarksError") != null) ? request.getAttribute("totalMarksError") : ""%></span>
            <br>

            <label class="form-label">Duration (minutes):</label>
            <input class="form-input" type="number" name="duration" min="15" value="<%= (request.getAttribute("duration") != null) ? request.getAttribute("duration") : ""%>">
            <span class="form-error"><%= (request.getAttribute("durationError") != null) ? request.getAttribute("durationError") : ""%></span>
            <br>

            <button type="submit">Create Exam</button>
        </form>
            </div>

        <br>
        <a href="MainController?action=viewExamCategories">Back to Exam Categories</a>
        </div>
        <%} else {%>
        <div class="container">
        <h1>403 Error</h1>
        <p>You do not have permission to access this content!</p>
        <a href="MainController?action=viewExamCategories" class="back-link">Back to List</a>
        </div>
        <%}
        } else {%>
        <div class="container">
        <h1>Access Denied</h1>
        <p>Please log in to access this page.</p>
        <a href="login.jsp" class="back-link">Go to Login</a>
        </div>
        <%}%>
    </body>
</html>
