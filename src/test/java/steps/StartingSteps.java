package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import cucumber.api.java.Before;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StartingSteps extends BasePageStep {
   //private AppiumDriverLocalService appiumService;
   private AppiumDriverLocalService service;
    @Before
    public void initialize() throws MalformedURLException {
        String osName = System.getProperty("os.name");
       // int port = 4724;
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        System.out.println("started");
       /* if (osName.contains("Mac")) {
            appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingDriverExecutable(new File("/usr/local/bin/node"))
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/appium.js"))
                    .withIPAddress("127.0.0.1")
                    .usingPort(port)
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                    .withLogFile(new File("target/build.log")));
        }

        appiumService.start();*/
        DesiredCapabilities cap = new DesiredCapabilities();
//        String target = System.getProperty("targetDevice");
//        System.out.println("Input Target Device is: " + target);
//        if (target.equalsIgnoreCase("android")) {
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        cap.setCapability("app", "/Users/moniljoshi/Development/Goibibo/app/Goibibo.apk");
        cap.setCapability("appPackage", "com.goibibo");
        cap.setCapability("appActivity", "com.goibibo.common.HomeActivity");
        cap.setCapability("autoAcceptAlerts", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //}
    }
    @After
    public void tearDown(Scenario scenario) {
            driver.quit();
            //appiumService.stop();
        service.stop();
    }
}
