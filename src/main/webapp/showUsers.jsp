<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Usuarios</h1>
<table>
    <thead><tr><th>Nombre</th><th>Apellido</th><th>Edad</th><th>Email</th><th>Dni</th></tr></thead>
    <% List<User> userList = (List<User>) request.getSession().getAttribute("users");

    for(User user : userList) {;%>

    <tr>
        <td><%= user.getName() %></td>
        <td><%= user.getSurname() %></td>
        <td><%= user.getAge() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getDni() %></td>
    </tr>

    <% }%>
</table>


</body>
</html>


<style>
    table {
        border-collapse: collapse;
    }
    td {
        background: whitesmoke;
        padding: 0.5em 1em;
    }
    tr:nth-child(even) td {
        background: lightgray;
    }
    th {
        background: lightgray;
        padding: 0.5em 1em;
    }
    th:nth-child(even) {
        background: gray;
    }
</style>
