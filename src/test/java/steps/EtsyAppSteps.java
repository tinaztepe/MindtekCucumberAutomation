package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class EtsyAppSteps {
    WebDriver driver= Driver.getDriver();
    EtsyAppHomePage etsyAppHomePage=new EtsyAppHomePage();
    EtsyAppSearchPage etsyAppSearchPage=new EtsyAppSearchPage();

    @Given("user navigates to Etsy application")
    public void user_navigates_to_Etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));

    }

    @When("user searches for {string}")
    public void user_searches_for(String itemName) {
        etsyAppHomePage.searchBox.sendKeys(itemName+ Keys.ENTER);



    }

    @When("user applies filter over {int}")
    public void user_applies_filter_over(Integer price) {
        etsyAppSearchPage.filterButton.click();
        etsyAppSearchPage.priceFilterOver1000.click();
        etsyAppSearchPage.applyButton.click();


    }

    @Then("user validates the items price is equal or over {double}")
    public void user_validates_the_items_price_is_equal_or_over(Double price) throws InterruptedException {

        Thread.sleep(3000);
        List<WebElement> prices=etsyAppSearchPage.prices;
        for(WebElement element:prices){
            String priceStr=element.getText().replace(",","");
            double doublePrice=Double.parseDouble(priceStr);
            Assert.assertTrue(doublePrice>=price);
        }


    }

    @Then("user validates search result items contains keyword {string} or {string}")
    public void userValidatesSearchResultItemsContainsKeyword(String item1,String item2) {
        List<WebElement> itemNames=etsyAppSearchPage.itemNames;
       for(int i=0; i<itemNames.size(); i++){
           String newItemNames=itemNames.get(i).getText();
           boolean condition=newItemNames.toLowerCase().contains(item1)||newItemNames.toLowerCase().contains(item2);
           if(condition){
               StringBuilder str=new StringBuilder();
               str.append(newItemNames);
               System.out.println(str);
               Assert.assertTrue(str.toString().toLowerCase().contains(item1)||str.toString().toLowerCase().contains(item2));
           }
       }

    }

    @When("user clicks on {string} section")
    public void userClicksOnSection(String section) {

    }

    @Then("user validates title is {string}")
    public void userValidatesTitleIs(String title) {
    }
}
