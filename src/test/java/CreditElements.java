import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CreditElements extends TestBaseChrome {
    MainPage mainPage;
    CreditPage creditPage;

    @Test
    public void creditPageElements() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickCreditButton();
        creditPage = PageFactory.initElements(driver, CreditPage.class);
        Assert.assertEquals(creditPage.listOfTheCreditRules(), 4);
    }

    @Test
    public void creditTableTitle() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickCreditButton();
        creditPage = PageFactory.initElements(driver, CreditPage.class);
        Assert.assertEquals(creditPage.getTitleOfTheCreditTable(), "Условия кредитования");

    }

    @Test
    public void checkTheAgeAlfaBank() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickCreditButton();
        creditPage = PageFactory.initElements(driver, CreditPage.class);
        creditPage.scrollPageToAlfaBank();
        Assert.assertEquals(creditPage.getAgeAlfaBank(), "21-70");

    }

    @Test
    public void checkTheTable() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickCreditButton();
        creditPage = PageFactory.initElements(driver, CreditPage.class);
        Assert.assertEquals(creditPage.checkTheCreditTable("0,01% на 15 месяцев", "Льготный период"), "15");

    }
}
