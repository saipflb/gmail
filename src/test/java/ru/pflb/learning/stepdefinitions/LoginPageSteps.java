package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import org.testng.Assert;
import ru.pflb.learning.pages.LoginPage;
import ru.pflb.learning.pages.MainPage;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();

    @Пусть("^пользователь вводит логин '(.+)'$")
    public void fillLogin(String login) {
        loginPage.fillLoginField(login);
            }

    @И("^нажимает кнопку Далее$")
    public void clickEnterButton(){
        loginPage.clickSubmitButton();
    }

    @И("^вводит пароль '(.+)'$")
    public void fillPassword(String password) throws InterruptedException {
        loginPage.fillPasswordField(password);
    }

    @И("^еще раз нажимает кнопку Далее$")
    public void clickNextButton(){
        loginPage.clickNextButton();
    }

    @И("пользователь '(.+)' авторизован")
    public void checkforUserAuthenticated(String user){
        Assert.assertTrue(mainPage.getUserName().contains(user));
    }


}