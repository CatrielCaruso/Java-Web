<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
	<style>.fondo{background-color:white}</style>
</head>
<body class="fondo">

	<nav class="navbar navbar-expand-lg  navbar-dark bg-dark"">


		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<form action="DireccionNavbar" method="post">

						<button name="home" value="salir" class="btn btn-outline-light"
							style="margin-left: 10px; border: none" class="nav-link" href="#">Home</button>
					</form>
				</li>

				<li class="nav-item">
					<form action="DireccionNavbar" method="post">
						<button name="reservas" value="salir"
							style="margin-left: 10px; border: none"
							class="btn btn-outline-light" href="#">Mis reservas</button>
					</form>
				</li>
				<li class="nav-item">
					<form action="DireccionNavbar" method="post">
						<button name="contacto" value="salir"
							style="margin-left: 10px; border: none"
							class="btn btn-outline-light" href="#">CONTACTOS</button>
					</form>
				</li>
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="#" tabindex="-1"
					aria-disabled="true"></a></li>
			</ul>

		</div>

		<div class="dropdown">
			<button style="border: none"
				class="btn btn-outline-light dropdown-toggle" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">${personaLogueada.getNombre()}
				${personaLogueada.getApellido()}</button>
			<div class="dropdown-menu text-center"
				aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item" href="#"> <img
					src="style/img/index.png"
					alt="100" width="100" />
				</a> <a class="dropdown-item" href="#">${personaLogueada.getUsuario()}</a>
				<a class="dropdown-item" href="#">${personaLogueada.getEmail()}</a>
				<div class="dropdown-divider"></div>
				<form action="Login" method="post">
					<button name="salir" value="salir" class="dropdown-item" href="#">Salir</button>
				</form>
			</div>
		</div>
	</nav>

	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>