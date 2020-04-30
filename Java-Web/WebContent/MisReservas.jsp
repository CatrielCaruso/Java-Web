<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../Principal.jsp"%>


	<h1>Holaaa</h1>

	<form action="Reservas" method="POST">
		<input type="submit" name="listar" value="listar"
			class="btn btn-info btn-lg">
	</form>







	<table>

		<thead>
			<tr>
				<th>IdReserva</th>
				<th>Fecha desde:</th>
				<th>Fecha hasta:</th>
				<th>Cantidad dias:</th>
				<th>Precio total:</th>
				<th>Lugar:</th>

			</tr>
		</thead>

		<tbody>
			<c:forEach items="${todasReservas}" var="r">
				<tr>

					<td>${r.getIdReserva()}</td>
					<td>${r.getFechaDesde()}</td>
					<td>${r.getFechaHasta()}</td>
					<td>${r.getCantidadDias()}</td>
					<td>${r.getPrecioTotal()}</td>
					<td>${r.getCaba().getLugar()}</td>
					<td>${r.getPer().getNombre()}</td>


				</tr>
			</c:forEach>

		</tbody>
	</table>
	<%@include file="../Footer.jsp"%>
</body>
</html>