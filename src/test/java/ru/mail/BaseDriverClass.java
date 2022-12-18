package ru.mail;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseDriverClass {
    private String ggrUrl = "http://localhost:4445";

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Rule
    public TestWatcher watcher;

    {
        watcher = new TestWatcher() {


            @Override
            protected void starting(Description description) {
                ChromeOptions options = new ChromeOptions();
                URL url = null;

                try {
                    url = new URL(ggrUrl + "/wd/hub");

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(url, options);
            }

            @Override
            protected void succeeded(Description description) {

            }

            @Override
            protected void failed(Throwable e, Description description) {

            }

            @Override
            protected void finished(Description description) {

            }


        };

    }


}


