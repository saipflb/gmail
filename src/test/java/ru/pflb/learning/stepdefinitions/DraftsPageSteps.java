package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.DraftsPage;
import ru.pflb.learning.pages.MainPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DraftsPageSteps extends AbstractPage{
    private DraftsPage draftsPage = new DraftsPage();
    private MainPage mainPage = new MainPage();

    @И("^проверяет, что письмо сохранено в черновиках$")
    public void compliteMail() throws InterruptedException {
        logger.info("проверяет, что письмо сохранено в черновиках");
        assertEquals(mainPage.getSubjectPlusTime(), draftsPage.getDraftSubject());
    }
    @И("^открывает черновик$")
    public void openDraft() {
        logger.info("открывает черновик");
        draftsPage.draftClicker();
    }
    @И("^проверяет, что адресат письма соответствует введенному$")
    public void checkMailTo(){
        logger.info("проверяет, что адресат письма соответствует введенному");
        assertEquals(mainPage.getAddress(), draftsPage.getMailToField());

    }
    @И("^проверяет, что тема письма соответствует введенной$")
    public void checkMailSubject(){
        logger.info("проверяет, что тема письма соответствует введенной");
        assertEquals(mainPage.getSubjectPlusTime(), draftsPage.getMailSubject());
    }

    @И("^проверяет, что текст письма соответствует введенному$")
    public void checkMailText(){
        logger.info("проверяет, что текст письма соответствует введенному");
        assertEquals(mainPage.getText(), draftsPage.getMailText());
    }

    @И("^отправляет письмо$")
    public void sendMail() {
        logger.info("отправляет письмо");
        draftsPage.mailSender();
    }

    @И("^проверяет, что письмо исчезло из черновиков$")
    public void checkMail() throws InterruptedException {
        logger.info("проверяет, что письмо исчезло из черновиков");
        logger.debug("жмет кнопку обновить");
        draftsPage.refreshButton();
        logger.debug("сравнивает тему первого письма с введенной");
        assertNotEquals(mainPage.getSubjectPlusTime(), draftsPage.getDraftSubject()); //переписать, используя Expliced wait
    }
    }


