<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
	
	<link href="style/css/ConfirmarReserva.css" rel="stylesheet">




</head>
<body class="fondo">



	

	 
	

	<div class="container center contenedor">

	
			<div class="col-sm-12   cont ">


				<div class="row animated fadeInDown">Fecha desde: ${reservahecha.getFechaDesde()}</div>
				<div class="row animated fadeInLeft">Fecha hasta: ${reservahecha.getFechaHasta()}</div>
				<div class="row animated fadeInRight">Cantidad de dias: ${reservahecha.getCantidadDias()}</div>
				<div class="row animated fadeInLeft">Capacidad: ${caba.getCapacidad()}</div>
				<div class="row animated fadeInRight">Precio total de alquiler: ${reservahecha.getPrecioTotal()} pesos Argentinos</div>
				<div class="row animated fadeInLeft">Lugar: ${caba.getLugar()}  </div>
				<div class="row  animated fadeInUp">Dirección: ${caba.getDireccion()}</div>
				
				
			<form  action="Reservas" method="POST">	
			
			
				<input type="submit" name="confirmar" value="CONFIRMAR"
							class="btn btn-success btn-lg">
			
               <input type="submit" name="volver" value="Volver"
							class="btn btn-info btn-lg">
            </form>
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