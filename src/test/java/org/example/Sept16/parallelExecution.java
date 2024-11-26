package org.example.Sept16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class parallelExecution {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver (ChromeDriver in this case)
        driver = new ChromeDriver();
    }
    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Google Test is running on: " + Thread.currentThread().getId());
    }
    @Test
    public void openFacebook() {
        driver.get("https://www.facebook.com");
        System.out.println("Facebook Test is running on: " + Thread.currentThread().getId());
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
