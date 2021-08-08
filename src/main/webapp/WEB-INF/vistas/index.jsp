<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    
    <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>
	
	<script type="text/javascript">
	
	
	
	$(document).ready(function(){
		
		listar();
		add();
		$(".cuadrosList").hide();
		$(".form2").hide();
		
		
	});
	
	var listar= function(){
		
		var backend = "http://localhost:8080";
		
		var table = $('#partidaList').DataTable({
			"destroy":true,
			"ajax":{
				"url": backend + "/api/partida",
				"type": "GET",
                "dataSrc": ""
              },
			 columns : [
			  { "data" : "id"},
			  { "data" : "jugador_id"},
			  { "data" : "dado_id"},
			  {	"defaultContent" : "<button class='editar btn btn-warning'>Editar</button>"}
			  /*{	"defaultContent" : "<button class='quemar btn btn-danger'>Quemar</button>"},
			  {	"defaultContent" : "<button class='add btn btn-secondary'>Nuevo Cuadro</button>"},
			  {	"defaultContent" : "<button class='ver btn btn-primary'>Ver Cuadros</button>"},
			  {	"defaultContent" : "<button class='recargar btn btn-success'>Recargar</button>"}*/
			 ]
		});
					
		//ver_cuadros("#tiendaList tbody", table);
		//add_cuadros("#tiendaList tbody", table);
		editar_datos("#partidaList tbody", table);
		//quemar_cuadros("#tiendaList tbody", table);
		//recargar("#tiendaList tbody", table);
	}
	
	var editar_datos = function(tbody,table){
		$(tbody).on("click", "button.editar", function(){
			var data = table.row( $(this).parents("tr") ).data();
			var id = $("#idf").val(data.id),
				nombre = $("#nombref").val(data.nombre);
		})
	}
	
	/*var listar= function(){
		
			var backend = "http://localhost:8080";
			
			var table = $('#tiendaList').DataTable({
				"destroy":true,
				"ajax":{
					"url": backend + "/api/shops",
					"type": "GET",
	                "dataSrc": ""
	              },
				 columns : [
				  { "data" : "id"},
				  { "data" : "nombre"},
				  { "data" : "capacidad"},
				  {	"defaultContent" : "<button class='editar btn btn-warning'>Editar</button>"},
				  {	"defaultContent" : "<button class='quemar btn btn-danger'>Quemar</button>"},
				  {	"defaultContent" : "<button class='add btn btn-secondary'>Nuevo Cuadro</button>"},
				  {	"defaultContent" : "<button class='ver btn btn-primary'>Ver Cuadros</button>"},
				  {	"defaultContent" : "<button class='recargar btn btn-success'>Recargar</button>"}
				 ]
			});
						
			ver_cuadros("#tiendaList tbody", table);
			add_cuadros("#tiendaList tbody", table);
			editar_datos("#tiendaList tbody", table);
			quemar_cuadros("#tiendaList tbody", table);
			recargar("#tiendaList tbody", table);
	}
	
	
	var editar_datos = function(tbody,table){
		$(tbody).on("click", "button.editar", function(){
			var data = table.row( $(this).parents("tr") ).data();
			var id = $("#idf").val(data.id),
				nombre = $("#nombref").val(data.nombre),
				capacidad = $("#capacidadf").val(data.capacidad);
		})
	}
	
	
	var ver_cuadros = function(tbody,lista){
		$(tbody).on("click", "button.ver", function(){
			var data = lista.row( $(this).parents("tr") ).data();
			var id = data.id;
			
			console.log(data);
			
			
			var backend = "http://localhost:8080";
			
			$('#cuadrosList').dataTable().fnDestroy();
			
			var table = $('#cuadrosList').DataTable({
				"destroy":true,
				"ajax":{
					"url": backend + "/api/shops/"+id+"/pictures",
					"type": "GET",
	                "dataSrc": ""
	              },
				 columns : [
				  { "data" : "id"},
				  { "data" : "nombre"},
				  { "data" : "autor"},
				  { "data" : "precio"},
				  { "data" : "tienda.nombre"}
				 ]
			});
			
			
			$(".cuadrosList").show(2000);
			
			
		})
	}
	
	var add_cuadros = function(tbody,lista){
		$(tbody).on("click", "button.add", function(){
			var data = lista.row( $(this).parents("tr") ).data();
			var id = data.id;
			var backend = "http://localhost:8080";
			
			console.log(data);
			
			$(".form1").hide();
			
						
			var table = $('#cuadrosList').DataTable({
				"destroy":true,
				"ajax":{
					"url": backend + "/api/shops/"+id+"/pictures",
					"type": "GET",
	                "dataSrc": ""
	              },
				 columns : [
				  { "data" : "id"},
				  { "data" : "nombre"},
				  { "data" : "autor"},
				  { "data" : "precio"},
				  { "data" : "tienda.nombre"}
				 ]
			});
			
			
			$(".cuadrosList").show(2000);
			$(".form2").show(2200);
			
			$('#cuadrosList').dataTable().fnDestroy();
			
			$("#formDatos2").on("submit", function(e){
				e.preventDefault();
				
				var tienda = {
					"id": $("#idf2").val(),
					"nombre": $("#nombref2").val(),
					"autor": $("#autorf2").val(),
					"precio": $("#preciof2").val(),
					"tienda_id": id
				}
				
				console.log(tienda);
				
				$.ajax({
					url: backend + "/api/shops/"+id+"/pictures",
					type: 'post',
		            dataType: 'json',
		            contentType: 'application/json',
					data: JSON.stringify(tienda)
				}).done( function(){
					
				});
				
				location.reload();
				
			});
			
		})
	}
	
	var quemar_cuadros = function(tbody,lista){
		$(tbody).on("click", "button.quemar", function(){
			var data = lista.row( $(this).parents("tr") ).data();
			var id = data.id;
			
			console.log(data);
			
			
			var backend = "http://localhost:8080";
			
			$('#cuadrosList').dataTable().fnDestroy();
			
			var table = $('#cuadrosList').DataTable({
				"destroy":true,
				"ajax":{
					"url": backend + "/api/shops/"+id+"/pictures",
					"type": "DELETE",
	                "dataSrc": ""
	              }
			});
			
			
			$(".cuadrosList").show(2000);
			
		})
	}
	
	var recargar = function(tbody,lista){
		$(tbody).on("click", "button.recargar", function(){
			location.reload();
		})
	}
	
	var add = function(){
		$("#formDatos1").on("submit", function(e){
			e.preventDefault();
			var backend = "http://localhost:8080";

			
			var tienda = {
				"id": $("#idf").val(),
				"nombre": $("#nombref").val(),
				"capacidad": $("#capacidadf").val()
			}
			
			console.log(tienda);
			
			$.ajax({
				url: backend + "/api/shops",
				type: 'post',
	            dataType: 'json',
	            contentType: 'application/json',
				data: JSON.stringify(tienda)
			}).done( function(){
				
			});
			
			location.reload();
		});
		*/
	}

	
	</script>

