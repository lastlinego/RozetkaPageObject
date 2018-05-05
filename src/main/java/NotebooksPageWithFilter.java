import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotebooksPageWithFilter {
    private WebDriver driver;

    public NotebooksPageWithFilter(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='filter-active-i-link novisited sprite-side']")
    private WebElement nameOfTheFilter;

    @FindBy(xpath = "//a[@class='filter-active-i-link novisited filter-active-i-link-reset sprite-side']")
    private WebElement resetFilterBtn;

    public String getNameOfTheFilter() {
        return nameOfTheFilter.getText();
    }

    public NotebooksPageWithFilter pressResetFilterBtn() {
        resetFilterBtn.click();
        return this;
    }
}
