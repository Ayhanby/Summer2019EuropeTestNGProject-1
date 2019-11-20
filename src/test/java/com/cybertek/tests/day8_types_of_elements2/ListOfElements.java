package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons=driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());

        //verify that you got 6 webelement

        Assert.assertEquals(buttons.size(),6,"verify that you got 6 webelement");

        //iter+space -- shortcut
        for (WebElement button : buttons) {
            System.out.println(button.getText());
        }
        //itar+space--shortcut
       // for (int i = 0; i < array.length; i++) {
            // = array[i];

        //}

    }

    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //wrong locator but we are not getting any error, we are getting empty list
        List<WebElement> buttons=driver.findElements(By.tagName("buttonfgfg"));
        System.out.println("buttons.size() = " + buttons.size());

    }

}
