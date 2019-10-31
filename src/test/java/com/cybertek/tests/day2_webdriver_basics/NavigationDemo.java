package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static  void main (String [] args) throws InterruptedException { //psvm shortcut

        //setting up the

        WebDriverManager.chromedriver().setup();
        // import class CMD+Enter or alt+enter or control+ space
        // selenium object
        WebDriver driver =new ChromeDriver();

        // navigate to website
        driver.get("https://www.google.com");

        driver.navigate().to("https://www.facebook.com");
        //goes back to previous webpage
        driver.navigate().back();

       // Thread.sleep(3000); // stops your code
        //goes forward after goes back
        driver.navigate().forward();
        // refresh the page
        driver.navigate().refresh();



    }
}
