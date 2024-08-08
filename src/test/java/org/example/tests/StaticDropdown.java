package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        WebElement currency  = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));

        Select sel = new Select(currency);
        sel.selectByIndex(2);
        Thread.sleep(2000);
        System.out.println(sel.getFirstSelectedOption().getText());
        sel.selectByVisibleText("INR");
        Thread.sleep(2000);
        System.out.println(sel.getFirstSelectedOption().getText());
        sel.selectByValue("USD");
        Thread.sleep(2000);
        System.out.println(sel.getFirstSelectedOption().getText());
        driver.quit();
    }
}
