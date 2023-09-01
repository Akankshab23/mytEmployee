package com.myt.employee.confic;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//		defaul security
//		 http.authorizeRequests(request->request.anyRequest().authenticated());
//		 http.formLogin();
//		 http.httpBasic();

      http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/api/v1/addEmployee").authenticated()
                .antMatchers("/api/v1/delete/{empId}").authenticated()
                .antMatchers("/api/v1/update/{empId}").authenticated()
                .antMatchers("/api/v1/pagingAndSortingEmployee/{pageNumber}/{pageSize}").authenticated()
                .antMatchers("/api/v1/getallemployee").authenticated()
                .antMatchers("/api/v1/getemployeebyfirstname").permitAll()
                .and().formLogin()
                .and().httpBasic();

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("ranjan").password("ranjan@123").authorities("admin").and()
                .withUser("akanksha").password("akanksha@123").authorities("read").and()
                .withUser("aadil").password("aadil@123").authorities("read").and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
