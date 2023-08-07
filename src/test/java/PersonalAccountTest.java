import helpers.user.DeleteUser;
import helpers.user.User;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.PersonalAccountPage;
import pageobject.SignInPage;

public class PersonalAccountTest extends BaseTest {
    User user;

    @Test
    @DisplayName("Перейти в личный кабинет по клику на кнопку «Личный кабинет»")
    public void goToPersonalAccount() throws Exception {
        createUserByApi();
        driver.get(SignInPage.URL);
        signIn();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickElement("Личный кабинет");
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.findElement("Профиль");
    }

    @Test
    @DisplayName("Выйти из аккаунта")
    public void signOut() throws Exception {
        createUserByApi();
        driver.get(SignInPage.URL);
        signIn();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickElement("Личный кабинет");
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickElement("Выход");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.findElement("Вход");
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

    @After
    public void deleteUser() {
        DeleteUser.deleteUser(user.getEmail(), user.getPassword(), user.getName(), user.getToken());
    }
}
