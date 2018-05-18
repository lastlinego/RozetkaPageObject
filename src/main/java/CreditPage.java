import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.NoSuchElementException;


public class CreditPage {
    WebDriver driver;
    HashMap<String, String> list;

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

    @FindBy(className = "rz-credit-terms-table")
    private WebElement tableElement1;

    private By listOfTableItems = By.xpath("//div[@class='rz-credit-block'][1]/table/tbody/tr[@class='rz-credit-terms-tr']");

    @FindBy(xpath = "//td[@class='rz-credit-terms-td']")
    List<WebElement> columnNameList1;

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

    public String getAgeAlfaBank() {
        return ageAlfaBank.getText();
    }

    @FindBy(className = "rz-credit-terms-table")
    private WebElement tableElement;

    By rows = By.xpath("//tr[@class='rz-credit-terms-tr']");

    @FindBy (xpath = "//td[@class='rz-credit-terms-td rz-credit-terms-td-deposit']")
    List<WebElement> depositTermsList;

    By columnNameList = By.xpath("//td[@class='rz-credit-terms-td']");


    public String checkTheCreditTable(String nameOfTheProductPackage, String columnName ) {
        List<WebElement> rowList = tableElement.findElements(rows);
        List<WebElement> columnList = tableElement.findElements(columnNameList);

        for (WebElement row : rowList) {
            if (row.getText().contains(nameOfTheProductPackage)) {
                for (int i = 0; i < columnList.size(); i++) {
                    WebElement result = columnList.get(i);
                    if (result.getText().contains(columnName)) {
                        return row.findElements(By.className("rz-credit-terms-td")).get(i).getText();
                    }
                }
            }
        }

        return "not found";

    }

}





