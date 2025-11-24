package org.example.PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class waits001 {

    WebDriver driver;

    @BeforeTest
    public void init_Browser()
    {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1()
    {
        String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
        driver.get(url);
        By logo = By.xpath("//div[@class='brand greenLogo']");

        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logo));

        WebElement addBtn = driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='+'])[1]"));
        WebElement addToCart = driver.findElement(By.xpath("//div[@class='products']//div[1]//div[3]//button[1]"));
        int count = 5;
        for (int i=0;i<count;i++)
        {
            addBtn.click();
        }
        addToCart.click();

        By cartCount = By.xpath("(//strong[contains(text(),'0')])[1]");
        try
        {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(cartCount,"1"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

        }


    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
