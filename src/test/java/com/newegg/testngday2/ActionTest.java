package com.newegg.testngday2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ActionTest{
    private WebDriver driver;
    @BeforeMethod
    public void getWebDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\software\\新建文件夹\\zmym\\源代码\\selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public  void  closeBrower(){
        driver.quit();
    }

    @Test
    public void clickDemo(){
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]"));
        element.click();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url,"http://news.baidu.com/");
    }


    @Test
    public void clickDemo1() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        element.sendKeys("selenium");
        Thread.sleep(1000);
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"su\"]"));
        element1.click();
        String title = driver.getTitle();
        Assert.assertEquals("selenium_百度搜索",title);
    }

    @Test
    public void test1(){
        driver.get("http://www.baidu.com");
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"su\"]"));
        String name = element1.getAttribute("value");
        Assert.assertEquals(name,"百度一下");
    }

    //截图
    @Test
    public void test2() throws IOException {
        driver.get("http://www.baidu.com");
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File("D:\\software\\新建文件夹\\zmym\\源代码\\selenium\\images\\"+ UUID.randomUUID()+".png"));

    }
}
