package com.onlineAutoPartsStore.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * The type App configuration.
 */
@Configuration
@ComponentScan(basePackages = "com.onlineAutoPartsStore")
@Import({WebConfiguration.class, DatabaseConfiguration.class, MessagesConfiguration.class})
public class AppConfiguration {

}
