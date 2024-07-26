package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class flipKart {


    @Test
    public void locators() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        //String mobile = driver.findElement(By.linkText("Mobiles & Tablets")).getText();
        //driver.findElement(By.linkText("Mobiles & Tablets")).click();
        String mobile = driver.findElement(By.cssSelector("a[class ='_1ch8e_']:nth-child(2)")).getText();//finding element using index in css  selector


        System.out.println(mobile);











        Thread.sleep(5000);
        driver.quit();
    }


}


