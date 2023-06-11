$(document).on("click", "#btnagregar", function(){
	$("#txtnombre").val("");
	$("#txtapellido").val("");
	$("#modalEmpleado").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	if($("#txtnombre").val() == ""){
		$("#errornombre").text("Es obligatorio el nombre.");
	}else{
		$("#errornombre").text("");
	}
	if($("#txtapellido").val() == ""){
		$("#errorapellido").text("Es obligatorio el apellido.");
	}else{
		$("#errorapellido").text("");
	}
	if($("#txtnombre").val() != "" 
		&& $("#txtapellido").val() != "")
	{
		$.ajax({
			type: "POST",
			url: "/empleado/registrarEmpleado",
			contentType: "application/json",
			data: JSON.stringify({
				nombre: $("#txtnombre").val(),
				apellido: $("#txtapellido").val()				
			}),
			success: function(resultado){
				alert(resultado.mensaje);
				ListarEmpleado();
			}
		});
		$("#modalEmpleado").modal("hide");
	}
	
	
})


function ListarEmpleado(){
	$.ajax({
		type: "GET",
		url: "/empleado/listarempleados",
		dataType: "json",
		success: function(resultado){
			console.log(resultado);
			$("#tblempleado > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblempleado > tbody").append("<tr>"+
						"<td>"+value.idempleado+"</td>"+
						"<td>"+value.nombre+"</td>"+
						"<td>"+value.apellido+"</td>"+
						"<td>"+value.fechacontrat+"</td>"+													
						"</tr>")
			})
		}
	})
}