package org.example.Oct07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openGoogle {
    public static WebDriver driver;
    public static void main(String[] args) {
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String url = driver.getCurrentUrl();
        if (url.equalsIgnoreCase("https://www.google.com/"))
        {
            System.out.println("Its redirected to Google");
        }
        else
        {
            System.out.println("Its not Google. Please provide another URL");
        }

        driver.quit();

    }
}
