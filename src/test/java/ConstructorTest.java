import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.MainPage;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest {
    private String tabName;

    public ConstructorTest(String tabName) {
        this.tabName = tabName;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[]{
                "Булки",
                "Соусы",
                "Начинки",
        };
    }

    @Test
    @DisplayName("Проверить работу перехода к разделам конструктора")
    public void testTest() throws Exception {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);
        if (!tabName.equals("Булки")) {
            // Раздел Булки выбран по умолчанию, поэтому не кликаем
            mainPage.clickElement(tabName);
        }
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.attributeContains(mainPage.findElement(tabName), "class", "tab_type_current"));
    }

}
