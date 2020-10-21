package com.dvla.testframework.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Get Vehicle Information page object
 */
@Component
public class GetVehicleInformationHomePage {
    @Value("${getVehicleInformationHome.url}")
    private String getVehicleInformationHomePageUrl;

    private final WebDriver driver;

    @FindBy(linkText = "Start now")
    private WebElement startNowButton;

    @Autowired
    public GetVehicleInformationHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void load() {
        driver.get(getVehicleInformationHomePageUrl);
    }

    public void startVehicleDetailsSearch() {
        startNowButton.click();
    }
}
