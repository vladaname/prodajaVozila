<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>

    <!-- BOOTSTRAP -->
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="css/style.css">

    <link rel="icon" href="Favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link href="/login.css" rel="stylesheet">

</head>
<body>
${poruka}
<table>
    <tr>
        <td>marka</td>
        <td>model</td>
        <td>cena</td>
        <td>vrstaVozila</td>
        <td>tekst</td>

    </tr>
    <c:forEach var="listaOglasa" items="${listaOglasa}">
        <tr>
            <%--@elvariable id="izmeniOglasDTO" type=""--%>
            <form:form method="post" action="/izmeniOglas" modelAttribute="izmeniOglasDTO">
                <input type="hidden" name="idoglas" value="${listaOglasa.idoglas}">
                <td><input type="text" name="marka" value="${listaOglasa.marka}"></td>
                <td><input type="text" name="model" value="${listaOglasa.model}"></td>
                <td><input type="number" name="cena" value="${listaOglasa.cena}"></td>
                <td><input type="text" name="vrstaVozila" value="${listaOglasa.vrstaVozila}"></td>
                <td><input type="text" name="tekst" value="${listaOglasa.tekst}"></td>

                <td><input type="submit" value="izmeni"></td>
            </form:form>
        </tr>

    </c:forEach>
</table>
</body>
</html>