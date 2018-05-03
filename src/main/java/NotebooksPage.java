import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NotebooksPage {
    private WebDriver driver;

    public NotebooksPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='pab-cell pab-img-45']")
    private List<WebElement> brandsList;

    public int numberOfTheBrands() {
        return brandsList.size();
    }
}
