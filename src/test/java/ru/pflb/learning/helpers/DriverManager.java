package ru.pflb.learning.helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {

    }

    public static WebDriver getDriver() {//TODO приложить драйвера к тесту и прописать путь до них
        if (driver == null) {
//            System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver.exe");
//            System.setProperty("chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
//            driver = new FirefoxDriver();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
