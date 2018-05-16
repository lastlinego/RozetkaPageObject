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

    public String checkTheCreditTable() {
        List<WebElement> trCollection = tableElement.findElements(listOfTableItems);

        int rowNum, colNum;
        rowNum = 1;
        colNum = 1;

        for(WebElement trElement : trCollection) {
            List<WebElement> tdCollection = trElement.findElements(By.xpath("td"));
            for (WebElement tdElement : tdCollection) {
                if (tdElement.getText().contains("0,01% на 15 месяцев")) {

                    for (int i = 2; i < driver.findElements(By.xpath("//td[@class='rz-credit-terms-td rz-credit-terms-td-period']")).size(); i++) {
                        if (driver.findElement(By.xpath("(//td[@class='rz-credit-terms-td rz-credit-terms-td-period'])[1]")).getText().contains("15"));
                    }
                        return "all works fine";
                }
            }
                colNum++;
        }
            rowNum++;
        return "test doesn't work";
    }

//    private void array(){
//        list = new HashMap<String,String>;
//        list.put("Льготный период без комиссий, мес","rz-credit-terms-td rz-credit-terms-td-period");
//        list.put("Льготный период без комиссий, мес","rz-credit-terms-td rz-credit-terms-td-period");
//        list.put("Льготный период без комиссий, мес","rz-credit-terms-td rz-credit-terms-td-period");
//        list.put("Льготный период без комиссий, мес","rz-credit-terms-td rz-credit-terms-td-period");
//        list.put("Льготный период без комиссий, мес","rz-credit-terms-td rz-credit-terms-td-period");
//    }







}




