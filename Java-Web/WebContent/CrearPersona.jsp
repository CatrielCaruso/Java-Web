<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear persona</title>
<link href="style/css/CrearPersona.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
</head>
<body>
<%@include file="../PrincipalAdministrador.jsp"%>

<div class="container mt-2 col-lg-6 animated fadeInLeft">

		<div class="col-sm-12">

			

				<form class="form-horizontal"  action="RegistrarPersona" method="POST">

					<div class="form-group text-center">
						<h3>Nuevo usuario</h3>
					</div>
					
					<div class="form-group">
						<label>Apellido:</label> <input type="text" name="apellido"
							class="form-control" >
					</div>
					


					<div class="form-group">
						<label>Nombre:</label> <input type="text" name="nombre"
							class="form-control" >
					</div>


					<div class="form-group">
						<label>Dni:</label> <input type="text" name="dni"
							class="form-control" >
					</div>

					<div class="form-group">
						<label>Telefono:</label> <input type="text" name="telefono"
							class="form-control" >
					</div>

					<div class="form-group">
						<label>Email:</label> <input type="text" name="email"
							class="form-control" >
					</div>

					<div class="form-group">
						<label>Usuario:</label> <input type="text" name="usuario"
							class="form-control" >
					</div>

					<div class="form-group">
						<label>Contraseņa:</label> <input type="password"
							name="contrasena" class="form-control" >
					</div>
					
					<div class="form-group">
					
					<input type="hidden" name="rol" value="cliente" readonly="readonly">
					</div>
					
					
					<input type="submit"
							name="volver" value="Volver" class="btn btn-primary btn-lg">
					<input type="submit" name="acciones" value="Agregar"
						class="btn btn-success btn-lg">
				
				      
				
				</form>



			</div>



		</div>

	


<%@include file="../Footer.jsp"%>
</body>
</html>