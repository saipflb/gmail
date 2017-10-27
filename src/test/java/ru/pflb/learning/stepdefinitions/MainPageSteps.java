package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import ru.pflb.learning.pages.MainPage;

public class MainPageSteps {
    private MainPage mainPage = new MainPage();

    @И("^пользователь создает новое письмо$")
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
        mainPage.clickDraftsButton();
    }



}

