import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.practicum.stellarburgers.utils.DriverHelper;

public class BaseTest {
    WebDriver driver;

    @Before
    public void setDriver() throws Exception {
        DriverHelper driverHelper = new DriverHelper();
        driver = driverHelper.driverInit();
    }

    @Before
    public void setURI() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
