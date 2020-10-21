package com.dvla.testframework.config;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    private WebDriver driver;
    private Scenario scenario;
    @Bean
    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @AfterStep
    public void takeScreenShotAfterEveryStep() {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Result");
    }
    @After
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
