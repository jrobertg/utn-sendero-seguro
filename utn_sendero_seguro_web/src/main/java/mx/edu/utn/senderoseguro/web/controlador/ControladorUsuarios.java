package mx.edu.utn.senderoseguro.web.controlador;

import static java.util.Objects.isNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.edu.utn.senderoseguro.modelo.User;
import mx.edu.utn.senderoseguro.servicio.ServicioUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.RespuestaBase;
import mx.edu.utn.senderoseguro.web.controlador.dto.Usuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.RegistroUsuarioDTO;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudActivarUsuario;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.SolicitudInactivarUsuario;
import mx.edu.utn.senderoseguro.web.datatables.BaseDatatablesDTO;
import mx.edu.utn.senderoseguro.web.datatables.DataTableRequest;
import mx.edu.utn.senderoseguro.web.datatables.DataTableResults;
import mx.edu.utn.senderoseguro.web.datatables.PaginationCriteria;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ControladorUsuarios {

	private final ServicioUsuario servicioUsuario;
	
	@GetMapping(value = "/registro")
	public ModelAndView showRegistrationForm() {
		ModelAndView model = new ModelAndView("usuarios/registro");
		model.addObject("user", new RegistroUsuarioDTO());
		return model;
	}
	
	@GetMapping(value = "/administrar-usuarios")
	public ModelAndView administrarUsuarios() {
		ModelAndView model = new ModelAndView("usuarios/administrar_usuarios");
		return model;
	}
	
	@PostMapping(value = "/registro")
	public String registerUserAccount(@ModelAttribute("user") RegistroUsuarioDTO registrationDto) {
		log.info(registrationDto.toString());
		User currentUser = servicioUsuario.obtenerUsuarioPorCorreo(registrationDto.getEmail());
		if (isNull(currentUser)) {
			servicioUsuario.save(registrationDto);
			return "redirect:/registro?success";
		} else {
			return "redirect:/registro?failure";
		}
	}
	
	@PostMapping(value = "/usuario/obtener-usuarios", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<DataTableResults<ModeloUsuario>> obtenerModeloUsuarios(Model model,
			@RequestBody DataTableRequest<BaseDatatablesDTO> dataTableRequest) {
		DataTableResults<ModeloUsuario> dataTableResult = new DataTableResults<ModeloUsuario>()
				.setRecordsTotal(0).setRecordsFiltered(0)
				.setDraw(0).setData(new ArrayList<>(0));
		try {
			PaginationCriteria.customCriteriosFilter(dataTableRequest);
		} catch (Exception e) {
			log.error("Error al aplicar personalizar los filtros." + e.getMessage(), e);
			return ok(dataTableResult);
		}
				
		try {
			List<ModeloUsuario> resultado = servicioUsuario.obtenerConsultaModeloUsuarios(dataTableRequest.getBaseFilter());
			if (!PaginationCriteria.isObjectEmpty(resultado)) {
				dataTableResult.setRecordsTotal(resultado.get(0).getTotalRecords());
				dataTableResult.setRecordsFiltered(resultado.get(0).getTotalRecords());
				dataTableResult.setDraw(dataTableRequest.getDraw());
				dataTableResult.setData(resultado);
			}
		} catch (Exception e) {
			log.error("Error al obtener registros a mostrar." + e.getMessage(), e);
			return new ResponseEntity<DataTableResults<ModeloUsuario>>(dataTableResult,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ok(dataTableResult);
	}
	
	@PostMapping(value = "/usuarios/activar-usuarios", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase> activarUsuarios(Model model, @RequestBody SolicitudActivarUsuario solicitudActivarUsuario) {
		Usuario current = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		solicitudActivarUsuario.setIdUsuarioSolicitante(current.getIdUsuario());
		return ok(servicioUsuario.activarUsuarios(solicitudActivarUsuario));
	}
	
	@PostMapping(value = "/usuarios/inactivar-usuarios", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase> inactivarUsuarios(Model model, @RequestBody SolicitudInactivarUsuario solicitudInactivarUsuario) {
		Usuario current = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		solicitudInactivarUsuario.setIdUsuarioSolicitante(current.getIdUsuario());
		return ok(servicioUsuario.inactivarUsuarios(solicitudInactivarUsuario));
	}
	
	@ModelAttribute("javascriptFiles")
	public List<String> javascriptFiles() {
		return Arrays.asList(
			"/js/usuarios/funciones_administrar_usuarios.js"
		);
	}
}
