package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import pages.SeatSelectionPage;

public class SeatSelectionPageStep extends BasePageStep{
    SeatSelectionPage seatSelectionPage = new SeatSelectionPage(driver);

    @And("^user on seatSelectionpage selected seat number (\\d+) and (\\d+)$")
    public void user_on_seatSelectionpage_selected_seat_number(int seatno,int seatnum) throws Throwable {
        seatSelectionPage.user_on_seatSelectionpage_selected_seat_number(seatno,seatnum);
    }
    @And("^user on seatSelectionpage taps on continue$")
    public void use_on_seatSelectionpage_taps_on_continue() throws Throwable {
        seatSelectionPage.use_on_seatSelectionpage_taps_on_continue();
    }

    @And("^user on seatSelectionpage select pick up point as \"([^\"]*)\"$")
    public void user_on_seatselectionpage_select_pick_up_pointAs(String pickuppoint) throws Throwable {
        seatSelectionPage.user_on_seatselectionpage_select_pick_up_pointAs(pickuppoint);
    }
}