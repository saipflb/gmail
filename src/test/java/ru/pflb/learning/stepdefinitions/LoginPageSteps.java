package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import org.testng.Assert;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.LoginPage;
import ru.pflb.learning.pages.MainPage;

public class LoginPageSteps extends AbstractPage{
       private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();

    @Пусть("^пользователь вводит логин '(.+)'$")
    public void fillLogin(String login) {
        logger.info("Логинимся");
        loginPage.fillLoginField(login);
        }

    @И("^нажимает кнопку Далее$")
    public void clickEnterButton(){
        logger.info("Жмем кнопку Далее");
        loginPage.clickSubmitButton();
    }

    @И("^вводит пароль '(.+)'$")
    public void fillPassword(String password) throws InterruptedException {
        logger.info("Вводим пароль");
        loginPage.fillPasswordField(password);
    }

    @И("^еще раз нажимает кнопку Далее$")
    public void clickNextButton(){
        logger.info("Жмем кнопку Далее");
        loginPage.clickNextButton();
    }

    @И("пользователь '(.+)' авторизован")
    public void checkforUserAuthenticated(String user){
        logger.info("Проверяем, что залогинились");
        Assert.assertTrue(mainPage.getUserName().contains(user));
    }


}