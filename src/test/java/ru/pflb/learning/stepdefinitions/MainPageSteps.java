package ru.pflb.learning.stepdefinitions;

import cucumber.api.PendingException;
import org.testng.Assert;
import ru.pflb.learning.pages.MainPage;
import ru.pflb.learning.pages.DraftsPage;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;

public class MainPageSteps {
    private MainPage mainPage = new MainPage();
    private DraftsPage draftsPage = new DraftsPage();

    @Пусть("^пользователь создает новое письмо$")
        public void newMessage() throws InterruptedException {
                mainPage.createNewMessage();
    }


    @И("^пользователь заполняет поле адресат '(.+)'$")
    public void fillAddress(String address) throws InterruptedException {
        mainPage.fillMailToField(address);
    }

    @И("^пользователь заполняет поле '(.+)'$")
    public void fillSubject(String subject){
        mainPage.fillMailSubjectField(subject);
    }

    @И("^пользователь вводит '(.+)'$")
    public void fillMailText(String text){
        mainPage.fillMailTextField(text);
    }

    @И("^закрывает письмо$")
    public void closeMail() {
        mainPage.saveAndCloseMessage();
    }

    @И("^переходит в раздел 'Черновики'$")
    public void goToDrafts() throws InterruptedException {
        draftsPage.clickDraftsButton();
    }

//    @Тогда("^тест завершен$")
//    public void compliteMail()
//        {
//
//        Assert.assertEquals(draftsPage.getDraftSubject(), mainPage.getSubject);
//    }


}

