import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilePOM {

    static public WebElement Button_Is_Cancel(){
        return HomePage.driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
    }
    static  public WebElement Search(){
        return HomePage.driver.findElement(By.name("keyword"));
    }
    static  public WebElement ClickOnButtonSearch(){
        return HomePage.driver.findElement(By.xpath("//*[@id=\"searchBtn\"]"));
    }
    static public  WebElement ClickOnButtonSigIn(){
        return  HomePage.driver.findElement(By.id("ml-topnav-identity-link"));
    }
    static public  WebElement ClickOnButtonCreateAccount(){
        return  HomePage.driver.findElement(By.xpath("//*[@id=\"loggedin_panel\"]/div/div/div[2]/button[2]"));
    }


}
