package com.jahedullah.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    //We are Using inMemory data sorage here.
    //SO, WHAT IS INMEMORY STORAGE??  The data storage we are using in this below mehtod is the server.
    //Whenever the server gets started the data storage  is created up and goes away all data after the termination of the server.

    //NoopPassEncoder used when the passwords are stored in a plaintext.
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("jahedul")
//                .password("jahedul123")
//                .roles("admin");
//    }
//
//    @Bean
//    PasswordEncoder getPassWordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }


    //BcryptPassword encoder is an algorithm which encodes the password in a different format. Below is the implementation.

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("jahedul")
                // If you use {noop} or {bcrypt} before the password make sure you are not using the bean configuration in project config file for the password encoder.
                .password("{bcrypt}$2a$12$.N2VMZ7drJ/S3Hv0RXQpUewrfnQABF3HrITW08Nw6i99qaeORTzH2") // this is BcryptEncoded for password string : "jahedul123"
                .roles("admin");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin();

    }
    //Usage of permitAll() and debyAll()
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/greet").permitAll()
//                .antMatchers("/","/securityWorld")
//                .authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .formLogin();
//
//    }
}
