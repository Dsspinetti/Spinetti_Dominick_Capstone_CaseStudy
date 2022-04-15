//package com.example.spinetti_case_study.security;
//
//
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//
//        http.authorizeRequests()
//                .mvcMatchers("/login").permitAll()
//                .mvcMatchers("/deleteUser/**").hasAnyRole("SUPERADMIN")
//                .mvcMatchers("/showFormForUpdate/**").hasAnyRole("ADMIN", "SUPERADMIN")
//                .mvcMatchers("/listAccounts/**").hasAnyRole("ADMIN", "SUPERADMIN")
//                .mvcMatchers("/saveUser/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
////                .antMatchers("/**").permitAll()
//                .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/main.css");
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder.encode("user")).roles("USER").and()
//                .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").and()
//                .withUser("superadmin").password(passwordEncoder.encode("superadmin")).roles("USER", "ADMIN", "SUPERADMIN");
//
//    }
//}
package com.example.spinetti_case_study.security;

import com.example.spinetti_case_study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // We will create userService class in upcoming step
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .antMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
        // @formatter:on
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

        @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/main.css");
    }


}



