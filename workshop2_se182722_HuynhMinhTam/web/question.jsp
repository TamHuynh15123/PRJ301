<%-- 
    Document   : question
    Created on : 16/03/2025, 8:34:21 PM
    Author     : HP
--%>

<%@page import="dto.userDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 20px;
            }
            .container {
                max-width: 600px;
                margin: auto;
                background: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
            }
            h2 {
                text-align: center;
                color: #333;
            }
            label {
                display: block;
                margin-top: 15px;
                font-weight: bold;
            }
            input, textarea, select {
                width: 100%;
                padding: 8px;
                margin-top: 5px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            button {
                margin-top: 20px;
                padding: 10px;
                width: 100%;
                background-color: #1f3b50;
                border: none;
                border-radius: 4px;
                color: #fff;
                font-size: 16px;
                cursor: pointer;
            }
            button:hover {
                background-color: #007f66;
            }
            a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #1f3b50; /* Đổi màu theo header */
            font-weight: bold;
            }

            a:hover {
            color: #162b3d; /* Màu tối hơn khi hover */
}
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% if (session.getAttribute("user") != null) {
                userDTO user = (userDTO) session.getAttribute("user");
                if (user.getRole().equals("Instructor")) {
        %>
        <h2>Add a New Question</h2>

        <c:if test="${not empty message}">
            <p>${message}</p>
        </c:if>

        <form action="MainController" method="post" class="container">
            <input type="hidden" name="action" value="addQuestion" />

            

            <label for="question_text">Question Text:</label>
            <textarea id="question_text" name="question_text" rows="4" required></textarea>

            <label for="option_a">Option A:</label>
            <input type="text" id="option_a" name="option_a" required />

            <label for="option_b">Option B:</label>
            <input type="text" id="option_b" name="option_b" required />

            <label for="option_c">Option C:</label>
            <input type="text" id="option_c" name="option_c" required />

            <label for="option_d">Option D:</label>
            <input type="text" id="option_d" name="option_d" required />

            <label class="label">Correct Option (A/B/C/D):</label>
            <select id="correct_option" name="correct_option" required>
                <option value="">--Select--</option>
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
            </select>
            <button type="submit" class="button">Add Question</button>
        </form>

        <a href="MainController?action=viewExamCategories">Back to Exam Categories</a>

        <%}
            }%>
    </body>
</html>
