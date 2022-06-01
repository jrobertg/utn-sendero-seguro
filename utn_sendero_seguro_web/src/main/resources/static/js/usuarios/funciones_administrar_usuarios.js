var tablaUsuarios = undefined;
$(document).ready(function() {
	tablaUsuarios = $('#tablaAdministracionUsuarios').DataTable({
		//dom: 'Bfrtip',
		scrollY: "34vh",
		//scrollX: true,
		responsive: true,
		language: dataTable_es_MX,
		processing: true,
		serverSide : true,
		lengthChange: true,
		searchable: true,
		select: true,
		/*lengthMenu: [
			[25, 50, 75, 100],
			['25 registros', '50 registros', '75 registros', '100 registros']
		],*/
		lengthMenu: [25, 50, 75, 100],
		pageLength: 25,
		pagingType: "full_numbers",
		ajax : {
			url : _ctx + '/usuario/obtener-usuarios',
			type : 'POST',
			dataType : 'json',
			contentType : 'application/json',
			headers: {"X-XSRF-TOKEN": getCookie('XSRF-TOKEN')},
			data : function(data) {
				return JSON.stringify(data);
			}, error: function (xhr, error, thrown) {
				muestraError(xhr, error, thrown);
			}
		},
		columns: [
			{ data: "id", defaultContent: "<i>No establecido</i>", orderable: false },
			{ data: "email", defaultContent: "<i>No establecido</i>" },
			{ data: "firstName", defaultContent: "<i>No establecido</i>" },
			{ data: "lastName", defaultContent: "<i>No establecido</i>" },
			{ data: "idStatus", defaultContent: "<i>No establecido</i>", orderable: false,
				render: function (data, type, row) {
					var strReturn = '';
					if (row.idStatus == 1) {
						strReturn = `<span class="badge rounded-pill bg-success">Activo</span>`;
					} else if (row.idStatus == 2) {
						strReturn = `<span class="badge rounded-pill bg-warning text-dark">Inactivo</span>`;
					}
					return strReturn;
				}
			}
			//{ "data": "idTipoUsuario", "defaultContent": "<i>No establecido</i>" }
		],
		select: {
			style: 'multi'
		},
		buttons: [
			{
				text: 'pageLength',
				/*action: function () {
					table.rows().select();
				}*/
			}
		]
	});

	/*$('table tbody').on('click', 'tr', function() {
		if ($(this).hasClass('selected')) {
			$(this).removeClass('selected');
		} else {
			tablaUsuarios.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});*/
	
	$(".dataTables_filter input")
    	.unbind() // Unbind previous default bindings
    	.bind("keyup input", delay(function(e) { // Bind our desired behavior
            var searchTerm = $(".dataTables_filter input").val();
            if ((searchTerm.length >= 4 || searchTerm === "") && (
            	    e.keyCode == 13 // tecla enter
            	|| (e.keyCode >= 48 && e.keyCode <= 57) // números del 0 al 9
            	|| (e.keyCode >= 65 && e.keyCode <= 90) // letras de la 'A' a la 'Z' mayusculas
            	|| (e.keyCode >= 97 && e.keyCode <= 122) // letras de la 'a' a la 'z' minusculas
            	|| e.keyCode == 241 // letra ñ minuscula
            	|| e.keyCode == 209 // letra Ñ mayuscula
            	|| e.keyCode == 32  // espacio
            	|| e.keyCode == 46  // delete
            	|| e.keyCode == 8  // delete
            )) {
				tablaUsuarios.search(searchTerm).draw();
			} else if(searchTerm === ""){
				tablaUsuarios.search("").draw();
			}
        }, 500));
});

$("#btnSeleccionarTodos").click(function(e) {
	e.preventDefault();
	if (tablaUsuarios !== undefined) {
		tablaUsuarios.rows().select();
	}
});

$("#btnAnularSeleccion").click(function(e) {
	e.preventDefault();
	if (tablaUsuarios !== undefined) {
		tablaUsuarios.rows().deselect();
	}
});

$("#btnActivarSeleccionados").click(function(e) {
	e.preventDefault();
	if (tablaUsuarios !== undefined) {
		var count = tablaUsuarios.rows( { selected: true } ).count();
		if (count >= 1) {
			var json = {};
			json.idUsuarios = [];
			var data = tablaUsuarios.rows( { selected: true } ).data();
			for (let i = 0; i < count; i++) {
				data["" + i + ""];
				json.idUsuarios.push(data["" + i + ""].id);
			}
			asyncPost('/usuarios/activar-usuarios', json,
				function(respuesta) {
					if (respuesta != null && respuesta != undefined && respuesta.codigo == 0) {
						console.log("respuesta: " + JSON.stringify(respuesta));
						tablaUsuarios.draw();
					} else {
						
					}
				},
				function(jqxhr, error, errorEstado) {
					muestraError(jqxhr, error, errorEstado);
					//$('#ModalError #spanError').text("Error al almacenar las preguntas generales, favor de volverlo a intentar.");
					//$("#ModalError").modal({show: true, backdrop: 'static', keyboard: false});
				});
		}
	}
});

$("#btnInactivarSeleccionados").click(function(e) {
	e.preventDefault();
	if (tablaUsuarios !== undefined) {
		var count = tablaUsuarios.rows( { selected: true } ).count();
		if (count >= 1) {
			var json = {};
			json.idUsuarios = [];
			var data = tablaUsuarios.rows( { selected: true } ).data();
			for (let i = 0; i < count; i++) {
				data["" + i + ""];
				json.idUsuarios.push(data["" + i + ""].id);
			}
			asyncPost('/usuarios/inactivar-usuarios', json,
				function(respuesta) {
					if (respuesta != null && respuesta != undefined && respuesta.codigo == 0) {
						console.log("respuesta: " + JSON.stringify(respuesta));
						tablaUsuarios.draw();
					} else {
						
					}
				},
				function(jqxhr, error, errorEstado) {
					muestraError(jqxhr, error, errorEstado);
					//$('#ModalError #spanError').text("Error al almacenar las preguntas generales, favor de volverlo a intentar.");
					//$("#ModalError").modal({show: true, backdrop: 'static', keyboard: false});
				});
		}
	}
});