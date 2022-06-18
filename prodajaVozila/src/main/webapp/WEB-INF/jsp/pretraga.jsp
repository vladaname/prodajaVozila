<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
Poruka:${poruka}



<%--@elvariable id="pretragaVozila" type=""--%>
<form:form method="post" action="/pretraga"
           modelAttribute="pretragaVozila">
    <table>
        <tr>
            <td><form:label path="cenaStigloOd">cena od</form:label></td>
            <td><form:input type="number" path="cenaStigloOd" /></td>
        </tr>
        <tr>
            <td><form:label path="cenaStigloDo">cena do</form:label></td>
            <td><form:input type="number" path="cenaStigloDo" /></td>
        </tr>
        <tr>
            <td><form:label path="kriterijumPretrage">kriterijumPretrage</form:label></td>
            <td><form:input path="kriterijumPretrage" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>


</form:form>

</body>
</html>