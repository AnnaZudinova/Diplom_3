import jdk.jfr.Description;
import org.junit.After;
import org.junit.Test;
import page_object.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTests extends BaseTest {

    @Test
    @Description("переход к разделу Соусы")
    public void goToSauceTest() {
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);

        mainPageObj.clickSauceSection();
        assertEquals(true,mainPageObj.isSpicySauceVisible());
    }

    @Test
    @Description("переход к разделу Начинки")
    public void goToFillingTest() {
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);

        mainPageObj.clickFillingSection();
        assertEquals(true,mainPageObj.isProtostomiaMeatVisible());
    }

    @Test
    @Description("переход к разделу Булки")
    public void goToBunsTest() {
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);

        mainPageObj.clickFillingSection();
        if (mainPageObj.isProtostomiaMeatVisible()) {
            mainPageObj.clickBunsSection();
        }
        assertEquals(true,mainPageObj.isFluorescentBunVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
