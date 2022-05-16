package BEtask.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;
    String URL = "https://www.coinmarketcap.com/";

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\QH User\\Downloads\\serenity-rest-starter-master\\serenity-rest-starter-master\\src\\test\\resources\\driver\\windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } catch (Exception e){
            System.out.println("Website was not reached.");
        }
    }
    public void closeDriver() {
        driver.quit();
    }
    public void back() {
        driver.navigate().back();
    }
    public void switchToNewWindow() {
        driver.switchTo().window(driver.getWindowHandles().stream().reduce((f, s) -> s).orElse(null));
    }
}
