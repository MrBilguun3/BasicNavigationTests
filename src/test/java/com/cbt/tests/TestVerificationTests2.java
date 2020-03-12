package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TestVerificationTests2 {
    public static void main(String[] args) throws Exception{

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");
        WebDriver driver = BrowserFactory.getDriver("chrome");

        int count = 1;
        for (int i = 0; i <urls.size() ; i++) {
            driver.get(urls.get(i));
            driver.navigate().forward();
            Thread.sleep(3000);
            int first = driver.getCurrentUrl().indexOf(".")+1;
            int last = driver.getCurrentUrl().lastIndexOf(".");
            String url = driver.getCurrentUrl().substring(first, last);
            String titleNoSpace = driver.getTitle().replace(" ", "").toLowerCase();
            if(titleNoSpace.contains(url)){
                System.out.println("PASS: "+ count);
            }else {
                System.out.println("FAIL: " + count);
                System.out.println(url);
                System.out.println(titleNoSpace);
            }
            count++;
        }

        Thread.sleep(20000);

    }
}
