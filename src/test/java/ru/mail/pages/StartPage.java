package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static ru.mail.RunTest.driver;

public class StartPage {
    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    //Кнопка вход
    @FindBy(xpath = "//button[@class=\"resplash-btn resplash-btn_primary resplash-btn_mailbox-big svelte-1y37831\"]")
    private WebElement entryBtn;


    /**
     * Метод Нажатия кнопки вход
     */
    public void clickEntryBtn() {
        entryBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
}


