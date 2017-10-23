package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeatSelectionPage extends BasePage {
    AppiumDriver androidDriver;

    @FindBys({@FindBy(id = "seat")})
    List<WebElement> seats;

    @FindBy(id = "com.goibibo:id/proceed")
    private WebElement proceed;

    @FindBys({@FindBy(id = "boarding_point")})
    List<WebElement> boardingpoints;

    public SeatSelectionPage(AppiumDriver driver) {
        super(driver);
        this.androidDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void user_on_seatSelectionpage_selected_seat_number(int seatno,int seatnum)  throws Throwable {
        int n =seats.size();
        seats.get(seatno).click();
        seats.get(seatnum).click();
    }

    public void use_on_seatSelectionpage_taps_on_continue() throws Throwable {
       proceed.click();
    }

    public void user_on_seatselectionpage_select_pick_up_pointAs(String pickuppoint) throws InterruptedException {
        for(int i=0;i<boardingpoints.size();i++)
        {
            String boardingpt = boardingpoints.get(i).getText();
                if (boardingpt.contains(pickuppoint))
                {
                    boardingpoints.get(i).click();
                    break;
                }
        }
    }
}

