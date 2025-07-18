package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private static By personalAccountButton = By.xpath(".//a[@href='/account']/p");
    private static By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private static By bunsSection = By.xpath(".//span[text()='Булки']");
    private static By sauceSection = By.xpath(".//span[text()='Соусы']");
    private static By fillingSection = By.xpath(".//span[text()='Начинки']");
    private static By placeOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private static By spicySauce = By.xpath(".//img[@alt='Соус Spicy-X']");
    private static By protostomiaMeat = By.xpath(".//img[@alt='Мясо бессмертных моллюсков Protostomia']");
    private static By fluorescentBun = By.xpath(".//img[@alt='Флюоресцентная булка R2-D3']");

    public MainPage (WebDriver driver) {this.driver=driver;}

    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        driver.findElement(personalAccountButton).click();
    }

    public void clickEnterAccountButton () {
        driver.findElement(enterAccountButton).click();
    }

    public void clickBunsSection () {
        driver.findElement(bunsSection).click();
    }

    public void clickSauceSection () {
        driver.findElement(sauceSection).click();
    }

    public void clickFillingSection () {
        driver.findElement(fillingSection).click();
    }

    public boolean isPlaceOrderButtonClickable () {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        return driver.findElement(placeOrderButton).isDisplayed();
    }

    public boolean isSpicySauceVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(spicySauce));
        return driver.findElement(spicySauce).isDisplayed();
    }

    public boolean isProtostomiaMeatVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(protostomiaMeat));
        return driver.findElement(protostomiaMeat).isDisplayed();
    }

    public boolean isFluorescentBunVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fluorescentBun));
        return driver.findElement(fluorescentBun).isDisplayed();
    }

}
