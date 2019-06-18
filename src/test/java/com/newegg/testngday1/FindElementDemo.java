package com.newegg.testngday1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementDemo {
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
    public void getElement(){
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("kw"));
    }

}
