package ru.pflb.learning.helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {

    }

    public static WebDriver getDriver() {//TODO приложить драйвера к тесту и прописать путь до них
        if (driver == null) {
//            System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver.exe");
//            System.setProperty("chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");

            try {
                driver = new ChromeDriver();
//                driver = new FirefoxDriver();
            } finally {
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new BrowserCleanup()));
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            System.err.print("Closing the browser");
            close();
        }
    }

    public static void close() {
        try {
            getDriver().quit();
            driver = null;
        } catch (UnreachableBrowserException e) {
            System.err.print("cannot close browser: unreachable browser");
        }
    }
}
