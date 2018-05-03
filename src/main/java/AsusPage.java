import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AsusPage {
    WebDriver driver;

    public AsusPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='g-i-tile g-i-tile-catalog']")
    private List<WebElement> defaultAsusItems;

    public int listOfTheAsusItems() {
        return defaultAsusItems.size();
    }

}
