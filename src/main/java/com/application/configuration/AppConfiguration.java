package com.application.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.application")
@Import({WebConfiguration.class, JpaConfiguration.class,SecurityConfiguration.class})
public class AppConfiguration {
}
