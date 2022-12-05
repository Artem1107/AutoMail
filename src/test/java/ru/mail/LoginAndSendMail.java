package ru.mail;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static ru.mail.RunTest.*;


public class LoginAndSendMail {
    public static void login() {
        {
            // Кликаем войти
            startPage.clickEntryBtn();
            //Вводим логин
            authorizationPage.frame();//переключаемся в фрейм
            authorizationPage.inputLogin(ConfProperties.getProperty("mail"));
            //Кликаем ввести пароль
            authorizationPage.clickGoInputPassBtn();
            //Вводим пароль
            authorizationPage.inputPassword(ConfProperties.getProperty("password"));
            //Кликаем войти
            authorizationPage.clickEntryBtn();
            driver.switchTo().defaultContent();//выходим из фрейма
            //проверяем что мы авторизовались
            String user = mainPage.getTextUserNameMenu();
            Assert.assertEquals(ConfProperties.getProperty("mail"),user);
            //System.out.println(user);
        }
    }
    public static void sendLetter(){
        try {
            //Проверяем банер и закрываем его
            mainPage.clickCloseВlackBanner();
        } catch (NoSuchElementException e){
            //если банера нет то ещё лучше
            System.out.println("банера нет");
            //идём дальше
        }finally {
            //кликаем на написать письмо
            mainPage.clickWriteLetterBtn();
            //Проверяем что открылась форма создания письма
            Assert.assertEquals( letterPage.komuText(),"Кому");
            //Заполняем адресата
            letterPage.inputReceiverField(ConfProperties.getProperty("mail"));
            //Заполняем тему
            letterPage.inputSummaryField(ConfProperties.getProperty("summaryLetter"));
            //заполнить тело письма
            letterPage.inputLetterField(ConfProperties.getProperty("textLetter"));
            //Кликаем отправить
            letterPage.clickSendBtn();
            //Нажимаем на эскейп чтоб закрыть окно писмо отправлено
            letterPage.esc();
        }
    }

    public static void checkingMail(){
        
        //Кликаем на Входящие
        mainPage.clickInboxBtn();
        //Нажимаем Письма себе
        mainPage.clickLetterYourself();
        //Получаем тему входящего письма сравниваем тему письма с тем что отправили
        Assert.assertEquals(mainPage.getSummaryLetter(),ConfProperties.getProperty("summaryLetter"));
        //Открываем письмо
        mainPage.clickSummaryLetter();
        //Получаем тему письма и сравниваем с тем что отправляли
        Assert.assertEquals(mainPage.getSummaryInLetter(),ConfProperties.getProperty("summaryLetter"));
        //Получаем текст письма и сравниваем с тем что отправляли
        Assert.assertEquals(mainPage.getTextInLetter(),ConfProperties.getProperty("textLetter"));
        System.out.println(mainPage.getSummaryInLetter() + ' ' + mainPage.getTextInLetter());
    }

    public static void signСhange(){

    }


}
