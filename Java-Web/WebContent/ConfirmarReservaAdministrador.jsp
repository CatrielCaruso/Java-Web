<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmar reserva administrador</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
	<link href="style/css/ConfirmarModificarReserva.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
	
	




</head>
<body>



	

	 
	

	<div class="container center animated fadeInLeft">
			<div class="col-sm-12 ">


				<div class="card-body">

					<form class="form-sign" action="Reservas" method="POST">

						
						<div class="form-group">
							<h3>Fecha desde:</h3> <input type="text" value="${reservahecha.getFechaDesde()}"
								name="fecha_desde" class="form-control">
						</div>

						<div class="form-group">
							<h3>Fecha hasta</h3> <input type="text"
								value="${reservahecha.getFechaHasta()}" name="fecha_hasta"
								class="form-control">
						</div>

					
						<div class="form-group">
							 <input 
								value="${reservahecha.getPer().getIdPersona()}" name="idpersona"
								class="form-control" type="hidden">
						</div>
					
					
					<div class="form-group">
							 <input 
								value="${reservahecha.getCaba().getIdCabana()}" name="idcabana"
								class="form-control" type="hidden">
						</div>
					
						<div class="form-group">
							<h3>Cantidad de dias</h3> <input type="text"
								value="${reservahecha.getCantidadDias()}" name="cantidaddias"
								class="form-control">
						</div>
                        
                        
                        	<div class="form-group">
							<h3>Precio total</h3> <input type="text"
								value="${reservahecha.getPrecioTotal()}" name="preciototal"
								class="form-control">
						</div>


                           <input type="submit" name="ErrorAdministrador" value="Volver al menu principal"
							class="btn btn-primary btn-lg">
						 
						<input type="submit" name="reservaAdmin" value="Aceptar"
							class="btn btn-success btn-lg">



					</form>



				</div>


			</div>


	</div>


  <%@include file="../Footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>



	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>



</body>
</html>