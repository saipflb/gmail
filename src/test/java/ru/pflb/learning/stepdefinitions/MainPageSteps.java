package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.MainPage;

public class MainPageSteps extends AbstractPage {
    private MainPage mainPage = new MainPage();
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 100, 1000);
    public static String subjectPlusTime;

    public String getSubjectPlusTime() {
        return subjectPlusTime;
    }


    @Когда("пользователь \"(.*)\" авторизован")
    public void checkforUserAuthenticated(String user) {
        logger.info("Проверяем, что залогинились");
        Assert.assertTrue(mainPage.userName.getAttribute("title").contains(user));
    }

    @То("^пользователь создает новое письмо$")
    public void newMessage() {
        logger.info("Создаем новое сообщение");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By.xpath("//div[@role='button' and text()='НАПИСАТЬ']")))));
        mainPage.clickNewMessage.click();
    }

    @И("^пользователь заполняет поле адресат '(.+)'$")
    public void fillAddress(String address) {
        logger.info("Заполняется поле адресат");
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.mailTo));
        mainPage.mailTo.clear();
        mainPage.mailTo.sendKeys(address);
    }

    @И("^пользователь заполняет поле '(.+)'$")
    public void fillSubject(String subject) {
        logger.info("Заполняется поле Тема");
        mainPage.mailSubject.clear();
        subjectPlusTime = subject + System.currentTimeMillis();
        mainPage.mailSubject.sendKeys(subjectPlusTime);
    }

    @И("^пользователь заполняет \"(.*)\"$")
    public void fillMailText(String text) {
        logger.info("Заполняется текст письма");
        mainPage.mailText.clear();
        mainPage.mailText.sendKeys(text);
    }

    @И("^закрывает письмо$")
    public void closeMail() {
        logger.info("Письмо закрывается");
        mainPage.closeMail.click();
        ;
    }

    @И("^переходит в раздел 'Черновики'$")
    public void goToDrafts() throws InterruptedException {
        logger.info("Переходим в раздел черновиков");
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.draftsButton));
        mainPage.draftsButton.click();
    }


}

