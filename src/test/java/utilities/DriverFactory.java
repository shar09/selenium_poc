package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver init(String browserType) {
        // Driver Path
        String projectPath = System.getProperty("user.dir");

        if (browserType.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver");
            return new FirefoxDriver();

        }
        else {
            System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
            return new ChromeDriver();
        }
    }
}
