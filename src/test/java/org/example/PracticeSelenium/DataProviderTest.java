package org.example.PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    WebDriver driver;
    //ChromeOptions options;

    @BeforeTest
    public void init_Browser()
    {
        //options = new ChromeOptions();
        //options.addArguments("--headless=new");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String usernme,String password)
    {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(usernme);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        System.out.println("Test executed with "+ usernme+"/"+password);
    }

    @DataProvider(name= "loginData")
    public Object[][] getData()
    {
     return new Object[][]
             {
                     {"standard_user","secret_sauce"},
                     {"problem_user", "secret_sauce"},
                     {"locked_out_user", "secret_sauce"},
             };
    }




    @AfterTest
    public void teardown()
    {
        driver.quit();
    }

}
