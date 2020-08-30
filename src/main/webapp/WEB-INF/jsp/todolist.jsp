<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ToDoList</title>
</head>
<h4><a href="/news">Новости (только пользователь)</a>
    <a href="/todolist">ToDoList</a>
    <a href="/admin">Пользователи (только админ)</a>
    ${pageContext.request.userPrincipal.name}
    <a href="/logout">Выйти</a></h4>

<form method="post" action="/todolist">
    <h2 align="center">Yours ToDo</h2>

    <div>
        <table>
            <thead>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Date</th>
            <th>Status</th>
            </thead>
            <c:forEach items="${allToDoItems}" var="toDoItem">
                <tr>
                    <td>${toDoItem.id}</td>
                    <td>${toDoItem.toDoName}</td>
                    <td>${toDoItem.toDoDescription}</td>
                    <td>${toDoItem.dateCteation}</td>
                    <td>${toDoItem.status}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/" method="post">
                            <input type="hidden" name="toDoId" value="${toDoItem.id}"/>
                            <input type="hidden" name="action" value="delete"/>
                            <button type="submit">Delete</button>
                            <button type ="submit">Edit</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
<form method="get" action="/todolist">
    <div align="center">

        <input name="toDoId" type="number" placeholder="id"
               autofocus="true"/>

        <input name="toDoName" type="text" placeholder="ToDoName"
               autofocus="true"/>

        <input name="toDoDescription" type="text" placeholder="ToDoDescription"
                   autofocus="true"/>

        <input name="dateCreation" type="datetime-local" placeholder="Date"
                   autofocus="true"/>

        <input name="status" type="checkbox" placeholder="Status"
               autofocus="true"/>
        <input type="hidden" name="toDoId" value="${toDoItem.id}"/>
        <input type="hidden" name="action" value="add"/>
        <button type="submit" align="center">Add</button>
    </div>

</form>
</body>
</html>