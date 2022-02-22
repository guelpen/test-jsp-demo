<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>
        Register User
    </title>
    <style type="text/css">
        label{
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
    </style>
</head>
<body>
    <div align="center">
        <h2>User Registration</h2>
        <form:form action="register" method="post" modelAttribute="user">
            <form:label path="username">Username:</form:label>
            <form:input path="username"/><br>
            <form:label path="email">Email:</form:label>
            <form:input path="email"/><br>
            <form:label path="password">Password:</form:label>
            <form:input path="password"/><br>

            <form:button>Register</form:button>
        </form:form>
    </div>
</body>
</html>