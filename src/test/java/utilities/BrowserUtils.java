package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {
    /**
     * method will select value in dropdown by value name
     * @param element
     * @param value
     */

    public static void selectDropDownBtValue(WebElement element,String value){
        Select select=new Select(element);
        select.selectByValue(value);
    }

    /**
     * meyhod will scroll up or down by the number of pixels
     * that is provided as parameter.
     * Positive number of pixels:Scroll down
     * Negative number of pixels:Scroll down
     *
     * @param pixels
     */
    public static void scrollUpOrDown(int pixels){
        WebDriver driver=Driver.getDriver();
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,"+pixels+")");
    }

    /**
     * Method moves to element in browser
     * @param element
     */
    public static void hoverOver(WebElement element){
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Take screenshot of current page and stores it under screenshots folder
     * @return
     * @throws IOException
     */
    public static String takeScreenShot() throws IOException {
        WebDriver driver=Driver.getDriver();
        File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenShotName=System.currentTimeMillis()+".png";
        String path="/Users/mustafa/IdeaProjects/MindtekTestNGFramework/src/test/resources/screenshots/"+screenShotName;
        File file=new File(path);
        FileUtils.copyFile(screenShot,file);
        return screenShotName;
    }

    /**
     * Method waits explicitly for element to be clickable
     * @param element
     * @return
     */
    public static WebElement waitElementToBeClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        WebElement clickableElement=wait.until(ExpectedConditions.elementToBeClickable(element));
        return clickableElement;
    }

    /**
     *Method waits explicitly for element to be visible
     * @param element
     * @return
     */
    public static WebElement waitElementToBeVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        WebElement visibleElement=wait.until(ExpectedConditions.visibilityOf(element));
        return visibleElement;
    }


}
