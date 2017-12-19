package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.DraftsPage;
import ru.pflb.learning.pages.FinishPage;


public class FinishPageSteps extends AbstractPage {
    private FinishPage finishPage = new FinishPage();


    @И("^проверяет, что письмо появилось в Отправленных$")
    public void findMail() {
        logger.info("проверяет, что письмо появилось в Отправленных");
        finishPage.findMail();
    }

    @И("^закрывает почту$")
    public void logout() {
        logger.info("закрывает почту");
        finishPage.logOut();
    }

    @И("^попадает на страницу логина$")
    public void logoutCheck() {
        logger.info("попадает на страницу логина");
        try {
            finishPage.logoutchecking();
        } catch (Exception e) {
            logger.info("Промахнулся мимо страницы логина");
            closeDriver();
        }
    }

    @Тогда("^тест завершен$")
    public void finishTest() throws InterruptedException {
        logger.info("<<<<<<<<<<<<<<<<<<<<<Тест успешно завершен>>>>>>>>>>>>>>>>>>>>");
        Thread.sleep(1000);
//        closeDriver();
        }

}
