package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends TopPage implements Element {
    private By fieldName = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By fieldEmail = By.xpath("//label[text()='Email']/following-sibling::input");
    private By fieldPassword = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private By buttonRegister = By.xpath("//button[text()='Зарегистрироваться']");
    private By textElementIncorrectPassword = By.xpath("//p[text()='Некорректный пароль']");
    private By linkSignIm = By.xpath("//a[text()='Войти']");
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    public RegisterPage(WebDriver driver) {
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
            case ("Имя"):
                elementBy = fieldName;
                break;
            case ("Email"):
                elementBy = fieldEmail;
                break;
            case ("Пароль"):
                elementBy = fieldPassword;
                break;
            case ("Зарегистрироваться"):
                elementBy = buttonRegister;
                break;
            case ("Некорректный пароль"):
                elementBy = textElementIncorrectPassword;
                break;
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
