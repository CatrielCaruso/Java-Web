<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


	
<link href="style/css/Home.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>

<script>
	new WOW().init();
</script>

<title>Home</title>
</head>
<body>
	<%@include file="../Principal.jsp"%>


	<div class=" borde container center animated fadeInLeft">

		<div class="row">

			<div class=" color1 col-sm-12">Chalten ciudad del tekking</div>
		</div>

		<div class="row">
			<div class=" color2 col-sm-4">Izquierda</div>
			<div class="color2 col-sm-8">
				<div id="carouselExampleIndicators1" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to=""
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to=""></li>
						<li data-target="#carouselExampleIndicators" data-slide-to=""></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="style/img/chalten1.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/chalten2.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/chalten3.jpg" class="d-block w-100" alt="">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators1"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next"
						href="#carouselExampleIndicators1" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>



			</div>
		</div>

		<div class="row">
			<div class=" color3 col-sm-12">
				<form method="post" action="Reservas">
                   <input type="hidden" name="idcabana" value="1">
					<button type="submit" class="btn btn-success btn-lg" value="" name="alquilar">Reservar</button>
					
					<button class="btn btn-info btn-lg" value="" name="contacto">Contacto</button>

				</form>


			</div>
		</div>
	</div>









	<div class=" borde container center wow animated fadeInRight">

		<div class="row">

			<div class=" color1 col-sm-12">Calafate cuna de los glaciares</div>
		</div>

		<div class="row">
			<div class=" color2 col-sm-4">Izquierda</div>
			<div class="color2 col-sm-8">
				<div id="carouselExampleIndicators2" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="style/img/calafate1.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/calafate2.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/calafate3.jpg" class="d-block w-100" alt="">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators2"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next"
						href="#carouselExampleIndicators2" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>



			</div>
		</div>

		<div class="row">
			<div class=" color3 col-sm-12">
				<form method="post" action="Reservas">
                     <input type="hidden" name="idcabana" value="2">
					<button class="btn btn-success btn-lg" value="" name="alquilar">Reservar</button>
					<button class="btn btn-info btn-lg" value="" name="contacto">Contacto</button>

				</form>

			</div>
		</div>
	</div>

	<div class=" borde container center wow animated fadeInLeft">

		<div class="row">

			<div class=" color1 col-sm-12">Ushuaia la ciudad más austral
				del mundo</div>
		</div>

		<div class="row">
			<div class=" color2 col-sm-4">Izquierda</div>
			<div class="color2 col-sm-8">
				<div id="carouselExampleIndicators3" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to=""
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to=""></li>
						<li data-target="#carouselExampleIndicators" data-slide-to=""></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="style/img/ushuaia1.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/ushuaia2.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/ushuaia3.jpg" class="d-block w-100" alt="">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators3"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next"
						href="#carouselExampleIndicators3" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>



			</div>
		</div>

		<div class="row">
			<div class=" color3 col-sm-12">
				<form method="post" action="Reservas">
                      <input type="hidden" name="idcabana" value="3">
					<button class="btn btn-success btn-lg" value="" name="alquilar">Reservar</button>
					<button class="btn btn-info btn-lg" value="" name="contacto">Contacto</button>

				</form>


			</div>
		</div>
	</div>


	<div class=" borde container center wow animated fadeInRight">

		<div class="row">

			<div class=" color1 col-sm-12">El Bolson</div>
		</div>

		<div class="row">
			<div class=" color2 col-sm-4">Izquierda</div>
			<div class="color2 col-sm-8">
				<div id="carouselExampleIndicators4" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to=""
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to=""></li>
						<li data-target="#carouselExampleIndicators" data-slide-to=""></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="style/img/bolson1.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/bolson2.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/bolson3.jpg" class="d-block w-100" alt="">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators4"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next"
						href="#carouselExampleIndicators4" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>



			</div>
		</div>

		<div class="row">
			<div class=" color3 col-sm-12">
				<form method="post" action="Reservas">
                      <input type="hidden" name="idcabana" value="4">
					<button class="btn btn-success btn-lg" value="" name="alquilar">Reservar</button>
					<button class="btn btn-info btn-lg" value="" name="contacto">Contacto</button>

				</form>



			</div>
		</div>
	</div>


	<div class=" borde container center wow animated fadeInLeft">

		<div class="row">

			<div class=" color1 col-sm-12 ">Esquel</div>
		</div>

		<div class="row">
			<div class=" color2 col-sm-4">Izquierda</div>
			<div class="color2 col-sm-8">
				<div id="carouselExampleIndicators5" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to=""
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to=""></li>
						<li data-target="#carouselExampleIndicators" data-slide-to=""></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="style/img/esquel1.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/esquel2.jpg" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="style/img/esquel3.jpg" class="d-block w-100" alt="">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators5"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next"
						href="#carouselExampleIndicators5" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>



			</div>
		</div>

		<div class="row">
			<div class=" color3 col-sm-12">
				<form method="post" action="Reservas">
				
                     <input type="hidden" name="idcabana" value="5">
					<button class="btn btn-success btn-lg" value="" name="alquilar">Reservar</button>
					<button class="btn btn-info btn-lg" value="" name="contacto">Contacto</button>

				</form>



			</div>
		</div>
	</div>









</body>
</html>