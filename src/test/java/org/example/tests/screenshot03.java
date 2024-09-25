package org.example.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class screenshot03 {
    public static void main(String[] args) throws IOException ,InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath("//div[@class = '_2SmNnR']/input"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        WebElement login = driver.findElement(By.xpath("(//div[@class='_1Us3XD'])[1]"));
        //Hovering Mouse
        Actions a = new Actions(driver);
        a.moveToElement(login).perform();
        System.out.println("Moving to element");
        //Taking Screenshot
        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(),new File("C:\\Users\\HP\\OneDrive\\Desktop\\Screenshot\\image.jpg").toPath());
        System.out.println("Screenshot Taken");
        Thread.sleep(5000);

        driver.quit();



    }
}
