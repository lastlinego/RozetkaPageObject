import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreditPage {
    WebDriver driver;

    public CreditPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(className = "credit-rules-list")
    private WebElement creditRulesList;

    public CreditPage getNumberOfRules() {
        creditRulesList.getSize();
        return this;
    }

}
