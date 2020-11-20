package testScripts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class InquiryTest {
    AndroidDriver driver;

    @Test
    public void test() throws InterruptedException {
        System.out.println("-----------test()-----------");
        Thread.sleep(15000);
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        System.out.println("-----------------进入BeforeClass.setUp()-----------------");

        DesiredCapabilities dsc = new DesiredCapabilities();// 负责启动服务端时的参数设置
        dsc.setCapability("platformName","Android");//平台名称
        dsc.setCapability("platformVersion","5.1.1");
        //dsc.setCapability("udid", "MKJNW18105004350");//荣耀9
        dsc.setCapability("udid", "127.0.0.1:5555");//模拟器
        dsc.setCapability("deviceName", "MKJNW18105004350");//使用的手机类型或模拟器类型  UDID
        //dsc.setCapability("appPackage", "com.jiaparts.jsjxz_fwl");//小掌柜包名
        dsc.setCapability("appPackage", "com.jiaparts.jsj_wl");//交收嘉包名
        dsc.setCapability("appActivity", "com.jiaparts.business.ui.MainActivity");//主Activity
        //dsc.setCapability("appActivity", "com.jiaparts.business.ui.LoginActivity");//登录activity
        dsc.setCapability("resetKeyboard",true);//支持中文输入
        //dsc.setCapability("newCommandTimeout", "10");//没有新命令时的超时时间设置
        dsc.setCapability("nosign", "True");//跳过检查和对应用进行 debug 签名的步骤
        dsc.setCapability("autoGrantPermissions","true");//自动权限授权

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dsc);//虚拟机默认地址
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//全局设置显示等待
    }


    @AfterClass
    public void tearDown(){
        System.out.println("----------------进入AfterClass.tearDown()---------------------");

        driver.quit();
    }
}
