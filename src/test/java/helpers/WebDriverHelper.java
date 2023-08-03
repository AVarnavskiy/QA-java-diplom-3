package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverHelper {

    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // Запуск в ЯБ командой mvn -DBROWSER=yandex test
        String yandexBrowserPath = "C:/Users/artem/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";
        if (hasSystemEnvOrPropertyValueYandexBrowser()) {
            options.setBinary(yandexBrowserPath);
        }
        return new ChromeDriver(options);
    }

    private static Boolean hasSystemEnvOrPropertyValueYandexBrowser() {
        // Запуск в ЯБ с помощью Maven: mvn -DBROWSER=yandex test
        // Запуск отдельных тестов в idea с указанием env BROWSER=yandex
        if (
                (System.getProperties().containsKey("BROWSER") && System.getProperty("BROWSER").equals("yandex")) ||
                (System.getenv().containsKey("BROWSER")) && System.getenv("BROWSER").equals("yandex")
        ) {
            return true;
        } else {
            return false;
        }
    }
    public static void quitDriver(WebDriver driver) {
        driver.quit();
    }

}
