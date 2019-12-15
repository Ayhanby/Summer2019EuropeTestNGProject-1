package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    @Test
    public void verifySubtitleTest(){

         /*Test case
    Open browser
    Login as a Driver
    Verify that page subtitle is Quick Launchpad
    Go to Activities -> Calendar Events
    verify that page subtitle is Calendar Events
    */

        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username, password);

        DashboardPage dashboardPage=new DashboardPage();
        System.out.println(dashboardPage.getPageSubTitle());

        Assert.assertEquals(dashboardPage.getPageSubTitle(),"Quick Launchpad","verify that subtitle is 'Quick Launchpad'");

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        String secondSubtitle = calendarEventsPage.getPageSubTitle();
        System.out.println("secondSubtitle = " + secondSubtitle);
        Assert.assertEquals(secondSubtitle, "Calendar Events", "verify the calendar events");


    }

}
