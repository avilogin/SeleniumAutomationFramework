package org.example.Oct09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SelectClass {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        WebElement drop = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"))));
        Select sel = new Select(drop);
       List<WebElement> options =  sel.getOptions();
       for (WebElement option :options)
       {
           if(option.getText().equalsIgnoreCase("USD"))
           {
               option.click();
           }
       }
       Thread.sleep(5000);
       driver.quit();

    }
}
