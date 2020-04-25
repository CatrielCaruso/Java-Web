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

<title>Insert title here</title>
</head>
<body>
	<div class="container mt-2 col-lg-6">

		<div class="card col-sm-10">

			<div class="card-body ">

				<form class="form-horizontal"  action="Persona" method="POST">

					<div class="form-group text-center">
						<h3>Nuevo usuario</h3>
					</div>
					
					<div class="form-group">
						<label>Apellido:</label> <input type="text" name="apellido"
							class="form-control">
					</div>
					


					<div class="form-group">
						<label>Nombre:</label> <input type="text" name="nombre"
							class="form-control">
					</div>


					<div class="form-group">
						<label>Dni:</label> <input type="text" name="dni"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Telefono:</label> <input type="text" name="telefono"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Email:</label> <input type="text" name="email"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Usuario:</label> <input type="text" name="usuario"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Contraseņa:</label> <input type="password"
							name="contrasena" class="form-control">
					</div>
					
					<div class="form-group">
					
					<input type="hidden" name="rol" value="cliente" readonly="readonly">
					</div>
					<input type="submit" name="accion" value="agregar"
						class="btn btn-primary btn-block">
				
				      
				
				</form>



			</div>



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