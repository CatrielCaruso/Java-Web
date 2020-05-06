
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
	
	<link href="style/css/SeleccionarReservaAdministrador.css" rel="stylesheet">


<title>Seleccionar Cabañas</title>
</head>
<body>

	<%@include file="../PrincipalAdministrador.jsp"%>







	<div class="container center animated fadeInLeft">
		






			<form class="form-sign" action="Reservas" method="POST">




				<div class="form-group">

					<h3 class=" col-sm-2 control-label">Nombre:${persona.getNombre()}</h3>
				</div>
				<div class="form-group">
					<h3 class=" col-sm-2 control-label">Apellido:${persona.getApellido()}</h3>
				</div>

				<div class="form-group">
					<h3 class=" col-sm-4 control-label">Seleccionar destino</h3>


					<div class="col-sm-6 cont1">

						<select name="idcabana" id="tipo" class="form-control">
							<c:forEach items="${allCabana}" var="c">

								<option value="${c.getIdCabana()}">${c.getLugar()}</option>
							</c:forEach>
						</select>
					</div>
				</div>





                   <div class="col-sm-6 cont2">


				<div class="form-group col">
					<h3>Fecha desde:</h3>
					<input type="text" name="fecha_desde" class="form-control"
						placeholder="AAAA/MM/DD">
				</div>

				<div class="form-group col">
					<h3>Fecha hasta:</h3>
					<input type="text" name="fecha_hasta" class="form-control"
						placeholder="AAAA/MM/DD">
				</div>








				
				<input type="hidden" name="idpersona"
					value="${persona.getIdPersona()}"> <input type="submit"
					name="ErrorAdministrador"  value="Volver al menú principal" class="btn btn-primary btn-lg"> <input
					type="submit" name="ReservaAdministrador" value="RESERVAR"
					class="btn btn-success btn-lg">


              </div>
              

			</form>

		</div>

	














	<%@include file="../Footer.jsp"%>
</body>
</html>