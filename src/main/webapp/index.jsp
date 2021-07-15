<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="recursos/css/bootstrap.min.css" />
<link rel="stylesheet" href="recursos/css/estilos.css" />
<title>Tienda</title>
</head>
<body>
	<div class="row">
		<div class="col-12">
			<nav class="navbar navbar-light colorheader" id="navbar">
				<a class="navbar-brand titulos" style="color: white;" href="#">
					<i class="fas fa-shopping-cart"></i>
					<span style="margin-left: 5px">Tiendita</span>
				</a>
			</nav>
		</div>
	</div>

	<div class="row">
		<div class="col-5">
			<div class="container">
				<form>
					<div class="form-row" style="padding-top: 20px;">
						<div class="form-group col-md-12">
							<label>Nombre</label> <input type="text" class="form-control"
								id="nom">
						</div>
						<div class="form-group col-md-12">
							<label>Precio</label> <input type="number" class="form-control"
								id="precio">
						</div>
						<div class="form-group col-md-12">
							<label>Stock</label> <input type="number" class="form-control"
								id="stock">
						</div>
						
						<div class="form-group col-md-12">
							<%@include file="WEB-INF/templates/categoria.jspf" %>
						</div>
				
						<input type="hidden" class="form-control"	id="id" value="0" />
					</div>

				</form>
				<button class="btn btn-primary" id="registrar">Registrar</button>
			</div>
			
			<div id="resultado"></div>
		</div>
		<div class="col-7">

			<div class="container" style="padding-top: 20px;">
				<table class="table" id="tablita">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">ID</th>
							<th scope="col">Nombre</th>
							<th scope="col">Precio</th>
							<th scope="col">Stock</th>
							<th scope="col" colspan="2">Acción</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>

		</div>
	</div>
	<script src="recursos/js/jquery.js"></script>
	<script src="recursos/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="recursos/js/script.js"></script>
	
</body>
</html>