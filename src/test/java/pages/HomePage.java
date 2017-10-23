package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    AppiumDriver appiumDriver;

    @FindBy(id = "onboarding_enter_mob_skip_txtVw")
    private WebElement clickonSKIP;

    @FindBy(id = "android:id/button2")
    private WebElement skipconfirm;

    @FindBy(id = "bus_icon")
    private WebElement text_bus;

    @FindBy(id = "got_it")
    private WebElement popup1;

    public HomePage(AppiumDriver driver) {
        super(driver);
        appiumDriver = driver;
        PageFactory.initElements(driver, this);
    }


    public void user_on_home_screen_taps_skip() {
        clickonSKIP.click();
        skipconfirm.click();
    }

    public void user_on_home_screen_taps_on_bus() throws InterruptedException {
        text_bus.click();
        popup1.click();
    }

}
