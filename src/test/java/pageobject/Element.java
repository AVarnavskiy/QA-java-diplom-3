package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Element {
    By getElementLocator (String elementName) throws Exception;
    WebElement findElement(String elementName) throws Exception;
}
