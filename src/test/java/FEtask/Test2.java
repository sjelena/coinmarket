package FEtask;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class Test2 extends Driver {
    @Test
    public void test2() throws InterruptedException {
        setDriver();
        int randomNum = (int) ((Math.random() * (10 - 5)) + 5);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        for (int i=0; i<randomNum; i++) {
            executor.executeScript("window.scrollBy(0, 500)");
            executor.executeScript("window.scrollBy(0, 1000)");
            executor.executeScript("window.scrollBy(0, 1500)");
            executor.executeScript("window.scrollBy(0, 2000)");
            executor.executeScript("window.scrollBy(0, 2500)");
            executor.executeScript("window.scrollBy(0, 3000)");

            List<WebElement> cryptocurrenciesList = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr/td[11]/div//child::button"));
            Random random = new Random();
            WebElement element = cryptocurrenciesList.get(random.nextInt(cryptocurrenciesList.size()));

            // clik on button
            executor.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", element);
            executor.executeScript("arguments[0].click();", element);

            // clik on View 7 days button
            WebElement buttonView7Days = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/a[3]/button"));
            executor.executeScript("arguments[0].click();", buttonView7Days);

            // click on date range button

            WebElement dateRangdeButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[1]/span/button"));
            executor.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", dateRangdeButton);
            Thread.sleep(5000);
            dateRangdeButton.click();

            // change date rang and display it
            WebElement daysButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[1]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]"));
            daysButton.click();
            WebElement continueButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[1]/span/button"));
            continueButton.click();

            back();
        }
        closeDriver();
    }
}
