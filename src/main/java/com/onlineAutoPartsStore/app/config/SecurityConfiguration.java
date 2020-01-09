package com.onlineAutoPartsStore.app.config;

import com.onlineAutoPartsStore.app.security.filter.AuthenticationTokenFilter;
import com.onlineAutoPartsStore.app.service.security.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The type Security configuration.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final TokenService tokenService;

    private final UserDetailsService userDetailsService;

    /**
     * Instantiates a new Security configuration.
     *
     * @param tokenService       the token service
     * @param userDetailsService the user details service
     */
    public SecurityConfiguration(TokenService tokenService, UserDetailsService userDetailsService) {
        this.tokenService = tokenService;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .authorizeRequests()
                .mvcMatchers("/authentication/**").permitAll();
        final AuthenticationTokenFilter filter = new AuthenticationTokenFilter(tokenService, userDetailsService);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
