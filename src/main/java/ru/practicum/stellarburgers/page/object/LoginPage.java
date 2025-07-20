package ru.practicum.stellarburgers.page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private static By emailField = By.xpath(".//input[@name='name']");
    private static By passwordField = By.xpath(".//input[@name='Пароль']");
    private static By enterButton = By.xpath(".//button[text()='Войти']");
    private static By registrationButton = By.xpath(".//a[@href='/register']");
    private static By restorePasswordButton = By.xpath(".//a[@href='/forgot-password']");


    public LoginPage (WebDriver driver) {this.driver=driver;}

    @Step ("Заполнить поле Email")
    public void fillEmailField (String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step ("Заполнить поле Пароль")
    public void fillPasswordField (String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step ("Нажать войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step ("Нажать зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step ("Нажать восставновить пароль")
    public void clickRestorePasswordButton() {
        driver.findElement(restorePasswordButton).click();
    }

    @Step ("Проверка видимости кнопки Войти")
    public boolean isEnterButtonAvailable () {
       new WebDriverWait(driver, Duration.ofSeconds(5))
               .until(ExpectedConditions.elementToBeClickable(enterButton));
        return driver.findElement(enterButton).isDisplayed();
    }

}
