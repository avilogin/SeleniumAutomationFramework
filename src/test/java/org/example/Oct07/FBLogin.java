package org.example.Oct07;

import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;


public class FBLogin {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException, IOException {
        driver = new ChromeDriver();
        String user = "abhijeet.Jana.9";
        String pass = "password";//password is incorrect
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//div[@class='_6lux']/input")).sendKeys(user);
        driver.findElement(By.xpath("//div[@class='_6lux']/div/input")).sendKeys(pass);
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        WebDriverWait w =  new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[normalize-space(text())='Abhijeet Jana']"),"Abhijeet Jana"));

        File f  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(),new File("D:\\Documents for Study\\Automation class\\Screenshot\\login.jpg").toPath());

        Thread.sleep(5000);
        //Scrolling
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");


        Thread.sleep(5000);
        driver.quit();


    }
}
