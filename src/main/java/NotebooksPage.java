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

    @FindBy(xpath = "//a[@class='m-cat-subl-i-link'][contains(text(), 'Asus')]")
    private WebElement asusBtn;

    @FindBy(xpath = "//a[@class='m-cat-subl-i-link'][contains(text(),'10 000 грн - 12 999 грн')]")
    private WebElement filter10kBtn;

    public int numberOfTheBrands() {
        return brandsList.size();
    }

    public AsusPage clickAsusBtn() {
        asusBtn.click();
        return new AsusPage(driver);
    }

    public NotebooksPageWithFilter clickFilter10kBtn() {
        filter10kBtn.click();
        return new NotebooksPageWithFilter(driver);
    }


}
