package org.example.tests;

import org.apache.log.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicDropdown03 {



    @Test(enabled = false)
    public void autoSuggestiveDropDown() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class= 'ui-menu-item']/a"));
        for(WebElement option :options)
        {
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void spiceJet01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.findElement(By.xpath("(//div[@class = 'css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'])[2]")).click();

        driver.findElement(By.xpath("(//div[@class = 'css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input)[1]")).sendKeys("ban");
        List<WebElement> from = driver.findElements(By.xpath("//div[@class = 'css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3']/div/div/div/div"));

        for (WebElement from_place : from)
        {
            if(from_place.getText().equalsIgnoreCase("Bengaluru"))
            {
                from_place.click();
                break;
            }
        }
        driver.findElement(By.xpath("(//div[@class = 'css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input)[2]")).sendKeys("mumb");

        Thread.sleep(5000);
        driver.quit();
    }




}
