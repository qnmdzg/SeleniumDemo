package com.newegg.testngday2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    private WebDriver driver;

    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\software\\新建文件夹\\zmym\\源代码\\selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//全局等待
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("file:///D:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//全局等待
        WebElement element = driver.findElement(By.xpath("//*[@id=\"wait\"]/input"));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"display\"]/div[1]"));
        String text = element1.getText();
        Assert.assertEquals("wait for display",text);
    }


    @Test
    public void test2(){
        driver.get("file:///D:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");

        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //显示等待
        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div[1]")));

        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div[1]")).getText();
        Assert.assertEquals("wait for display",text);
    }
}
