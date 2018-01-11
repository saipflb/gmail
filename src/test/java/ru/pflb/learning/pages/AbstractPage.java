package ru.pflb.learning.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.pflb.learning.helpers.DriverManager;

public abstract class AbstractPage {
    protected final Logger logger = Logger.getLogger(getClass());
    protected WebDriver driver;

    public AbstractPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}