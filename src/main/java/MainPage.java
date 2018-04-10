import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signUpButton = By.xpath("//a[text()='Регистрация']");
    private By signInButton = By.xpath("//a[text()='Войти в личный кабинет']");
    private By signInPopUpEmail = By.xpath("//input[@class='input-text auth-input-text'][@name='login']");
    private By signInPopUpPass = By.xpath("//div[@class='auth-f-i']//input[@type='password']");
    private By signInPopUpButton = By.xpath("//button[@type='submit'][contains(text(),'Войти')]");
    private By myProfileButton = By.xpath("//span[@id='header_user_menu_parent']");

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public LoginPopUp clickSignInButton() {
      driver.findElement(signInButton).click();
      return new LoginPopUp(driver);
    }

    public MainPage typeUserEmail(String userEmail) {
        driver.findElement(signInPopUpEmail).sendKeys(userEmail);
        return this;
    }

    public MainPage typeUserPass(String userPass) {
        driver.findElement(signInPopUpPass).sendKeys(userPass);
        return this;
    }

    public MyProfile clickSignInPopUpButton() {
        driver.findElement(signInPopUpButton).click();
        return new MyProfile(driver);
    }

    public MyProfile clickMyProfileButton() throws InterruptedException {
        driver.findElement(myProfileButton).click();
        return new MyProfile(driver);
    }

    public MyProfile login(String userEmail, String userPass) throws InterruptedException {
        this.typeUserEmail(userEmail);
        this.typeUserPass(userPass);
        this.clickSignInPopUpButton();
        Thread.sleep(1500);
        return new MyProfile(driver);
    }




}
