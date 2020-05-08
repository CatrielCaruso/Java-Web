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




<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">



<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
</head>
<body>
	<%@include file="../Principal.jsp"%>


	<div class="container animated fadeInDown ">

		<div class="row tipot">
			<div class="col-sm-4  ">

				<h3 class="tipo">Caracteristicas de la cabaña:</h3>
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
					<div class="row">Precio por día:${caba.getPrecioDia()}</div>
					<div class="row">Dirección:${caba.getDireccion()}</div>
					<div class="row">Capacidad:${caba.getCapacidad()}</div>
					<div class="row">Asador: ${caba.getAsador()}</div>
					<div class="row">Cocina: ${caba.getCocina()}</div>
					<div class="row">Heladera: ${caba.getHeladera()}</div>
					<div class="row">Lavarropa:${caba.getLavarropa()}</div>
					<div class="row">Cochera: ${caba.getCochera()}</div>
					<div class="row">WIFI: ${caba.getWiFi()}</div>
					<div class="row">Calefacción:${caba.getCalefaccion()}</div>
					<div class="row">Televisor:${caba.getTelevisor()}</div>


				</div>



				<div class="col-sm-8 cont1 animated fadeInRight ">




					<form class="form-sign" action="Reservas" method="POST">








						<div class="container">
							<div class="form-group">
								<h3>FECHA DESDE:</h3>
								<div class="row">
									<div class="col-sm-7">
										<div class="form-group">
											<div class="input-group date" id="datetimepicker4"
												data-target-input="nearest">
												<input type="text" name='fecha_desde'
													class="form-control datetimepicker-input"
													data-target="#datetimepicker4" >
												
												<div class="input-group-append"
													data-target="#datetimepicker4" data-toggle="datetimepicker">
													<div class="input-group-text">
														<i class="fa fa-calendar"></i>
													</div>
												</div>
											</div>
										</div>
									</div>
									<script type="text/javascript">
										$(function() {
											$('#datetimepicker4')
													.datetimepicker({
														format: 'L'
													});
										});
									</script>
								</div>
							</div>










						</div>





						<div class="container">
							<div class="form-group">
								<h3>FECHA HASTA:</h3>

								<div class="row">
									<div class="col-sm-7">
										<div class="form-group">
											<div class="input-group date" id="datetimepicker5"
												data-target-input="nearest">
												<input type="text" name='fecha_hasta'
													class="form-control datetimepicker-input"
													data-target="#datetimepicker5" />
												<div class="input-group-append"
													data-target="#datetimepicker5" data-toggle="datetimepicker">
													<div class="input-group-text">
														<i class="fa fa-calendar"></i>
													</div>
												</div>
											</div>
										</div>
									</div>
									<script type="text/javascript">
										$(function() {
											$('#datetimepicker')
													.datetimepicker({
														format : 'L'
													});
										});
									</script>
								</div>
							</div>
							
							
							<input type="hidden" name="idcabana" value="${caba.getIdCabana()}">
						<input type="submit" name="prereserva" value="RESERVAR"
							class="btn btn-success btn-lg">
							

						</div>









						



					</form>










				</div>

			</div>

		</div>

	</div>

	<%@include file="../Footer.jsp"%>

</body>
</html>