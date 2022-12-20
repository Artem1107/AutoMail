package ru.mail.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    protected WebDriver driver;
    protected int sec = 20;

    public Base(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    //Возможно метод не должен возвращать результат
    public boolean waitVisibalElement(final WebElement element, final int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public void click(final WebElement element) {
        waitVisibalElement(element, sec);
        element.click();
    }

    public String getText(final WebElement element) {
        waitVisibalElement(element, sec);
        return element.getText();

    }

    public void inputText(final WebElement element, String text) {
        waitVisibalElement(element, sec);
        element.sendKeys(text);
    }

    public void clear(final WebElement element) {
        waitVisibalElement(element, sec);
        element.clear();
    }


}
