import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

import static io.restassured.RestAssured.given;

public class UserSteps {
    protected String email = RandomStringUtils.randomAlphabetic(5)+"@ya.ru";
    protected String password = RandomStringUtils.randomAlphanumeric(7);
    protected String name = RandomStringUtils.randomAlphabetic(10);
    protected String shortPassword = RandomStringUtils.randomAlphanumeric(4);
    protected String accessToken;

    protected final String CREATE_USER ="/api/auth/register";
    protected final String DELETE_USER = "/api/auth/user";
    protected final String LOGIN = "/api/auth/login";

    User user = new User(email, password, name);

    @Step
    @DisplayName("Создать уникального пользователя")
    public void createUser() {
        Response response = given()
                .contentType(ContentType.JSON)
                .and()
                .body(user)
                .post(CREATE_USER);

        RegistrationResponse registrationResponse = response.as(RegistrationResponse.class);
        accessToken = registrationResponse.getAccessToken();
    }

    @Step
    @DisplayName("Авторизация существующего пользователя")
    public void existingUserLogin() {
        Response response= given()
                .contentType(ContentType.JSON)
                .and()
                .body(user)
                .post(LOGIN);

        RegistrationResponse registrationResponse = response.as(RegistrationResponse.class);
        accessToken = registrationResponse.getAccessToken();
    }

    @Step
    @DisplayName("Удалить пользователя")
    public void deleteUser() {
        try {
            given()
                    .contentType(ContentType.JSON)
                    .header(new Header("Authorization", accessToken))
                    .and()
                    .body(user)
                    .delete(DELETE_USER);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
