package com.qa.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
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
    Robot robot = new Robot();

    public WanWeb() throws AWTException {
    }

    @BeforeTest
    public void logIn() throws InterruptedException {

        //这里实现登录wan_web
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //进入wanweb登录页
        driver.get("https://200000001-zaixian.sdndc.cn/account/login");
        System.out.println("成功打开wan_web首页");

        //浏览器最大化
        driver.manage().window().maximize();

        //输入用户名密码后登录
        driver.findElement(By.xpath("//input[@placeholder=\"请输入用户名\"]")).sendKeys("13002840927");
        driver.findElement(By.xpath("//input[@placeholder=\"请输入密码\"]")).sendKeys("Dzj940927");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        System.out.println("用户登录成功");
        Thread.sleep(5000);
    }

    @Test
    public void application() throws InterruptedException, IOException {

        //实现wan_web申办业务

        //点击进入申办
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[1]/a")).click();
        Thread.sleep(3500);
        //点击右上角“开始申办”按钮
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[1]/div[2]/div/div/div[2]/span[2]/button")).click();
        Thread.sleep(1500);
        //点击第一个申办场景“公众买糖场景”
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[2]/div/div/div/div[1]/div/div")).click();
        Thread.sleep(2000);
        //点击右上角开始申办按钮
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[1]/div[2]/div/div/div[2]/span[2]/span/button")).click();
        Thread.sleep(1000);
        //点击选择大厅
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[4]/div[4]/div/h3")).click();
        Thread.sleep(2000);
//        //不选择团队直接点击申办按钮
//        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button")).click();
        //点击选择金咖社业务团队
        driver.findElement(By.xpath("//div[contains(text(),'金咖社业务团队')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button")).click();

        Thread.sleep(8000);
        System.out.println("登记业务成功，待填写资料后申办");


        //填写基本信息
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[3]/div/div/div[1]/div/div/div[1]")).click();
        Thread.sleep(1500);
        //用途
        driver.findElement(By.xpath("//*[@id=\"wanPurposeId\"]/div/div/div[2]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//div[contains(text(),'买房子')]")).click();
        //几套房子
        driver.findElement(By.xpath("//*[@id=\"field_4863\"]")).sendKeys("3");
        //腾讯
        driver.findElement(By.xpath("//*[@id=\"field_4036\"]")).sendKeys("腾讯成都大厦A座");
        //称呼
        driver.findElement(By.xpath("//*[@id=\"field_4860\"]")).sendKeys("杜征骏");
        //手机号
        driver.findElement(By.xpath("//*[@id=\"field_4861\"]")).sendKeys("13002840927");
        //职业
        driver.findElement(By.xpath("//*[@id=\"field_4862\"]")).sendKeys("面点师");
        //手机号整数
        driver.findElement(By.xpath("//*[@id=\"field_4864\"]")).sendKeys("17");

        //点击确定提交基本信息
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("基本信息填写完成");
        Thread.sleep(4000);


        //设置当事人
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div[2]/div/span")).click();
        //添加申请人 杜征骏
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[3]/span[2]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"idType\"]/div/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'身份证人像面')]")).click();
        driver.findElement(By.xpath("//*[@id=\"idNumber\"]/div/div/ul/li/div/input")).sendKeys("510921199409275117");
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("杜征骏");
        driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("13002840927");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1500);
//        //添加公众角色 自己
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[3]/div/div[1]/div/table/tbody/tr/td[3]/span[2]/button[2]")).click();
        //添加公众角色 田欣
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[3]/div/div[1]/div/table/tbody/tr/td[3]/span[2]/button[1]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"idType\"]/div/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'居民身份证正面')]")).click();
        driver.findElement(By.xpath("//*[@id=\"idNumber\"]/div/div/ul/li/div/input")).sendKeys("51300219930912544X");
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("田欣");
        driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("19182261929");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[1]/div[2]/div/div/div[2]/span[2]/button")).click();
        System.out.println("添加当事人成功");
        Thread.sleep(2000);


        //上传材料
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[3]/div/div/div[3]/div/div/div[1]/div[2]/div/span")).click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[1]/div/div[1]/span[2]/div[1]/span/div/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[1]/div/div[1]/span[2]/div[1]/span/input")).sendKeys("C:\\Users\\zzsoft\\iCloudDrive\\音乐\\收集\\one love（女声版）.mp3");
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[5]/div/div[1]/span[2]/div[1]/span/input")).sendKeys("C:\\Users\\zzsoft\\Pictures\\壁纸\\欢迎乘坐非法运营车辆.png");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[1]/div[2]/div/div/div[2]/span[3]/button")).click();
        Thread.sleep(2000);


        //选择模板
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[3]/div/div/div[4]/div/div/div[1]/div[2]/div/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div/span/div/div/div/div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div/span/div/div/div/div[2]/div/input")).sendKeys("委托书");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[1]/div[2]/div/div/div[2]/span[1]/div/h4")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/section/section/main/div[1]/div[1]/div[2]/div/div/div[2]/span[3]/div/button[2]")).click();
        System.out.println("选择模板成功");
        Thread.sleep(2000);

        //预览文书


        //提交申办
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[3]/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/div/button[2]")).click();
        Thread.sleep(3000);
        System.out.println("申办业务成功");
        //返回申办详情
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[4]/button")).click();
        Thread.sleep(3000);

        //作废申办业务
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div[1]/div[2]/div/div/div/div[3]/div/h4/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]")).click();
        Thread.sleep(2000);
        System.out.println("作废业务成功");






        //封装select对象
//        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"idType\"]/div/div/div[1]")));
//        for (WebElement e : select.getOptions())
//            e.click();
//        select.selectByVisibleText("身份证人面像");
//        driver.findElement(By.xpath("//*[@id=\"283407b7-a991-4659-e3a5-549c8a11d816\"]/ul/li[2]/div")).click();



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
