<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>

<body>
<div>
    <form:form method="POST" modelAttribute="userForm">
        <div align="right">
            <a href="/" >Главная</a>
        </div>
        <h2 align="center">Регистрация</h2>

        <div align="center">
            <form:input type="text" path="username" placeholder="Username"
                        autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
                ${usernameError}
        </div>
        <div align="center">
            <form:input type="password" path="password" placeholder="Password"></form:input>
        </div>
        <div align="center">
            <form:input type="password" path="passwordConfirm"
                        placeholder="Confirm your password"></form:input>
            <form:errors path="password"></form:errors>
                ${passwordError}
        </div>
        <div align="center">
    <button type="submit" >Зарегистрироваться</button>
        </div>
    </form:form>

</div>
</body>
</html>
