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



<%--@elvariable id="oglasDTO" type=""--%>
<form:form method="post" action="/searchByMarka"
           modelAttribute="oglasDTO">
    <table>

        <tr>
            <td><form:label path="vrstaVozila">Model</form:label></td>
            <td><form:input path="vrstaVozila" /></td>
        </tr>

        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>


</form:form>

</body>
</html>