package baseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseClass {

    public static AppiumDriver<MobileElement> driver;
    @BeforeTest(alwaysRun = true)
    @Parameters({"deviceName","udid", "platformVersion","url", "systemPort"})
    public void setup(String deviceName, String udid,String platformVersion,String url, String systemPort) throws InterruptedException, MalformedURLException
    {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("deviceName", deviceName);
        cap.setCapability("udid", udid);
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", platformVersion);
        cap.setCapability("isHeadless", true);
        cap.setCapability("systemPort", systemPort);
        driver=new AppiumDriver<MobileElement>(new URL(url), cap);
        Thread.sleep(5000);

    }

}