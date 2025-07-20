import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.stellarburgers.page.object.ForgotPasswordPage;
import ru.practicum.stellarburgers.page.object.LoginPage;
import ru.practicum.stellarburgers.page.object.MainPage;
import ru.practicum.stellarburgers.page.object.RegistrationPage;

import static org.junit.Assert.assertEquals;

public class LoginTests extends BaseTest {
    UserSteps userSteps=new UserSteps();

    @Before
    public void startUp() {
        userSteps.createUser();
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginByEnterAccountOnManePage (){
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);
        LoginPage loginPageObj=new LoginPage(driver);

        mainPageObj.clickEnterAccountButton();
        loginPageObj.fillEmailField(userSteps.email);
        loginPageObj.fillPasswordField(userSteps.password);
        loginPageObj.clickEnterButton();

        assertEquals(true, mainPageObj.isPlaceOrderButtonClickable());
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void testLoginByPersonalAccount (){
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);
        LoginPage loginPageObj=new LoginPage(driver);

        mainPageObj.clickPersonalAccountButton();
        loginPageObj.fillEmailField(userSteps.email);
        loginPageObj.fillPasswordField(userSteps.password);
        loginPageObj.clickEnterButton();

        assertEquals(true, mainPageObj.isPlaceOrderButtonClickable());
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void testLoginByRegistrationPage (){
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);
        LoginPage loginPageObj=new LoginPage(driver);
        RegistrationPage registrationPageObj=new RegistrationPage(driver);

        mainPageObj.clickEnterAccountButton();
        loginPageObj.clickRegistrationButton();
        registrationPageObj.clickEnterButton();

        loginPageObj.fillEmailField(userSteps.email);
        loginPageObj.fillPasswordField(userSteps.password);
        loginPageObj.clickEnterButton();

        assertEquals(true, mainPageObj.isPlaceOrderButtonClickable());
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void testLoginByForgotPasswordPage (){
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);
        LoginPage loginPageObj=new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(driver);

        mainPageObj.clickEnterAccountButton();
        loginPageObj.clickRestorePasswordButton();
        forgotPasswordPage.clickEnterButton();

        loginPageObj.fillEmailField(userSteps.email);
        loginPageObj.fillPasswordField(userSteps.password);
        loginPageObj.clickEnterButton();

        assertEquals(true, mainPageObj.isPlaceOrderButtonClickable());
    }


    @After
    public void tearDown() {
        userSteps.deleteUser();
        driver.quit();
    }

}
