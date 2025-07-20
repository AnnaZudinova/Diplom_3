package ru.practicum.stellarburgers.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.util.Properties;

public class DriverHelper {
    protected WebDriver driver;

    public WebDriver driverInit () throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/browser.properties"));
        String browserProperty = properties.getProperty("testBrowser");

        BrowserType browserType = BrowserType.valueOf(browserProperty);
        switch (browserType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case YANDEX:
                System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:/Users/User/AppData/Local/Yandex/YandexBrowser/Application/browser.exe"); // Укажите путь к исполняемому файлу Яндекс Браузера
                driver = new ChromeDriver(options);
                break;
            default:
                throw new RemoteException("Browser undentified");
        }
        return driver;
    }
}
