package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleTitle {
    public static void main(String[] args) throws Exception{
        /*
        1. Open browser
        2. Go to https://google.com
        3. Search for one of the strings the list searchStrs given below
        4. In the results pages, capture the url right above the first result
        5. Click on the first result
        6. Verify that url is equal to the value from step 4
        7. Navigate back
        8. Repeat the same steps for all search items in the list
        Note: Do this exercise using a for loop. Here is the list that was mentioned step 3:
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", “Selenium web browser
        automation" );
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");

        //<input class="gLFyf gsfi" maxlength="2048" name="q" type="text" jsaction="paste:puy29d" aria-autocomplete="both" aria-haspopup="false" autocapitalize="off" autocomplete="off" autocorrect="off" autofocus="" role="combobox" spellcheck="false" title="Search" value="" aria-label="Search" data-ved="0ahUKEwiLl6fp4ZXoAhUNgnIEHUCEBmcQ39UDCAY">
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("java", Keys.ENTER);
        //<cite class="iUh30 tjvcx">www.java.com</cite>
        String url = driver.findElement(By.cssSelector("[class*='tjvcx']")).getText();
        //<h3 class="LC20lb DKV0Md">Java | Oracle</h3>
        WebElement result = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div.r > a > h3"));
        result.click();
        if(driver.getCurrentUrl().toLowerCase().contains(url)){
            System.out.println("PASS: " + driver.getCurrentUrl());
        }else {
            System.out.println("FAIL: "+ driver.getCurrentUrl());
        }

        Thread.sleep(5000);
        driver.navigate().back();driver.get("https://google.com");

        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation");

        //<h3 class="LC20lb DKV0Md">Cucumber: BDD Testing &amp; Collaboration Tools for Teams</h3>
        for(String each : searchStrs) {
            driver.get("https://google.com");
            WebElement lookFor = driver.findElement(By.name("q"));
            lookFor.sendKeys(each, Keys.ENTER);
            String urlLook = driver.findElement(By.cssSelector("[class*='LC20l']")).getText();
            WebElement Result = driver.findElement(By.className("LC20lb"));
            Result.click();

            if(driver.getCurrentUrl().toLowerCase().contains(urlLook.toLowerCase())){
                System.out.println("PASS: " + driver.getCurrentUrl());
            }else {
                System.out.println("FAIL: "+ driver.getCurrentUrl());
            }

            Thread.sleep(2000);
        }

        Thread.sleep(4000);
        driver.close();

    }
}
