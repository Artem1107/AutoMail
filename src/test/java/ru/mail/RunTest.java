package ru.mail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mail.pages.AuthorizationPage;
import ru.mail.pages.StartPage;
import ru.mail.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class RunTest {
        public static StartPage startPage;
        public static AuthorizationPage authorizationPage;
        public static MainPage mainPage;
        public static WebDriver driver;

        @BeforeClass
        public static void setup() {
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            //WebDriver driver = new ChromeDriver();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(ConfProperties.getProperty("loginPage"));
            startPage = new StartPage(driver);
            mainPage = new MainPage(driver);
            authorizationPage = new AuthorizationPage(driver);

        }

        @Test
        public void login() {
            Login.login();


    }
}

