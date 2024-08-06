package org.example.tests;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class screenshot {
    public static void main(String[] args) throws IOException {


// Instantiate chrome driver object
        WebDriver driver = new ChromeDriver();
// Navigate to the testim website
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(), new File("C:\\Users\\HP\\OneDrive\\Desktop\\Screenshot\\image.jpg").toPath());
        System.out.println("Screenshot Taken");
        driver.close();
    }
}
