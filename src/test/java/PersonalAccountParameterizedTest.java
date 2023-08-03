import helpers.user.DeleteUser;
import helpers.user.User;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.PersonalAccountPage;
import pageobject.SignInPage;

@RunWith(Parameterized.class)
public class PersonalAccountParameterizedTest extends BaseTest {
    private String elementName;
    private User user;

    public PersonalAccountParameterizedTest(String elementName) {
        this.elementName = elementName;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[]{
                "Конструктор",
                "Логотип"
        };
    }

    @Test
    @DisplayName("Перейти из личного кабинета на главную страницу")
    public void goToMainPageByClickConstructor() throws Exception {
        createUserByApi();
        driver.get(SignInPage.URL);
        signIn();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickElement("Личный кабинет");
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickElement(elementName);
        Assert.assertEquals(MainPage.URL + "/", driver.getCurrentUrl());
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
