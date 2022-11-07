package by.it_academy.cucumber.driver;

import static com.codeborne.selenide.Configuration.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DriverConfigurator {
    public static void setUpDriver() {
        chromedriver().setup();
        browser = "chrome";
        pageLoadTimeout = 20000;
        browserSize = "1920x1080";
    }
}
