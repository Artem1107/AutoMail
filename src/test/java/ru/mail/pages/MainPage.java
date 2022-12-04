package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    /**
     Описание элементов
     */
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    //Кнопка написать письмо
    @FindBy(xpath = "//span[@class=\"compose-button__txt\"]")
    private WebElement writeLetterBtn;

    //Кнопка Входщие
    @FindBy(xpath = "//div[text()='Входящие']")
    private WebElement inboxBtn;

    //Тема письма
    @FindBy(xpath = "//span[@class=\"mt-snt-tmslf__subject-value\"]")
    private WebElement summaryLetter;

   // Тема письма в самом письме
   @FindBy(xpath = "//h2[@class='thread-subject']")
   private WebElement summaryInLetter;

    // Текст в открытого письме
    @FindBy(xpath = "//div[@class=\"cl_075096\"]/div[1]")
    private WebElement textInLetter;

    //Кнопка Настройки
    @FindBy(xpath = "//div[text()='Настройки']")
    private WebElement settingsBtn;

    public String summaryLetter() {
        String summaryLetterText = summaryLetter.getText();
        return summaryLetterText;
    }


    /**
     * Дальше методы
     */


    //метод для получения текста темы письма

    public String getSummaryLetter() {
        String summaryLetterText = summaryLetter.getText();
        return summaryLetterText;
    }


    //метод для получения текста темы письма из самого письма


    public String summaryInLetter() {
        String summaryInLetterText = summaryInLetter.getText();
        return summaryInLetterText;
    }

    /**
     * метод для получения текста текста из письма
     */

    public String textInLetter() {
        String textLetter = textInLetter.getText();
        return textLetter;
    }


}
