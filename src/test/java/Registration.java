import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends TestBase {
    MainPage mainPage;
    SignUpPage signUpPage;
    MyProfile myProfile;

    @Test
    void registration() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickSignUpButton();
        signUpPage = new SignUpPage(driver);
        signUpPage.signUp("newuser", "newuser2@yopmail.com", "Gfhjkm123");
        myProfile = new MyProfile(driver);
        Assert.assertEquals(myProfile.getHeadingText(),"Личные данные");

    }
}
