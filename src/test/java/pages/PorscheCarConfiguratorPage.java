package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PorscheCarConfiguratorPage {
    public PorscheCarConfiguratorPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="(//span[@class='expandButton'])[3]")
    public WebElement section;
    @FindBy(xpath = "//div[@class='disclaimer-box toast-notification']//span[@class='close-button']")
    public WebElement closeButton;
    @FindBy(xpath = "(//div[@class='row additional']//div[@class='cca-price'])[1]")
    public WebElement basePrice;
    @FindBy(id="s_interieur_x_PP06")
    public WebElement powerSeatsRadioButton;
    @FindBy(xpath = "//div[@data-option-id='PP06']//div[@class='pBox']")
    public WebElement seatPrice;
    @FindBy(xpath = "//div[@class='row']//div[@class='cca-price']")
    public WebElement equipmentPrice;
}
