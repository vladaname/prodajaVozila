<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link href="/listaOglasa.css" rel="stylesheet">
</head>
<body>
<script>
    function myFunction() {
        var copyText = document.getElementById("myInput");
        var tempInput = document.createElement("input");
        tempInput.style = "position: absolute; left: -1000px; top: -1000px";
        tempInput.value = copyText.value;
        document.body.appendChild(tempInput);
        tempInput.select();
        document.execCommand("copy");
        document.body.removeChild(tempInput);
        alert("Podeljen link: " + copyText.value);
    }
</script>

${poruka}

<!-- Second navbar for search -->
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-3">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-3">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="listaPromovisan">Home</a></li>
                <li><a href="login">Login</a></li>
<%--                <li><a href="listaOglasa">Oglasi</a></li>--%>
                <li><a href="login">Kreiraj oglas</a></li>
                <li><a href="createOsoba">Prijava</a></li>
                <li><a href="#">Contact</a></li>
                <li>
                    <a class="btn btn-default btn-outline btn-circle"  data-toggle="collapse" href="#nav-collapse3" aria-expanded="false" aria-controls="nav-collapse3">Search</a>
                </li>
            </ul>
            <div class="collapse nav navbar-nav nav-collapse" id="nav-collapse3">
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" />
                    </div>
                    <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                </form>
            </div>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->
<h3 align="center">LISTA VOZILA</h3>


<table class="table table-striped">
    <tr>
        <td>marka</td>
        <td>model</td>
        <td>cena</td>
        <td>tekst</td>
        <td>akcija</td>
        <td>prosledi</td>
    </tr>
    <c:forEach var="listaOglasa" items="${listaOglasa}">
        <tr>
            <td>${listaOglasa.marka}</td>
            <td>${listaOglasa.model}</td>
            <td>${listaOglasa.cena}</td>
            <td>${listaOglasa.tekst}</td>
            <td>
            <%--@elvariable id="kupiOglasDTO" type=""--%>
            <form:form method="post" action="/kupiVozilo" modelAttribute="kupiOglasDTO">
                <input type="hidden" name="idoglas" value="${listaOglasa.idoglas}">
                <input type="submit" value="kupi">
            </form:form>
            </td>
            <td>
                <input type="hidden" value="http://localhost:8080/pregledOglasa/${listaOglasa.idoglas}" id="myInput">
                <button onclick="myFunction()">Prosledi</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>