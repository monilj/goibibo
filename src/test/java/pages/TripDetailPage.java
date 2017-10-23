package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TripDetailPage extends BasePage {
    AppiumDriver androidDriver;
    TouchAction tAction =new TouchAction(driver);

    @FindBy(id = "bus_origin")
    private WebElement bus_dept_city;

    @FindBy(id = "search_edit")
    private WebElement sendcityname;

    @FindBys({@FindBy(id="suggested_place")})
    List<WebElement> selectfirstoption;

    @FindBy(id = "bus_dest")
    private WebElement bus_arr_city;

    @FindBy(id="textBusOnwDay_cur")
    private WebElement calClick;

    @FindBys({@FindBy(id = "title")})
    List<WebElement>  tripmonth;

    @FindBy(id = "button_apply_filter")
    private WebElement getSetgo;

    public TripDetailPage(AppiumDriver driver) {
        super(driver);
        this.androidDriver = driver;
        PageFactory.initElements(driver, this);

    }

    public void user_on_tripDetail_page_taps_on_From()
    {

        bus_dept_city.click();
    }

    public void user_on_tripDetail_page_types_on_enterdeptartureCityName_value(String dept_city) throws Throwable {
        sendcityname.sendKeys(dept_city);
    }

    public void user_on_tripDetail_page_select_first_option_from_city() throws Throwable {
        selectfirstoption.get(0).click();
    }

    public void user_on_tripDetail_page_taps_on_To() throws Throwable {
        bus_arr_city.click();
    }

    public void user_on_tripDetail_page_types_on_enterarrivalCityName_value(String arr_city) throws Throwable {
        sendcityname.sendKeys(arr_city);
    }

    public void user_on_tripDetail_page_taps_on_Departure_date() throws Throwable {
        calClick.click();

    }

    //select reavel date
    public void user_on_tripDetail_page_select_from_calender(int date,String month) throws Throwable {
        for(int i=0;i<tripmonth.size();i++)
        {
            if(tripmonth.get(i).getText().contains(month))
            {
                driver.findElement(By.xpath("//android.widget.TextView[@text="+date+"]")).click();
                break;
            }
        }
    }

    public void user_on_tripDetail_page_taps_on_SearchButton() throws Throwable{
        getSetgo.click();
    }
}
