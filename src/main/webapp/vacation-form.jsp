<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
    <%--<script type="text/javascript" src="js/validators/loginValidator.js"></script>--%>

    <link rel="stylesheet" href="resources/css/kamadatepicker.min.css">
    <link rel="stylesheet" href="/kamadatepicker.min.css">
    <script src="/js/kamadatepicker.min.js"></script>
    <%--        <link rel="stylesheet" href="../css/kamadatepicker.min.css">
        <link href="<c:url value="/resources/css/kamadatepicker.min.css" />" rel="stylesheet">--%>
    <%--<jsp:include page="css/kamadatepicker.min.css"/>--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}css/kamadatepicker.min.css" />--%>
    <script src="//code.jquery.com/jquery.min.js"></script>
    <%--<script src="${pageContext.request.contextPath}js/kamadatepicker.min.js"></script>--%>
</head>
<body>
<center>
    <h1>vacation Request</h1>
    <%--<h2>--%>
    <%--<a href="new">Add New Employee</a>--%>
    <%--&nbsp;&nbsp;&nbsp;--%>
    <%--<a href="list">List All Employee</a>--%>

    <%--</h2>--%>
</center>
<div align="center">

    <form action="insertVacation" method="post">

        <table border="1" cellpadding="5" bgcolor=#f2f2f2 style="color:white">
            <caption>
                <h2>
                    Add New Vacation Request
                </h2>
            </caption>

            <tr>
                <th bgcolor=#4CAF50>Date from :</th>
                <td>
                    <input type="datetime-local" name="from" size="45"/>
                    <input type="text" id="date1">
                    <input type="hidden" id="id" name="id" value="${id}">

                </td>
            </tr>
            <tr>
                <th bgcolor=#4CAF50>Date to :</th>
                <td>
                    <input type="datetime-local" name="to" size="45"/>

                </td>
            </tr>
            <tr>
                <th bgcolor=#4CAF50>Description :</th>
                <td>
                    <input type="text" name="description" size="45"/>

                </td>
            </tr>
            <%-- <tr>
                 <th bgcolor=#4CAF50>userId:</th>
                 <td>
                     <input type="number" name="userID" size="45"/>

                 </td>
             </tr>--%>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
<script>
    //  kamaDatepicker('date1', { buttonsColor: "red" });

    var customOptions = {
        placeholder: "روز / ماه / سال"
        , twodigit: false
        , closeAfterSelect: false
        , nextButtonIcon: "fa fa-arrow-circle-right"
        , previousButtonIcon: "fa fa-arrow-circle-left"
        , buttonsColor: "blue"
        , forceFarsiDigits: true
        , markToday: true
        , markHolidays: true
        , highlightSelectedDay: true
        , sync: true
        , gotoToday: true
    }
</script>
</html>