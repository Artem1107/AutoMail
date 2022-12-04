package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.mail.ConfProperties;

public class AllSettingPage {

    private final WebDriver driver;

    public AllSettingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //перейти в блок Имя и подпись
    @FindBy(xpath = "//h4[text()='Имя и подпись']")
    private WebElement nameSignBtn;

    //Кнопка редактировать подпись
    @FindBy(xpath = "//button[@data-test-id='edit']")
    private WebElement editSignBtn;


    //Текст подписи
    @FindBy(xpath = "//div[@class='editable-a1ag cke_editable cke_editable_inline cke_contents_true cke_show_borders']/div")
    private WebElement signText;

    //Сохранить подпись
    @FindBy(xpath = "//div[@class='SignatureEditPopup__buttons--1Q_w0']/button")
    private WebElement saveSignBtn;

    //Кнопка вернуться в почту
    @FindBy(xpath = "//span[text()='Вернуться в почту']")
    private WebElement goMailBtn;


}
