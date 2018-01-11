package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.DraftsPage;
import ru.pflb.learning.pages.FinishPage;

import static ru.pflb.learning.stepdefinitions.MainPageSteps.subjectPlusTime;


public class FinishPageSteps extends AbstractPage {
    private FinishPage finishPage = new FinishPage();


    @И("^проверяет, что письмо появилось в Отправленных$")
    public void findMail() {
        logger.info("проверяет, что письмо появилось в Отправленных");
        driver.findElement(By.xpath(String.format("//*[text()='%s']", subjectPlusTime)));
    }

    @И("^закрывает почту$")
    public void logout() {
        logger.info("закрывает почту");
        finishPage.userIcon.click();
        finishPage.logoutButton.click();
    }

    @И("^попадает на страницу логина$")
    public void logoutCheck() {
        logger.info("попадает на страницу логина");
        try {
            driver.findElement(By.name("password"));
        } catch (Exception e) {
            logger.info("Промахнулся мимо страницы логина");
        }
    }

    @Тогда("^тест завершен$")
    public void finishTest() {
        logger.info("<<<<<<<<<<<<<<<<<<<<<Тест успешно завершен>>>>>>>>>>>>>>>>>>>>");
    }

}
