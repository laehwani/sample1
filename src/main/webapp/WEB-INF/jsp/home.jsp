<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-16
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>할 일</h3>
<h4>
    <form action="/add" method="post">
        <input type="text" name="todo" placeholder="할 일을 입력하세요">
    </form>
</h4>
<hr>
<h4>할 일 추가 프로그램</h4>
<div>
    <table>
        <tr>
            <td>id</td>
            <td>todo</td>
            <td>입력일시</td>
        </tr>
        <c:forEach items="${todoList}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.todo}</td>
                <td>${todo.inserted}</td>
                <td><button>삭제</button></td>
                <td><button>변경</button></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
