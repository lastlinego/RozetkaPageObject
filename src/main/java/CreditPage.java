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

    @FindBy(xpath = "//html//div[@class='credit-rules-list']/div[1]")
    private WebElement creditRulesObject1;

    @FindBy(xpath = "//html//div[@class='credit-rules-list']/div[2]")
    private WebElement creditRulesObject2;

    @FindBy(xpath = "//html//div[@class='credit-rules-list']/div[3]")
    private WebElement creditRulesObject3;

    @FindBy(xpath = "//html//div[@class='credit-rules-list']/div[4]")
    private WebElement creditRulesObject4;

    public boolean present() {
        try {
            driver.findElement(By.xpath("//html//div[@class='credit-rules-list']/div[1]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
