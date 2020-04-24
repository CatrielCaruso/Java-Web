
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>Insert title here</title>
</head>
<body>

	<div class="d-flex">
		<div class="card col-sm-4">


			<div class="card-body">

				<form class="form-sign" action="GestionPersona" method="POST">
				
				    <div class="form-group">
						<label>Id</label> <input type="text" value="${persona.getIdPersona()}" name="idpersona" readonly="readonly"
							class="form-control">
					</div>
					
					<div class="form-group">
						<label>Dni</label> <input type="text" value="${persona.getDni()}" name="dni"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Apellido</label> <input type="text" value="${persona.getApellido()}" name="apellido"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Nombre</label> <input type="text" value="${persona.getNombre()}" name="nombre"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Telefono</label> <input type="text" value="${persona.getTelefono()}" name="telefono"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Email</label> <input type="text" value="${persona.getEmail()}" name="email"
							class="form-control">
					</div>


					<div class="form-group">
						<label>Usuario</label> <input type="text" value="${persona.getUsuario()}" name="usuario"
							class="form-control">
					</div>

					<div>
						<label>Contraseña</label> <input type="text" value="${persona.getContrasena()}" name="contrasena"
							class="form-control">
					</div>
         
					
					<input type="submit" name="accion" value="agregar"
						class="btn btn-success btn-lg">
				    <input type="submit" name="listar" value="listar"
						class="btn btn-info btn-lg">
					  <input type="submit" name="actualizar" value="actualizar"
						class="btn btn-primary btn-lg">				
					 
						
                    
				</form>



			</div>


		</div>


		<div class="col-sm-8">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>IdPersona</th>
						<th>Dni</th>
						<th>Apellido</th>
						<th>Nombre</th>
						<th>Email</th>
						<th>Telefono</th>
						<th>Usuario</th>
						<th>Contraseña</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
				
			<c:forEach items="${allPeople}" var="p">
					<tr>
					
					    <td>${p.getIdPersona()}</td>
					    <td>${p.getDni()}</td>
						<td>${p.getApellido()}</td>
						<td>${p.getNombre()}</td>
						<td>${p.getEmail()}</td>
						<td>${p.getTelefono()}</td>
				        <td>${p.getUsuario()}</td>
				        <td>${p.getContrasena()}</td>
				        
						
						   <td>
						    <form method="post" action="GestionPersona">
						     <button class="btn btn-warning btn-lg" value="${p.getIdPersona()}" name="modificar">Editar</button>
						     <button class="btn btn-danger btn-lg"  value="${p.getIdPersona()}" name="borrar">Delete</button>
						    </form>
						  </td>
					</tr>
              </c:forEach>

				</tbody>
			</table>

		</div>
	</div>



	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>