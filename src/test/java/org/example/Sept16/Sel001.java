package org.example.Sept16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class Sel001 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@aria-label = 'Search']"));
        searchBox.sendKeys("Facebook");
        searchBox.submit();
        //driver.findElement(By.xpath("(//div[@class ='pcTkSc'])[1]/div[@aria-label = 'facebook']")).click();
        Thread.sleep(3000);


        //driver.quit();

    }
}
