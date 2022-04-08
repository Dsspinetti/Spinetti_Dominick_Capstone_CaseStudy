package com.example.spinetti_case_study.security;


import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/deleteUser/**").hasAnyRole("SUPERADMIN")
                .mvcMatchers("/showFormForUpdate/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/listAccounts/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/saveUser/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
//                .antMatchers("/**").permitAll()
                .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/main.css");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder.encode("user")).roles("USER").and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").and()
                .withUser("superadmin").password(passwordEncoder.encode("superadmin")).roles("USER", "ADMIN", "SUPERADMIN");

    }
}