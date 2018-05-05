import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBaseChrome {
    MainPage mainPage;
    MyProfile myProfile;

    @Test
     public void login() throws InterruptedException {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignInButton();
        mainPage.login("newuser2@yopmail.com", "Gfhjkm123");
        mainPage.clickMyProfileButton();
        myProfile = PageFactory.initElements(driver, MyProfile.class);
        Assert.assertEquals(myProfile.getHeadingText(),"Личные данные");

    }

}
