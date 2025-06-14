<%-- 
    Document   : login
    Created on : 14/03/2025, 10:06:51 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        /* Định dạng toàn bộ trang */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(to right, #3498db, #8e44ad);
        }

        .login-container {
            width: 400px;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            animation: fadeIn 0.8s ease-in-out;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .login-container h2 {
            color: #333;
            margin-bottom: 20px;
        }

        .login-container input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
            transition: 0.3s;
        }

        .login-container input:focus {
            border-color: #3498db;
            outline: none;
            box-shadow: 0px 0px 5px rgba(52, 152, 219, 0.5);
        }

        .login-container input[type="submit"] {
            background: #3498db;
            color: white;
            font-size: 18px;
            font-weight: bold;
            cursor: pointer;
            border: none;
            transition: 0.3s;
        }

        .login-container input[type="submit"]:hover {
            background: #2980b9;
            transform: scale(1.05);
        }

        .error-message {
            color: red;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>

    </head>

    <body>
        <div class="login-container">
        <h2>Login to Exam System</h2>
        <%
                String message = request.getAttribute("message") + "";
                message = message.equals("null") ? "" : message;
            %>
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="login">
            <label>Username:</label> <input type="text" name="txtUserID" required><br>
            <label>Password:</label> <input type="password" name="txtPassword" required><br>
            <input type="submit" value="Login">
        </form>
        <p style="color:red;">${requestScope.message}</p>
        </div>
    </body>
</html>
