package com.dvla.testframework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/test/resources/application.properties")
@ComponentScan("com.dvla.testframework")
public class TestConfig {
}
