import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotebookPageElements extends TesteBaseChrome {
    MainPage mainPage;
    NotebooksPage notebooksPage;
    AsusPage asusPage;


    @Test
    public void checkTheBrandsNumber() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickNotebooksBtn();
        notebooksPage = PageFactory.initElements(driver, NotebooksPage.class);
        Assert.assertEquals(notebooksPage.numberOfTheBrands(), 8);
    }

    @Test
    public void checkTheAsusItems() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickNotebooksBtn();
        notebooksPage = PageFactory.initElements(driver, NotebooksPage.class);
        notebooksPage.clickAsusBtn();
        asusPage = PageFactory.initElements(driver, AsusPage.class);
        Assert.assertEquals(asusPage.listOfTheAsusItems(), 32);

    }

    @Test
    public void changeViewOfTheAsusPage() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickNotebooksBtn();
        notebooksPage = PageFactory.initElements(driver, NotebooksPage.class);
        notebooksPage.clickAsusBtn();
        asusPage = PageFactory.initElements(driver, AsusPage.class);
        asusPage.changeViewToList();
        Assert.assertEquals(asusPage.getSizeOfTheAsusDefaultList(), 16);

    }
}
