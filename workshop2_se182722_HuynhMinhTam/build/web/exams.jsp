<%-- 
    Document   : exams
    Created on : 14/03/2025, 10:34:26 AM
    Author     : HP
--%>

<%@page import="dto.userDTO"%>
<%@page import="dto.ExamCategoriesDTO"%>
<%@page import="utils.AuthUtils"%>
<%@page import="dto.ExamsDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%
            userDTO user = (userDTO) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        
        <div class="container">
            
            <c:choose> 
                
                <c:when test="${test eq 'categories'}">
                    
                    <h2>Exam Categories</h2>
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Category_Name</th>
                            <th>Description</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="c" items="${list}">
                            <tr>
                                <td>${c.categoryId}</td>
                                <td>${c.categoryName}</td>
                                <td>${c.description}</td>
                                <td>
                                    <% if (user.getRole().equalsIgnoreCase("Student")) {%>
                                    <a href="MainController?action=viewExamsByCategory&categoryId=${c.categoryId}">View</a>
                                    <% } else {%>
                                    <a href="MainController?action=addQuestion&categoryId=${c.categoryId}">Add Question</a>
                                    <% }%>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br>
                    <% if (!user.getRole().equalsIgnoreCase("Student")) { %>
                    <button type="button" class="btn" onclick="window.location.href = 'create.jsp'">Add New Exam</button>
                    <% } %>


                </c:when>

                <c:when test="${test eq 'exams'}">

                    <h2>Exams by Category</h2>
                    <table>
                        <tr>
                            <th>Exam Title</th>
                            <th>Subject</th>
                            <th>Total Marks</th>
                            <th>Duration</th>
                        </tr>
                        <c:forEach var="exam" items="${exams}">
                            <tr>
                                <td>${exam.examTitle}</td>
                                <td>${exam.subject}</td>
                                <td>${exam.totalMarks}</td>
                                <td>${exam.duration}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br>
                    <a href="MainController?action=viewExamCategories">Back to Categories</a>




                </c:when>

            </c:choose>
        </div>
    </body>
</html>
