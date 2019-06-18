package com.newegg.testngday1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenBrowser {
    WebDriver webDriver;

    @Test
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\software\\新建文件夹\\zmym\\源代码\\selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

    }

    @Test
    public  void getWin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\software\\新建文件夹\\zmym\\源代码\\selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        webDriver.navigate().back();//后退
        Thread.sleep(3000);
        webDriver.quit();

    }


    @Test
    public  void getWin1() throws InterruptedException {

        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        webDriver.manage().window().maximize();//最大化
        Thread.sleep(3000);
        webDriver.manage().window().setSize(new Dimension(300,300));
        Thread.sleep(3000);
        webDriver.quit();

    }

    @BeforeMethod
    public  void  openBrower(){
        System.setProperty("webdriver.chrome.driver","D:\\software\\新建文件夹\\zmym\\源代码\\selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public  void closeBrower(){
        webDriver.quit();
    }
}
