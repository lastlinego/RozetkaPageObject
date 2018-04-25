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
        Assert.assertEquals(creditPage.present(), true);

    }
}
