package com.dvla.testframework.stepdefinitions;

import com.dvla.testframework.config.TestConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class TestContextConfiguration {
}
