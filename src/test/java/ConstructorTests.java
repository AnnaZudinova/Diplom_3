import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.practicum.stellarburgers.page.object.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTests extends BaseTest {

    @Test
    @DisplayName("переход к разделу Соусы")
    public void goToSauceTest() {
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);

        mainPageObj.clickSauceSection();
        assertTrue(mainPageObj.isSauceSectionActive());
    }

    @Test
    @DisplayName("переход к разделу Начинки")
    public void goToFillingTest(){
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);

        mainPageObj.clickFillingSection();
        assertTrue(mainPageObj.isFillingSectionActive());
    }

    @Test
    @DisplayName("переход к разделу Булки")
    public void goToBunsTest() {
        driver.get(MainPage.URL);

        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickSauceSection();
        if (mainPageObj.isSauceSectionActive()) {
            mainPageObj.clickBunsSection();
            assertTrue(mainPageObj.isBunSectionActive());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
