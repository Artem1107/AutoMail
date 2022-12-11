package ru.mail;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static ru.mail.RunTest.*;


public class LoginAndSendMail {
    static String fuckingSignature;

    public static void login() {

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
            Assert.assertEquals(ConfProperties.getProperty("mail"), user);
            //System.out.println(user);
            try {
                //Проверяем банер и закрываем его
                mainPage.clickCloseВlackBanner();
            } catch (NoSuchElementException e) {
                //если банера нет то ещё лучше
                System.out.println("банера нет");
                //идём дальше
        }
    }

    public static void sendLetter() {

            //кликаем на написать письмо
            mainPage.clickWriteLetterBtn();
            //Проверяем что открылась форма создания письма
            Assert.assertEquals(letterPage.komuText(), "Кому");
            //Заполняем адресата
            letterPage.inputReceiverField(ConfProperties.getProperty("mail"));
            //Заполняем тему
            letterPage.inputSummaryField(ConfProperties.getProperty("summaryLetter"));
            //заполнить тело письма
            letterPage.inputLetterField(ConfProperties.getProperty("textLetter"));
            //кликаем прикрепить файл
            letterPage.clickAttachBtn(ConfProperties.getProperty("file"));
            //Кликаем отправить
            letterPage.clickSendBtn();
            //Нажимаем на эскейп чтоб закрыть окно писмо отправлено
            letterPage.esc();

        }


    public static void checkingMail() {

        //Кликаем на Входящие
        mainPage.clickInboxBtn();
        //Нажимаем Письма себе
        mainPage.clickLetterYourself();
        //Получаем тему входящего письма сравниваем тему письма с тем что отправили
        Assert.assertEquals(mainPage.getSummaryLetter(), ConfProperties.getProperty("summaryLetter"));
        //Открываем письмо
        mainPage.clickSummaryLetter();
        //Получаем тему письма и сравниваем с тем что отправляли
        Assert.assertEquals(mainPage.getSummaryInLetter(), ConfProperties.getProperty("summaryLetter"));
        //Получаем текст письма и сравниваем с тем что отправляли
        Assert.assertEquals(mainPage.getTextInLetter(), ConfProperties.getProperty("textLetter"));
        //Проверяем наместе ли файл
        //Assert.assertEquals(mainPage.getFileName(), ConfProperties.getProperty("autoTest.doc"));
        //Скачиваем файл
        mainPage.downloadFile();


    }

    public static void checkingSign(){
        //Получаем подпись и сравниваем с тем что наизменяли
        Assert.assertEquals(letterPage.getSignText(),fuckingSignature);
    }

    public static void goToIncoming(){
       //переход во входящие
       mainPage.clickInboxBtn();
    }

    public static void signСhange() {


        //Переходим в настроки учетки
        mainPage.clickSettingsBtn();

        //Переходим во все настроки
        settingPage.clickAllSettingsBtn();

        //помещаем 1 вкладку в отдельную переменную
        String window1 = driver.getWindowHandle();
        System.out.println("урл страницы " + driver.getCurrentUrl());

        //Переходим во все настроки
        settingPage.clickAllSettingsBtn();

        /*Тут открывается новая вкладка*/
        /**
         *Потом вынести в отдельный метод
         */
        Set<String> curentWindows = driver.getWindowHandles();//получаем все вкладки
        String window2 = null;
        for (String window : curentWindows) {
            if (!window.equals(window1)) { //сравниваем с первым окном
                window2 = window;
                break;
            }
        }

        driver.switchTo().window(window2);// переключаемся на другую вкладку
        System.out.println("урл страницы 2 " + driver.getCurrentUrl());

        //Переходим в блок Имя и подпись
        allSettingPage.clickNameSignBtn();
        //Клкаем редактировать
        allSettingPage.clickEditSignBtn();
        //измненяем подпись
        allSettingPage.editSignText("QA " + Math.random());
        fuckingSignature = allSettingPage.getSignText();
        //созраняем новую подпись
        allSettingPage.clickSaveSignBtn();
        //Возвращаемся в почту
        allSettingPage.clickGoMailBtn();
    }

    public static void deleteLetter() {
        try {
            //выделяем
            mainPage.clickAllCheckboxAboutLettter();
            //Удаляем
            mainPage.clickDeleteLeterBtn();
            //Проверяем что удалилось
            Assert.assertEquals(mainPage.getTextLetterNo(), "Писем нет");
            System.out.println(mainPage.getTextLetterNo());
        }
        catch (NoSuchElementException | InterruptedException e){

        }



    }



}
