package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import org.testng.Assert;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.LoginPage;
import ru.pflb.learning.pages.MainPage;

public class LoginPageSteps extends AbstractPage{
    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();

    @Пусть("^пользователь вводит \"(.*)\"$")
    public void fillLogin(String login) {
        logger.info("Пользователь вводит логин" + login);
        loginPage.fillLoginField(login);
        }

    @И("^нажимает кнопку Далее$")
    public void clickEnterButton(){
        logger.info("Жмем кнопку Далее");
        loginPage.clickSubmitButton();
    }

    @Если("^появилось окно \"(.*)\", то пользователь вводит \"(.*)\"$")
    public void checkUserForm(String check, String email){
        logger.info ("Появилось окно" + check);
//        loginPage.
    }

    @И("^вводит пароль \"(.*)\"$")
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