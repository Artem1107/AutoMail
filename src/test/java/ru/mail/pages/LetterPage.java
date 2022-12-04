package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetterPage {
    private final WebDriver driver;

    public LetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //То что идентифицирует форму создания письма, пусть будет иконка ? с подсказкой
    @FindBy(xpath = "//div[@class=\"base-0-2-85 tooltip-0-2-87\"]")
    private WebElement helpIcon;

    //Поле кому
    @FindBy(xpath = "//label[@class=\"container--zU301\"]")
    private WebElement receiverField;

    //Поле Тема
    @FindBy(xpath = "//div[@class=\"container--3QXHv\"]")
    private WebElement summaryField;

    //Поле тела письма
    @FindBy(xpath = "//div[@class=\"editable-1s0m cke_editable cke_editable_inline cke_contents_true cke_show_borders\"]")
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
     * метод для получения текста подсказки
     */

    public String helpIcon() {
        String iconText = helpIcon.getText();
        return iconText;
    }

    /**
     * метод для получения текста подписи
     */

    public String getSignText() {
        String iconText = helpIcon.getText();
        return iconText;
    }
}
