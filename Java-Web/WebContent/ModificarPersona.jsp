<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar persona</title>
<link href="style/css/ModificarPersona.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
</head>
<body>

<%@include file="../PrincipalAdministrador.jsp"%>

<div class="container col-lg-6 animated fadeInLeft">
			<div class="col-sm-12 ">


				<div class="card-body">

					<form class="form-sign" action="GestionPersona" method="POST">

						<div class="form-group">
							<label>Id</label> <input type="text"
								value="${persona.getIdPersona()}" name="idpersona"
								readonly="readonly" class="form-control">
						</div>

						<div class="form-group">
							<label>Dni</label> <input type="text" value="${persona.getDni()}"
								name="dni" class="form-control">
						</div>

						<div class="form-group">
							<label>Apellido</label> <input type="text"
								value="${persona.getApellido()}" name="apellido"
								class="form-control">
						</div>

						<div class="form-group">
							<label>Nombre</label> <input type="text"
								value="${persona.getNombre()}" name="nombre"
								class="form-control">
						</div>

						<div class="form-group">
							<label>Telefono</label> <input type="text"
								value="${persona.getTelefono()}" name="telefono"
								class="form-control">
						</div>

						<div class="form-group">
							<label>Email</label> <input type="text"
								value="${persona.getEmail()}" name="email" class="form-control">
						</div>


						<div class="form-group">
							<label>Usuario</label> <input type="text"
								value="${persona.getUsuario()}" name="usuario"
								class="form-control">
						</div>

						<div>
							<label>Contraseña</label> <input type="text"
								value="${persona.getContrasena()}" name="contrasena"
								class="form-control">
						</div>

						<div>
							<label>Rol</label> <input type="text" value="${persona.getRol()}"
								name="rol" class="form-control">
						</div>

						 <input type="submit"
							name="volver" value="Volver" class="btn btn-primary btn-lg">
						<input type="submit" name="actualizar" value="Aceptar"
							class="btn btn-success btn-lg">



					</form>



				</div>


			</div>


	</div>



<%@include file="../Footer.jsp"%>

</body>
</html>