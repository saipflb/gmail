package ru.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(css = "#identifierId")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/content/span")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/content/span")
    private WebElement nextButton;



    private String BASE_URL = "https://gmail.com";

    public LoginPage(){
        super();
        driver.get(BASE_URL);
    }

    public void fillLoginField(String userName) {
        loginField.clear();
        loginField.sendKeys(userName);
    }

    public void fillPasswordField(String password) throws InterruptedException {
        Thread.sleep(2000);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void clickNextButton() {
        nextButton.click();
    }
}

