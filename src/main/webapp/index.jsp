
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>INPUT NUMBER</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}
        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }
        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }
        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">INPUT NUMBER</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">

        </div>
        <div class="col-sm-8 text-left">

            <c:if test="${msg_success}">
            <div class="alert alert-success">
                <strong>Success!</strong>
            </div>
            </c:if>
            <c:if test="${delete_success}">
                <div class="alert alert-success">
                    <strong>Success!</strong>
                </div>
            </c:if>
            <h1>INPUT NUMBER</h1>
            <form class="form-horizontal" action="/action" method="post">
                <div class="form-group">

<div class="form-group">
    <label class="control-label col-sm-2" for="number">INPUT</label>
    <div class="col-sm-10">
        <input type="number" class="form-control" id="number" name="number" placeholder="ENTER NUMBER" required>
    </div>
</div>
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">PUSH</button>
        <a href="/sum" id="btnSum" class="btn btn-sm btn-primary">
            <span class="glyphicon glyphicon-plus-sign"></span>Sum it all
        </a>
        <a href="/clear" id="btnClear" class="btn btn-sm btn-primary">
            <span class="glyphicon glyphicon-plus-sign"></span>Clear all
        </a>
        <a href="/average" id="btnAverage" class="btn btn-sm btn-primary">
            <span class="glyphicon glyphicon-plus-sign"></span>Average
        </a>
        <a href="/min" id="btnMinimum" class="btn btn-sm btn-primary">
            <span class="glyphicon glyphicon-plus-sign"></span>Minimum
        </a>
        <a href="/max" id="btnMaximum" class="btn btn-sm btn-primary">
            <span class="glyphicon glyphicon-plus-sign"></span>Maximum
        </a>
    </div>
</div>
<c:forEach items="${nList}" var="aMagic">
    <c:out value="${aMagic.number}"/>
</c:forEach>
                </div>

            </form>
        </div>
        <div class="col-sm-2 sidenav">
            <c:out value="${result}"/>

        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    WEBAPP</footer>

</body>
</html>

