package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LetterPage {
    private final WebDriver driver;


    public LetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Описание элементов
     */
    //Фрейм написания письма

    //То что идентифицирует форму создания письма, пусть будет название кнопки "Кому"
    @FindBy(xpath = "//button[@class='container--2lPGK type_base--rkphf color_secondary--2J-6y link--EcxEU inline--PKmCd']")
    private WebElement komu;

    //Поле кому
    @FindBy(xpath = "//label[@class=\"container--zU301\"]")
    private WebElement receiverField;

    //Поле Тема
    @FindBy(xpath = "//div[@class='container--3QXHv']/div/input")
    private WebElement summaryField;

    //Поле тела письма
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement letterField;

    //Поле подписи письма
    @FindBy(xpath = "//div[@data-signature-widget='content']")
    private WebElement signField;

    //Кнопка Отправить
    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement sendBtn;

    //Кнопка Прикрепить файл
    @FindBy(xpath = "//div[text()='Прикрепить файл']")
    private WebElement attachBtn;


    /**
     * Методы
     */

    //метод для получения текста подсказки
    public String komuText() {
        String komuText = komu.getText();
        return komuText;
    }

    //метод для получения текста подписи
    public String getSignText() {
        String iconText = signField.getText();
        return iconText;
    }

    //Метод ввода темы
    public void inputSummaryField(String mail) {
        summaryField.sendKeys(mail);
    }

    //Метод ввода адреста
    public void inputReceiverField(String summary) {
        receiverField.sendKeys(summary);
    }
    //Метод ввода тела письма
    public void inputLetterField(String text) {
        //letterField.click();
        letterField.sendKeys(text);
    }

    //метод нажатия на Отправить
    public void clickSendBtn() {
        sendBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
