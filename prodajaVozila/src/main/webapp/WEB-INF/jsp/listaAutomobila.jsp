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
    <link href="/listaPromovisan.css" rel="stylesheet">

</head>
<body>
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
                <%--                <li><a href="listaPromovisan">Home</a></li>--%>
                <li><a href="login">Login</a></li>
                <li><a href="listaOglasa">Oglasi</a></li>
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
<h3 align="center">AUTOMOBILI</h3>

<table class="table table-striped">
    <tr>
        <td>marka</td>
        <td>model</td>
        <td>cena</td>
        <td>tekst</td>
    </tr>
    <c:forEach var="automobil" items="${listaAutomobilia}">
        <tr>
            <td>${automobil.marka}</td>
            <td>${automobil.model}</td>
            <td>${automobil.cena}</td>
            <td>${automobil.tekst}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>