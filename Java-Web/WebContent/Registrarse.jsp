<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
 <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
	<link href="style/css/Registrarse.css" rel="stylesheet">
<title>Registrarse</title>
</head>
<body>
	<div class="container animated fadeInLeft">

		<div class="col-sm-12">

			

				<form class="form-horizontal"  action="RegistrarPersona" method="POST">

					<div class="form-group text-center">
						<h1>Nuevo usuario</h1>
					</div>
					
					<div class="form-group">
						<h5>Apellido:</h5> <input type="text" name="apellido"
							class="form-control" required>
					</div>
					


					<div class="form-group">
						<h5>Nombre:</h5> <input type="text" name="nombre"
							class="form-control" required>
					</div>


					<div class="form-group">
						<h5>Dni:</h5> <input type="text" name="dni"
							class="form-control" required>
					</div>

					<div class="form-group">
						<h5>Telefono:</h5> <input type="text" name="telefono"
							class="form-control" required>
					</div>

					<div class="form-group">
						<h5>Email:</h5> <input type="text" name="email"
							class="form-control" required>
					</div>

					<div class="form-group">
						<h5>Usuario:</h5> <input type="text" name="usuario"
							class="form-control" required>
					</div>

					<div class="form-group">
						<h5>Contraseña:</h5> <input type="password"
							name="contrasena" class="form-control" required>
					</div>
					
					<div class="form-group">
					
					<input type="hidden" name="rol" value="cliente" readonly="readonly">
					</div>
					<input type="submit" name="accion" value="Agregar"
						class="btn btn-primary btn-block">
				
				      
				
				</form>



			



		</div>

	</div>


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