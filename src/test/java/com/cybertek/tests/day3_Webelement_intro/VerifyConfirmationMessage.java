package com.cybertek.tests.day3_Webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Verify confirmation message
 * open browser
 * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
 * enter any email
 * verify that email is displayed in the input box
 * click on Retrieve password
 * verify that confirmation message says ‘Your e-mail’s been sent!’
 */


public class VerifyConfirmationMessage {
    public static void main(String[] args) {
        // open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //enter any email
        WebElement emailInputbox=driver.findElement(By.name("email"));
        String expectedEmail="test@gmail.com";
        //send expectedEmail
        emailInputbox.sendKeys(expectedEmail);
        //verify that email is displayed in the input box
        // getting text from webElement
        //getText()--> get txt from web element %99
        // getAttribute("value")--> get value of attributes

        String actualEmail=emailInputbox.getAttribute("value");
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualEmail = "+actualEmail);
            System.out.println("expectedEmail= "+expectedEmail);

        }

        //click on Retrieve password
        WebElement retrievePasswordButton =driver.findElement(By.id("form_submit"));
        //click()--> clicking the web element
        retrievePasswordButton.click();

        //verify that confirmation message says ‘Your e-mail’s been sent!’
        String expectedMessage="Your e-mail's been sent!";

       WebElement messageElement=driver.findElement(By.name("confirmation_message") );
        String actualMessage=messageElement.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualMessage = "+actualMessage);
            System.out.println("expectedMessage= "+expectedMessage);
        }

        // close the browser
        driver.quit();



    }
}
