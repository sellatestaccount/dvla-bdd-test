package com.dvla.testframework.testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com.dvla.testframework.stepdefinitions",
        plugin = {"pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json"},
        monochrome = true
)
public class TestRunner {
}
