package org.example.Nov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parallelTest01 {


    WebDriver driver;
    @Test(invocationCount = 2)
    public void test01() throws InterruptedException {
        System.out.println("Test1 execution" +Thread.currentThread().getId());
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.close();
    }

    @Test(enabled = false)
    public void test02() throws InterruptedException {
        System.out.println("Test2 execution"+ Thread.currentThread().getId());
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.close();

    }

    @Test(enabled = false)
    public void test03() throws InterruptedException {
        System.out.println("Test3 execution"+ Thread.currentThread().getId());
        driver = new ChromeDriver();
        driver.get("https://www.gmail.com/");
        Thread.sleep(2000);
        driver.close();

    }
}
