package com.newegg.testngday2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTest1 {
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

    /*
        在百度按钮上点击右键
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement su = driver.findElement(By.id("su"));
        //实例化actions类
        Actions actions = new Actions(driver);
       // actions.contextClick(su).perform();
        actions.contextClick().perform();
        Thread.sleep(5000);
    }

    @Test
    public void  test2() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //获得更多产品的元素
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"u1\"]/a[9]"));
        //鼠标移动到更多产品上
        Actions actions =new Actions(driver);
        actions.moveToElement(element1).perform();

        //获取图片
        WebElement element = driver.findElement(By.xpath("//*[@id=\"head\"]/div/div[4]/div/div[2]/div[1]/div/a[3]/span"));

        //显示等待
       // WebDriverWait wait = new WebDriverWait(driver,10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"head\"]/div/div[4]/div/div[2]/div[1]/div/a[3]/span")));
        element.click();
        Thread.sleep(5000);
    }
}
