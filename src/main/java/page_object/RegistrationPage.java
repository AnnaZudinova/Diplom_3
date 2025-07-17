import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;

    private static By nameField = By.xpath(".//label[text()='Имя']/../input");
    private static By emailField = By.xpath(".//label[text()='Email']/../input");
    private static By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    private static By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private static By enterButton = By.xpath(".//a[@href='/login']");
    private static By incorrectPasswordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage (WebDriver driver) {this.driver=driver;}

    public void fillNameField (String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void fillEmailField (String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField (String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationButton () {
        driver.findElement(registrationButton).click();
    }

    public void clickEnterButton () {
        driver.findElement(enterButton).click();
    }

    public boolean isIncorrectPasswordErrorVisible () {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordError));
        return driver.findElement(incorrectPasswordError).isDisplayed();
    }
}

