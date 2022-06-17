package mx.edu.utn.senderoseguro.web.controlador.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.edu.utn.senderoseguro.entidad.CatalogoRolWeb;
import mx.edu.utn.senderoseguro.entidad.UsuarioWeb;

@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends User {

	private static final long serialVersionUID = 1L;
	
	private Integer idUsuario;

	private String firstName;

	private String lastName;

	public Usuario(UsuarioWeb usuarioWeb, List<CatalogoRolWeb> roles) {
		this(usuarioWeb.getCorreo(), usuarioWeb.getContrasena(), roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRolWeb())).collect(Collectors.toList()));
		setIdUsuario(usuarioWeb.getIdUsuarioWeb());
		setFirstName(usuarioWeb.getNombres());
		setLastName(usuarioWeb.getApellidos());
	}

	public Usuario(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, true, true, true, true, authorities);
	}

	public Usuario(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

}
