package com.newegg.testngday1;

import org.testng.annotations.*;

public class TestNgDemo1 {

    @Test
    public  void testCase1(){
        System.out.println("这是@test，case1");
        System.out.println(System.getProperty("user.dir"));

    }
    @Test
    public  void  testCase2(){
        System.out.println("这是@test，case2");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("这是 @BeforeTest，在所有的test前运行且只运行一次");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是 @BeforeMethod，在所有的test前运行,有多少个test运行多少次");
    }

    @AfterTest
    public  void  afterTest(){
        System.out.println("这是 @AfterTest，在所有的test运行后运行，且只运行一次");
    }

    @AfterMethod
    public  void  afterMethod(){
        System.out.println("这是 @AfterTest，在所有的test运行后运行,有多少个test运行多少次");
    }

}
