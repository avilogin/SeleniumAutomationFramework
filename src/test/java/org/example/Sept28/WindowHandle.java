package org.example.Sept28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle { static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String mainWin = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

        Set<String> allWin = driver.getWindowHandles();

        for (String win : allWin)
        {
            driver.switchTo().window(win);
            if (driver.getPageSource().contains("New Window"))
            {
                System.out.println("Switched to another window");
                break;
            }
        }
        Thread.sleep(3000);
        driver.switchTo().window(mainWin);
       String url_copy =  driver.getCurrentUrl();
        Assert.assertEquals(URL,url_copy);
        System.out.println("Switched To main window");
        Thread.sleep(3000);
        driver.quit();

    }
}
