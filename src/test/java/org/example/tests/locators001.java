package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class locators001 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//waits
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Avijeet");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String errorMsg = driver.findElement(By.cssSelector("p.error")).getText();
       System.out.println(errorMsg);
        driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click();//contains text method using xpath
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.xpath("//button[@fdprocessedid = 't6p6s8']")).click();
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();//Used the indexing to find the element in xpath
       // driver.findElement(By.cssSelector("input[type ='text']:nth-child(2)")).getText();//finding element using index in css  selector
       driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");//used the tag-name to locate the attributes using xpath
       System.out.println(driver.findElement(By.cssSelector("form p")).getText());// Used the tag-name to locate the attribute using css selector
       driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");//regular Expression in CSS Selector
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //regular Expression in xpath
        driver.findElement(By.xpath("//div[@class = 'forgot-pwd-btn-conainer']/button[1]")).click();//using parent to child tag and also indexing in xpath
        //driver.quit();
    }

}
