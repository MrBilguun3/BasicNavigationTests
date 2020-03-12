package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitle {
    public static void main(String[] args) throws Exception{

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        String searchItem = "Macbook";
        search.sendKeys(searchItem);
        Thread.sleep(2000);
        //<input type="submit" class="nav-input" value="Go" tabindex="20">
        WebElement click = driver.findElement(By.className("nav-input"));
        click.click();

        driver.navigate().forward();
        if(driver.getTitle().contains(searchItem)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        Thread.sleep(10000);



    }
}
