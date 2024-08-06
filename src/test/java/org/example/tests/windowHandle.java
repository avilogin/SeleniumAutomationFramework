package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class windowHandle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println(mainWindowHandle);
        WebElement link = driver.findElement(By.linkText("Click Here"));

        // Click the link to open a new window
        link.click();

        // Store the handles of all open windows in a list
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles)
        {
            driver.switchTo().window(handle);

            // Check if the text "New Window" is present in the window
            if (driver.getPageSource().contains("New Window")) {
                System.out.println("The text 'New Window' was found in the new window.");
                break;
            }

        }
        driver.switchTo().window(mainWindowHandle);

        // Close the web driver
        driver.quit();


    }
}
