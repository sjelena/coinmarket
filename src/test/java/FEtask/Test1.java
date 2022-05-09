package FEtask;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 {

    @Test
    public void test1 (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\QH User\\Downloads\\serenity-rest-starter-master\\serenity-rest-starter-master\\src\\test\\resources\\driver\\windows\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://coinmarketcap.com/nft/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[4]/p/span/a[1]/button"));
        Actions action = new Actions(driver);
        action.moveToElement(button).click();
    }
}
