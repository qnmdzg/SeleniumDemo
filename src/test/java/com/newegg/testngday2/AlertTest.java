package com.newegg.testngday2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    private WebDriver driver;

    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\software\\新建文件夹\\zmym\\源代码\\selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("file:///D:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"alert\"]/input"));
        element.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();//把控制权给alert页面
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(text,"请点击确定");

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("file:///D:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"confirm\"]/input"));
        element.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();//把控制权给alert页面
        alert.dismiss();//点击取消
        Thread.sleep(2000);
        alert.accept();
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("file:///D:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"prompt\"]/input"));
        element.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();//把控制权给alert页面
        alert.sendKeys("hello world");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        alert.accept();
    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("file:///D:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
        //WebDriver aa = driver.switchTo().frame("aa");//这是frame
        WebDriver aa = driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe")));
        aa.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
        Thread.sleep(3000);
        //driver.switchTo().defaultContent();//把driver的控制权转交给默认的
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
    }
}
