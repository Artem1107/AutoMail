package ru.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class MainPage {


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Описание элементов
     */


    //имя авторизованного пользака
    @FindBy(xpath = ".//span[@class='ph-project__user-name svelte-1hiqrvn']")
    private WebElement userNameMenu;

    //Кнопка написать письмо
    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private WebElement writeLetterBtn;

    //Кнопка Входящие
    @FindBy(xpath = "//a[@class = 'nav__item js-shortcut nav__item_active nav__item_shortcut nav__item_child-level_0']")
    private WebElement inboxBtn;

    //Тема письма
    @FindBy(xpath = "//a[@class='llc llc_has-indent llc_new llc_new-selection js-letter-list-item js-tooltip-direction_letter-bottom'][1]//span[@class='ll-sj__normal']")
    private WebElement summaryLetter;

    // Тема письма в самом письме
    @FindBy(xpath = "//h2[@class='thread-subject']")
    private WebElement summaryInLetter;

    // Текст в открытого письме
    @FindBy(xpath = "//div[text()='Hello']") //умней ничего не придумал(
    private WebElement textInLetter;

    //Кнопка Настройки
    @FindBy(xpath = ".//span[@data-highlighted-class='button2_highlighted' and @title = 'Настройки']")
    private WebElement settingsBtn;


    //Значек закрытие банера
    @FindBy(xpath = "//div[@class='ph-project-promo-close-icon__container svelte-m7oyyo']")
    private WebElement closeВlackBanner;

    //Плученное письмо
    @FindBy(xpath = "//div[@class='mt-h-c__content']")
    private WebElement receivedLetter;

    //Письма себе
    @FindBy(xpath = "//span[@class='mt-t mt-t_tomyself mt-t_unread mt-t_no-caps']")
    private WebElement letterYourself;

    //последнее полученное сообщение
    @FindBy(xpath = "//a[@class='llc llc_has-indent llc_new llc_new-selection js-letter-list-item js-tooltip-direction_letter-bottom'][1]//span[@class='llc__subject llc__subject_unread']")
    private WebElement lastReceivedLetter;

    //иконка над чекбоксом сообщений
    @FindBy(xpath = "//div[@class='llc__avatar']")
    private WebElement  iconAboutLettter;

    //чекбоксы сообщений
    @FindBy(xpath = "//div[@class='checkbox__box checkbox__box_checked']")
    private WebElement  checkboxAboutLettter;

    //чекбоксы сообщений
    @FindBy(xpath = "//span[@class='button2 button2_has-ico button2_has-ico-s button2_delete button2_pure button2_ico-text-top button2_hover-support js-shortcut']")
    private WebElement  deleteLeterBtn;

    //Надпись Писем нет
    @FindBy(xpath = ".//span[@class='octopus__title']")
    private WebElement letterNo;

    /**
     * Дальше методы
     */

    //Получаем все чекбоксы письма и кликаем на них

    public void clickAllCheckboxAboutLettter() throws InterruptedException {
        Actions actions = new Actions(driver);
        int a=0;

        List <WebElement> icons = driver.findElements(By.xpath("//span[@class='ll-av__img']"));
        for (WebElement icon:icons){
            actions.moveToElement(icon).click().perform();
            a++;}
        System.out.println(a);

    }

    //Получаем надпись писем нет
    public String getTextLetterNo(){
       String letterNoText = letterNo.getText();
       return letterNoText;
    }

    //метод нажатия на сообщения
    public void clickDeleteLeterBtn() {
        deleteLeterBtn.click();
    }

    //метод для получения текста темы письма
    public String getSummaryLetter() {
        String summaryLetterText = summaryLetter.getText();
        return summaryLetterText;
    }


    //метод для получения текста темы письма из самого письма
    public String getTextInLetter() {
        String textLetter = textInLetter.getText();
        return textLetter;
    }


    //метод для получения текста письма
    public String getSummaryInLetter() {
        String summaryInLetterText = summaryInLetter.getText();
        return summaryInLetterText;
    }


    //метод текста из меню авторизованого пользователя
    public String getTextUserNameMenu() {
        String textMenu = userNameMenu.getText();
        return textMenu;
    }

    //метод закрытия банера
    public void clickCloseВlackBanner() {
        closeВlackBanner.click();
    }
    //метод нажатия на написать письмо
    public void clickWriteLetterBtn() {
        writeLetterBtn.click();
    }

    //метод нажатия на Входящие
    public void clickInboxBtn() {
        inboxBtn.click();
    }

    //метод нажатия на 'письма себе'
    public void clickLetterYourself() {
        letterYourself.click();
    }

    //метод нажатия на тему письма для его открытия
    public void clickSummaryLetter() {
        summaryLetter.click();
    }
    //метод перехода в настройки
    public void clickSettingsBtn() {
        settingsBtn.click();
    }

    }


