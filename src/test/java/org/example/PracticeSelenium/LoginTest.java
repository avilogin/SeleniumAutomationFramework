package org.example.PracticeSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class LoginTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "excelData")
    public void loginTest(String username, String password) {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        System.out.println("Login tried with: " + username + " | " + password);
    }

    @DataProvider(name = "excelData")
    public Object[][] getData() {
        String excelPath = System.getProperty("user.dir") + "/src/test/java/org/example/testdata/LoginData.xlsx";
        //System.out.println(excelPath);
        return ExcelUtils.getExcelData(excelPath, "Sheet1");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
