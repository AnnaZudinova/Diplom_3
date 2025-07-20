package ru.practicum.stellarburgers.page.object;

import io.qameta.allure.Step;
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
    private static By bunsSectionActive = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Булки']");
    private static By sauceSectionActive = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Соусы']");
    private static By fillingSectionActive = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Начинки']");

    public MainPage (WebDriver driver) {this.driver=driver;}
    @Step("Нажать Личный кабинет")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажать войти")
    public void clickEnterAccountButton () {
        driver.findElement(enterAccountButton).click();
    }

    @Step ("Нажать на раздел Булки")
    public void clickBunsSection () {
        driver.findElement(bunsSection).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsSectionActive));
    }

    @Step ("Нажать на раздел Соус")
    public void clickSauceSection () {
        driver.findElement(sauceSection).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSectionActive));
    }

    @Step ("Нажать на раздел Начинки")
    public void clickFillingSection () {
        driver.findElement(fillingSection).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingSectionActive));
    }

    @Step ("Проверка видимости кнопки Оформить заказ")
    public boolean isPlaceOrderButtonClickable () {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        return driver.findElement(placeOrderButton).isDisplayed();
    }

    @Step("Проверка активности раздела Булки")
    public boolean isBunSectionActive() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bunsSectionActive));
        return driver.findElement(bunsSectionActive).isDisplayed();
    }

    @Step("Проверка активности раздела Соусы")
    public boolean isSauceSectionActive() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(sauceSectionActive));
        return driver.findElement(sauceSectionActive).isDisplayed();
    }

    @Step("Проверка активности раздела Начинки")
    public boolean isFillingSectionActive(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingSectionActive));
        return driver.findElement(fillingSectionActive).isDisplayed();
    }


}
