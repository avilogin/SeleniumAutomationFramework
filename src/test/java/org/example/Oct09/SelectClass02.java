package org.example.Oct09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectClass02 {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        String currency_want = "Kuwaiti Dinar";
        String country_want ="UAE";
        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement popup = driver.findElement(By.xpath("//span[@class = 'commonModal__close']"));//closing the popup
        popup.click();
//        WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class = 'style__LocaleSettingsSelectorText-sc-1sh96gm-1 kbXnxm'])[2]")));


        //Need to update the codes

        WebElement region = driver.findElement(By.xpath("(//span[@class = 'style__LocaleSettingsSelectorText-sc-1sh96gm-1 kbXnxm'])[1]"));
        region.click();

        List<WebElement> country_list = driver.findElements(By.xpath("//div[@data-cy = 'country-dropdown']/div[2]/child::p/span/span"));
        for (WebElement country:country_list)
        {
            if (country.getText().equalsIgnoreCase(country_want))
            {
                country.click();
            }
        }

//        WebElement sel_country = driver.findElement(By.xpath("//div[@data-cy = 'country-dropdown']"));
//        sel_country.click();

        List<WebElement> sel_language = driver.findElements(By.xpath("//div[@data-cy = 'language-dropdown']/div[2]/p/span"));
        for (WebElement language : sel_language)
        {
            System.out.println(language.getText());
        }

//-----------------------------------------------------------------------

        WebElement currency = driver.findElement(By.xpath("(//span[@class = 'style__LocaleSettingsSelectorText-sc-1sh96gm-1 kbXnxm'])[2]"));
        currency.click();

        List<WebElement> list_curr = driver.findElements(By.xpath("//span[contains(@class, 'styles__CurrencyName-sc-1ybcz2e-9 jQRMDS')]"));
        for (WebElement curr : list_curr)
        {
            if (curr.getText().equalsIgnoreCase(currency_want));
            {
                curr.click();
            }
        }



       Thread.sleep(5000);
       driver.quit();

    }
}
