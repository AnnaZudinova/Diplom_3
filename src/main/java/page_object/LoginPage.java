package page_object;

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

    public void fillEmailField (String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField (String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void clickRestorePasswordButton() {
        driver.findElement(restorePasswordButton).click();
    }

    public boolean isEnterButtonAvailable () {
       new WebDriverWait(driver, Duration.ofSeconds(5))
               .until(ExpectedConditions.elementToBeClickable(enterButton));
        return driver.findElement(enterButton).isDisplayed();
    }

}
