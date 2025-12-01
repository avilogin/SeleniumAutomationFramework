package org.example.PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class waits003 {
    WebDriver driver;
    //ChromeOptions options;

    @BeforeTest
    public void init_Browser() {
        //options = new ChromeOptions();
        //options.addArguments("--headless=new");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test(enabled = false)
    public void test3() {
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);
        By link = By.xpath("//a[contains(text(),'Dynamic Controls')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(link));

        driver.findElement(link).click();
        driver.findElement(By.xpath("//button[normalize-space()='Remove']")).click();

        By addBtn = By.xpath("//button[normalize-space()='Add']");

        wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        driver.findElement(addBtn).click();

        By backMsg = By.xpath("//p[@id='message']");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(backMsg, "It's back!"));

        String message = driver.findElement(backMsg).getText();

        System.out.println("Mesage Returned : " + message);

    }

    @Test
    public void xpathXpressions() {
        String url = "https://testpages.eviltester.com/";
        driver.get(url);
        driver.findElement(By.xpath("//a[@id='m-pages']")).click();
        driver.findElement(By.xpath("//a[@id = 'm-pagesforms']")).click();
        driver.findElement(By.xpath("//a[@id = 'm-pagesformstext-inputs']")).click();

        // Multiple attributes
        driver.findElement(By.xpath("//input[@type = 'text' and @id = 'text-input']")).sendKeys("Multi Attribute");

        //Using contains()
        driver.findElement(By.xpath("//input[contains(@type,'search')]")).sendKeys("Contains");

        //contains text
        String text1 = driver.findElement(By.xpath("//label[contains(text(),'Password')]")).getText();
        System.out.println(text1);

        //starts-with()
        driver.findElement(By.xpath("//input[starts-with(@id,'password')]")).sendKeys("Password");

        //ends-with()--does not support

        //or condition
        driver.findElement(By.xpath("//input[@id='url-input' or @type='url']")).sendKeys("URL");

        //windcard tag
        driver.findElement(By.xpath("//*[@id='tel-input']")).sendKeys("7682918898");

        //Using parent axis
        driver.findElement(By.xpath("//input[@id='text-input']/parent::div"));

        //child axis
        driver.findElement(By.xpath(" //div[@id='text-controls']/child::div/input[@id='text-input']")).sendKeys("child axis");

        //following-sibling
        String submit = driver.findElement(By.xpath("//input[@type='reset']/following-sibling::input")).getAttribute("value");
        System.out.println(submit);

        //preceding-sibling
        String label = driver.findElement(By.xpath("//input[@id='text-input']/preceding-sibling::label")).getText();
        System.out.println(label);

        /*
        12. ancestor
//button[text()='Save']/ancestor::form

13. descendant
//div[@id='container']/descendant::input[@type='text']

14. following
//h2[text()='Overview']/following::p[1]

15. preceding
//div[@class='footer']/preceding::h3[1]

16. self axis
//input[@name='email']/self::input

17. nth element
(//input[@type='text'])[3]

18. last element
(//div[@class='item'])[last()]

19. normalize-space()
//button[normalize-space(text())='Login']

20. position()
//ul/li[position()=2]

21. not()
//input[not(@disabled)]

22. Multiple dynamic conditions
//div[contains(@id,'error') or contains(@class,'danger')]

23. contains + starts-with
//input[contains(@name,'user') and starts-with(@id,'input')]

24. contains on normalized text
//p[contains(normalize-space(),'successfully')]

25. count()
//table[count(.//tr) > 5]

26. Specific index under parent
//div[@class='row']/div[2]/input

27. Sibling with partial text
//h3[contains(text(),'Order')]/following-sibling::button

28. Dynamic tag using name()
//*[name()='svg']

29. All ancestors
//input[@id='search']/ancestor::*

30. Grouped OR conditions
//a[@class='link' and (contains(@href,'product') or contains(@href,'item'))]
         */

    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}
