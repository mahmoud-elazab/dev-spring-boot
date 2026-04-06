package com.melazab.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // adding support for JDBC

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    };


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/managers/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                ).logout(logout -> logout.permitAll()
                ).exceptionHandling(configurer ->
                configurer.accessDeniedPage("/access-denied")
                );
        return http.build();
    }

        /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails max = User.builder()
                .username("max")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails katja = User.builder()
                .username("katja")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails karl = User.builder()
                .username("karl")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(max, katja, karl);
    }

     */

}
