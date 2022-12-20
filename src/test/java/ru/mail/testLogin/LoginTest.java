package ru.mail.testLogin;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.BaseDriverClass;
import ru.mail.helpers.ConfProperties;
import ru.mail.pages.*;

import java.util.NoSuchElementException;
import java.util.Set;

public class LoginTest extends BaseDriverClass {
    private StartPage startPage;
    private AuthorizationPage authorizationPage;
    private MainPage mainPage;
    private SettingPage settingPage;
    private LetterPage letterPage;
    private AllSettingPage allSettingPage;

    @Test
    public void loginTest() {
        startPage = new StartPage(getDriver());
        authorizationPage = new AuthorizationPage(getDriver());
        mainPage = new MainPage(getDriver());
        settingPage = new SettingPage(getDriver());
        letterPage = new LetterPage(getDriver());
        allSettingPage = new AllSettingPage(getDriver());
        start();
        login();
        sendLetter();
        checkingMail();
        signСhange();
        sendLetter();
        checkingMail();
        checkingSign();
        goToIncoming();
        deleteLetter();
    }

    String fuckingSignature;

    public void start() {
        getDriver().get(ConfProperties.getProperty("loginPage"));
    }


    public void login() {
        getDriver().get(ConfProperties.getProperty("loginPage"));
        // Кликаем войти
        startPage.clickEntryBtn();
        //Вводим логин
        authorizationPage.frame();//переключаемся в фрейм
        authorizationPage.inputLogin();
        //Кликаем ввести пароль
        authorizationPage.clickGoInputPassBtn();
        //Вводим пароль
        authorizationPage.inputPassword();
        //Кликаем войти
        authorizationPage.clickEntryBtn();
        getDriver().switchTo().defaultContent();//выходим из фрейма
        //проверяем что мы авторизовались
        String user = mainPage.getTextUserNameMenu();
        Assert.assertEquals(ConfProperties.getProperty("mail"), user);
        //System.out.println(user);
        try {
            //Проверяем банер и закрываем его
            mainPage.clickCloseBanner();
        } catch (NoSuchElementException e) {
            //если банера нет то ещё лучше
            System.out.println("банера нет");
            //идём дальше
        }
    }

    public void sendLetter() {

        //кликаем на написать письмо
        mainPage.clickWriteLetterBtn();
        //Проверяем что открылась форма создания письма
        Assert.assertEquals(letterPage.komuText(), "Кому");
        //Заполняем адресата
        letterPage.inputReceiverField();
        //Заполняем тему
        letterPage.inputSummaryField();
        //заполнить тело письма
        letterPage.inputLetterField();
        //кликаем прикрепить файл
        letterPage.clickAttachBtn();
        //Кликаем отправить
        letterPage.clickSendBtn();
        //Нажимаем на эскейп чтоб закрыть окно писмо отправлено
       // letterPage.esc();

    }


    public void checkingMail() {

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
        //Assert.assertEquals(mainPage.getFileName(), helpers.ConfProperties.getProperty("autoTest.doc"));
        //Скачиваем файл
        mainPage.downloadFile();


    }

    public void checkingSign() {
        //Получаем подпись и сравниваем с тем что наизменяли
        Assert.assertEquals(letterPage.getSignText(), fuckingSignature);
    }

    public void goToIncoming() {
        //переход во входящие
        mainPage.clickInboxBtn();
    }

    public void signСhange() {


        //Переходим в настроки учетки
        mainPage.clickSettingsBtn();

        //Переходим во все настроки
        settingPage.clickAllSettingsBtn();

        //помещаем 1 вкладку в отдельную переменную
        String window1 = driver.getWindowHandle();
        System.out.println("урл страницы " + getDriver().getCurrentUrl());

        //Переходим во все настроки
        settingPage.clickAllSettingsBtn();

        /*Тут открывается новая вкладка*/

        Set<String> curentWindows = getDriver().getWindowHandles();//получаем все вкладки
        String window2 = null;
        for (String window : curentWindows) {
            if (!window.equals(window1)) { //сравниваем с первым окном
                window2 = window;
                break;
            }
        }

        getDriver().switchTo().window(window2);// переключаемся на другую вкладку
        //System.out.println("урл страницы 2 " + driver.getCurrentUrl());

        //Переходим в блок Имя и подпись
        allSettingPage.clickNameSignBtn();
        //Клкаем редактировать
        allSettingPage.clickEditSignBtn();
        //измненяем подпись
        allSettingPage.editSignText();
        fuckingSignature = allSettingPage.getSignText();
        //созраняем новую подпись
        allSettingPage.clickSaveSignBtn();
        //Возвращаемся в почту
        allSettingPage.clickGoMailBtn();
    }

    public void deleteLetter() {
        try {
            //выделяем
            mainPage.clickAllCheckboxAboutLetter();
            //Удаляем
            mainPage.clickDeleteLeterBtn();
            //Проверяем что удалилось
            Assert.assertEquals(mainPage.getTextLetterNo(), "Писем нет");
            System.out.println(mainPage.getTextLetterNo());
        } catch (NoSuchElementException | InterruptedException e) {

        }


    }
}
