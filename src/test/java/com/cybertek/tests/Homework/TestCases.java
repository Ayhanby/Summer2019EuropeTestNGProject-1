package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases {

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
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Registration Form']")).click();
        driver.findElement(By.xpath("//*[@*='MM/DD/YYYY']")).sendKeys("wrong_dob");
        WebElement actualMessage = driver.findElement(By.xpath("//*[text()='The date of birth is not valid']"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "The date of birth is not valid";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:“The date of birth is not valid”");
    }

    @Test
    public void test2() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Registration Form']")).click();
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@*='inlineCheckbox1'][2]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@*='inlineCheckbox2'][2]"));
        WebElement checkbox3 = driver.findElement(By.xpath("//*[@*='inlineCheckbox3'][2]"));

        System.out.println("checkbox3 = " + checkbox3.getText());
        System.out.println("checkbox2 = " + checkbox2.getText());
        System.out.println("checkbox1 = " + checkbox1.getText());

        Assert.assertTrue(checkbox1.isDisplayed());
        Assert.assertTrue(checkbox2.isDisplayed());
        Assert.assertTrue(checkbox3.isDisplayed());

    }

    @Test
    public void test3() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Registration Form']")).click();
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("w");
        WebElement actualMessage = driver.findElement(By.xpath("//*[text()='first name must be more than 2 and less than 64 characters long']"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:“first name must be more than 2 and less than 64 characters long”");
    }

    @Test
    public void test4() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Registration Form']")).click();
        driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("E");
        WebElement actualMessage = driver.findElement(By.xpath("//*[text()='The last name must be more than 2 and less than 64 characters long']"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:“The last name must be more than 2 and less than 64 characters long”");
    }

    @Test
    public void test5() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Registration Form']")).click();
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("John");
        driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("Wick");
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Jwick1");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("jwick1@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("555-555-5555");
        driver.findElement(By.xpath("//*[@value='male']")).click();
        driver.findElement(By.xpath("//*[@*='MM/DD/YYYY']")).sendKeys("11/11/2011");

        WebElement dropdownElement = driver.findElement(By.xpath("//*[@name='department']"));
        dropdownElement.click();
        driver.findElement(By.xpath(" //*[@value='DE']")).click();

        WebElement dropdownElement2 = driver.findElement(By.xpath(" //*[@name='job_title']"));
        dropdownElement2.click();
        driver.findElement(By.xpath("//*[text()='SDET']")).click();
        driver.findElement(By.cssSelector("#inlineCheckbox2")).click();
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        WebElement actualMessage = driver.findElement(By.xpath("//*[contains(text(),'egistration!')]"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "You've successfully completed registration!";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:“You've successfully completed registration!”");

    }

    @Test
    public void test6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com");
        driver.findElement(By.xpath("(//*[@title='Copy this email address'])[1]")).click();
        WebElement tempemail = driver.findElement(By.xpath("//*[@class='animace']"));
        String savetempemail = tempemail.getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Sign Up For Mailing List']")).click();
        driver.findElement(By.xpath("//*[@name='full_name']")).sendKeys("John Wick");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(savetempemail);
        driver.findElement(By.xpath("//*[@name='wooden_spoon']")).click();

        WebElement actualMessage = driver.findElement(By.xpath("//*[@name='signup_message']"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:Thank you for signing up. Click the button below to return to the home page.");
        driver.get("https://www.tempmailaddress.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/table/tbody/tr[3]/td[1]")).click();

        WebElement actualMessage2 = driver.findElement(By.cssSelector("#predmet"));
         System.out.println(actualMessage2.getText());
        String expectedMessage2 = "Thanks for subscribing to practice.cybertekschool.com!";

        Assert.assertEquals(actualMessage2.getText(), expectedMessage2, "Verify that warning message is displayed:Thanks for subscribing to practice.cybertekschool.com!");
    }

    @Test
    public void test7() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='File Upload']")).click();
        WebElement uploadfile = driver.findElement(By.xpath(" //*[@name='file']"));
        uploadfile.sendKeys("C:/Users/DELL_PC/Desktop/testcase7.txt");
        driver.findElement(By.cssSelector("#file-submit")).click();

        WebElement actualMessage = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "File Uploaded!";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:File Uploaded!");


    }

    @Test
    public void test8() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Autocomplete']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//*[@*='btn btn-primary']")).click();

        WebElement actualMessage = driver.findElement(By.cssSelector("#result"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "You selected: United States of America";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:You selected: United States of America");
    }

    @Test
    public void test9() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//*[text()='200']")).click();

        WebElement actualMessage = driver.findElement(By.xpath("//*[contains(text(),'This page returned a 200 status code.')]"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "This page returned a 200 status code.";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:This page returned a 200 status code.");

    }

    @Test
    public void test10() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//*[text()='301']")).click();

        WebElement actualMessage = driver.findElement(By.xpath("//*[contains(text(),'This page returned a 301 status code.')]"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "This page returned a 301 status code.";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:This page returned a 301 status code.");

    }
    @Test
    public void test11() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//*[text()='404']")).click();

        WebElement actualMessage = driver.findElement(By.xpath("//*[contains(text(),'This page returned a 404 status code.')]"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "This page returned a 404 status code.";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:This page returned a 404 status code.");

    }
    @Test
    public void test12() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//*[text()='500']")).click();

        WebElement actualMessage = driver.findElement(By.xpath("//*[contains(text(),'This page returned a 500 status code.')]"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "This page returned a 500 status code.";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:This page returned a 500 status code.");

    }




}


