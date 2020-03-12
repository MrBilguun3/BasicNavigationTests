package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {
    public static void main(String[] args) throws Exception{
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        String starts = "http://practice.cybertekschool.com";
        int count = 1;
        for(String each : urls) {
            driver.get(each);
            if(driver.getCurrentUrl().startsWith(starts)){
                System.out.println("PASS: " + count);
            }else {
                System.out.println("Fail: " + count);
            }
            count++;
        }

        Thread.sleep(20000);

    }
}
