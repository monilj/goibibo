package steps;

import cucumber.api.java.en.And;
import pages.BusSearchPage;

public class BusSearchPageStep extends BasePageStep {

    BusSearchPage busSearchPage = new BusSearchPage(driver);

    @And("^user on busSearch page select first bus$")
    public void user_on_busSearch_page_select_first_bus() throws Throwable {
        busSearchPage.user_on_busSearch_page_select_first_bus();
    }
}
