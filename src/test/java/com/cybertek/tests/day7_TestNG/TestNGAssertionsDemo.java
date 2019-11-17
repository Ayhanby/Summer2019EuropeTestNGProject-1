package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){

        Assert.assertEquals("one","one");

    }

    @Test
    public void test2(){

        Assert.assertEquals(1,2);
    }
    @Test
    public void test3(){

        // verify that title starts with C

        String actualTitle ="Cybertek";
        String expectedTitle="B";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title starts with C");

        //Task
        //verify that email includes @ sign
        Assert.assertTrue("harun%mail".contains("@"),"Verify @ in email");
    }

    @Test
    public void test4(){
        //Negative testing
        Assert.assertNotEquals("one","two");
        Assert.assertFalse(1<0);




    }
}
