package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class DropDown04 {

  WebDriver driver;


    @Test
    public void amazonDropdown() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        WebElement lang = driver.findElement(By.xpath("//a[@class= 'nav-a nav-a-2 icp-link-style-2']"));
        Actions a = new Actions(driver);
        a.moveToElement(lang).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement lang_sel = driver.findElement(By.xpath("//div[@class= 'nav-template nav-flyout-content nav-tpl-itemList']/following::a[@lang = 'kn-IN']"));
        lang_sel.click();
        Thread.sleep(5000);


        driver.quit();

    }
}
