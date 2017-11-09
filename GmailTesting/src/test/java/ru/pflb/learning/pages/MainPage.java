package ru.pflb.learning.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.pflb.learning.pages.AbstractPage;

public class MainPage extends AbstractPage {

    public String subjectPlusTime;

    @FindBy(xpath = "//*[contains(@title, 'kotionb3505@gmail.com')]")
    private WebElement userName;

    @FindBy(xpath = "//div[@role='button' and text()='НАПИСАТЬ']")
    private WebElement clickNewMessage;

    @FindBy(name = "to")
    private WebElement mailTo;

    @FindBy(name = "subjectbox")
    private WebElement mailSubject;

    @FindBy(xpath = "//div[@aria-label='Тело письма']")
    private WebElement mailText;

    @FindBy(xpath = "//img[@aria-label='Сохранить и закрыть']")
    private WebElement closeMail;


//    проверка того, что пользователь корректно залогинился

    public String getUserName() {
        return userName.getAttribute("title");
    }

    //создание нового сообщения
    public void createNewMessage() throws InterruptedException {
        Thread.sleep(4000);
        clickNewMessage.click();
    }
    //ввод адреса
    public void fillMailToField(String address) throws InterruptedException {
        Thread.sleep(4000);
        mailTo.clear();
        mailTo.sendKeys(address);
    }
    //ввод темы
    public void fillMailSubjectField(String subject) {
        mailSubject.clear();
        subjectPlusTime = subject+System.currentTimeMillis();
        mailSubject.sendKeys(subjectPlusTime);
    }
    //ввод текста
    public void fillMailTextField(String text) {
        mailText.clear();
        mailText.sendKeys(text);
    }
//сохранить и закрыть письмо
    public void saveAndCloseMessage() {
       closeMail.click();
           }
}