package com.qa.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：EZ6Web
 * @ Author：duzhengjun
 * @ dateTime：15:05
 */
public class EZ6Web {
    //准备一个webdriver的实例
    WebDriver driver = new ChromeDriver();



    @BeforeTest
    public void logIn() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver","\\Tools\\chrome.exe");
        driver.get("https://200000001-ez.sdndc.cn/login");//进入易证6web登录页
        System.out.println("成功打开易证6web后台开发环境");
        driver.manage().window().maximize();//浏览器最大化

        driver.findElement(By.xpath("//*[@title=\"账号登录\"]")).click();//点击右上角登录button进入登录页
        Thread.sleep(1000);//线程休眠1000ms
        driver.findElement(By.xpath("//input[@placeholder=\"用户名/手机号/邮箱\"]")).sendKeys("13002840927");
        driver.findElement(By.xpath("//input[@placeholder=\"请输入密码\"]")).sendKeys("Dzj123456");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        System.out.println("用户登录成功");
        Thread.sleep(1000);//线程休眠1000ms
    }

    @Test
    public void businessType() throws InterruptedException {
        driver.findElement(By.xpath("//div[@data-menu-id=\"rc-menu-uuid-10966-4-/app\"]")).click();
        driver.findElement(By.xpath("//li[@title=\"业务类型\"]")).click();



    }

    //上传文件
    class FileUpload {
        //这个方法供上传文件用（Mac），Windows可以使用第三方工具AutoIt来处理文件上传
        public void uploadFile(String filepath){
            //File Need to be imported
            File file = new File(filepath);
            StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
            //Copy to clipboard
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            Robot robot = null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ////// Cmd + Tab is needed since it launches a Java app and the browser looses focus

            robot.keyPress(KeyEvent.VK_META);

            robot.keyPress(KeyEvent.VK_TAB);

            robot.keyRelease(KeyEvent.VK_META);

            robot.keyRelease(KeyEvent.VK_TAB);

            robot.delay(500);

            /////Open Goto window shortkey is commmand +shift + G, adpate to MAC///////

            robot.keyPress(KeyEvent.VK_META);

            robot.keyPress(KeyEvent.VK_SHIFT);

            robot.keyPress(KeyEvent.VK_G);

            robot.keyRelease(KeyEvent.VK_META);

            robot.keyRelease(KeyEvent.VK_SHIFT);

            robot.keyRelease(KeyEvent.VK_G);

            /////Paste the clipboard value

            robot.keyPress(KeyEvent.VK_META);

            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_META);

            robot.keyRelease(KeyEvent.VK_V);

            ///////Press Enter key to close the Goto window and Upload window

            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);


            robot.delay(2000);

            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);


        }
    }

}

//        //使用方法uploadFile实现新增用户头像上传
//        FileUpload fl2 = new FileUpload();
//        System.out.println("准备上传头像");
//        fl2.uploadFile("/Users/duzhengjun/Pictures/壁纸/《睡》二次元动漫美图_彼岸图网.jpg");
//        Thread.sleep(5000);