<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%--This page gets call from the controller--%>
<html>
<head>
    <title>List customers</title>

    <link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css"
    />

</head>

<body>
    <div id="wrapper">
        <div id="header">
            <h1> Welcome to list customers </h1>
        </div>
    </div>

    <div id="container">

        <div id="content">
            <table>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                </tr>

                    <%-- the if of the for each and the model value from the controller--%>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>
</body>

</html>
