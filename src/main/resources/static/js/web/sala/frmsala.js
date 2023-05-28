$(document).on("click", "#btnagregar", function(){
	$("#txtdescripcion").val("");
	$("#txtnroasientos").val("");
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