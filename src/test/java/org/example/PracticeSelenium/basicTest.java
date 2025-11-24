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

public class basicTest {

    WebDriver driver;

    @BeforeTest
    public void init_Browser()
    {
         driver = new ChromeDriver();
         driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        String url = "https://testpages.eviltester.com/styled/index.html";
        driver.get(url);
        By locator = By.xpath("//h1[normalize-space()='Practice Applications and Pages For Automating and Testing']");
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        try
        {
            String actual = "Practice Applications and Pages For Automating and Testing";
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            if (actual.equals("Practice Applications and Pages For Automating and Testing"))
            {
                System.out.println("Success");
            }
            else
            {
                System.out.println("Failure");
            }
        }
        catch (Exception e)
        {
            System.out.println("Text not found");
        }

        //clicking another link
        //driver.findElement();






        }






    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }


}
