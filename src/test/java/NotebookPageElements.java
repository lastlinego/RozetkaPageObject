import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NotebookPageElements extends TestBase {
    MainPage mainPage;
    NotebooksPage notebooksPage;

    @Test
    public void checkTheBrandsNumber() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickNotebooksBtn();
    }
}
