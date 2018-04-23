import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='title']")
    private WebElement registrationUsername;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement registrationMail;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement registrationPass;

    @FindBy(xpath = "//button[@class='btn-link-i'][contains(text(),'Зарегистрироваться')]")
    private WebElement registrationButton;


    private SignUpPage typeUsername(String userName) {
        registrationUsername.sendKeys(userName);
        return this;
    }

    private SignUpPage typeUserMail(String userEmail) {
        registrationMail.sendKeys(userEmail);
        return this;
    }

    private SignUpPage typeUserPass(String userPass) {
        registrationPass.sendKeys(userPass);
        return this;
    }

    private MyProfile clickRegistrationButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn-link-i'][contains(text(),'Зарегистрироваться')]")));
        registrationButton.click();
        return new MyProfile(driver);
    }

    public MyProfile signUp(String userName, String userEmail, String userPass) throws InterruptedException {
        this.typeUsername(userName);
        this.typeUserMail(userEmail);
        this.typeUserPass(userPass);
        this.clickRegistrationButton();
        return new MyProfile(driver);
    }

}
