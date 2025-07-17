import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver driver;

    private static By enterButton = By.xpath(".//a[@href='/login']");

    public ForgotPasswordPage (WebDriver driver) {
        this.driver=driver;
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}
