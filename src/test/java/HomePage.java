import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {

    @Test(priority = 1)
    public void VerifyTheTitleIsCorrect() {
        String expectedResult = "Furniture, Home Decor, Rugs, Unique Gifts | World Market";
        String ActualResult = SetUp.driver.getTitle();
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
        String currentExpectedUrl = "https://www.worldmarket.com/search.do?pageName=&keyword=Gifts";

        WebElement search = FilePOM.Search();
        search.sendKeys("Gifts");

        WebElement clickButton = FilePOM.ClickOnButtonSearch();
        Assert.assertTrue(clickButton.isDisplayed());
        clickButton.click();
        SetUp.driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        String currentUrl = SetUp.driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertEquals(currentExpectedUrl,currentUrl);

    }


    @AfterClass
    void tearDown() {
        SetUp.driver.quit();
    }

}