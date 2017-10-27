package ru.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends AbstractPage {
    @FindBy(xpath = "//*[contains(@title, 'Черновики')]")
    private WebElement draftsButton;

    @FindBy(xpath = "//*[@class='bog']")
    private WebElement draftSubject;

//нажимается кнопка "Черновик"
    public void clickDraftsButton() throws InterruptedException {
        Thread.sleep(2000);
        draftsButton.click();
    }
//проверяется, что создан черновик с нужной темой
    public String getDraftSubject() {
        return draftSubject.getText();
    }
}