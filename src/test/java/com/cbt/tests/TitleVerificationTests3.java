package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests3 {
    public static void main(String[] args) throws Exception {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        int count = 1;
        for(String each : urls) {
            driver.get(each);
            driver.navigate().forward();
            String title = driver.getTitle().toLowerCase().replace(" ","");
            if(driver.getCurrentUrl().contains(title)){
                System.out.println("PASS: "+count);
            }else {
                System.out.println("FAIL: "+count);
                System.out.println(title);
                System.out.println(driver.getCurrentUrl());
            }

            count++; Thread.sleep(3500);

        }
        Thread.sleep(5500);

    }
}
