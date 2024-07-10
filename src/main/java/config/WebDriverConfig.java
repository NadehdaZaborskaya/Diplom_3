package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {
    public static final long WAIT_SEC_TIMEOUT = 10;
    private static final ChromeOptions options = new ChromeOptions();

    public static WebDriver setDriver() {
        //Запуск тестов в Chrome Browser
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);

        //Запуск тестов в Yandex Browser
    //    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    //    ChromeOptions options = new ChromeOptions();
    //    options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
    //    return new ChromeDriver(options);
    }

}
