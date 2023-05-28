$(document).on("click", "#btnagregar", function(){
	$("#txtdescripcion").val("");
	$("#txtnroasientos").val("");
	$("#hddidregistrosala").val("0");
	$("#cboestado").empty();
	$.ajax({
		type: "GET",
		url: "/Estado/listarEstados",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cboestado").append(
							`<option value="${value.idestado}">
								${value.descestado}</option>`
							);
				})
			}			
		}
	})
	$("#modalSala").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtdescripcion").val($(this).attr("data-descsala"));
	$("#txtnroasientos").val($(this).attr("data-asientos"));
	$("#hddidregistrosala").val($(this).attr("data-idsala"));
	$("#cboestado").empty();
	var idestado = $(this).attr("data-idestado");
	$.ajax({
		type: "GET",
		url: "/Estado/listarEstados",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cboestado").append(
							`<option value="${value.idestado}">
								${value.descestado}</option>`
							);
				})
				$("#cboestado").val(idestado);
			}			
		}
	})
	$("#modalSala").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/sala/registrarSala",
		contentType: "application/json",
		data: JSON.stringify({
			idsala: $("#hddidregistrosala").val(),
			descsala: $("#txtdescripcion").val(),
			asientos: $("#txtnroasientos").val(),
			idestado: $("#cboestado").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarSala();
		}
	});
	$("#modalSala").modal("hide");
})

$(document).on("click", ".btneliminarsala", function(){
	$("#hddideliminarsala").val("");
	$("#hddideliminarsala").val($(this).attr("data-idsala"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-descsala")+"?");
	$("#modalEliminarSala").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/sala/eliminarSala",
		data: JSON.stringify({
			idsala: $("#hddideliminarsala").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarSala();
		}
	})
	$("#modalEliminarSala").modal("hide");
})

function ListarSala(){
	$.ajax({
		type: "GET",
		url: "/sala/listarSalas",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblsala > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblsala > tbody").append("<tr>"+
						"<td>"+value.idsala+"</td>"+
						"<td>"+value.descsala+"</td>"+
						"<td>"+value.asientos+"</td>"+
						"<td>"+value.estado.descestado+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idsala='"+value.idsala+"'"+
							" data-descsala='"+value.descsala+"'"+
							" data-asientos='"+value.asientos+"'"+
							" data-idestado='"+value.estado.idestado+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarsala'"+	
							" data-idsala='"+value.idsala+"'"+
							" data-descsala='"+value.descsala+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





