import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class HomePage {

    protected static ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
        driver.get("https://www.worldmarket.com/");
    }

    @Test(priority = 1)
    public void VerifyTheTitleIsCorrect() {
        String expectedResult = "Furniture, Home Decor, Rugs, Unique Gifts | World Market";
        String ActualResult = driver.getTitle();
        System.out.println("The title is " + ActualResult);
        Assert.assertEquals(ActualResult, expectedResult);
    }

    @Test(priority = 2)
    public void ClickOnCancelButton(){
        WebElement Cancel = FilePOM.Button_Is_Cancel();
        Cancel.click();

    }


    @Test(priority = 5)
   public void checkTheSearchIsFunctionality() {
        WebElement search = FilePOM.Search();
        search.sendKeys("Gifts");

        WebElement clickButton = FilePOM.ClickOnButtonSearch();
        Assert.assertTrue(clickButton.isDisplayed());
        clickButton.click();
    }


    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
