package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopPage {
    protected WebDriver driver;
    protected By linkConstructor = By.xpath("//a[.//p[text()='Конструктор']]");
    protected By linkLogo = By.xpath("//div[contains(@class,'header__logo')]/a");
    protected By linkPersonalAccount = By.xpath("//a[.//p[text()='Личный Кабинет']]");
}
