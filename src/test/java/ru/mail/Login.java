package ru.mail;

import org.junit.Assert;
import ru.mail.pages.StartPage;

import java.util.concurrent.TimeUnit;

import static ru.mail.RunTest.*;


public class Login {
    public static void login() {
        {
            // Кликаем войти
            startPage.clickEntryBtn();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Вводим логин
            authorizationPage.inputLogin(ConfProperties.getProperty("mail"));
            //Кликаем ввести пароль
            authorizationPage.clickGoInputPassBtn();
            //Вводим пароль
            authorizationPage.inputPassword(ConfProperties.getProperty("password"));
            //Кликаем войти
            authorizationPage.clickEntryBtn();

        }
    }
}
