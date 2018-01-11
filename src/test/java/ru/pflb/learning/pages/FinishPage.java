package ru.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends AbstractPage {
    @FindBy(xpath = "//*[text()='Выйти']")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[contains(@title, 'Аккаунт Google')]")
    public WebElement userIcon;
}