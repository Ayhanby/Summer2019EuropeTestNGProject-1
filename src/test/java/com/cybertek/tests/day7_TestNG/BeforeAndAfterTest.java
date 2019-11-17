package com.cybertek.tests.day7_TestNG;


import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @Test
    public void test1(){
        System.out.println("This is test 1");

        //--> beginning of the each test
        //webdriver code
        //open browser
        //maximize window

        //after each
        //close browser


    }
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }
    @BeforeMethod
    public void setUpMethod(){

        System.out.println("BEFORE METHOD");
        System.out.println("OPENING THE BROWSER");

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD");
        System.out.println("CLOSE BROWSER");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS CODE");

    }
    @AfterClass
    public void afterClass(){

        System.out.println("AFTER CLASS CODE");
        System.out.println("REPORTING");
    }



}
