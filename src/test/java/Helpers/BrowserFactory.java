package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
   static WebDriver driver;

    public static WebDriver setBrowser (String BrowserName, String url){
        if (BrowserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "/users/olgacissa/downloads/chromedriver 2");
            driver = new ChromeDriver();
        }
        else if (BrowserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.firefox.driver", "/users/olgacissa/downloads/geckodriver 2");
            driver = new FirefoxDriver();
        }
        else if (BrowserName.equalsIgnoreCase("IE")){
            driver = new InternetExplorerDriver();
        }
        driver.get(url);
        return driver;
    }

}
