import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class CreditPage {
    WebDriver driver;

    public CreditPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='credit-rules-list']/div")
    private List<WebElement> creditRules;

    public int listOfTheCreditRules() {
      return creditRules.size();
    }
}
