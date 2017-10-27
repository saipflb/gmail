package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import org.testng.Assert;
import ru.pflb.learning.pages.DraftsPage;
import ru.pflb.learning.pages.MainPage;

public class DraftsPageSteps {
    private DraftsPage draftsPage = new DraftsPage();
    private MainPage mainPage = new MainPage();
    @И("^проверяет, что письмо сохранено в черновиках$")
    public void compliteMail() throws InterruptedException {

        Assert.assertEquals(mainPage.getSubjectPlusTime(), draftsPage.getDraftSubject());
    }

}
