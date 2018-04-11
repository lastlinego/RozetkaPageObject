import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends TestBase {

    @Test
    public void registration() throws InterruptedException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignUpButton();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.signUp("newuser", "newuser4@yopmail.com", "Gfhjkm123");
        MyProfile myProfile = PageFactory.initElements(driver, MyProfile.class);
        Assert.assertEquals(myProfile.getHeadingText(),"Личные данные");

    }
}