</head>
<body>

	<div class="container">
	
		<h2>Partidas</h2>
		<table class="table table-striped tiendaList" id="partidaList">
		
			<thead>
			    <tr>
				    <th>Id</th>
				    <th>Jugador</th>
				    <th>Dado</th>
				    <th></th>
				    <th></th>
				    <th></th>
				    <th></th>
				    <th></th>
			    </tr>
			 </thead>
			 <tbody>
			 </tbody>
            
        </table>
	
	</div>
	
	<div class="container cuadrosList">
	
		<h2>Cuadros</h2>
		<table class="table table-striped cuadrosList" id="cuadrosList">
		
			<thead>
			    <tr>
				    <th>Id</th>
				    <th>Nombre</th>
				    <th>Autor</th>
				    <th>Precio</th>
				    <th>Tienda</th>
			    </tr>
			 </thead>
			 <tbody>
			 </tbody>
            
        </table>
	
	</div>
	
        
       <div id="form1" class="form form1 container">
       
       		<h4>Datos Jugador</h4>
            
            <form id="formDatos1" class="form form1" method="POST" action="/">
			
				<input type="text" name="id" id="idf" value="">
				
				<label for="nombre">Nombre:</label>
				<input type="text" name="nombre" id="nombref" value="">
				<input type="submit" name="submit" value="Enviar">
			</form>
			<a href="/">Limpiar</a>
            
        </div>
        
        <div id="form2" class="form form2 container">
       
       		<h4>Datos Cuadro</h4>
            
            <form id="formDatos2" class="form form2" method="POST" action="/">
			
				<input type="text" name="id" id="idf2" value="">
				
				<label for="nombre">Nombre:</label>
				<input type="text" name="nombre" id="nombref2" value="">
				<label for="autor">Autor:</label>
				<input type="text" name="autor" id="autorf2" value="">
				<label for="precio">Precio:</label>
				<input type="text" name="precio" id="preciof2" value="">
				<input type="submit" name="submit" value="Enviar">
			</form>
			<a href="/">Limpiar</a>
            
        </div>
	

</body>
</html>