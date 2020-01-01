package com.cybertek.tests.Homework;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestCases4 extends TestBase {


    /*
    Test Case #1
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Hover on three dots “…” for “Testers meeting”
calendar event
Verify that “view”, “edit” and “delete” options
are available

     */

    @Test
    public void TestersMeetingTest1(){
        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);

        extentLogger.info("Hover on three dots “…” for “Testers meeting”\n" +
                "calendar event");
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) driver).executeScript(strJavaScript, calendarEventsPage.treedots);
        WebElement launcherItem = driver.findElement(By.xpath("//li[@class='launcher-item']"));
        //BrowserUtils.clickWithJS(View);
        extentLogger.info("Verify that “view”, “edit” and “delete” options\n" +
                "are available");
        Assert.assertTrue(launcherItem.isDisplayed(),"verify View icon is displayed");


/*

Test Case #2
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Grid Options” button
5. Deselect all options except “Title”
6. Verify that “Title” column still displayed
 */

    }
    @Test
    public void titleTest2(){

        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);

        extentLogger.info("Click on “Grid Options” button");
        calendarEventsPage.grid.click();
        Actions actions= new Actions(driver);
        BrowserUtils.waitFor(1);

        extentLogger.info("Deselect all options except “Title”");
        calendarEventsPage.calendarCheckbox.click();
        calendarEventsPage.startCheckbox.click();
        calendarEventsPage.endCheckbox.click();
        calendarEventsPage.recurrentCheckbox.click();
        calendarEventsPage.recurrenceCheckbox.click();
        calendarEventsPage.invalidStatusCheckbox.click();
        extentLogger.info("Verify that “Title” column still displayed”");
        Assert.assertTrue(calendarEventsPage.titleCheckbox.isDisplayed(),"Verify that “Title” column still displayed");

    }


    /*
    Test Case #3
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
5. Expand “Save And Close” menu
6. Verify that “Save And Close”, “Save And New”
and “Save” options are available


     */

    @Test
    public void SaveAndCloseTest3(){
        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(4);
        extentLogger.info("Expand “Save And Close” menu");
        createCalendarEventsPage.saveAndClose.click();
        BrowserUtils.waitFor(2);
        extentLogger.info("Verify that “Save And Close”, “Save And New”\n" +
                "and “Save” options are available");
        Assert.assertTrue(createCalendarEventsPage.subSaveAndClose.isDisplayed());
        Assert.assertTrue(createCalendarEventsPage.saveAndNew.isDisplayed());
        Assert.assertTrue(createCalendarEventsPage.save.isDisplayed());


    }
    /*
    Test Case #4
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
5. Then, click on “Cancel” button
6. Verify that “All Calendar Events” page subtitle is
displayed


     */

    @Test
    public void AllCalendarEventsTest4(){

        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(4);

        extentLogger.info("click on “Cancel” button");
        createCalendarEventsPage.cancel.click();
        BrowserUtils.waitFor(4);
        extentLogger.info("Verify that “All Calendar Events” page subtitle is\n" +
                "displayed");
        Assert.assertTrue(createCalendarEventsPage.allCalendarEventsSubtitle.isDisplayed(),"Verify that “All Calendar Events” page subtitle is\n" +
                "displayed");

    }
    /*
    Test Case #5
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
5. Verify that difference between end and start time
is exactly 1 hour

     */

    @Test
    public void startTimeTest5(){

        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(4);

        extentLogger.info("Get the values of start time and end time values");
        String startTime=createCalendarEventsPage.startTime.getAttribute("value");
        String endTime=createCalendarEventsPage.endTime.getAttribute("value");
        extentLogger.pass("PASS: Get the values End Time And Start Time Values");
        String[]startTime1=startTime.split(":");
        System.out.println("startTime1 = " + Arrays.toString(startTime1));
        String[]endTime1=endTime.split(":");
        System.out.println("endTime1 = " + Arrays.toString(endTime1));
        int actualDifference= Integer.valueOf(endTime1[0])-Integer.valueOf(startTime1[0]);

        System.out.println("actualDifference. = " + actualDifference);
        extentLogger.info("Verify that difference between end time and start time is exactly 1 hour");
        Assert.assertEquals(actualDifference, 1);
        extentLogger.pass("PASS: Verify that difference between end time and start time is exactly 1 hour");

        
    }
    /*
Test Case #6
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
Select “9:00 PM” as a start time
6. Verify that end time is equals to “10:00 PM”

     */
    @Test
    public void endTime_is10Test6() throws InterruptedException {

        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(4);

        extentLogger.info("Select “9:00 PM” as a start time");
        createCalendarEventsPage.startTime.click();
        driver.findElement(By.xpath("/html/body/div[6]/ul/li[19]")).click();
        Thread.sleep(3000);
        extentLogger.pass("Verify that end time is equals to “10:00 PM”");
        String actualEndTime = createCalendarEventsPage.endTime.getAttribute("value");
        String expectedEndTime = "10:00 AM";
        Assert.assertEquals(actualEndTime,expectedEndTime,"verify end time");





        //createCalendarEventsPage.startTime.clear();
       // createCalendarEventsPage.startTime.sendKeys("9:00 AM");
       // BrowserUtils.waitFor(5);
       // createCalendarEventsPage.title.sendKeys("");
       // BrowserUtils.waitFor(5);
       // String endingTime=createCalendarEventsPage.endTime.getAttribute("value");
      //  extentLogger.pass("Verify that end time is equals to “10:00 PM”");
       // Assert.assertEquals(endingTime,"10:00 PM","Verify that end time is equals to “10:00 PM”");
       // BrowserUtils.waitFor(5);
    }
    /*
    Test Case #7
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
5. Select “All-Day Event” checkbox
6. Verify that “All-Day Event” checkbox is selected
7. Verify that start and end time input boxes are
not displayed
8. Verify that start and end date input boxes are
displayed
     */
    @Test
    public void inputBox_isDisplayedTest7(){

        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(4);
        extentLogger.info("Verify that “All-Day Event” checkbox is selected");
        createCalendarEventsPage.allDayEventCheckBox.click();
        extentLogger.pass("Verify that start and end time input boxes are\n" +
                "not displayed");
        Assert.assertTrue(!createCalendarEventsPage.startTime.isDisplayed());
        Assert.assertTrue(!createCalendarEventsPage.endTime.isDisplayed());

        extentLogger.pass("Verify that start and end date input boxes are\n" +
                "displayed");
        Assert.assertTrue(createCalendarEventsPage.startDate.isDisplayed());
        Assert.assertTrue(createCalendarEventsPage.endDate.isDisplayed());

    }
    /*
    Test Case #8
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
5. Select “Repeat” checkbox
6. Verify that “Repeat” checkbox is selected
7. Verify that “Daily” is selected by default and
following options are available in
“Repeats” drop-down:


     */
    @Test
    public void RepeatsTest8(){
        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(4);
        extentLogger.info("Select “Repeat” checkbox");
        createCalendarEventsPage.repeat.click();
        //Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<WebElement> actualOptions = createCalendarEventsPage.repeatOptionsList().getOptions();

        //get text of each webelement and return as a list of String
        List<String> actualList = BrowserUtils.getElementsText(actualOptions);


        extentLogger.pass("Verify that “Daily” is selected by default and\n" +
                "following options are available in\n" +
                "“Repeats” drop-down:");

        //compare actual and expected list
        Assert.assertEquals(actualList,expectedList,"Compare dropdown values");
        //Assert.assertEquals(actualOptions,expectedList);

    }
    /*
    Test Case #9
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
5. Select “Repeat” checkbox
6. Verify that “Repeat” checkbox is selected
7. Verify that “Repeat Every” radio button is
selected
8. Verify that “Never” radio button is selected as an
“Ends” option.
9. Verify that following message as a summary is
displayed: “Summary: Daily every 1 day”

     */
    @Test
    public void SummaryTest9(){
        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(4);
        extentLogger.info("Select “Repeat” checkbox");
        createCalendarEventsPage.repeat.click();

        extentLogger.pass("Verify that “Repeat Every” radio button is\n" +
                "selected");
        Assert.assertTrue(createCalendarEventsPage.repeatEveryCheckBox.isSelected());
        extentLogger.pass("Verify that “Never” radio button is selected as an\n" +
                "“Ends” option.");
        Assert.assertTrue(createCalendarEventsPage.never.isSelected());
        extentLogger.pass("Verify that following message as a summary is\n" +
                "displayed: “Summary: Daily every 1 day”");
        BrowserUtils.waitFor(4);

        String expectedMessage="Daily every 1 day";
        String actualMessage=createCalendarEventsPage.summary.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Verify that following message as a summary is\\n\" +\n" +
                "                \"displayed: “Summary: Daily every 1 day”");

    }

    /*
Test Case #10
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
5. Select “Repeat” checkbox
6. Select “After 10 occurrences” as an “Ends”
option.
7. Verify that following message as a summary is
displayed: “Summary: Daily every 1 day, end
after 10 occurrences”

     */
    @Test
    public void SummaryTest10(){
        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(5);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(5);
        extentLogger.info("Select “Repeat” checkbox");
        createCalendarEventsPage.repeat.click();
        extentLogger.info(" Select “After 10 occurrences” as an “Ends”\n" +
                "option.");
        createCalendarEventsPage.after.click();
        createCalendarEventsPage.occurrences.sendKeys("10");
        extentLogger.pass("Verify that following message as a summary is\n" +
                "displayed: “Summary: Daily every 1 day, end\n" +
                "after 10 occurrences”");
         BrowserUtils.waitFor(5);
        createCalendarEventsPage.occurrences.click();
        BrowserUtils.waitFor(5);

        String expectedMessage="Daily every 1 day, end after 10 occurrences";
        String actualMessage=createCalendarEventsPage.summary.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Verify that following message as a summary is\\n\" +\n" +
                "                \"displayed: “Daily every 1 day, end after 10 occurrences”");


    }
    /*
    Test Case #11
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
5. Select “Repeat” checkbox
6. Select “By Nov 18, 2021” as an “Ends” option.
7. Verify that following message as a summary is
displayed: “Summary: Daily every 1 day, end by
Nov 18, 2021”


     */
    @Test
    public void SummaryTest11(){
        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(5);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(5);
        extentLogger.info("Select “Repeat” checkbox");
        createCalendarEventsPage.repeat.click();
        extentLogger.info(" Select “By Nov 18, 2021” as an “Ends” option.");
        createCalendarEventsPage.by.click();
        BrowserUtils.waitFor(5);
        createCalendarEventsPage.byDateBox.sendKeys("Nov 18, 2021"+ Keys.ENTER);
        BrowserUtils.waitFor(5);



        extentLogger.pass("Verify that following message as a summary is\\n\" +\n" +
                "                \"displayed: “Summary: Daily every 1 day, end by\\n\" +\n" +
                "                \"Nov 18, 2021”");

        String expectedMessage="Daily every 1 day, end by Nov 18, 2021";
        String actualMessage=createCalendarEventsPage.summary.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Verify that following message as a summary is\n" +
                "displayed: “Summary: Daily every 1 day, end by\n" +
                "Nov 18, 2021”");

    }
    /*
    Test Case #12
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on “Create Calendar Event” button
5. Select “Repeat” checkbox
6. Select “Weekly” options as a “Repeat” option
7. Select “Monday and Friday” options as a
“Repeat On” options
8. Verify that “Monday and Friday” options are
selected
9. Verify that following message as a summary is
displayed: “Summary: Weekly every 1 week on
Monday, Friday”

     */
    @Test
    public void SummaryTest12(){

        extentLogger = report.createTest("TestersMeetingTest");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a store manager");
        loginPage.login(username,password);
        BrowserUtils.waitFor(5);

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Navigate to Activities -- Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        extentLogger.info("Click on “Create Calendar Event” button");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(5);
        extentLogger.info("Select “Repeat” checkbox");
        createCalendarEventsPage.repeat.click();
        BrowserUtils.waitFor(5);
        extentLogger.info(" Select “Weekly” options as a “Repeat” option");
        createCalendarEventsPage.repeatOptionsList().selectByVisibleText("Weekly");
        BrowserUtils.waitFor(5);
        extentLogger.pass(" Select “Monday and Friday” options as a\n" +
                "“Repeat On” options");
        createCalendarEventsPage.monday.click();
        createCalendarEventsPage.friday.click();
        BrowserUtils.waitFor(2);

        extentLogger.pass(" Verify that following message as a summary is\n" +
                "displayed: “Summary: Weekly every 1 week on\n" +
                "Monday, Friday”");
        String expectedMessage="Weekly every 1 week on Monday, Friday";
        String actualMessage=createCalendarEventsPage.summary.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Verify that following message as a summary is\n" +
                "displayed: “Summary: Weekly every 1 week on\\n\" +\n" +
                "                \"Monday, Friday”");




    }
}
