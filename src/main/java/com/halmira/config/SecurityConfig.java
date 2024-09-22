package com.halmira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF in Spring Security 6.x
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/users/register").permitAll()  // Allow access to registration without authentication
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .build();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // In-memory user store for testing purposes
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build()
        );
    }
}
