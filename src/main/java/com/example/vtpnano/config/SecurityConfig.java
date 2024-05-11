package com.example.vtpnano.config;

import com.example.vtpnano.security.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
//    private final UserDetailsService userDetailsService;
    private final AuthenticationProvider authProvider;

    private final JwtAuthenticationFilter jwtAuthFilter;
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(auth->{
                    auth.requestMatchers(HttpMethod.GET,"api/events","api/events/{id}","api/members","api/members/{id}","api/users","api/users/{id}","api/members/search/{nameOrSurname}").permitAll();
                    auth.requestMatchers(HttpMethod.POST,"api/events","api/members","api/users","api/users/register","/api/users/login").permitAll();
                    auth.requestMatchers(HttpMethod.PUT,"api/events/{id}","api/members/{id}","api/users/{id}").permitAll();
                    auth.requestMatchers(HttpMethod.DELETE,"api/events","api/events/{id}","api/members","api/members/{id}","api/users","api/users/{id}").permitAll();
                    auth.requestMatchers(HttpMethod.GET,"http://localhost:8080/swagger-ui/index.html#/").permitAll();


                }).sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
