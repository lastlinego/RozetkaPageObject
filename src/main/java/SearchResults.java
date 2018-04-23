import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {
   private WebDriver driver;

    public SearchResults(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class='sprite-side btn-link btn-link-green detail-buy-btn-link']/button[@type='submit']")
    private WebElement buyButton;

    @FindBy(xpath = "//a[@name='goods-link'][contains(text(),'Встраиваемая посудомоечная машина BOSCH SMV 24 AX ')]")
    private WebElement nameOfTheLot;

    public SearchResults clickBuyButton() {
        buyButton.click();
        return this;
    }

    public String getNameOfTheLot() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@name='goods-link'][contains(text(),'Встраиваемая посудомоечная машина BOSCH SMV 24 AX ')]")));
        return nameOfTheLot.getText();
    }


}
