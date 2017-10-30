package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StartingSteps extends BasePageStep {
   private AppiumDriverLocalService appiumService;

@Before
public void initialize()
    {
        int port = 4723;
        String osName = System.getProperty("os.name");
        System.out.println("started");
       if (osName.contains("Mac")) {
            appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingDriverExecutable(new File("/usr/local/bin/node"))
                    .withAppiumJS(new File("/usr/local/bin/appium"))
                    .withIPAddress("127.0.0.1")
                    .usingPort(port)
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                     .withLogFile(new File("target/appium.log")));
        }
        appiumService.start();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        cap.setCapability("app", "/Users/moniljoshi/Development/Goibibo/app/Goibibo.apk");
        cap.setCapability("appPackage", "com.goibibo");
        cap.setCapability("appActivity", "com.goibibo.common.HomeActivity");
        cap.setCapability("autoAcceptAlerts", true);
        cap.setCapability("newCommandTimeout", 30);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:"+port+"/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    @After
    public void tearDown(Scenario scenario) {
            driver.quit();
            appiumService.stop();
    }
    }
