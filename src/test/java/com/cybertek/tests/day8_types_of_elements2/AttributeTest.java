package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
       //driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton =driver.findElement(By.id("blue"));
        System.out.println(radioButton.getAttribute("name"));
        System.out.println(radioButton.getAttribute("id"));
        System.out.println(radioButton.getAttribute("type"));

        //tring to get attribute does not exist
        //When we use non exist attribute it will return null to us.
        System.out.println(radioButton.getAttribute("href"));

        //attribute without value(checked)
        //checked atribute value is boolean if it is checked it will be true
        System.out.println(radioButton.getAttribute("checked"));

        System.out.println(radioButton.getAttribute("outerHTML"));

        //3rd way of getting text "innerHTML"(certain cases)
        System.out.println(radioButton.getAttribute("innerHTML"));



    }
}
