package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OrangeHRMPage;
import utilities.ConfigReader;
import utilities.Driver;

public class OrangeHRMSteps {
    WebDriver driver = Driver.getDriver();
    OrangeHRMPage orangeHRMPage=new OrangeHRMPage();

    @When("user navigates to {string} page")
    public void user_navigates_to_page(String string) {



    }
    @Given("user send username {string} and password {string}")
    public void user_send_username_and_password(String username, String password) {
        driver.get(ConfigReader.getProperty("OrangeHRURL"));
        orangeHRMPage.username.sendKeys(username);
        orangeHRMPage.password.sendKeys(password);
        orangeHRMPage.loginButton.click();


    }



    @When("user chooses and clicks one of the {string} weeks from dropdown")
    public void user_chooses_and_clicks_one_of_the_weeks_from_dropdown(String string) {

    }

    @Then("user validates the desired {string} week is selected")
    public void user_validates_the_desired_week_is_selected(String string) {

    }

    @And("user adds a row to the {string} week")
    public void userAddsARowToTheWeek(String arg0) {

    }

    @Then("user validates the row is added")
    public void userValidatesTheRowIsAdded() {
    }

}
