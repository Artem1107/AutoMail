package ru.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.helpers.ConfProperties;
import ru.mail.steps.Base;

public class LetterPage extends Base {

    public LetterPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[@class='container--2lPGK type_base--rkphf color_secondary--2J-6y link--EcxEU inline--PKmCd']")
    private WebElement komu;

    @FindBy(xpath = "//label[@class=\"container--zU301\"]")
    private WebElement receiverField;

    @FindBy(xpath = "//div[@class='container--3QXHv']/div/input")
    private WebElement summaryField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement letterField;

    @FindBy(xpath = "//div[@data-signature-widget='content']")
    private WebElement signField;

    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement sendBtn;

    @FindBy(xpath = "//input[@class = 'desktopInput--3cWPE']")
    private WebElement attachBtn;


    /**
     * Метод для получения текста подсказки
     */
    public String komuText() {
        return getText(komu);
    }

    /**
     * метод для получения текста подписи
     */
    public String getSignText() {
        return getText(signField);
    }

    /**
     * Метод ввода темы
     */
    public void inputSummaryField() {
        inputText(summaryField, ConfProperties.getProperty("summaryLetter"));
    }

    /**
     * Метод ввода адреста
     */
    public void inputReceiverField() {
        inputText(receiverField, ConfProperties.getProperty("mail"));
    }

    /**
     * Метод ввода тела письма
     */
    public void inputLetterField() {
        inputText(letterField, ConfProperties.getProperty("textLetter"));
    }

    /**
     * метод нажатия на Отправить
     */
    public void clickSendBtn() {
        click(sendBtn);
    }

    /**
     * кликнем ескейп
     */
    //public void esc() {
        //getDriver().;
  //  }

    /**
     * клик на прикрепить файл
     */
    public void clickAttachBtn() {
        inputText(attachBtn, ConfProperties.getProperty("file"));
    }

}
