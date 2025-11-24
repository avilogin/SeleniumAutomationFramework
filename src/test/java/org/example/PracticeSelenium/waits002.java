package org.example.PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class waits002 {

    WebDriver driver;

    @BeforeTest
    public void init_Browser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1()
    {
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);
        By link = By.xpath("//a[contains(text(),'Dynamic Loading')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(link));

        driver.findElement(link).click();
        driver. findElement(By.xpath("//a[contains(text(),'Example 2:')]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

        By message = By.xpath("//div[@id = 'finish']/h4");

        wait.until(ExpectedConditions.presenceOfElementLocated(message));

        String outputMsg = driver.findElement(message).getText();

        System.out.println(outputMsg);
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
