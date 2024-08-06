package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class locators002 {


    public static void main(String[] args) throws InterruptedException {
        String name = "Avijeet";
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click();//contains text method using xpath
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@class,'pwd')]/button[1]")).click();//contains class as pwd and from parent to child with index in xpath
        driver.findElement(By.cssSelector("input[placeholder = 'Username']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("rahulshettyacademy");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        String msg= driver.findElement(By.xpath("//p[contains(text(),'successfully')]")).getText();
        System.out.println(msg);
        Assert.assertEquals(msg,"You are successfully logged in.");
        String text = driver.findElement(By.cssSelector("div h2")).getText();
        Assert.assertEquals(text,"Hello "+name+",");
        driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();//this is only applicable for xpath















        Thread.sleep(5000);
        driver.quit();







    }
}
