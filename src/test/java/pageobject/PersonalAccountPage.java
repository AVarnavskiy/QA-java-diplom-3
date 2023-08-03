package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalAccountPage extends TopPage implements Element {
    private By linkProfile = By.xpath("//a[text()='Профиль']");
    private By buttonExit = By.xpath("//button[text()='Выход']");
    public static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(String elementName) throws Exception {
        findElement(elementName).click();
    }

    public By getElementLocator(String elementName) throws Exception {
        By elementBy;
        switch (elementName) {
            case ("Профиль"):
                elementBy = linkProfile;
                break;
            case ("Конструктор"):
                elementBy = linkConstructor;
                break;
            case ("Логотип"):
                elementBy = linkLogo;
                break;
            case ("Выход"):
                elementBy = buttonExit;
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
