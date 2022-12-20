package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.steps.Base;


public class AllSettingPage extends Base {

    public AllSettingPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//p[text()='Изменить имя отправителя, добавить и изменить подпись']")
    private WebElement nameSignBtn;

    @FindBy(xpath = "//button[@data-test-id='edit']")
    private WebElement editSignBtn;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement signText;

    @FindBy(xpath = "//div[@class='SignatureEditPopup__buttons--1Q_w0']/button")
    private WebElement saveSignBtn;

    @FindBy(xpath = "//span[text()='Вернуться в почту']")
    private WebElement goMailBtn;


    /**
     * метод перехода в блок Имя и подпись
     */
    public void clickNameSignBtn() {
        click(nameSignBtn);
    }

    /**
     * клик на иконку изменения имени и подписи
     */
    public void clickEditSignBtn() {
        click(editSignBtn);
    }

    /**
     * клик на иконку изменения имени и подписи
     */
    public void editSignText() {
        clear(signText);
        inputText(signText, "QA " + Math.random());
    }

    /**
     * метод получения текста подписи
     */
    public String getSignText() {
        return getText(signText);
    }

    /**
     * клик на сохранить
     */
    public void clickSaveSignBtn() {
        click(saveSignBtn);
    }

    /**
     * клик вернуться в почту
     */
    public void clickGoMailBtn() {
        click(goMailBtn);
    }


}
