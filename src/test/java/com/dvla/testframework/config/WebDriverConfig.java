package com.dvla.testframework.config;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * WebDriver Configuration with @Bean annotation for getDriver method,
 * spring will use this method to get its WebDriver instance,
 * and then use that whenever any constructor asks for a WebDriver instance
 */
@Configuration
public class WebDriverConfig {

    @Bean
    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @After
    public void quitDriver(WebDriver driver) {
        driver.close();
        driver.quit();
    }
}
