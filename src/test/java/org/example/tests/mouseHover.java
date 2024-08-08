package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseHover {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        Actions a = new Actions(driver);
       // a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Fashion')]"))).perform();
        //Thread.sleep(3000);
        a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Login')]"))).perform();
        Thread.sleep(3000);

        driver.quit();

    }
}
