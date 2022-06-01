package mx.edu.utn.senderoseguro.web.controlador.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends User {

	private static final long serialVersionUID = 1L;
	
	private Long idUsuario;

	private String firstName;

	private String lastName;

	public Usuario(mx.edu.utn.senderoseguro.modelo.User user) {
		this(user.getEmail(), user.getPassword(), user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
		setIdUsuario(user.getId());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
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
