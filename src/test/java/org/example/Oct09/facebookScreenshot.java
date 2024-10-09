package org.example.Oct09;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class facebookScreenshot {
    public static WebDriver driver;
    public static void main(String[] args) throws IOException {
        driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(),new File("D:\\Documents for Study\\Automation class\\Screenshot\\fb.jpg").toPath());

        System.out.println("Screenshot Taken");
        driver.quit();


    }
}
