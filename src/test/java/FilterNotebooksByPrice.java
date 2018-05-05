import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterNotebooksByPrice extends TestBaseChrome {
    MainPage mainPage;
    NotebooksPage notebooksPage;
    NotebooksPageWithFilter notebooksPageWithFilter;

    @Test
    public void filterNotebooksByPrice() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickNotebooksBtn();
        notebooksPage = PageFactory.initElements(driver, NotebooksPage.class);
        notebooksPage.clickFilter10kBtn();
        notebooksPageWithFilter = PageFactory.initElements(driver, NotebooksPageWithFilter.class);
        Assert.assertEquals(notebooksPageWithFilter.getNameOfTheFilter(), "от 10000 до 12999 грн");
        notebooksPageWithFilter.pressResetFilterBtn();

    }

}
