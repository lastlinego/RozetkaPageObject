import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
     public void login() throws InterruptedException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignInButton();
        mainPage.login("newuser2@yopmail.com", "Gfhjkm123");
        mainPage.clickMyProfileButton();
        MyProfile myProfile = PageFactory.initElements(driver, MyProfile.class);
        Assert.assertEquals(myProfile.getHeadingText(),"Личные данные");

    }

}
