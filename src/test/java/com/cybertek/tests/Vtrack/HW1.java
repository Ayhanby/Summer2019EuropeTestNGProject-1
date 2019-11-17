package com.cybertek.tests.Vtrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW1 {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/user/login");

        WebElement username=driver.findElement(By.id("prependedInput"));
        username.sendKeys("user1");

        WebElement password=driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");

        WebElement loginButton=driver.findElement(By.id("_submit"));
        loginButton.click();

        String expectedUrl="https://qa1.vytrack.com/";
        String actualUrl=driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
        }

        driver.quit();



    }
}
