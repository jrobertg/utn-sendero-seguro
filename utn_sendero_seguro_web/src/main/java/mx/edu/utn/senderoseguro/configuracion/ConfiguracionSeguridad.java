package mx.edu.utn.senderoseguro.configuracion;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;
import mx.edu.utn.senderoseguro.servicio.ServicioUsuario;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	private final ServletContext servletContext;
	private final ServicioUsuario servicioUsuario;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(servicioUsuario);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		http
			.authorizeRequests()
				.antMatchers("/webjars/**","/assets/**")
				.permitAll()
			.anyRequest()
				.authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
			.and()
				.logout()
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login?logout")
					.permitAll();
	}
	
	@Bean
	public ContextPathService contextPathService() {
		return () -> servletContext.getContextPath().isEmpty() ? "-" : servletContext.getContextPath();
	}
	
	public interface ContextPathService {
		String getApplicationUrl();	
	}

}
