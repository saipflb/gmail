package ru.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='ae4 UI']/div/div/table/tbody/tr/td/div/div/div/span")
    private WebElement draftSubject;

//проверяется, что создан черновик с нужной темой
    public String getDraftSubject() throws InterruptedException {
        Thread.sleep(2000);
        return draftSubject.getText();
    }
}