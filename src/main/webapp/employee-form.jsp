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
    <c:if test="${employee != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${employee == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${employee != null}">
                            Edit Employee
                        </c:if>
                        <c:if test="${employee == null}">
                            Add New Employee
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${employee != null}">
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                </c:if>
                <tr>
                    <th>Employee Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${employee.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Employee LastName: </th>
                    <td>
                        <input type="text" name="lastName" size="45"
                               value="<c:out value='${employee.lastName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Employee Email: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="<c:out value='${employee.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Phone: </th>
                    <td>
                        <input type="text" name="phone" size="15"
                               value="<c:out value='${employee.phone}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Employee Age: </th>
                    <td>
                        <input type="text" name="age" size="45"
                               value="<c:out value='${employee.age}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Employee Role: </th>
                    <td>
                        <%--<input type="text" name="role" size="45"--%>
                               <%--value="<c:out value='${employee.role}' />"--%>
                        <%--/>--%>
                            <select name="role">
                                <c:forEach items="${roles}" var="role">
                                    <option value="${role.id}">${role.name}</option>
                                </c:forEach>
                            </select>
                    </td>
                </tr>
                <tr>
                    <th>Employee ManagerId: </th>
                    <td>
                        <%--<input type="text" name="managerId" size="45"--%>
                               <%--value="<c:out value='${employee.managerId}' />"--%>
                        <%--/>--%>
                            <select name="managerId">
                                <c:forEach items="${manager}" var="manage">
                                    <option value="${manage.id}">${manage.name}</option>
                                </c:forEach>
                            </select>
                    </td>
                </tr>
                <tr>
                    <th>Employee Address: </th>
                    <td>
                        <input type="text" name="address" size="15"
                               value="<c:out value='${employee.address}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Employee active: </th>
                    <td>
                       <%-- <input type="text" name="active" size="15"
                               value="<c:out value='${employee.active}' />"
                        />--%>
                    <input type="checkbox" id="active" name="active" value="true">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>