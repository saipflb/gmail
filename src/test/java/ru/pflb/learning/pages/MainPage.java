package ru.pflb.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 100, 1000);

    public static String subjectPlusTime, text, address;

    public String getSubjectPlusTime() {
        return subjectPlusTime;
    }
    public String getAddress() {
        return address;
    }
    public String getText(){return text;}

    @FindBy(xpath = "//*[contains(@title, 'Аккаунт Google')]")
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

    @FindBy(xpath = "//*[contains(@title, 'Черновики')]")
    private WebElement draftsButton;



//    проверка того, что пользователь корректно залогинился
    public String getUserName() {
        return userName.getAttribute("title");
    }

    //создание нового сообщения
    public void createNewMessage() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By.xpath("//div[@role='button' and text()='НАПИСАТЬ']")))));
//        Thread.sleep(4000);
        clickNewMessage.click();
    }
    //ввод адреса
    public void fillMailToField(String address) throws InterruptedException {
      MainPage.address=address;
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
        MainPage.text=text;
        mailText.clear();
        mailText.sendKeys(text);
    }
    //сохранить и закрыть письмо
    public void saveAndCloseMessage() {
       closeMail.click();
           }

    //нажимается кнопка "Черновик"
    public void clickDraftsButton() throws InterruptedException {
        Thread.sleep(2000);
        draftsButton.click();
    }
}