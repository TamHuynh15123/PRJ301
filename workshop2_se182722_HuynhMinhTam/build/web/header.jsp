<%-- 
    Document   : header
    Created on : 14/03/2025, 8:55:46 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            /* Header Styles */
            .user-section {
                display: flex;
                justify-content: space-between;
                align-items: center;
                background: #2c3e50;
                padding: 15px 20px;
                color: white;
                border-bottom: 3px solid #3498db;
                font-size: 18px;
            }

            .welcome-text {
                font-weight: bold;
            }

            .user-name {
                color: #f1c40f;
                font-weight: bold;
            }

            /* Logout Button */
            .logout-btn {
                background: #e74c3c;
                color: white;
                border: none;
                padding: 8px 15px;
                font-size: 16px;
                border-radius: 5px;
                cursor: pointer;
                transition: 0.3s;
            }

            .logout-btn:hover {
                background: #c0392b;
            }
        </style>
        <c:if test="${not empty sessionScope.user}">
            <div class="user-section">
                <span class="welcome-text">Welcome, <span class="user-name">${user.name}</span>!</span>
                <form action="MainController" method="post" style="margin: 0;">
                    <input type="hidden" name="action" value="logout"/>
                    <input type="submit" value="Log out" class="logout-btn"/>
                </form>
            </div>
        </c:if>
    </body>
</html>
