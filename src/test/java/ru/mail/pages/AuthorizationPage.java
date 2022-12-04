package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static ru.mail.RunTest.driver;

public class AuthorizationPage {
    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Описание элементов
     */

    //Поле Имя акаунта
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    //Кнопка ввести пароль
    @FindBy(xpath = "//span[text()='Ввести пароль'] ")
    private WebElement goInputPassBtn;

    //Поле пароль
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    //Кнопка войти
    @FindBy(xpath = "//span[text()='Войти']")
    private WebElement entryBtn;

    /**
     * Дальше методы
     */
    //Метод ввода имя акаунта
    public void inputLogin(String mail) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        usernameField.sendKeys(mail);
    }

    // Метод нажатия кнопки ввести пароль
    public void clickGoInputPassBtn() {
        goInputPassBtn.click();
    }

    //Метод ввода пароля
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    // Метод нажатия кнопки вход
    public void clickEntryBtn() {
        entryBtn.click();
    }

}
