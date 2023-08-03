import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageobject.SignInPage;
import pageobject.RegisterPage;

public class RegisterTest extends BaseTest {
    private String userName;
    private String userEmail;
    private String userPassword;

    @Before
    public void openPage() {
        driver.get(RegisterPage.URL);
    }

    @Test
    @DisplayName("Зарегистрировать пользователя")
    public void successfullyRegister() throws Exception {
        generateUserData();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillField("Имя", userName);
        registerPage.fillField("Email", userEmail);
        registerPage.fillField("Пароль", userPassword);
        registerPage.clickElement("Зарегистрироваться");
        // После успешной регистрации открывается страница авторизации. Проверяем наличие элемента с этой страницы
        SignInPage signInPage = new SignInPage(driver);
        signInPage.findElement("Вход");
    }

    @Test
    @DisplayName("Нельзя указать пароль менее 6 символов при регистрации")
    public void registerWithShortPassword() throws Exception {
        generateUserData();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillField("Имя", userName);
        registerPage.fillField("Email", userEmail);
        userPassword = faker.number().digits(5);
        registerPage.fillField("Пароль", userPassword);
        registerPage.clickElement("Зарегистрироваться");
        registerPage.findElement("Некорректный пароль");
    }

    @Step("Сгенерировать данные для регистрации пользователя")
    public void generateUserData() {
        userEmail = faker.pokemon().name() + faker.number().digits(4) + "@mail.ru";
        userPassword = faker.number().digits(6);
        userName = faker.name().firstName();
    }
}
