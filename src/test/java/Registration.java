import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends TestBase {
    MainPage mainPage;
    SignUpPage signUpPage;
    MyProfile myProfile;

    @Test
    public void registration() throws InterruptedException {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignUpButton();
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.signUp("newuser", "newuser4@yopmail.com", "Gfhjkm123");
        myProfile = PageFactory.initElements(driver, MyProfile.class);
        Assert.assertEquals(myProfile.getHeadingText(),"Личные данные");

    }
}
