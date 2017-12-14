package ru.pflb.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.pflb.learning.helpers.DriverManager;

public abstract class AbstractPage {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected WebDriver driver;

//    protected final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
    public AbstractPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

}