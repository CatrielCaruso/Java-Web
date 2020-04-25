<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link href="style/css/Login.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
</head>
<body>
   
   
<div class="animated fadeInUp">
<form id="form" action="Login" method="post">
		<input type="text" placeholder="Usuario" id="usuario" name="user">
		<input type="password" placeholder="Contraseña" id="clave" name="pass">
	<input type="submit" name="loguear" value="Ingresar" id="ingresar">
</form>

 </div>

</body>
</html>