
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
<title>Gesti�n personas</title>
<link href="style/css/PersonaCrud.css" rel="stylesheet">
</head>
<body>

	<%@include file="../PrincipalAdministrador.jsp"%>


	<form method="post" action="RegistrarPersona">
		<div class="row">

			<div class="col-sm-6  buscador">
				<div class="input-group mb-3">
					<input class="form-control"
						placeholder="Ingrese apellido del cliente"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						type="text" name="nombre">
					<div class="input-group-append">

						<button type="submit" class="btn btn-success" name="buscar"
							type="button">Buscar</button>

					</div>



				</div>
			</div>
	</form>
	<div class="col-sm-6 ">
		<form method="post" action="RegistrarPersona">
			<input type="submit" name="crear" value="Crear nuevo usuario"
				class="coli">
		</form>
	</div>



	</div>



	<div class="animated fadeIn">


		<div class="d-flex">


			<div class="col-sm-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>IdPersona</th>
							<th>Dni</th>
							<th>Apellido</th>
							<th>Nombre</th>
							<th>Email</th>
							<th>Telefono</th>
							<th>Usuario</th>
							<th>Contrase�a</th>
							<th>Rol</th>
							<th>Acci�n:</th>
							<th>Acci�n:</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${allPeople}" var="p">
							<tr>

								<td>${p.getIdPersona()}</td>
								<td>${p.getDni()}</td>
								<td>${p.getApellido()}</td>
								<td>${p.getNombre()}</td>
								<td>${p.getEmail()}</td>
								<td>${p.getTelefono()}</td>
								<td>${p.getUsuario()}</td>
								<td>${p.getContrasena()}</td>
								<td>${p.getRol()}</td>

								<form method="post" action="GestionPersona">
								<td>

									<button class="btn btn-warning btn-lg"
										value="${p.getIdPersona()}" name="modificar">Editar</button>
								</td>
								<td>
									<button class="btn btn-danger btn-lg"
										value="${p.getIdPersona()}" name="borrar">Delete</button>

								</td>
								</form>

							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>
		</div>




	</div>

	<%@include file="../Footer.jsp"%>
</body>
</html>