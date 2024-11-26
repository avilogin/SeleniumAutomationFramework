package org.example.Nov;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class scrollTest {

    WebDriver driver;
    @Test
    public void scrolling() throws InterruptedException {
       // ChromeOptions op = new ChromeOptions();
        //op.addArguments("--incognito");
        //op.addArguments("--start-maximized");
        driver =  new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        WebElement el = driver.findElement(By.xpath("//span[text()='Best Sellers in Clothing & Accessories']"));

        //Scrolling to the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",el);
        Thread.sleep(5000);

        driver.quit();



    }
}
