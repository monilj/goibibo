package steps;

import cucumber.api.java.en.And;
import pages.TripDetailPage;

public class TripDetailPageStep extends BasePageStep{

    TripDetailPage tripDetailPage = new TripDetailPage(driver);

    @And("^user on tripDetail page taps on From$")
    public void user_on_tripDetail_page_taps_on_From() throws Throwable {
     tripDetailPage.user_on_tripDetail_page_taps_on_From();
    }

    @And("^user on tripDetail page types on enterdeptartureCityName value \"([^\"]*)\"$")
    public void user_on_tripDetail_page_types_on_enterdeptartureCityName_value(String dept_city) throws Throwable {
        tripDetailPage.user_on_tripDetail_page_types_on_enterdeptartureCityName_value(dept_city);
    }

    @And("^user on tripDetail page select first option from city$")
    public void user_on_tripDetail_page_select_first_option_from_city() throws Throwable {
        tripDetailPage.user_on_tripDetail_page_select_first_option_from_city();
    }
    @And("^user on tripDetail page taps on To$")
    public void user_on_tripDetail_page_taps_on_To() throws Throwable {
        tripDetailPage.user_on_tripDetail_page_taps_on_To();
    }
    @And("^user on tripDetail page types on enterarrivalCityName value \"([^\"]*)\"$")
    public void user_on_tripDetail_page_types_on_enterarrivalCityName_value(String arr_city) throws Throwable {
        tripDetailPage.user_on_tripDetail_page_types_on_enterarrivalCityName_value(arr_city);
    }
    @And("^user on tripDetail page taps on Departure date$")
    public void user_on_tripDetail_page_taps_on_Departure_date() throws Throwable {
        tripDetailPage.user_on_tripDetail_page_taps_on_Departure_date();
    }
    @And("^user on tripDetail page select date (\\d+) \"(.*)\" from calender$")
    public void user_on_tripDetail_page_select_from_calender(int date,String month) throws Throwable {
    tripDetailPage.user_on_tripDetail_page_select_from_calender(date,month);
    }


    @And("^user on tripDetail page taps on SearchButton$")
    public void user_on_tripDetail_page_taps_on_SearchButton() throws Throwable {
    tripDetailPage.user_on_tripDetail_page_taps_on_SearchButton();
    }

}
