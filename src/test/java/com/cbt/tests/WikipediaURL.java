package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaURL {
    /*
        1. Go to wikipedia.org
        2. enter search term selenium webdriver
        3. click on search button
        4. click on search result Selenium (software)
        5. verify url ends with Selenium_(software)
     */
    public static void main(String[] args) throws Exception {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://wikipedia.org");
        //<input id="searchInput" name="search" type="search" size="20" autofocus="autofocus" accesskey="F" dir="auto" autocomplete="off" list="suggestions" style="padding-right: 64px;">
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("selenium webdriver");
        Thread.sleep(2000);

        //<i class="sprite svg-search-icon" data-jsl10n="search-input-button">Search</i>
        WebElement click = driver.findElement(By.cssSelector(".sprite.svg-search-icon"));
        click.click();

        Thread.sleep(2000);
        //<span class="searchmatch">Selenium</span>
        WebElement searchResult = driver.findElement(By.className("searchmatch"));
        searchResult.click();

        String ends = "Selenium_(software)";
        driver.navigate().forward();
        if(driver.getCurrentUrl().contains(ends)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println(driver.getCurrentUrl());
        }




    }
}
