
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
<title>Crear nueva reserva</title>
<link href="style/css/PersonaCrud.css" rel="stylesheet">
</head>
<body>

	<%@include file="../PrincipalAdministrador.jsp"%>


	<form method="post" action="Reservas">
		<div class="row animated fadeIn">

			<div class="col-sm-6  buscador animated fadeIn">
				<div class="input-group mb-3">
					<input class="form-control"
						placeholder="Ingrese apellido del cliente"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						type="text" name="nombre">
					<div class="input-group-append">

						<button type="submit" class="btn btn-success" name="PersonaReserva"
							type="button">Buscar</button>

					</div>



				</div>
			</div>
	
	</div>



	



	<div class="animated fadeIn">


		<div class="d-flex">


			<div class="col-sm-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>IdPersona</th>
							
							<th>Apellido</th>
							<th>Nombre</th>
						
							<th>Acción:</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${allPeople}" var="p">
							<tr>

								<td>${p.getIdPersona()}</td>
							
								<td>${p.getApellido()}</td>
								<td>${p.getNombre()}</td>
							

								<form method="post" action="Reservas">
								<td>

									<button class="btn btn-primary btn-lg"
										value="${p.getIdPersona()}" name="seleccionarReserva">RESERVAR</button>
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