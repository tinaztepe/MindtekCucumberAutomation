package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Porsche718Page;
import pages.PorscheCarConfiguratorPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Iterator;
import java.util.Set;

public class PorscheAppSteps {
    WebDriver driver= Driver.getDriver();
    Porsche718Page porsche718Page=new Porsche718Page();
    PorscheCarConfiguratorPage porscheCarConfiguratorPage=new PorscheCarConfiguratorPage();
    @Given("user navigates to Porsche Application")
    public void user_navigates_to_Porsche_Application() {
        driver.get(ConfigReader.getProperty("PorscheURL"));
    }
    @When("user stores the price and selects the model 718 Cayman")
    public void user_stores_the_price_and_selects_the_model_Cayman() {
        String listedPrice=porsche718Page.listedPrice.getText();
        listedPrice=listedPrice.replace(",","").substring(listedPrice.lastIndexOf(" "),listedPrice.length()-2);
        System.out.println(listedPrice);
        porsche718Page.cayman.click();
    }
    @Then("user validates Base price is matched with listed price")
    public void user_validates_Base_price_is_matched_with_listed_price() throws InterruptedException {
        String listedPrice=porsche718Page.listedPrice.getText();
        listedPrice=listedPrice.replace(",","").substring(listedPrice.lastIndexOf(" ")+1,listedPrice.length()-2);
        Set<String> windowIds=driver.getWindowHandles();
        Iterator<String> it=windowIds.iterator();
        String parentId=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
        porscheCarConfiguratorPage.closeButton.click();
        Thread.sleep(5000);
        porscheCarConfiguratorPage.section.click();
        String basePrice=porscheCarConfiguratorPage.basePrice.getText();
        basePrice=basePrice.replace(",","").substring(1);
        Assert.assertEquals(basePrice,listedPrice);
        driver.quit();

    }





    @When("user adds Power Sport Seats \\(14-way) with Memory Package")
    public void user_adds_Power_Sport_Seats_way_with_Memory_Package() throws InterruptedException {

        Set<String> windowIds=driver.getWindowHandles();
        Iterator<String> it=windowIds.iterator();
        String parentId=it.next();
        String childId=it.next();

        driver.switchTo().window(childId);
        porscheCarConfiguratorPage.closeButton.click();
        Thread.sleep(5000);

        porscheCarConfiguratorPage.powerSeatsRadioButton.click();
        String seatPrice=porscheCarConfiguratorPage.seatPrice.getText();
        System.out.println(seatPrice);
        Thread.sleep(5000);
        String equipmentPrice=porscheCarConfiguratorPage.equipmentPrice.getText();
        System.out.println(equipmentPrice);

    }

    @Then("user validates that Price For Equipment is added and price matches")
    public void user_validates_that_Price_For_Equipment_is_added_and_price_matches() throws InterruptedException {
        String seatPrice=porscheCarConfiguratorPage.seatPrice.getText();

        Thread.sleep(5000);
        String equipmentPrice=porscheCarConfiguratorPage.equipmentPrice.getText();
        Assert.assertEquals(seatPrice,equipmentPrice);

    }


}
