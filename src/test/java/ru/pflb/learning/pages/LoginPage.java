package ru.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(css = "#identifierId")
    public WebElement loginField;

    @FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id='identifierNext']/content/span")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id='passwordNext']/content/span")
    public WebElement nextButton;

    @FindBy(xpath = "//*[@id='headingText']")
    public WebElement checkUser;

    @FindBy(xpath = "//*[@id='view_container']/form/div[2]/div/div/div/ul/li[1]/div")
    public WebElement reserveEmailConfirm;




    private String BASE_URL = "https://gmail.com";

    public LoginPage(){
        super();
        driver.get(BASE_URL);
    }

    public void fillLoginField(String userName) {
        loginField.clear();
        loginField.sendKeys(userName);
    }

}

