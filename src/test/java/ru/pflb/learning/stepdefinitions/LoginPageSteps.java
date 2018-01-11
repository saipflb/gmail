package ru.pflb.learning.stepdefinitions;

import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.learning.pages.AbstractPage;
import ru.pflb.learning.pages.LoginPage;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertNotNull;

public class LoginPageSteps extends AbstractPage {
    private LoginPage loginPage = new LoginPage();
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 100, 1000);
    private String BASE_URL = "https://gmail.com";

    public LoginPageSteps() {
        super();
        driver.get(BASE_URL);
    }

    @Пусть("^пользователь вводит \"(.*)\"$")
//TODO проверка на то, что поле login уже заполнено после прошлого прогона через цикл
    public void fillLogin(String login) {
        logger.info("Проверяем, заполнено ли поле логина");
        try {
            assertNotNull(loginPage.profileIdentifier.getText());
            logger.warn("Поле логина уже заполнено");
            loginPage.expandButton.click();
            logger.info("Жмем на кнопку развертки");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='identifierLink']")));
            loginPage.changeUser.click();
            logger.info("Выбираем поле 'Другой аккаунт' ");
        } catch (Exception e) {
            logger.info("Поле логина пустое");
        }
        logger.info("Пользователь вводит логин " + login);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#identifierId")));
            loginPage.loginField.clear();
            loginPage.loginField.sendKeys(login);
            loginPage.loginField.sendKeys(ENTER);
        } catch (Exception e) {
            logger.error("Не удалось ввести логин или такого пользователя не существует");//TODO проверка на неверный логин
        }


    }

    @Если("^появилось окно \"(.*)\", то пользователь вводит \"(.*)\"$")
    public void checkUserForm(String check, String email) {
        logger.info("Верит ли Google что логинится именно пользователь, а не хакер?");
        try {
            if (loginPage.checkUser.getText().equals(check)) {
                logger.info("Google не верит. Появилось окно " + check);
                loginPage.reserveEmailConfirm.click();
                loginPage.reserveEmailField.clear();
                loginPage.reserveEmailField.sendKeys(email);
                loginPage.reserveEmailField.sendKeys(ENTER);
            } else {
                logger.info("Google верит");
            }
        } catch (Exception e) {
            logger.info("All those moments will be lost in time, like tears in rain");
        }
    }

    @И("^вводит пароль \"(.*)\"$")
    public void fillPassword(String password) {
        logger.info("Вводим пароль");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
            loginPage.passwordField.sendKeys(password);
            loginPage.passwordField.sendKeys(ENTER);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement((By.xpath("//*[@id='password']/div[1]/div/div[1]/input")))));
            logger.info("Ждем, пока не исчезнет заголовок \"Добро пожаловать\"");
        } catch (Exception e) {
            logger.error("Не удалось ввести пароль или пароль не подходит");//TODO проверка на неверный пароль
        }

    }


}