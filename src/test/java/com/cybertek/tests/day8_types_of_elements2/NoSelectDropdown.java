package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement=driver.findElement(By.id("dropdownMenuLink"));

        //Select links =new Select(dropdownElement);
        // When we try to select dropdown which doesnt have select tag
        //it gives enexpectedtag error

        //open the dropdown
        dropdownElement.click();

       List<WebElement> listoflinks =driver.findElements(By.className("dropdown-item"));

        System.out.println("Number of links = " + listoflinks.size());

        // print text of each link
        for (WebElement option : listoflinks) { //iter+enter
            System.out.println(option.getText());

             }
        //print text of each link
        System.out.println(listoflinks.get(0).getText());

        // locate the element and clicking it
        //index of the list and click
        listoflinks.get(3).click();


    }
}
