package ru.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    //Закрытие банера
    @FindBy(xpath = "//div[@class='ph-project-promo-close-icon__container svelte-m7oyyo']")
    private WebElement closeВlackBanner;


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


    // if(!driver.findElements(By.xpath("//a[@data-show-pixel]")).isEmpty()){

    }


