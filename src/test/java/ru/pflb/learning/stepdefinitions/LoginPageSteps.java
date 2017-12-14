package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Пусть;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.LoginPage;
import ru.pflb.learning.pages.MainPage;

import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class LoginPageSteps extends AbstractPage{
    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();
    protected final Wait<WebDriver> wait = new WebDriverWait(driver, 100, 1000);

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
        try {
            wait.until(ExpectedConditions.visibilityOf(loginPage.reserveEmailConfirm));
            assertEquals(loginPage.checkUser.getText(), check); {
            logger.info("Появилось окно" + check);
            loginPage.reserveEmailConfirm.click();
            }
            catch (timeoutException t)
        } catch (NoSuchElementException e) {logger.info("Окно" + check + "Не появилось");}

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


}