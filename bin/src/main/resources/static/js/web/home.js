$(document).on("click", "#btnempezar", 
		function(){
	//alert("Hola Mundo Javascript");
	let usuario = $("#txtusuario").val();
	let password = $("#txtpassword").val();
	$("#lbldatos").text("Usuario: "+ usuario
			+" - Password: "+ password);
	$("#modalempezar").modal("show");
})