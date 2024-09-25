package org.example.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Scroll {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js  = (JavascriptExecutor) driver;
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,2000)");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //js.executeScript("window.scrollBy(1000,0)");


    }
}
