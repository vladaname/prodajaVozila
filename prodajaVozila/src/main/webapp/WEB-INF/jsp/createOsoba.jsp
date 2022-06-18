<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
Poruka:${poruka}

<%--@elvariable id="osobaDTO" type=""--%>
<form:form method="post" action="/createOsoba"
           modelAttribute="osobaDTO">
    <table>
        <tr>
            <td><form:label path="ime">ime</form:label></td>
            <td><form:input path="ime" /></td>
        </tr>
        <tr>
            <td><form:label path="prezime">prezime</form:label></td>
            <td><form:input path="prezime" /></td>
        </tr>
        <tr>
            <td><form:label path="tel">tel</form:label></td>
            <td><form:input path="tel" /></td>
        </tr>
        <tr>
            <td><form:label path="email">email</form:label></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="username">username</form:label></td>
            <td><form:input path="username" /></td>
        </tr>
        <tr>
            <td><form:label path="pass">pass</form:label></td>
            <td><form:input path="pass" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>


</form:form>

</body>
</html>