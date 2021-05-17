package com.brunobr9.cursomc.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PUBLIC_MATCHERS = { "/h2/**", "/h2-console" };
//    private static final String[] READ_ONLY_MATCHERS = { "/produto/**", "/categoria/**", "/cliente/**" };

    @Autowired
    private Environment env;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jWTUtil;

    @Autowired
    private BCryptPasswordEncoder byteBCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
	    http.headers().frameOptions().disable();
	}

	http.cors().and().csrf().disable();
	http.authorizeRequests()
//		.antMatchers(HttpMethod.GET, READ_ONLY_MATCHERS).permitAll()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		.anyRequest().authenticated();

	http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jWTUtil));
	http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jWTUtil, userDetailsService));
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(byteBCryptPasswordEncoder);
    }
}
