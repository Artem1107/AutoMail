package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.helpers.ConfProperties;
import ru.mail.steps.Base;


public class AuthorizationPage extends Base {

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = ".//iframe[contains(@class,'ag-popup__frame__layout__iframe')]")
    private WebElement frame;


    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;


    @FindBy(xpath = "//span[text()='Ввести пароль'] ")
    private WebElement goInputPassBtn;


    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;


    @FindBy(xpath = "//span[text()='Войти']")
    private WebElement entryBtn;


    /**
     * Метод ввода имя акаунта
     */
    public void inputLogin() {
        inputText(usernameField, ConfProperties.getProperty("mail"));
    }

    /**
     * Метод нажатия кнопки ввести пароль
     */
    public void clickGoInputPassBtn() {
        click(goInputPassBtn);
    }

    /**
     * Метод ввода пароля
     */
    public void inputPassword() {
        inputText(passwordField, ConfProperties.getProperty("password"));
    }

    /**
     * Метод нажатия кнопки вход
     */
    public void clickEntryBtn() {
        click(entryBtn);
    }

    /**
     * Метод перехода во фрейм
     */
    public void frame() {
        getDriver().switchTo().frame(frame);
    }

}
