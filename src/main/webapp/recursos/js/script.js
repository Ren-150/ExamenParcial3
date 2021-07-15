$(document).ready(function(){
	listar();
	listar2();
	limpiar();
	
});


function listar2(){
	$.get("cc", {"opc":1}, function(data){
		var x= JSON.parse(data);
		$("#categ tbody tr").remove();
		for(var i=0;i<x.length;i++){
			$("#categ").append("<option>"+x[i].nombre+"</option>");
		}
	});
}


function listar(){
	$.get("rc", {"opc":1}, function(data){
		var x= JSON.parse(data);
		$("#tablita tbody tr").remove();
		for(var i=0;i<x.length;i++){
			$("#tablita").append("<tr><td>"+(i+1)+"</td><td>"+x[i].idproducto+"</td><td>"+x[i].nombre+"</td><td>"+x[i].precio+"</td><td>"+x[i].stock+"</td><td><a href='#' onclick='editar("+x[i].idproducto+")'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></i></a></td><td><a href='#' onclick='eliminar("+x[i].idproducto+")'><i class='fa fa-trash' aria-hidden='true'></i></a></td></tr>");
		}
	});
}

$("#registrar").click(function(){
	var idr = $("#id").val();
	if(idr==0){
	var param = {"nombre":$("#nom").val(), "precio":$("#precio").val(), "stock":$("#stock").val(), "opc":2};
	$.ajax({
		beforeSend: function(){
			$('#resultado').html('Esperando...!');
		},
		data: param,
		url: 'rc',
		type: 'POST',
		success: function(response){
			alert(response);
			limpiar();
			listar();
		},
		error: function(jqXHR, estado, error){
		console.log(estado)
		console.log(error)
		},
		complete: function (jqXHR, estado){
			console.log(estado)
		}		
	});
	}else{
		alert($("#id").val()+"/"+$("#nom").val()+"/"+$("#precio").val()+"/"+$("#stock").val());
		$.post("rc",{"id":$("#id").val(),"nombre":$("#nom").val(),"precio":$("#precio").val(),"stock":$("#stock").val(), "opc":4},function (data) {
		listar();
		limpiar();
    });
	}
});

function editar(id){
	$("#registrar").html("Editar");
	$.get("rc",{"id":id,"opc":3},function (data) {
		var x = JSON.parse(data);
		$("#id").val(x.idproducto)
		$("#nom").val(x.nombre)
		$("#precio").val(x.precio)
		$("#stock").val(x.stock);
    });
}
function eliminar(id){
	$.get("rc",{"id":id,"opc":5},function () {
        listar();
    });
}
function limpiar(){
	$("#id").val(0);
	$("#nom").val("");
	$("#precio").val("");
	$("#stock").val("");
	$("#nom").focus();
	$("#registrar").html("Registrar");
}
