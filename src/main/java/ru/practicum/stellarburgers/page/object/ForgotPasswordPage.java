package ru.practicum.stellarburgers.page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver driver;

    private static By enterButton = By.xpath(".//a[@href='/login']");

    public ForgotPasswordPage (WebDriver driver) {
        this.driver=driver;
    }

    @Step("Нажать Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}
