package com.Biblioteca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                .antMatchers("/libros/agregar*", "/libros/guardar", "/libros/editar/**",
                        "/libros/eliminar/**", "/libros/**/copias", "/libros/**/copias/agregar",
                        "/libros/**/copias/**/eliminar")
                .hasRole("ADMIN")
                .antMatchers("/usuario", "/libros", "/libros/buscar/**", "/prestamos")
                .hasAnyRole("ADMIN", "USER"))
                .formLogin(login -> login.loginPage("/login"))
                .exceptionHandling(handling -> handling
                        .accessDeniedPage("/errors/403"));
    }
}
