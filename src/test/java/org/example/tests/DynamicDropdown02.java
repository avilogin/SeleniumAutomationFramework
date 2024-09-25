package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicDropdown02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        driver.manage().window().maximize();
        WebElement drop = driver.findElement(By.id("select-demo"));
        driver.findElement(By.id("select-demo")).click();

        Select sel = new Select(drop);
        sel.selectByValue("Wednesday");
        System.out.println(sel.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        WebElement drop2 = driver.findElement(By.name("States"));
        driver.findElement(By.name("States")).click();

        //Select sel2 = new Select(drop);
        //sel.selectByVisibleText("New Jersey");
        //System.out.println(sel.getFirstSelectedOption().getText());
        driver.findElement(By.xpath("//option[@value='New Jersey']")).click();
        driver.findElement(By.id("printMe"));
        String first = driver.findElement(By.xpath("(//span[@class='genderbutton'])[1]")).getText();

        System.out.println(first);
        //driver.close();

    }
}
