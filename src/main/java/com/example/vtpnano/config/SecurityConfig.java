package com.example.vtpnano.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .userDetailsService(userDetailsService)
                .authorizeHttpRequests(auth->{
                    auth.requestMatchers(HttpMethod.GET,"api/events","api/events/{id}","api/members","api/members/{id}","api/users","api/users/{id}").permitAll();
                    auth.requestMatchers(HttpMethod.POST,"api/events","api/members","api/users","api/users/register").permitAll();
                    auth.requestMatchers(HttpMethod.PUT,"api/events/{id}","api/members/{id}","api/users/{id}").permitAll();
                    auth.requestMatchers(HttpMethod.DELETE,"api/events","api/events/{id}","api/members","api/members/{id}","api/users","api/users/{id}").permitAll();

                }).httpBasic();
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();

        return http.build();
    }


}
