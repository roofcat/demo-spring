<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Form</title>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>
<body>
	
	<div class="container">
		
		<br>
		
		<form:form modelAttribute="contactoForm" method="POST" action="">
			
			<h2>Crear contacto</h2>
				
			<div class="form-group">
				<label>Nombre</label>
				<form:input path="nombre" />
			</div>
			
			<div class="form-group">
				<label>Apellido</label>
				<form:input path="apellido" />
			</div>
			
			<button type="submit">Enviar</button>
			
		</form:form>
	
	</div>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</body>
</html>