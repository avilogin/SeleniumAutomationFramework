package org.example.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class screenshot2 {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
// Navigate to the testim website
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        File ff = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Files.copy(ff.toPath(), new File("C:\\Users\\HP\\OneDrive\\Desktop\\Screenshot\\img.jpg").toPath());
        System.out.println("SS taken");
        driver.close();


    }
}
