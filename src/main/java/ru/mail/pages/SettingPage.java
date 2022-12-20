package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.steps.Base;

public class SettingPage extends Base {

    public SettingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Все настройки']")
    private WebElement allSettingsBtn;


    /**
     * метод перехода во все настройки
     */
    public void clickAllSettingsBtn() {
        click(allSettingsBtn);
    }


}
