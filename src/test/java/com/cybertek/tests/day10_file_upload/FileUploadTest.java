package com.cybertek.tests.day10_file_upload;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    /**
     *  go to website http://practice.cybertekschool.com/upload
     *  upload file.txt
     *  click upload
     *  verify file name is displayed in the next page
     */

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/upload");
        driver.findElement(By.name("file")).sendKeys("C:/Users/DELL_PC/Desktop/file.txt");
        driver.findElement(By.cssSelector("#file-submit")).click();

        WebElement actualMessage = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        System.out.println(actualMessage.getText());
        String expectedMessage = "File Uploaded!";

        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Verify that warning message is displayed:File Uploaded!");
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";
        String filePath = projectPath+"/"+relativePath;
        driver.findElement(By.name("file")).sendKeys(filePath);
        //clicking the upload button
        driver.findElement(By.id("file-submit")).click();
        //getting text of webelement
        String actualFilename = driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is displayed in the next page
        Assert.assertEquals(actualFilename,"testfile.txt","Verify the file name");
    }
}
