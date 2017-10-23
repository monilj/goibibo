package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.HomePage;


public class HomePageStep extends BasePageStep {
    @Given("^user on home screen taps skip$")
    public void user_on_home_screen_taps_skip()
    {
        new HomePage(driver).user_on_home_screen_taps_skip();
    }

    @And("^user on home screen taps on bus$")
    public void user_on_home_screen_taps_on_bus() throws Throwable {
        new HomePage(driver).user_on_home_screen_taps_on_bus();
    }
}
