package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod

    public void tearDownMethod() {

        // driver.quit();

    }

    @Test
    public void switchWindowsTest() {
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("After clicking the link  = " + driver.getTitle());
        // code for switching windows, we have to pass handle
        // driver.switchTo().window()

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("currentWindowHandle = " + currentWindowHandle);

        // Set is just like arraylist but without duplicate values
        Set<String> windowHandles = driver.getWindowHandles();
        // how many different handles it is keeping
        System.out.println(windowHandles.size());

        // our problem is how can we get new window handle from set of handles.
        // there is no index
        for (String handle : windowHandles) {
            if (!currentWindowHandle.equals(handle)) {
                driver.switchTo().window(handle);
            }

        }
        System.out.println("After Switching = " + driver.getTitle());


    }

    @Test

    public void moreThan2Windows() {

        driver.get("http://practice.cybertekschool.com/windows");

        String targetWindowTitle = "New Window";

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getWindowHandles().size());
        Set<String> windowHandles = driver.getWindowHandles();
        // we will keep switching windows until our title equals to targetWindowsTitle

        for (String handle : windowHandles) {

            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetWindowTitle)) {

                break;
            }
        }

        System.out.println("After loop title is = " + driver.getTitle());
    }

}
