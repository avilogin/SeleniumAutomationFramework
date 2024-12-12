package org.example.Dec;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test01 {

    WebDriver driver;

    @Test
    public void chromeTest() throws InterruptedException {
       driver = new ChromeDriver();
       driver.get("https://www.google.com/");
       driver.manage().window().maximize();
       Thread.sleep(3000);

       driver.quit();

    }

    @Test
    public void fireFoxTest() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.quit();

    }
}
