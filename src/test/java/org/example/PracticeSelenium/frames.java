package org.example.PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class frames {

    WebDriver driver;
    //ChromeOptions options;

    @BeforeTest
    public void init_Browser()
    {
        //options = new ChromeOptions();
        //options.addArguments("--headless=new");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void singleFrames()
    {
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[normalize-space()='Frames']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Nested Frames']")).click();

        WebElement parentFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(parentFrame);

        WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(leftFrame);
        String msg1 = driver.findElement(By.xpath("//body")).getText();
        System.out.println(msg1);

        driver.switchTo().parentFrame();
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(middleFrame);
        String msg2 = driver.findElement(By.xpath("//div[@id='content']")).getText();
        System.out.println(msg2);

        driver.switchTo().parentFrame();
        WebElement rightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));
        driver.switchTo().frame(rightFrame);
        String msg3 = driver.findElement(By.xpath("//body")).getText();
        System.out.println(msg3);

        driver.switchTo().defaultContent();

        System.out.println("We are outside of Frames");




    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }


}
