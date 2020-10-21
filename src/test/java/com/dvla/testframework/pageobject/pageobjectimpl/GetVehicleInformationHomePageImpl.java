package com.dvla.testframework.pageobject.pageobjectimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dvla.testframework.pageobject.model.GetVehicleInformationHomePage;

/**
 * Get Vehicle Information page object
 */
@Component
public class GetVehicleInformationHomePageImpl implements GetVehicleInformationHomePage {
    @Value("${getVehicleInformationHome.url}")
    private String getVehicleInformationHomePageUrl;

    private final WebDriver driver;

    @FindBy(linkText = "Start now")
    private WebElement startNowButton;

    @Autowired
    public GetVehicleInformationHomePageImpl(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    public void load() {
        driver.get(getVehicleInformationHomePageUrl);
    }

    @Override
    public void startVehicleDetailsSearch() {
        startNowButton.click();
    }
}
