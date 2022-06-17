package mx.edu.utn.senderoseguro.web.controlador;

import static java.util.Arrays.asList;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.edu.utn.senderoseguro.servicio.ServicioUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase;
import mx.edu.utn.senderoseguro.web.controlador.dto.Usuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuarioMovil;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.RegistroUsuarioDTO;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudActivarUsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudActivarUsuariosMovil;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudInactivarUsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudInactivarUsuariosMovil;
import mx.edu.utn.senderoseguro.web.datatables.BaseDatatablesDTO;
import mx.edu.utn.senderoseguro.web.datatables.DataTableRequest;
import mx.edu.utn.senderoseguro.web.datatables.DataTableResults;
import mx.edu.utn.senderoseguro.web.datatables.PaginationCriteria;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/usuario")
public class ControladorUsuarios {

	private final ServicioUsuario servicioUsuario;
	
	@GetMapping(value = "/registra-usuario-web")
	public ModelAndView muestraVistaRegistraUsuarioWeb() {
		ModelAndView model = new ModelAndView("usuarios/registra-usuario-web");
		model.addObject("usuario", new RegistroUsuarioDTO());
		model.addObject("rolesWeb", servicioUsuario.obtenerRolesWeb());
		return model;
	}
	
	@GetMapping(value = "/registra-usuario-conductor")
	public ModelAndView muestraVistaRegistraUsuarioConductor() {
		ModelAndView model = new ModelAndView("usuarios/registra-usuario-conductor");
		model.addObject("usuario", new RegistroUsuarioDTO());
		return model;
	}
	
	@GetMapping(value = "/administrar-usuarios-web")
	public ModelAndView administrarUsuariosWeb() {
		ModelAndView model = new ModelAndView("usuarios/administrar-usuarios-web");
		model.addObject("javascriptFiles", asList("/js/usuarios/funciones_administrar_usuarios_web.js"));
		return model;
	}
	
	@GetMapping(value = "/administrar-usuarios-movil")
	public ModelAndView administrarUsuariosMovil() {
		ModelAndView model = new ModelAndView("usuarios/administrar-usuarios-movil");
		model.addObject("javascriptFiles", asList("/js/usuarios/funciones_administrar_usuarios_movil.js"));
		return model;
	}
	
	@PostMapping(value = "/registra-usuario-web")
	public String registraUsuarioWeb(@ModelAttribute("usuario") RegistroUsuarioDTO registrationDto) {
		log.info(registrationDto.toString());
		RespuestaBase respuesta = servicioUsuario.registraUsuarioWeb(registrationDto);
		if (respuesta.getCodigo().intValue() == 0) {
			return "redirect:/usuario/registra-usuario-web?success";
		} else {
			return "redirect:/usuario/registra-usuario-web?failure=" + respuesta.getMensaje();
		}
	}
	
	@PostMapping(value = "/registra-usuario-conductor")
	public String registraUsuarioConductor(@ModelAttribute("usuario") RegistroUsuarioDTO registrationDto) {
		log.info(registrationDto.toString());
		RespuestaBase respuesta = servicioUsuario.registraUsuarioConductor(registrationDto);
		if (respuesta.getCodigo().intValue() == 0) {
			return "redirect:/usuario/registra-usuario-conductor?success";
		} else {
			return "redirect:/usuario/registra-usuario-conductor?failure=" + respuesta.getMensaje();
		}
	}
	
