package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.MainPage;

public class MainPageSteps extends AbstractPage{
    private MainPage mainPage = new MainPage();

    @И("^пользователь создает новое письмо$")
        public void newMessage() throws InterruptedException {
        logger.info("Создаем новое сообщение");
                mainPage.createNewMessage();
    }

    @И("^пользователь заполняет поле адресат '(.+)'$")
    public void fillAddress(String address) throws InterruptedException {
        logger.info("Заполняется поле адресат");
        mainPage.fillMailToField(address);
    }

    @И("^пользователь заполняет поле '(.+)'$")
    public void fillSubject(String subject){
        logger.info("Заполняется поле Тема");
        mainPage.fillMailSubjectField(subject);
    }

    @И("^пользователь вводит '(.+)'$")
    public void fillMailText(String text){
        logger.info("Заполняется текст письма");
        mainPage.fillMailTextField(text);
    }

    @И("^закрывает письмо$")
    public void closeMail() {
        logger.info("Письмо закрывается");
        mainPage.saveAndCloseMessage();
    }

    @И("^переходит в раздел 'Черновики'$")
    public void goToDrafts() throws InterruptedException {
        logger.info("Переходим в раздел черновиков");
        mainPage.clickDraftsButton();
    }



}

