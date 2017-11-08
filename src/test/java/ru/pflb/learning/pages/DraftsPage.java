package ru.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends AbstractPage {
//    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

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
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ae4 UI']/div/div/table/tbody/tr/td/div/div/div/span"))));
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

}