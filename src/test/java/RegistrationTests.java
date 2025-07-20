import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.practicum.stellarburgers.page.object.LoginPage;
import ru.practicum.stellarburgers.page.object.MainPage;
import ru.practicum.stellarburgers.page.object.RegistrationPage;

import static org.junit.Assert.assertEquals;

public class RegistrationTests extends BaseTest {
    UserSteps userSteps=new UserSteps();

    @Test
    @DisplayName("успешная регистрация")
    public void testSuccessfulRegistration() {
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);
        LoginPage loginPageObj=new LoginPage(driver);
        RegistrationPage registrationPageObj=new RegistrationPage(driver);

        mainPageObj.clickPersonalAccountButton();
        loginPageObj.clickRegistrationButton();
        registrationPageObj.fillNameField(userSteps.name);
        registrationPageObj.fillEmailField(userSteps.email);
        registrationPageObj.fillPasswordField(userSteps.password);
        registrationPageObj.clickRegistrationButton();

        assertEquals(true,loginPageObj.isEnterButtonAvailable());
    }

    @Test
    @DisplayName("ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    public void testRegistrationWithShortPassword() {
        driver.get(MainPage.URL);

        MainPage mainPageObj=new MainPage(driver);
        LoginPage loginPageObj=new LoginPage(driver);
        RegistrationPage registrationPageObj=new RegistrationPage(driver);

        mainPageObj.clickPersonalAccountButton();
        loginPageObj.clickRegistrationButton();
        registrationPageObj.fillNameField(userSteps.name);
        registrationPageObj.fillEmailField(userSteps.email);
        registrationPageObj.fillPasswordField(userSteps.shortPassword);
        registrationPageObj.clickRegistrationButton();

        assertEquals(true,registrationPageObj.isIncorrectPasswordErrorVisible());
    }

    @After
    public void tearDown() {
        userSteps.existingUserLogin();
        userSteps.deleteUser();
        driver.quit();
    }
}

