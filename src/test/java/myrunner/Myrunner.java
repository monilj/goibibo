package myrunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",format = {"pretty"},tags = "@seatbooking",
        glue={"steps"})


public class Myrunner {
}