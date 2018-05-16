import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.NoSuchElementException;


public class CreditPage {
    WebDriver driver;
    HashMap<String,String> list;

    public CreditPage(WebDriver driver) {
        this.driver = driver;
    }

     Actions actions;


    @FindBy(xpath = "//div[@class='credit-rules-list']/div")
    private List<WebElement> creditRules;

    @FindBy(xpath = "//td[@class='rz-credit-terms-td rz-credit-terms-td-period']")
    private List<WebElement> periodsWithoutTax;

    @FindBy(xpath = "//div[@class='rz-credit-block']/h2[contains (text(),'Условия кредитования')]")
    private WebElement titleOfTheCreditTable;

    @FindBy(xpath = "//td[@class='rz-credit-terms-td rz-credit-terms-td-age'][contains(text(),'21-70')]")
    private WebElement ageAlfaBank;

    By tableElement1 = By.className("rz-credit-terms-table");

    @FindBy(className = "rz-credit-terms-table")
    private WebElement tableElement;


    private By listOfTableItems = By.xpath("//div[@class='rz-credit-block'][1]/table/tbody/tr[@class='rz-credit-terms-tr']");

    public int listOfTheCreditRules() {
      return creditRules.size();
    }

    public String getTitleOfTheCreditTable() {
        return titleOfTheCreditTable.getText();
    }

    public CreditPage scrollPageToAlfaBank() {
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ageAlfaBank);
        actions = new Actions(driver);
        actions.moveToElement(ageAlfaBank);
        actions.perform();
        return this;
    }

    public String getAgeAlfaBank(){
        return ageAlfaBank.getText();
    }

    public String checkTheCreditTable(String nameOfTheProductPackage, String creditPeriodWithoutTheTax ) {
        List<WebElement> trCollection = tableElement.findElements(listOfTableItems);

        int rowNum, colNum;
        rowNum = 1;
        colNum = 1;

        for(WebElement trElement : trCollection) {
            List<WebElement> tdCollection = trElement.findElements(By.xpath("td"));
            for (WebElement tdElement : tdCollection) {
                if (tdElement.getText().equals(nameOfTheProductPackage)) {

                    for(WebElement trElement1 : trCollection) {
                        List<WebElement> tdCollection1 = trElement.findElements(By.xpath("td"));
                        for (WebElement tdElement1 : tdCollection) {
                            if (tdElement1.getText().equals(creditPeriodWithoutTheTax)){
                                return "all works fine";
                            }
                        }

                    }

                }
            }
                colNum++;
        }
            rowNum++;
        return "test doesn't work";
    }

}




