package com.nexmeter.kubecontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Tony
 * 2024/4/19
 */
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated()
                )
                .csrf((csrf) -> csrf.ignoringRequestMatchers("/token"))
                .httpBasic(Customizer.withDefaults())
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // @formatter:on
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        // @formatter:off
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password("{noop}password")
                        .authorities("all")
                        .build()
        );
        // @formatter:on
    }
}
