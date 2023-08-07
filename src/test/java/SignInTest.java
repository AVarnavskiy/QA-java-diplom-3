import helpers.user.DeleteUser;
import helpers.user.User;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pageobject.ForgotPasswordPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import pageobject.SignInPage;

public class SignInTest extends BaseTest {

    User user;

    @Test
    @DisplayName("Войти в аккаунт по кнопке «Войти в аккаунт» на главной")
    public void signInFromMainPage() throws Exception {
        createUserByApi();
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickElement("Войти в аккаунт");
        signIn();
        checkAbsenceButtonSignInMainPage();
    }

    @Test
    @DisplayName("Войти в аккаунт через кнопку «Личный кабинет»")
    public void signInByButtonPersonaArea() throws Exception {
        createUserByApi();
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickElement("Личный кабинет");
        signIn();
        checkAbsenceButtonSignInMainPage();
    }

    @Test
    @DisplayName("Войти в аккаунт через кнопку в форме регистрации")
    public void signInFromRegisterPage() throws Exception {
        createUserByApi();
        driver.get(RegisterPage.URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickElement("Войти");
        signIn();
        checkAbsenceButtonSignInMainPage();
    }

    @Test
    @DisplayName("Войти в аккаунт через кнопку в форме восстановления пароля")
    public void signInFromForgotPasswordPage() throws Exception {
        createUserByApi();
        driver.get(ForgotPasswordPage.URL);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickElement("Войти");
        signIn();
        checkAbsenceButtonSignInMainPage();
    }

    @Step("Создать пользователя с помощью api")
    public void createUserByApi() {
        user = new User();
        user.createUser();
    }

    @Step("Войти в аккаунт")
    public void signIn() throws Exception {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.fillField("Email", user.getEmail());
        signInPage.fillField("Пароль", user.getPassword());
        signInPage.clickElement("Войти");
    }

    @Step("Проверить отсутствие кнопки 'Войти в аккаунт' на главной странице после авторизации")
    public void checkAbsenceButtonSignInMainPage() throws Exception {
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(0, mainPage.getCountElements("Войти в аккаунт"));
    }

    @After
    public void deleteUser() {
        DeleteUser.deleteUser(user.getEmail(), user.getPassword(), user.getName(), user.getToken());
    }
}
