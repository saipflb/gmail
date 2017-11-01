package ru.pflb.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ru.pflb.learning.pages.MainPage.subjectPlusTime;

public class FinishPage extends AbstractPage {
    @FindBy(xpath = "//*[text()='Выйти']")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[contains(@title, 'Аккаунт Google')]")
    private WebElement userIcon;


    //ищется письмо с корректной темой
    public void findMail() {
        driver.findElement(By.xpath(String.format("//*[text()='%s']", subjectPlusTime)));
    }

    //выходим из почты
    public void logOut(){
        userIcon.click();
        logoutButton.click();

    }

    //закрываем браузер
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void logoutchecking() {
        driver.findElement(By.name("password"));
    }
}