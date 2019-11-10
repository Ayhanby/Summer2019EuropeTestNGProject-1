package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.get("http://amazon.com");
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("selenium");
        Thread.sleep(1000);

        WebElement clickButton=driver.findElement(By.xpath("//*[@value='Go']"));
        clickButton.click();

        WebElement text=driver.findElement(By.xpath("//span[contains(text(),'results')]"));
        String printtext=text.getText();
        System.out.println(printtext);


        //WebElement homelink=driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
       // homelink.click();
        //WebElement button1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
       // button1.click();
      //  WebElement button1=driver.findElement(By.xpath("//*[@onclick='button1()']"));
        //button1.click();

    }
}
