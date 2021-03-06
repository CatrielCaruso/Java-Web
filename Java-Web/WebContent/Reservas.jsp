<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservar</title>

<link href="style/css/MisReservas.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
</head>
<body>
	<%@include file="../Principal.jsp"%>


	<div class="container animated fadeInDown ">

		<div class="row tipot">
			<div class="col-sm-4  ">

				<h3 class="tipo">Caracteristicas de la caba�a:</h3>
			</div>

			<div class="col-sm-4 ">
				<h3 class="tipo">Hace tu reserva!!</h3>

			</div>

		</div>
	</div>



	<div class="d-flex">

		<div class="container">

			<div class="row">
				<div class="col-sm-4 cont animated fadeInLeft ">


					<div class="row">Lugar: ${caba.getLugar()}</div>
					<div class="row">Precio por d�a:${caba.getPrecioDia()}</div>
					<div class="row">Direcci�n:${caba.getDireccion()}</div>
					<div class="row">Capacidad:${caba.getCapacidad()}</div>
					<div class="row">Asador: ${caba.getAsador()}</div>
					<div class="row">Cocina: ${caba.getCocina()}</div>
					<div class="row">Heladera: ${caba.getHeladera()}</div>
					<div class="row">Lavarropa:${caba.getLavarropa()}</div>
					<div class="row">Cochera: ${caba.getCochera()}</div>
					<div class="row">WIFI: ${caba.getWiFi()}</div>
					<div class="row">Calefacci�n:${caba.getCalefaccion()}</div>
					<div class="row">Televisor:${caba.getTelevisor()}</div>


				</div>

				<div class="col-sm-8 cont1 animated fadeInRight ">




					<form class="form-sign" action="Reservas" method="POST">






						<div class="form-group">
							<h3>FECHA DESDE:</h3> <input type="text" name="fecha_desde"
								class="form-control" placeholder="AAAA/MM/DD">
						</div>

						<div class="form-group">
							<h3>FECHA HASTA:</h3> <input type="text" name="fecha_hasta"
								class="form-control" placeholder="AAAA/MM/DD">
						</div>








						<input type="hidden" name="idcabana" value="${caba.getIdCabana()}">
						<input type="submit" name="prereserva" value="RESERVAR"
							class="btn btn-success btn-lg">




					</form>










				</div>

			</div>

		</div>

	</div>

	<%@include file="../Footer.jsp"%>

</body>
</html>