	@PostMapping(value = "/obtener-usuarios-web", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<DataTableResults<ModeloUsuarioWeb>> obtenerModeloUsuariosWeb(Model model,
			@RequestBody DataTableRequest<BaseDatatablesDTO> dataTableRequest) {
		DataTableResults<ModeloUsuarioWeb> dataTableResult = new DataTableResults<ModeloUsuarioWeb>()
				.setRecordsTotal(0).setRecordsFiltered(0)
				.setDraw(0).setData(new ArrayList<>(0));
		try {
			PaginationCriteria.customCriteriosFilter(dataTableRequest);
		} catch (Exception e) {
			log.error("Error al aplicar personalizar los filtros." + e.getMessage(), e);
			return ok(dataTableResult);
		}
				
		try {
			List<ModeloUsuarioWeb> resultado = servicioUsuario.obtenerModeloUsuariosWeb(dataTableRequest.getBaseFilter());
			if (!PaginationCriteria.isObjectEmpty(resultado)) {
				dataTableResult.setRecordsTotal(resultado.get(0).getTotalRecords());
				dataTableResult.setRecordsFiltered(resultado.get(0).getTotalRecords());
				dataTableResult.setDraw(dataTableRequest.getDraw());
				dataTableResult.setData(resultado);
			}
		} catch (Exception e) {
			log.error("Error al obtener registros a mostrar." + e.getMessage(), e);
			return new ResponseEntity<DataTableResults<ModeloUsuarioWeb>>(dataTableResult,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ok(dataTableResult);
	}
	
	@PostMapping(value = "/obtener-usuarios-movil", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<DataTableResults<ModeloUsuarioMovil>> obtenerModeloUsuariosMovil(Model model,
			@RequestBody DataTableRequest<BaseDatatablesDTO> dataTableRequest) {
		DataTableResults<ModeloUsuarioMovil> dataTableResult = new DataTableResults<ModeloUsuarioMovil>()
				.setRecordsTotal(0).setRecordsFiltered(0)
				.setDraw(0).setData(new ArrayList<>(0));
		try {
			PaginationCriteria.customCriteriosFilter(dataTableRequest);
		} catch (Exception e) {
			log.error("Error al aplicar personalizar los filtros." + e.getMessage(), e);
			return ok(dataTableResult);
		}
				
		try {
			List<ModeloUsuarioMovil> resultado = servicioUsuario.obtenerModeloUsuariosMovil(dataTableRequest.getBaseFilter());
			if (!PaginationCriteria.isObjectEmpty(resultado)) {
				dataTableResult.setRecordsTotal(resultado.get(0).getTotalRecords());
				dataTableResult.setRecordsFiltered(resultado.get(0).getTotalRecords());
				dataTableResult.setDraw(dataTableRequest.getDraw());
				dataTableResult.setData(resultado);
			}
		} catch (Exception e) {
			log.error("Error al obtener registros a mostrar." + e.getMessage(), e);
			return new ResponseEntity<DataTableResults<ModeloUsuarioMovil>>(dataTableResult,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ok(dataTableResult);
	}
	
	@PostMapping(value = "/activar-usuario-web", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase> activarUsuarioWeb(Model model, @RequestBody SolicitudActivarUsuarioWeb solicitudActivarUsuarioWeb) {
		Usuario current = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		solicitudActivarUsuarioWeb.setIdUsuarioSolicitante(current.getIdUsuario());
		return ok(servicioUsuario.activarUsuarioWeb(solicitudActivarUsuarioWeb));
	}
	
	@PostMapping(value = "/inactivar-usuario-web", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase> inactivarUsuarioWeb(Model model, @RequestBody SolicitudInactivarUsuarioWeb solicitudInactivarUsuarioWeb) {
		Usuario current = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		solicitudInactivarUsuarioWeb.setIdUsuarioSolicitante(current.getIdUsuario());
		return ok(servicioUsuario.inactivarUsuarioWeb(solicitudInactivarUsuarioWeb));
	}
	
	@PostMapping(value = "/activar-usuarios-movil", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase> activarUsuariosMovil(Model model, @RequestBody SolicitudActivarUsuariosMovil solicitudActivarUsuariosMovil) {
		Usuario current = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		solicitudActivarUsuariosMovil.setIdUsuarioSolicitante(current.getIdUsuario());
		return ok(servicioUsuario.activarUsuariosMovil(solicitudActivarUsuariosMovil));
	}
	
	@PostMapping(value = "/inactivar-usuarios-movil", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase> inactivarUsuariosMovil(Model model, @RequestBody SolicitudInactivarUsuariosMovil solicitudInactivarUsuariosMovil) {
		Usuario current = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		solicitudInactivarUsuariosMovil.setIdUsuarioSolicitante(current.getIdUsuario());
		return ok(servicioUsuario.inactivarUsuariosMovil(solicitudInactivarUsuariosMovil));
	}
}
