package ru.pflb.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.pflb.learning.pages.MainPage.subjectPlusTime;

public class DraftsPage extends AbstractPage {
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 100, 1000);

    @FindBy(xpath = "//div[@class='ae4 UI']/div/div/table/tbody/tr/td/div/div/div/span")
    private WebElement draftSubject;//ищется первый черонивик в списке

    @FindBy (xpath = "//*[@data-hovercard-id]")
    private WebElement mailTo; //ищется поле "Кому"

    @FindBy (xpath = "//input[@name='subject']")
    private WebElement mailSubject; //ищется поле "Тема"

    @FindBy (xpath = "//div[@aria-label='Тело письма']")
    private WebElement mailText; //ищется поле "Тело письма"

    @FindBy (xpath = "//div[@aria-label[contains(.,'Отправить')]]")
    private WebElement mailSend; //ищется кнопка "Отправить"

    @FindBy (xpath = "//*[contains(@title, 'Черновики')]")
    private WebElement refresh; //ищется кнопка "Черновики"

    @FindBy(xpath = "//*[contains(@title, 'Отправленные')]")
    private WebElement sended;

     //проверяется, что создан черновик с нужной темой
    public String getDraftSubject() {

        return draftSubject.getText();

    }

    //открывается созданный черновик
    public void draftClicker() {
        draftSubject.click();
    }

    //извлекается содержимое поля "Кому"
    public String getMailToField(){
        return mailTo.getAttribute("data-hovercard-id");
    }

    //извлекается содержимое поля "Тема"
    public String getMailSubject(){
        return mailSubject.getAttribute("value");
    }

    //извлекается содержимое поля "Тело письма"
    public String getMailText(){
        return mailText.getText();
    }

    //черновик отправляется адресату
    public void mailSender() {
        mailSend.click();
    }

    //нажимается кнопка "Черновики"
    public void refreshButton() {
        refresh.click();
    }

        //нажимается кнопка "Отправленные"
    public void sendedButtonClicker()
    {
        sended.click();
    }

    public void searchForDraft (){
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement((By.xpath(String.format("//*[text()='%s']", subjectPlusTime))))));

    }

}