package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ultimatix {
    public static void main(String[] args) throws InterruptedException {
        String user = "1620391";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ultimatix.net/uxportal/uxportalhome.html/home");
        driver.findElement(By.id("form1")).sendKeys(user);
        driver.findElement(By.id("proceed-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("easyAuth-btn")).click();
        //System.out.println(driver.findElement(By.cssSelector("div[class='digits']")).getText());

    }
}
