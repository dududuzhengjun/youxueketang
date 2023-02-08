package com.qa.pagetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static WebDriver newInstance(){
//        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","/Users/duzhengjun/IdeaProjects/youxueketang/tools/chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
