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

    private SignUpPage typeUsername(String userName) {
        driver.findElement(registrationUsername).sendKeys(userName);
        return this;
    }

    private SignUpPage typeUserMail(String userEmail) {
        driver.findElement(registrationMail).sendKeys(userEmail);
        return this;
    }

    private SignUpPage typeUserPass(String userPass) {
        driver.findElement(registrationPass).sendKeys(userPass);
        return this;
    }

    private MyProfile clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new MyProfile(driver);
    }

    public MyProfile signUp(String userName, String userEmail, String userPass) throws InterruptedException {
        this.typeUsername(userName);
        this.typeUserMail(userEmail);
        this.typeUserPass(userPass);
        this.clickRegistrationButton();
        Thread.sleep(1500);
        return new MyProfile(driver);
    }


}
