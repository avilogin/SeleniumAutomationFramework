package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        //using index in xpath
//        driver.findElement(By.xpath("//a[@value='BLR']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //sending values in dropdown
//        driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("HYD");
//        Thread.sleep(2000);
//        driver.findElement(By.name("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
//        driver.findElement(By.name("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("JDH");

        //or
        //parent child relationship xpath
        driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value = 'PYG']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value = 'VTZ']")).click();
        Thread.sleep(2000);

        driver.close();
    }
}
