package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.DraftsPage;
import static org.testng.Assert.assertEquals;
import static ru.pflb.learning.stepdefinitions.MainPageSteps.subjectPlusTime;

public class DraftsPageSteps extends AbstractPage {
    private DraftsPage draftsPage = new DraftsPage();
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 100, 1000);

    @И("^проверяет, что письмо сохранено в черновиках$")
    public void compliteMail() throws InterruptedException {
        logger.info("проверяем, что письмо сохранено в черновиках");
        assertEquals(mainPageSteps.getSubjectPlusTime(), draftsPage.draftSubject.getText());
    }

    @И("^открывает черновик$")
    public void openDraft() {
        logger.info("открываем черновик");
        draftsPage.draftSubject.click();
    }

    @И("^проверяет, что \"(.*)\" письма соответствует введенному$")
    public void checkMailTo(String address) {
        logger.info("проверяем, что адресат письма соответствует введенному");
        assertEquals(address, draftsPage.mailTo.getAttribute("data-hovercard-id"));

    }

    @И("^проверяет, что тема письма соответствует введенной$")
    public void checkMailSubject() {
        logger.info("проверяем, что тема письма соответствует введенной");
        assertEquals(mainPageSteps.getSubjectPlusTime(), draftsPage.mailSubject.getAttribute("value"));
    }

    @И("^проверяет, что \"(.*)\" соответствует введенному$")
    public void checkMailText(String text) {
        logger.info("проверяем, что текст письма соответствует введенному");
        assertEquals(text, draftsPage.mailText.getText());
    }

    @И("^отправляет письмо$")
    public void sendMail() {
        logger.info("отправляем письмо");
        draftsPage.mailSend.click();
    }

    @И("^проверяет, что письмо исчезло из черновиков$")
    public void checkMail()  {
        logger.info("проверяем, что письмо исчезло из черновиков");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement((By.xpath(String.format("//*[text()='%s']", subjectPlusTime))))));
    }
    @И("^переходит в раздел Отправленные$")
    public void clickSended() {
        logger.info("переходим в раздел Отправленные");
        draftsPage.sended.click();

    }
}


