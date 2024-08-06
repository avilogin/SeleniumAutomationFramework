package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class passwordExtraction {

    public static void main(String[] args) throws InterruptedException {
        String name = "Avijeet";
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("input[placeholder = 'Username']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(3000);
        driver.close();



    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("reset-pwd-btn")).click();
        String passwordString = driver.findElement(By.className("infoMsg")).getText();
        // Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray1 =  passwordString.split("'");
        String[] passwordArray2 =  passwordArray1[1].split("'");
        String Extractedpassword = passwordArray2[0];
        return Extractedpassword;


    }


}
