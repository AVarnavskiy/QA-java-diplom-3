package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends TopPage implements Element {
    private By linkSignIm = By.xpath("//a[text()='Войти']");
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(String elementName) throws Exception {
        findElement(elementName).click();
    }

    public By getElementLocator(String elementName) throws Exception {
        By elementBy;
        switch (elementName) {
            case ("Войти"):
                elementBy = linkSignIm;
                break;
            default:
                throw new Exception("Элемент " + elementName + " не описан в классе");
        }
        return elementBy;
    }

    public WebElement findElement(String elementName) throws Exception {
        return driver.findElement(getElementLocator(elementName));
    }
}
