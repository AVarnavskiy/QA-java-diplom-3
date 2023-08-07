import com.github.javafaker.Faker;
import helpers.WebDriverHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected Faker faker = new Faker();

    @Before
    public void createDriver() {
        driver = WebDriverHelper.createDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        WebDriverHelper.quitDriver(driver);
    }
}
