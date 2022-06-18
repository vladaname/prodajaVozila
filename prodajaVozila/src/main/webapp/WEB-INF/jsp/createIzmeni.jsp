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
Ulogovani ste
<br>
${poruka}
<br>
${ulogovaniKorisnik}
<br>

${idKorisnik}


<form:form method="get" action="/kreiraj">
    <input type="hidden" name="akcija" value="createOglas">
    <input type="submit" value="createOglas"/>

</form:form>

<form:form method="get" action="/kreiraj">
    <input type="hidden" name="akcija" value="izmeniListaOglasa">
    <input type="submit" value="izmeniOglas"/>
</form:form>

</body>
</html>