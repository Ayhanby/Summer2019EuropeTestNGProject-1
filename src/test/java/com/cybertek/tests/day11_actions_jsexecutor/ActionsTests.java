package com.cybertek.tests.day11_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        // Actions--> class that contains all the user interations
        // how to create actions objects/ passing driver as a constructor

        Actions actions= new Actions(driver);

        WebElement img = driver.findElement(By.tagName("img"));

        // perform()--> perform the action.complete the action
        // moveToElement()--> move youor mouse to webelement(hoverover)
        actions.moveToElement(img).perform();

        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed(),"verify view profile displayed");
    }

    @Test
    public void DragAndDrop(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions= new Actions(driver);

        WebElement source =driver.findElement(By.id("draggable"));
        WebElement target =driver.findElement(By.id("droptarget"));
        // pause()--> wait just like thread.sleep

        actions.pause(3000);
        // we have to provide source and target to this method it will drag and drop
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        actions.dragAndDrop(source,target).perform();

    }
    @Test
    public void DragAndDropChaining(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions= new Actions(driver);

        WebElement source =driver.findElement(By.id("draggable"));
        WebElement target =driver.findElement(By.id("droptarget"));
        // pause()--> wait just like thread.sleep

        actions.pause(3000);
        // we have to provide source and target to this method it will drag and drop
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        // if you are chaining actions we add build() method before perform
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();



    }
}
