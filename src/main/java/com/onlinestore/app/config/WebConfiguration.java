package com.onlinestore.app.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The type Web configuration.
 */
@EnableWebMvc
public class WebConfiguration {
    /**
     * Mapper mapper.
     *
     * @return the mapper
     */
    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }

    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
