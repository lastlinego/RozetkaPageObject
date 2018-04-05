import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registrationUsername = By.xpath("//input[@name='title']");
    private By registrationMail = By.xpath("//input[@name='login']");
    private By registrationPass = By.xpath("//input[@name='password']");
    private By registrationButton = By.xpath("//button[@class='btn-link-i'][contains(text(),'Зарегистрироваться')]");

    public SignUpPage typeUsername(String userName) {
        driver.findElement(registrationUsername).sendKeys(userName);
        return this;
    }

    public SignUpPage typeUserMail(String userEmail) {
        driver.findElement(registrationMail).sendKeys(userEmail);
        return this;
    }

    public SignUpPage typeUserPass(String userPass) {
        driver.findElement(registrationPass).sendKeys(userPass);
        return this;
    }

    public MyProfile clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new MyProfile(driver);
    }

    public MyProfile signUp(String userName, String userEmail, String userPass) {
        this.typeUsername(userName);
        this.typeUserMail(userEmail);
        this.typeUserPass(userPass);
        this.clickRegistrationButton();
        return new MyProfile(driver);
    }


}
