package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Porsche718Page {
    public Porsche718Page(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='m982120']//div[@class='m-14-model-price']")
    public WebElement listedPrice;
    @FindBy(id="m982120")
    public WebElement cayman;

}
