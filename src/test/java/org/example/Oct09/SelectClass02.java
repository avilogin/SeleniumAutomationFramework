package org.example.Oct09;

import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectClass02 {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException, IOException {
        String currency_want = "US Dollar";
        String country_want ="IND";
        String language_want = "English";
        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Closing Popup
        try {
            WebElement popup = driver.findElement(By.xpath("//span[@class = 'commonModal__close']"));//closing the popup
            popup.click();
        }
        catch (Exception e)
        {
            System.out.println("Popup not found or already closed");
        }
//Selecting From City
        WebElement from_city = driver.findElement(By.id("fromCity"));
        from_city.click();

        WebElement select_city = driver.findElement(By.xpath("//input[@placeholder = 'From']"));
        select_city.clear();
        select_city.sendKeys("Chennai");
        List<WebElement> city_list = driver.findElements(By.xpath("//ul[@role='listbox']/li/div[contains(@class, 'makeFlex')]"));
        Actions act =  new Actions(driver);

        for (WebElement city :city_list)
        {
            if (city.getText().contains("Chennai"))
            {
                act.moveToElement(city).perform();
                Thread.sleep(3000);
                act.click(city).perform();
                break;
            }
        }

//       WebElement click_city = driver.findElement(By.xpath("//li[@id = 'react-autowhatever-1-section-0-item-0']"));
//        Actions act =  new Actions(driver);
//        act.moveToElement(click_city).click();



        /*


// select region and language
        WebElement region = driver.findElement(By.xpath("(//span[@class = 'style__LocaleSettingsSelectorText-sc-1sh96gm-1 kbXnxm'])[1]"));
        region.click();
        WebElement region_click = driver.findElement(By.xpath("//div[@data-cy = 'country-dropdown']"));
        region_click.click();
        List<WebElement> country_list = driver.findElements(By.xpath("//div[@data-cy = 'country-dropdown']/div[2]/child::p/span/span"));
        for (WebElement country:country_list)
        {

            if (country.getText().equalsIgnoreCase(country_want))
            {
                country.click();
                break;
            }
        }

        WebElement language_click = driver.findElement(By.xpath("//div[@data-cy = 'language-dropdown']"));
        language_click.click();
        List<WebElement> sel_language = driver.findElements(By.xpath("//div[@data-cy = 'language-dropdown']/div[2]/p/span"));
        for (WebElement language : sel_language)
        {
            if (language.getText().equalsIgnoreCase(language_want))
            {
                language.click();
                break;
            }
        }

        //click Apply Button
        WebElement apply_btn = driver.findElement(By.xpath("//button[@data-cy = 'country-lang-submit']"));
        apply_btn.click();

        //Select Currency
        WebElement currency = driver.findElement(By.xpath("(//span[@class = 'style__LocaleSettingsSelectorText-sc-1sh96gm-1 kbXnxm'])[2]"));
        currency.click();

        List<WebElement> curr_list = driver.findElements(By.xpath("//span[contains(@class, 'styles__CurrencyName-sc-1ybcz2e-9 jQRMDS')]"));

        for (WebElement curr : curr_list)
        {
            if (curr.getText().equalsIgnoreCase(currency_want))
            {
                curr.click();
                break;
            }
        }

        //Taking Screenshot
        try {
            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(f.toPath(), new File("D:\\Documents for Study\\Automation class\\Screenshot\\makeMyTrip01.jpg").toPath());
        }
        catch (IOException e)
        {
            System.out.println("Screenshot Failed : "+e.getMessage());
        }

*/

       Thread.sleep(5000);
       driver.quit();



    }
}
