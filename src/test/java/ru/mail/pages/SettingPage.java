package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingPage {
    private final WebDriver driver;

    public SettingPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Кнопка Все Настройки
    @FindBy(xpath = "//span[text()='Все настройки']")
    private WebElement allSettingsBtn;

    //метод перехода во все настройки
    public void clickAllSettingsBtn() {
        allSettingsBtn.click();}


}
