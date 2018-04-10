import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {
    MyProfile myProfile;
    MainPage mainPage;

    @Test
    void login() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickSignInButton();
        mainPage.login("newuser2@yopmail.com", "Gfhjkm123");
        mainPage.clickMyProfileButton();
        myProfile = new MyProfile(driver);
        Assert.assertEquals(myProfile.getHeadingText(),"Личные данные");

    }

}
