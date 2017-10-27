package ru.pflb.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.pflb.learning.helpers.DriverManager;

public abstract class AbstractPage {
    protected WebDriver driver;
    public AbstractPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}