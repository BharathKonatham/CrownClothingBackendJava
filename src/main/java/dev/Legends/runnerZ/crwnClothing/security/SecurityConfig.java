package dev.Legends.runnerZ.crwnClothing.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable() // Disable CSRF for non-browser clients like Postman
                .authorizeRequests(auth -> auth
                        // Permit registration and login without authentication
                        .requestMatchers("/auth/register", "/auth/login").permitAll()
                        // Protect /admin with role-based authentication (require ROLE_ADMIN)
                        .requestMatchers("/admin").hasRole("ADMIN")
                        // Authenticate any other request

                ).sessionManagement(session->
                                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

                // Allow access to the login page for testing
        return http.build();
    }
}
