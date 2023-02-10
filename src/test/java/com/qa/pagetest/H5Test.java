package com.qa.pagetest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：H5Test
 * @ Author：duzhengjun
 * @ dateTime：2023-02-10 15:37:00
 *
 * 需要添加依赖Appium java-client-7.0.0 .
 */



public class H5Test {

    //用来测试纯H5，安卓手机上需要安卓chrome浏览器

    AndroidDriver driver;
    public static AndroidDriver initDriverWithH5(String udid) throws Exception{
        DesiredCapabilities caps=new DesiredCapabilities();

        //测试的平台
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        //deviceName 在安卓上没用
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");

        //session超时时间
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);

        //appium要操作的手机udid，安卓上是使用adb devices看到的设备名称
        caps.setCapability(MobileCapabilityType.UDID, udid);

        //不重置应用数据
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

        //不重签名app
        caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);

        //指定对应的微信X5内核对应Chrome版本的Chromedriver版本
        caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "E:/newapk/chromedriver/81/chromedriver.exe");

        //每次进入webview或者H5界面是重新创建一个chromedriver的服务
        caps.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true);

        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        //关闭W3C，解决org.openqa.selenium.UnsupportedCommandException: unknown command: Cannot call non W3C standard command while in W3C mode错误
        caps.setCapability(AndroidMobileCapabilityType.CHROME_OPTIONS, ImmutableMap.of("w3c", false));

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        return driver;

    }

    @BeforeTest
    public void setUp() throws Exception{

        driver = initDriverWithH5("3c1bfcf6");
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @Test
    public void testH5() throws Exception{

        driver.get("百度一下");
        driver.findElement(By.id("index-kw")).sendKeys("小貓");
        driver.findElement(By.cssSelector("#index-box > div > div.suggest-panel > div.suggest-content > div:nth-child(3) > button")).click();

    }




}

















