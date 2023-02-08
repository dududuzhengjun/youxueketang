package com.qa.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：WanWeb
 * @ Author：@duzhengjun
 * @ dateTime：2023/2/8 20:40
 */
public class WanWeb{


    WebDriver driver=Driver.newInstance();

    @BeforeTest
    public void logIn() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://200000001-zaixian.sdndc.cn/account/login");//进入wanweb登录页
        System.out.println("成功打开wanweb首页");
        driver.manage().window().maximize();//浏览器最大化

        driver.findElement(By.xpath("//input[@placeholder=\"请输入用户名\"]")).sendKeys("13002840927");
        driver.findElement(By.xpath("//input[@placeholder=\"请输入密码\"]")).sendKeys("Dzj940927");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        System.out.println("用户登录成功");
        Thread.sleep(5000);//线程休眠1000ms
    }

    @Test
    public void application() throws InterruptedException {
        //wan_web申办业务
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[1]/a")).click(); //点击进入申办
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[1]/div[2]/div/div/div[2]/span[2]/button")).click();




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