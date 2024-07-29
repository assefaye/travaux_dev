package com.groupe.projet_testeApi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->csrf.disable())// Désactive la protection CSRF
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))// Configuration de la session en mode stateless
                .authorizeRequests(authorize -> authorize
                        .anyRequest().authenticated()) // Authentification requise pour toutes les requêtes
                .httpBasic(Customizer.withDefaults()); // Utilise l'authentification de base HTTP


        return http.build();
    }
}

