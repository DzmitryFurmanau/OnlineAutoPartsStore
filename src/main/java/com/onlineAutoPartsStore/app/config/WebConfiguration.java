package com.onlineAutoPartsStore.app.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
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
}
