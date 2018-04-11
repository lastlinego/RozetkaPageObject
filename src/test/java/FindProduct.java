import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FindProduct extends TestBase {

    @Test
    public void searchProduct() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.searchSomething("BOSCH SMV 24 AX 00 K");
        SearchResults searchResults = PageFactory.initElements(driver, SearchResults.class);

    }

}
