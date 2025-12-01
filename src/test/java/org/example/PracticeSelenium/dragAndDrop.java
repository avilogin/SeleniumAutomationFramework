package org.example.PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v121.domsnapshot.model.StringIndex;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class dragAndDrop {

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

    @Test(enabled = false)
    public void simpleOne()  {
        String url = "https://jqueryui.com/droppable/";
        driver.get(url);

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);

        WebElement src = driver.findElement(By.xpath("//div[@id= 'draggable']"));
        WebElement des = driver.findElement(By.xpath("//div[@id= 'droppable']"));

        Actions ac = new Actions(driver);
        ac.dragAndDrop(src,des).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By text = By.xpath("//div[@id='droppable']/child::p");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(text,"Dropped!"));

        System.out.println(driver.findElement(text).getText());

        driver.switchTo().defaultContent();

    }

    @Test
    public void html5DragAndDrop()
    {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script = "function createEvent(typeOfEvent) {\r\n" +
                "   var event = document.createEvent(\"CustomEvent\");\r\n" +
                "   event.initCustomEvent(typeOfEvent, true, true, null);\r\n" +
                "   event.dataTransfer = {\r\n" +
                "       data: {},\r\n" +
                "       setData: function (key, value) {\r\n" +
                "           this.data[key] = value;\r\n" +
                "       },\r\n" +
                "       getData: function (key) {\r\n" +
                "           return this.data[key];\r\n" +
                "       }\r\n" +
                "   };\r\n" +
                "   return event;\r\n" +
                "}\r\n" +
                "\r\n" +
                "function dispatchEvent(element, event, transferData) {\r\n" +
                "   if (transferData) {\r\n" +
                "       event.dataTransfer = transferData;\r\n" +
                "   }\r\n" +
                "   if (element.dispatchEvent) {\r\n" +
                "       element.dispatchEvent(event);\r\n" +
                "   } else if (element.fireEvent) {\r\n" +
                "       element.fireEvent(\"on\" + event.type, event);\r\n" +
                "   }\r\n" +
                "}\r\n" +
                "\r\n" +
                "function simulateHTML5DragAndDrop(element, destination) {\r\n" +
                "   var dragStartEvent = createEvent('dragstart');\r\n" +
                "   dispatchEvent(element, dragStartEvent);\r\n" +
                "\r\n" +
                "   var dropEvent = createEvent('drop');\r\n" +
                "   dispatchEvent(destination, dropEvent, dragStartEvent.dataTransfer);\r\n" +
                "\r\n" +
                "   var dragEndEvent = createEvent('dragend');\r\n" +
                "   dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);\r\n" +
                "}\r\n" +
                "\r\n" +
                "simulateHTML5DragAndDrop(arguments[0], arguments[1]);";

        js.executeScript(script, columnA, columnB);
    }


    @AfterTest
    public void teardown()
    {
        driver.quit();
    }

}
