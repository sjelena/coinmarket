package FEtask;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;

public class Test3 extends Driver {

    @Test
    public void Test3() throws InterruptedException {
        setDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        // open menu
        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/div/div[1]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(menu);
        action.perform();
        Thread.sleep(2000);

        // click on spotlight
        WebElement spotlightButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/div/div[1]/div/a[4]/img"));
        spotlightButton.click();

        // record the data
        List <WebElement> mostVisitedData = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[4]/div[2]/table/tbody/tr/td[2]/a/div/div/p"));
        executor.executeScript("window.scrollBy(0, 150)");
        executor.executeScript("window.scrollBy(0, 300)");
        List<String> list = new ArrayList<>();

        for (int i=0; i<mostVisitedData.size(); i++) {
            String elements = mostVisitedData.get(i).getText();
            list.add(elements);
        }

        // open most visited link
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        WebElement seeMoreMostVisited = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[4]/div[1]/a"));
        seeMoreMostVisited.sendKeys(selectLinkOpeninNewTab);

        switchToNewWindow();
        List <WebElement> mostVisitedNewTab = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[2]/table/tbody/tr[position()<=10]/td[3]/a/div/div/p"));
        List<String> listNewTab = new ArrayList<>();

        for (int i=0; i<mostVisitedNewTab.size(); i++) {
            String elementsNewTab = mostVisitedNewTab.get(i).getText();
            listNewTab.add(elementsNewTab);
        }
        Assert.assertEquals(list, listNewTab);

        closeDriver();
    }
}