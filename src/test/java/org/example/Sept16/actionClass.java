package org.example.Sept16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class actionClass {

    WebDriver driver;

    @BeforeTest
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");
    }

    @Test
    public void actionExample() throws InterruptedException {

        WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
        Actions a = new Actions(driver);
        a.keyDown(Keys.SHIFT)
                .sendKeys(username,"a")
                .keyUp(Keys.SHIFT).sendKeys("vijeet")
                .doubleClick(username)
                .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL).build().perform();

        a.click(password).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}
