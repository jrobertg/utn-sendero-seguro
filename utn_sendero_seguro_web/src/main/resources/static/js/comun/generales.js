let ctx = $("meta[name='_ctx']").attr("content");
let _ctx;
if (ctx == '-') {
	_ctx = '';
} else {
	_ctx = ctx;
}

const dataTable_es_MX = {
	"sProcessing": "Procesando...",
	"sLengthMenu": "Mostrar _MENU_ registros",
	"sZeroRecords": "No se encontraron resultados",
	"sEmptyTable": "Ningún dato disponible en esta tabla",
	"sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	"sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	"sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	"sInfoPostFix": "",
	"sSearch": "Búsqueda local",
	"sUrl": "",
	"sInfoThousands": ",",
	"sLoadingRecords": "Cargando...",
	"oPaginate": {
		"sFirst": "Primero",
		"sLast": "Último",
		"sNext": "Siguiente",
		"sPrevious": "Anterior"
	},
	"oAria": {
		"sSortAscending": ": Activar para ordenar la columna de manera ascendente",
		"sSortDescending": ": Activar para ordenar la columna de manera descendente"
	},
	"select": {
		"rows": {
			_: "%d registros seleccionados",
			0: "",
			1: "1 registro seleccionado"	
		}
	}
}

function muestraError(jqxhr, error, errorEstado) {
	if (error != null && error != undefined) {
		console.log("jqxhr: " + JSON.stringify(jqxhr));
		console.log("error: " + error);
		console.log("errorEstado: " + errorEstado);
	}
}

function getCookie(key) {
	var keyValue = document.cookie.match('(^|;) ?' + key + '=([^;]*)(;|$)');
	return keyValue ? keyValue[2] : null;
}

function delay(callback, ms) {
	var timer = 0;
	return function() {
		var context = this, args = arguments;
		clearTimeout(timer);
		timer = setTimeout(function () {
			callback.apply(context, args);
		}, ms || 0);
	};
}

function asyncPost(recurso, json, procesarRespuesta = function(respuesta) {}, procesarError = function(jqxhr, error, errorEstado) {}) {
	if (json !== undefined) {
		return $.ajax({
			url: _ctx + recurso,
			type: 'POST',
			dataType: "json",
			contentType: 'application/json; charset=utf-8',
			headers: {"X-XSRF-TOKEN": getCookie('XSRF-TOKEN')},
			data: JSON.stringify(json),
			success: procesarRespuesta,
			error: procesarError
		});
	} else {
		return $.ajax({
			url: _ctx + recurso,
			type: 'POST',
			dataType: "json",
			contentType: 'application/json; charset=utf-8',
			headers: {"X-XSRF-TOKEN": getCookie('XSRF-TOKEN')},
			success: procesarRespuesta,
			error: procesarError
		});
	}
}