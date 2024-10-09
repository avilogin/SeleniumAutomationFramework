package org.example.Sept27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test01 {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver =  new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement sign = driver.findElement(By.xpath("//a[@id = 'nav-link-accountList']"));
        Actions a = new Actions(driver);
        a.moveToElement(sign).perform();
        WebElement button =  driver.findElement(By.xpath("(//span[@class='nav-action-inner'][normalize-space()='Sign in'])[1]"));
        button.click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3000));



        Thread.sleep(5000);
        driver.quit();
    }
}
