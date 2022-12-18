package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.mail.steps.Base;

public class SettingPage extends Base {


    //Кнопка Все Настройки
    @FindBy(xpath = "//span[text()='Все настройки']")
    private WebElement allSettingsBtn;

    public SettingPage(WebDriver driver) {
        super(driver);
    }

    //метод перехода во все настройки
    public void clickAllSettingsBtn() {
        allSettingsBtn.click();}


}
