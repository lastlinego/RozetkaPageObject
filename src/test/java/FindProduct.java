import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FindProduct extends TestBase {
    MainPage mainPage;
    SearchResults searchResults;

    @Test
    public void searchProduct() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.searchSomething("BOSCH SMV 24 AX 00 K");
        searchResults = PageFactory.initElements(driver, SearchResults.class);
        searchResults.clickBuyButton();

    }

}
