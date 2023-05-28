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