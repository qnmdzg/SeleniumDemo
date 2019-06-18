package com.newegg.testngday3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {
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
    public void test1(){
        driver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"bb\");");
    }
}
