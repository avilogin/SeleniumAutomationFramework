package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown02 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        for (int i =0;i<3;i++)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        for (int i =0;i<2;i++)
        {
            driver.findElement(By.id("hrefIncChd")).click();
        }
        for (int i =0;i<2;i++)
        {
            driver.findElement(By.id("hrefIncInf")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.className("paxinfo")).getText();
        System.out.println(text);


        driver.quit();
    }
}
