<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="new">Add New Employee</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Employee</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Employee</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Age</th>
            <th>Role</th>
            <th>ManagerId</th>
            <th>Address</th>


        </tr>
        <c:forEach var="employee" items="${listEmployee}">
            <tr>
                <td><c:out value="${employee.id}" /></td>
                <td><c:out value="${employee.name}" /></td>
                <td><c:out value="${employee.lastName}" /></td>
                <td><c:out value="${employee.email}" /></td>
                <td><c:out value="${employee.phone}" /></td>
                <td><c:out value="${employee.age}" /></td>
                <td><c:out value="${employee.role}" /></td>
                <td><c:out value="${employee.managerId}" /></td>
                <td><c:out value="${employee.address}" /></td>

                <%--<td><c:out value="${employee.isActive}" /></td>--%>
                <%--<td><input type="checkbox" id="subscribeNews" name="subscribe" value="${employee.isActive}"></td>--%>
                <td>
                    <a href="edit?id=<c:out value='${employee.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${employee.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>