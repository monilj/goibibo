package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BusSearchPage extends BasePage {
    AppiumDriver driver;


    @FindBys({@FindBy(id = "bus_type")})
    List<WebElement> selectbus;

    public BusSearchPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void user_on_busSearch_page_select_first_bus() throws Throwable {
        for(int i=0;i<selectbus.size();i++)
        {
            String bustype = selectbus.get(i).getText();
            if (bustype.contains("Semi"))
            {
                selectbus.get(i).click();
                break;
            }
        }
    }
}