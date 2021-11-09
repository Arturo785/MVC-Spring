<%--
  Created by IntelliJ IDEA.
  User: Arturo
  Date: 27/09/2021
  Time: 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add customer</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"
    />

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-costumer-style.css"
    />

</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Add customer</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save customer</h3>

                                            <%--The one in the controller--%>
        <%--Spring is intelligent enough to set the values if available otherwise in blank--%>
        <%--Remember implicit getters and setters calls--%>
        <form:form action="saveCustomer" modelAttribute="customer" method="post">

            <%--To set the id and make the update-delete --%>
            <form:hidden path="id" />

            <table>
                <tbody>
                <tr>
                    <td> <label>First name</label> </td>
                    <td><form:input path="firstName" /></td>
                </tr>

                <tr>
                    <td> <label>Last name</label> </td>
                    <td><form:input path="lastName" /></td>
                </tr>

                <tr>
                    <td> <label>Email</label> </td>
                    <td><form:input path="email" /></td>
                </tr>

                <tr>
                    <td> <label></label> </td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>

                </tbody>
            </table>

        </form:form>

        <br/>
        <br/>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list"> Go to list</a>
        </p>

    </div>

</body>
</html>
