package ru.mail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mail.pages.*;

import java.util.concurrent.TimeUnit;

public class RunTest {
    public static StartPage startPage;
    public static AuthorizationPage authorizationPage;
    public static MainPage mainPage;
    public static LetterPage letterPage;
    public static SettingPage settingPage;
    public static AllSettingPage allSettingPage;

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
        letterPage = new LetterPage(driver);
        settingPage = new SettingPage(driver);
        allSettingPage = new AllSettingPage(driver);

    }

    @Test
    public void login() {
        LoginAndSendMail.login();
        LoginAndSendMail.sendLetter();
        LoginAndSendMail.checkingMail();
        LoginAndSendMail.signСhange();

        LoginAndSendMail.sendLetter();
        LoginAndSendMail.checkingMail();
        LoginAndSendMail.checkingSign();
        LoginAndSendMail.goToIncoming();
        LoginAndSendMail.deleteLetter();
    }

    @AfterClass
  public static void tearDown() throws InterruptedException {
       Thread.sleep(20000);
      driver.quit();
  }
}


