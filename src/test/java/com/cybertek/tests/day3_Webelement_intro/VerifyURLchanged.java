package com.cybertek.tests.day3_Webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLchanged {
    /**
     * open browser
     * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
     * enter any email
     * click on Retrieve password
     * verify that url changed to http://practice.cybertekschool.com/email_sent
     */

    public static void main(String[] args) {
        //open chrome
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        // go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password ");

        //enter any email
        WebElement emailInput=driver.findElement(By.name("email"));

        //sendKeys()--> send keyboard actions to webelement / enters given text

        emailInput.sendKeys("email@gmail.com");
        //click on Retrieve password
        WebElement retrievePasswordButton =driver.findElement(By.id("form_submit"));
        //click()--> clicking the web element
        retrievePasswordButton.click();

        String expectedUrl="http://practice.cybertekschool.com/email_sent";

        String actualUrl=driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualUrl = "+actualUrl);
            System.out.println("expectedUrl= "+expectedUrl);

        }

        // close
        driver.quit();


    }
}
