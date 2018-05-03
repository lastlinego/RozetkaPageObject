import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreditElements extends TestBase {
    MainPage mainPage;
    CreditPage creditPage;

    @Test
    public void creditPageElements() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickCreditButton();
        creditPage = PageFactory.initElements(driver, CreditPage.class);
        Assert.assertEquals(creditPage.listOfTheCreditRules(),4);
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

}
