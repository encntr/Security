<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
    <h4><a href="/news">Новости (только пользователь)</a>
        <a href="/todolist">ToDoList</a>
        <a href="/admin">Пользователи (только админ)</a>
        ${pageContext.request.userPrincipal.name}
    <sec:authorize access="!isAuthenticated()">
        <a href="/login">Войти</a>
        <a href="/registration">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>

</div>
</body>
</html>