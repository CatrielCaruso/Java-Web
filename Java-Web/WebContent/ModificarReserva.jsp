<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<title>Modificar reserva</title>
</head>
<body>
       
       <div class="container center">
       <div class="col-sm-8">






		<form class="form-sign" action="Reservas" method="POST">






						<div class="form-group">
							<label>Fecha desde:</label> <input type="text" name="fecha_desde"
								class="form-control" placeholder="AAAA/MM/DD"  >
						</div>

						<div class="form-group">
							<label>Fecha hasta:</label> <input type="text" name="fecha_hasta"
								class="form-control" placeholder="AAAA/MM/DD" >
						</div>



                         
                      


                        <input type="hidden" name="idreserva" value="${reserva.getIdReserva()}">
						<input type="hidden" name="idcabana" value="${reserva.getCaba().getIdCabana()}">
							<input type="hidden" name="idpersona" value="${reserva.getPer().getIdPersona()}">
						<input type="submit" name="actualizar" value="RESERVAR"
							class="btn btn-success btn-lg">




					</form>
					
			</div>	
			
	</div>		
			
			
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