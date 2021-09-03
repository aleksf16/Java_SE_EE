package com.example.api1.config;


import com.example.api1.Authentification.JWTFilter;
import com.example.api1.Auth0.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTFilter jwtFilter;

    private final LogoutHandler logoutHandler;

    public SecurityConfig(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .mvcMatchers("/users/**").authenticated()
                .mvcMatchers("/carts/**").authenticated()
                .mvcMatchers("/items/**").authenticated()
                .mvcMatchers("/me/role").authenticated()
                //.mvcMatchers("/swagger-ui.html#/").permitAll()
                .and().oauth2Login()
                .and().logout()
                // handle logout requests at /logout path
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // customize logout handler to log out of Auth0
                .addLogoutHandler(logoutHandler);
    }

}
