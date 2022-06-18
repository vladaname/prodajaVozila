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


<%--@elvariable id="izmeniOglasDTO" type=""--%>
<form:form method="post" action="/izmeniOglas"
           modelAttribute="izmeniOglasDTO">
    <table>

        <tr>
            <td><form:label path="vrstaVozila">vrstaVozila</form:label></td>
            <td><form:input path="vrstaVozila" /></td>
        </tr>

        <tr>
            <td><form:label path="marka">marka</form:label></td>
            <td><form:input path="marka" /></td>
        </tr>

        <tr>
            <td><form:label path="model">model</form:label></td>
            <td><form:input path="model" /></td>
        </tr>
        <tr>
            <td><form:label path="cena">cena</form:label></td>
            <td><form:input path="cena" /></td>
        </tr>
        <tr>
            <td><form:label path="tekst">tekst</form:label></td>
            <td><form:input path="tekst" /></td>
        </tr>
        <tr>

            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>


</form:form>

</body>
</html>