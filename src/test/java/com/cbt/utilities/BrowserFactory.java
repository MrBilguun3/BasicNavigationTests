package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String type){
        if(type.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(type.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if(type.equalsIgnoreCase(("safari"))){
            System.setProperty("webdriver.safari.driver", "C:/safaridriver.exe");
            return new SafariDriver();
        }else if(type.equalsIgnoreCase("edge") || type.equalsIgnoreCase("internet explorer") ){
            return null;
        }
        return null;
    }
}
