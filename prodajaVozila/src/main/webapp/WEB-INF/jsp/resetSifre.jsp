<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

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


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link href="/login.css" rel="stylesheet">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
    <div class="container">
        <a class="navbar-brand" href="#">Laravel</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="listaPromovisan">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="createOsoba">Register</a>
                </li>
            </ul>

        </div>
    </div>
</nav>

<h3 align="center">LOGIN</h3>

Poruka:${poruka}


<main class="login-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Register</div>
                    <div class="card-body">
                        <%--@elvariable id="resetSifreDTO" type=""--%>
                        <form:form method="post" action="/promeniSifru"
                                   modelAttribute="resetSifreDTO">
                        <div class="form-group row">
                            <label for="pass1" class="col-md-4 col-form-label text-md-right">nova sifra</label>
                            <div class="col-md-6">
                                <input type="text" id="pass1" class="form-control" name="pass1" required autofocus>
                            </div>
                        </div>
                            <div class="form-group row">
                                <label for="pass2" class="col-md-4 col-form-label text-md-right">ponovi sifru</label>
                                <div class="col-md-6">
                                    <input type="text" id="pass2" class="form-control" name="pass2" required autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="idosoba" class="col-md-4 col-form-label text-md-right"></label>
                                <div class="col-md-6">
                                    <input type="hidden" value="${idosoba}" id="idosoba" class="form-control" name="idosoba" required autofocus>
                                </div>
                            </div>

                        <div class="col-md-6 offset-md-4">
                            <button type="submit" class="btn btn-primary">
                                Posalji
                            </button>

                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

</main>

</body>
</html>