package ru.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    /*
Поле Логин
     */
    @FindBy(css = "#identifierId")
    public WebElement loginField;
    /*
Поле Пароль
     */
    @FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
    public WebElement passwordField;
/* Парочка лишних объектов //TODO Удалить
    @FindBy(xpath = "//*[@id='identifierNext']/content/span")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id='passwordNext']/content/span")
    public WebElement nextButton;
*/
/*
Заголовок окна проверки доступа
 */
    @FindBy(xpath = "//*[@id='headingText']")
    public WebElement checkUser;
/*
Поле ввода резервного email'a
 */
    @FindBy(xpath = "//*[@name='knowledgePreregisteredEmailResponse']")
    public WebElement reserveEmailField;
    /*
Кнопка подтверждения резервного email'a
     */
    @FindBy(xpath = "//*[@id='view_container']/form/div[2]/div/div/div/ul/li[1]/div")
    public WebElement reserveEmailConfirm;
    /*
Поле имени профиля
     */
    @FindBy(xpath = "//*[@id='profileIdentifier']")
    public WebElement profileIdentifier;
    /*
Кнопка перехода к меню выбора профиля
     */
    @FindBy(xpath = "//*[@aria-label='Сменить аккаунт']")
    public WebElement expandButton;
    /*
Кнопка смены профиля
     */
    @FindBy(xpath = "//*[@id='identifierLink']")
    public WebElement changeUser;
}

