package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.steps.Base;

public class StartPage extends Base {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big svelte-1y37831']")
    private WebElement entryBtn;

    /**
     * Метод Нажатия кнопки вход
     */
    public void clickEntryBtn() {
        click(entryBtn);
    }
}


