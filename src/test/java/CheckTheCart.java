import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTheCart extends TestBaseChrome {
    MainPage mainPage;

    @Test
    public void CheckCart() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickCartButton();
        Assert.assertEquals(mainPage.getCartHeading(), "Корзина пуста");
    }
}
