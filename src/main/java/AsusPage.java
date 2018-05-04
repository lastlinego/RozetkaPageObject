import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AsusPage {
    WebDriver driver;

    public AsusPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='g-i-tile g-i-tile-catalog']")
    private List<WebElement> defaultAsusItems;

    @FindBy(xpath = "//div[@id='filter_viewlist']")
    private WebElement listViewBtn;

    @FindBy(xpath = "//span[@class='g-i-more-link-text']")
    private WebElement loadMoreItemsBtn;

    @FindBy(xpath = "//div[@class='g-i-list available'] | //div[@class='g-i-list out_of_stock']")
    private List<WebElement> listOfTheItems;

    public int listOfTheAsusItems() {
        return defaultAsusItems.size();
    }

    public AsusPage changeViewToList() {
        listViewBtn.click();
        return this;
    }

    public int getSizeOfTheAsusDefaultList() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='g-i-more-link-text']")));
        return listOfTheItems.size();
    }

}
