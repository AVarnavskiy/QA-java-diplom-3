package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends TopPage implements Element {
    private By headerEntrance = By.xpath("//h2[text()='Вход']");
    private By fieldEmail = By.xpath("//label[text()='Email']/following-sibling::input");
    private By fieldPassword = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private By buttonSignIn = By.xpath("//button[text()='Войти']");
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillField(String elementName, String value) throws Exception {
        findElement(elementName).sendKeys(value);
    }

    public void clickElement(String elementName) throws Exception {
        findElement(elementName).click();
    }

    public By getElementLocator(String elementName) throws Exception {
        By elementBy;
        switch (elementName) {
            case ("Email"):
                elementBy = fieldEmail;
                break;
            case ("Пароль"):
                elementBy = fieldPassword;
                break;
            case ("Войти"):
                elementBy = buttonSignIn;
                break;
            case ("Вход"):
                elementBy = headerEntrance;
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
