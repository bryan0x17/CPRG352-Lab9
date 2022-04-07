<%-- 
    Document   : resetNewPassword
    Created on : Apr. 7, 2022, 12:04:53 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Change Password</h1>
        <p>Enter your email and your new password below.</p>
        <form action="reset" method="POST">
            <input type="hidden" name="uuid" id="uuid" value="${uuid}">
            <label for="email">Email: </label>
            <input type="email" name="email" id="email" required>
            <label for="password">New password: </label>
            <input type="password" name="password" id="password" required>
            <button type="submit">Change Password</button>
        </form>
            <p>${message}</p>
            <a href="login">Login</a>
    </body>
</html>
