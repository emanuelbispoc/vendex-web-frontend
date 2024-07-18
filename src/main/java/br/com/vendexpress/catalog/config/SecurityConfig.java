package br.com.vendexpress.catalog.config;

import br.com.vendexpress.catalog.services.impl.UsuarioDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request.requestMatchers("/login", "/css/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/usuarios").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.GET, "/cadastrar-usuario").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.POST, "/cadastrar-usuario").hasRole("ADMINISTRADOR")
                .requestMatchers(antMatcher("/usuarios/**/atualizar")).hasRole("ADMINISTRADOR")
                .requestMatchers(antMatcher("/usuarios/**/atualizar")).hasRole("ADMINISTRADOR")
                .requestMatchers(antMatcher("/usuarios/**/deletar")).hasRole("ADMINISTRADOR")
                .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("senha")
                .permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UsuarioDetailService();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
