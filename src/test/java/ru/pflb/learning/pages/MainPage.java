package ru.pflb.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@title, 'Аккаунт Google')]")
    public WebElement userName;

    @FindBy(xpath = "//div[@role='button' and text()='НАПИСАТЬ']")
    public WebElement clickNewMessage;

    @FindBy(name = "to")
    public WebElement mailTo;

    @FindBy(name = "subjectbox")
    public WebElement mailSubject;

    @FindBy(xpath = "//div[@aria-label='Тело письма']")
    public WebElement mailText;

    @FindBy(xpath = "//img[@aria-label='Сохранить и закрыть']")
    public WebElement closeMail;

    @FindBy(xpath = "//*[contains(@title, 'Черновики')]")
    public WebElement draftsButton;
}