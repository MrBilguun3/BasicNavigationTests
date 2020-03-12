package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class NavigationTests {
    public static void main(String[] args) throws Exception{
        WebDriver chrome = BrowserFactory.getDriver("chrome");
        WebDriver firefox = BrowserFactory.getDriver("firefox");
        WebDriver safari = BrowserFactory.getDriver("safari");

        chrome.get("https://google.com");
        firefox.get("https://google.com");
        safari.get("https://google.com");

        String titleChrome = chrome.getTitle();
        String titleFF = firefox.getTitle();
        String safariTitle = safari.getTitle();

        chrome.get("https://etsy.com");
        firefox.get("https://etsy.com");
        safari.get("https://etsy.com");

        String titleChrome1 = chrome.getTitle();
        String titleFF1 = firefox.getTitle();
        String safariTitle1 = safari.getTitle();

        chrome.navigate().back();
        firefox.navigate().back();
        safari.navigate().back();

        if(titleChrome.equals(chrome.getTitle()) && titleFF.equals(firefox.getTitle()) && safariTitle.equals(safari.getTitle())){
            System.out.println("PASS - 1");
        }else {
            System.out.println("FAIL - 1");
        }

        chrome.navigate().forward();
        firefox.navigate().forward();
        safari.navigate().forward();

        if(titleChrome1.equals(chrome.getTitle()) && titleFF1.equals(firefox.getTitle()) && safariTitle1.equals(safari.getTitle())){
            System.out.println("PASS - 2");
        }else {
            System.out.println("FAIL - 2");
        }

        Thread.sleep(20000);

    }
}
