package org.example.Sept16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Sel002 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String mainWin = driver.getWindowHandle();
        System.out.println(mainWin);
        driver.navigate().to("https://www.makemytrip.com/?srsltid=AfmBOoojS5eVM__bOts_NrtUQ5Dr33VS2r2fcfj3WJm51DlSi8A2HXay");
        driver.navigate().to("https://in.bookmyshow.com/");
       Set<String> windows =  driver.getWindowHandles();

       for (String one : windows)
       {
           System.out.println(one);
       }

        //driver.quit();

    }
}
