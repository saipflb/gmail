package ru.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends AbstractPage {


    @FindBy(xpath = "//div[@class='ae4 UI']/div/div/table/tbody/tr/td/div/div/div/span")
    public WebElement draftSubject;//ищется первый черонивик в списке

    @FindBy (xpath = "//*[@data-hovercard-id]")
    public WebElement mailTo; //ищется поле "Кому"

    @FindBy (xpath = "//input[@name='subject']")
    public WebElement mailSubject; //ищется поле "Тема"

    @FindBy (xpath = "//div[@aria-label='Тело письма']")
    public WebElement mailText; //ищется поле "Тело письма"

    @FindBy (xpath = "//div[@aria-label[contains(.,'Отправить')]]")
    public WebElement mailSend; //ищется кнопка "Отправить"

    @FindBy(xpath = "//*[contains(@title, 'Отправленные')]")
    public WebElement sended;

}