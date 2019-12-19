package com.cybertek.tests.Vtrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VyTrack_2 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Actions actions = new Actions(driver);
        WebElement activities = driver.findElement(By.xpath("(//*[contains (text(), '  Activities')])[1]"));
        //  System.out.println(" = " + activities.getText());
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(activities));
        actions.moveToElement(activities).perform();
        WebElement calendarEv = driver.findElement(By.xpath("//*[text()='Calendar Events']"));
        // System.out.println(calendarEv.getText());
        wait.until(ExpectedConditions.visibilityOf(calendarEv));
        actions.moveToElement(calendarEv).click().perform();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        //driver.quit();
    }

    @Test

    public void Test1() throws InterruptedException {

        //calendarEv.click();

        WebElement options = driver.findElement(By.xpath("//*[@*='btn btn-link dropdown-toggle'] "));

        System.out.println(options.getText());
        Assert.assertTrue(options.isDisplayed());

    }

    @Test
    public void Test2() {

        WebElement one = driver.findElement(By.xpath("//input[@value='1']"));
        System.out.println("page number is: " + one.getAttribute("value"));

        // WebDriverWait wait= new WebDriverWait(driver,15);
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='1']"))));
        // WebElement pageNumber=driver.findElement(By.xpath("//input[@value='1']"));
        //  String actualPagenumber= pageNumber.getAttribute("value");
        //  System.out.println(actualPagenumber);
        Assert.assertEquals(one.getAttribute("value"), "1", "Verify that page number is equals to '1'");


    }

    @Test
    public void Test3() throws InterruptedException {

        WebElement number25 = driver.findElement(By.xpath("//*[@*='btn dropdown-toggle ']"));
        System.out.println("number is: " + number25.getText());
        Thread.sleep(5000);
        Assert.assertEquals(number25.getText(), "25", "Verify that page number is equals to '25'");


    }
    @Test
    public void Test4() throws InterruptedException {

        List<WebElement> allRows = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));

        int rowNumber=allRows.size();
        System.out.println("allRows number = " + rowNumber);
        Thread.sleep(5000);
        WebElement records= driver.findElement(By.xpath("//*[@*='dib'][3]"));
        String numberOfRecords= records.getText();

        String actual="Total Of "+ rowNumber +" Records";
        Assert.assertEquals(actual, numberOfRecords, "Verify that the message is 'Total Of 24 Records'");

    }
    @Test
    public void Test5() throws InterruptedException {

        // 5.Verify that all calendar events were selected
        WebElement checkbox=driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
        Thread.sleep(5000);
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected(),"Verify that all calendar events were selected");
    }
    @Test
    public void TestCase_6() throws InterruptedException {
        // 4.Select "Testers meeting"
        // 5.Verify that following data is displayed:
        for (int i = 1; i < 25; i++) {
            WebElement Cell = driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[" + i + "]/td[2]"));
            System.out.println("Cell = " + Cell.getText());
            if (Cell.getText().equals("Testers Meeting")) {
                WebElement newCell = driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[" + i + "]/td[2]"));
                Thread.sleep(5000);
                newCell.click();
                break;
            }
        }
        Thread.sleep(3000);
        for (int i = 1; i < 10; i++) {
            String xpath = "(//div[@class='control-group attribute-row'])[" + i + "]/div/div";
            WebElement Value = driver.findElement(By.xpath(xpath));
            if (Value.isDisplayed() == true) {
                System.out.println(Value + " " + i + " value is displayed");
            } else {
                System.out.println(Value + " " + i + " value is NOT displayed");
            }
        }
    }

}
