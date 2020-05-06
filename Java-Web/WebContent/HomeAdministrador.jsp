<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home administrador</title>
<link href="style/css/PersonaCrud.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
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

						<button type="submit" class="btn btn-success" name="buscar"
							type="button">Buscar</button>

					</div>



				</div>
			</div>
	</form>
	<div class="col-sm-6 animated fadeIn ">
		<form method="post" action="Reservas">
			<input type="submit" name="nuevaReserva" value="Crear nueva reserva"
				class="coli">
		</form>
	</div>



	</div>




	<div class="col-sm-12 animated fadeIn">


		<table class="table table-hover animated fadeIn">

			<thead>
				<tr>
					<th>IdReserva</th>
					<th>Fecha desde:</th>
					<th>Fecha hasta:</th>
					<th>Cantidad dias:</th>
					<th>Precio total:</th>
					<th>Lugar:</th>
					<th>Nombre:</th>
					<th>Apellido:</th>
                   <th>Acción:</th>
                   <th>Acción:</th>
				</tr>
			</thead>

			<tbody class="animated fadeIn">
				<c:forEach items="${todasReservas}" var="r">
					<tr>

						<td>${r.getIdReserva()}</td>
						<td>${r.getFechaDesde()}</td>
						<td>${r.getFechaHasta()}</td>
						<td>${r.getCantidadDias()}</td>
						<td>${r.getPrecioTotal()}</td>
						<td>${r.getCaba().getLugar()}</td>
						<td>${r.getPer().getNombre()}</td>
						<td>${r.getPer().getApellido()}</td>
						
						<form action="Reservas" method="POST">
						<td>





							<button class="btn btn-warning btn-lg"
								value="${r.getIdReserva()}" name="modificar">Editar</button>
						</td>
						<td>
							<button class="btn btn-danger btn-lg" value="${r.getIdReserva()}"
								name="borrar">Eliminar</button>

						</td>


						</form>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>




	<%@include file="../Footer.jsp"%>
</body>
</html>