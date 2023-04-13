package com.curso.inicio;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
	//definición roles y usuarios
		@Bean
		public InMemoryUserDetailsManager usersDetailsMemory() throws Exception {
			List<UserDetails> users = List.of(
					User.withUsername("user1")
					.password("{noop}user1")
					.roles("INVITADO")
					.build(),
					User.withUsername("user2")
					.password("{noop}user2")
					.roles("USUARIO")
					.build(),
					User.withUsername("user3")
					.password("{noop}user3")
					.roles("ADMIN")
					.build(),
					User.withUsername("user4")
					.password("{noop}user4")
					.roles("USUARIO", "ADMIN")
					.build()

			);
			return new InMemoryUserDetailsManager(users);
		}

	//acceso a recursos
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.csrf().disable()
			.authorizeHttpRequests()
			.antMatchers(HttpMethod.GET, "/obtenerReservasExistentes/**").hasRole("ADMIN")
			/*.antMatchers(HttpMethod.DELETE, "/eliminarCurso/**").hasAnyRole("ADMIN", "OPERADOR")
			.antMatchers(HttpMethod.PUT, "/actualizarDuracion/**").hasAnyRole("ADMIN", "OPERADOR")
			.antMatchers(HttpMethod.GET, "/**").authenticated()*/
			.and().httpBasic();
			return http.build();
		}
}
