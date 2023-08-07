package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends TopPage implements Element {
    private By buttonSignIn = By.xpath("//button[text()='Войти в аккаунт']");
    private By tabBuns = By.xpath("//div[contains(@class,'tab') and ./span[text()='Булки']]");
    private By tabSauces = By.xpath("//div[contains(@class,'tab') and ./span[text()='Соусы']]");
    private By tabFillings = By.xpath("//div[contains(@class,'tab') and ./span[text()='Начинки']]");
    public static final String URL = "https://stellarburgers.nomoreparties.site";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(String elementName) throws Exception {
        findElement(elementName).click();
    }

    public int getCountElements(String elementName) throws Exception {
        return driver.findElements(getElementLocator(elementName)).size();
    }

    public By getElementLocator(String elementName) throws Exception {
        By elementBy;
        switch (elementName) {
            case ("Войти в аккаунт"):
                elementBy = buttonSignIn;
                break;
            case ("Личный кабинет"):
                elementBy = linkPersonalAccount;
                break;
            case ("Булки"):
                elementBy = tabBuns;
                break;
            case ("Соусы"):
                elementBy = tabSauces;
                break;
            case ("Начинки"):
                elementBy = tabFillings;
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
