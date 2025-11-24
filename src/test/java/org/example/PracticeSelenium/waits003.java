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

public class waits003 {
    WebDriver driver;

    @BeforeTest
    public void init_Browser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test3()
    {
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);
        By link = By.xpath("//a[contains(text(),'Dynamic Controls')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(link));

        driver.findElement(link).click();
        driver.findElement(By.xpath("//button[normalize-space()='Remove']")).click();

        By addBtn = By.xpath("//button[normalize-space()='Add']");

        wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        driver.findElement(addBtn).click();

        By backMsg = By.xpath("//p[@id='message']");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(backMsg,"It's back!"));

        String message = driver.findElement(backMsg).getText();

        System.out.println("Mesage Returned : "+message);

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
