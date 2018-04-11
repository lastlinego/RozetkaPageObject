import org.testng.annotations.Test;

public class FindProduct extends TestBase {
    MainPage mainPage;
    SearchResults searchResults;

    @Test
    void searchProduct() {
        mainPage = new MainPage(driver);
        mainPage.searchSomething("BOSCH SMV 24 AX 00 K");
        searchResults = new SearchResults(driver);

    }

}
