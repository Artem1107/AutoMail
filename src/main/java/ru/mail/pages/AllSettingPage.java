package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.mail.steps.Base;


public class AllSettingPage extends Base {



    // блок Имя и подпись
    @FindBy(xpath = "//p[text()='Изменить имя отправителя, добавить и изменить подпись']")
    private WebElement nameSignBtn;

    //Кнопка редактировать имя иподпись
    @FindBy(xpath = "//button[@data-test-id='edit']")
    private WebElement editSignBtn;


    //Текст подписи
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement signText;

    //Сохранить подпись
    @FindBy(xpath = "//div[@class='SignatureEditPopup__buttons--1Q_w0']/button")
    private WebElement saveSignBtn;

    //Кнопка вернуться в почту
    @FindBy(xpath = "//span[text()='Вернуться в почту']")
    private WebElement goMailBtn;

    public AllSettingPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Методы
     */
    //метод перехода в блок Имя и подпись
    public void clickNameSignBtn() {
        nameSignBtn.click();}

    //клик на иконку изменения имени и подписи
    public void clickEditSignBtn() {
        editSignBtn.click();}

    //метод изменения подписи
    public void editSignText (String sing){
        signText.clear();
        signText.sendKeys(sing);
    }

    //метод получения текста подписи
    public String getSignText (){
        String text = signText.getText();
        return text;
    }
    //клик на сохранить
    public void clickSaveSignBtn() {
        saveSignBtn.click();}

    //клик вернуться в почту
    public void clickGoMailBtn() {
        goMailBtn.click();}








}
