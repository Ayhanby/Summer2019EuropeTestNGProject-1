package com.cybertek.tests.day13_properties_driver_testbase;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void Test1(){


        String browser= ConfigurationReader.get("browser");
        System.out.println(browser);
        System.out.println(ConfigurationReader.get("url"));
        System.out.println(ConfigurationReader.get("salesmanager_username"));
        // if your key not exits in properties file, it will return null
    }
}
