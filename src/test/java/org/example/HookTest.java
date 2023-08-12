package org.example;

import org.testng.annotations.*;

public class HookTest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("before groups");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
    }
    @Test
    public void TC01(){
        System.out.println("TC01");
    }

    @Test
    public void TC02(){
        System.out.println("TC02");
    }
    @Test
    public void TC03(){
        System.out.println("TC03");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("after groups");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
}
