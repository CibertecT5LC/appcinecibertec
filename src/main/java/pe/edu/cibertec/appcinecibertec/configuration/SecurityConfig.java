package pe.edu.cibertec.appcinecibertec.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import pe.edu.cibertec.appcinecibertec.service.UsuarioDetalleService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Autowired
	private final UsuarioDetalleService 
		usuarioDetalleService;
	
	@Bean
	public SecurityFilterChain 
		configure(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests()
			.antMatchers("/auth/login",
					"/auth/registrar",
					"/auth/guardarUsuario",
					"/resources/**",
					"/static/**",
					"/css/**",
					"/js/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin().loginPage("/auth/login")
			.usernameParameter("txtusuario")
			.passwordParameter("txtpassword")
			.defaultSuccessUrl("/home")
			.failureUrl("/auth/login?error=true")
			.and()
			.authenticationProvider(
					authenticationProvider());
		return http.build();
			
	}
	
	@Bean
	public AuthenticationProvider 
		authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider
			= new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(
				usuarioDetalleService);
		authenticationProvider.setPasswordEncoder(
				new BCryptPasswordEncoder());
		return authenticationProvider;
	}
	
}
