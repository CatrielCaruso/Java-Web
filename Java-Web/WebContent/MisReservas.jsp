<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="style/css/MisReservas.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://csshake.surge.sh/csshake.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
</head>
<body>
	<%@include file="../Principal.jsp"%>




	<form action="Reservas" method="POST">

		<div class="shake-little shake-constant shake-constant--hover">
			<input type="submit" name="listar"
				value="Hace click para listar tus reservas!!" class="coli">

		</div>

	</form>




	<div class="col-sm-10">


		<table class="table table-hover">

			<thead>
				<tr>
					<th>IdReserva</th>
					<th>Fecha desde:</th>
					<th>Fecha hasta:</th>
					<th>Cantidad dias:</th>
					<th>Precio total:</th>
					<th>Lugar:</th>
					<th>Nombre:</th>

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

						<td>
							<form action="Reservas" method="POST">

								<div class="shake-little">
									<button class="btn btn-danger btn-lg"
										value="${r.getIdReserva()}" name="borrar">Eliminar</button>
								</div>
							</form>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>


	<%@include file="../Footer.jsp"%>
</body>
</html>