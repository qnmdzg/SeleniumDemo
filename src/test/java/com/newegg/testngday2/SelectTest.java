package com.newegg.testngday2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class SelectTest{
    private WebDriver driver;

    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\software\\新建文件夹\\zmym\\源代码\\selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("file:///D:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
        WebElement moreSelect = driver.findElement(By.id("moreSelect"));
        //操作select必须要实例一个select对象
        Select select =new Select(moreSelect);
        select.selectByIndex(2);//通过索引让下拉框被选中
        Thread.sleep(2000);
        select.selectByValue("oppe");//通过value设置选中
        Thread.sleep(2000);
        select.selectByVisibleText("xiaomi");//通过text设置选中
        Thread.sleep(2000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("file:///D:/BaiduNetdiskDownload/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"open\"]/a"));
        String windowHandle = driver.getWindowHandle();//获得当前win的句柄
        System.out.println(windowHandle);
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle:windowHandles){
            if (windowHandle.equals(handle)){
                continue;
            }else {
                driver.switchTo().window(handle);
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]")).click();
    }
}
