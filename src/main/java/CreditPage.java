import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class CreditPage {
    WebDriver driver;

    public CreditPage(WebDriver driver) {
        this.driver = driver;
    }

     Actions actions;


    @FindBy(xpath = "//div[@class='credit-rules-list']/div")
    private List<WebElement> creditRules;

    @FindBy(xpath = "//div[@class='rz-credit-block']/h2[contains (text(),'Условия кредитования')]")
    private WebElement titleOfTheCreditTable;

    @FindBy(xpath = "//td[@class='rz-credit-terms-td rz-credit-terms-td-age'][contains(text(),'21-70')]")
    private WebElement ageAlfaBank;

    public int listOfTheCreditRules() {
      return creditRules.size();
    }

    public String getTitleOfTheCreditTable() {
        return titleOfTheCreditTable.getText();
    }

    public CreditPage scrollPageToAlfaBank() {
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ageAlfaBank);
        actions=new Actions(driver);
        actions.moveToElement(ageAlfaBank);
        actions.perform();
        return this;
    }

}
