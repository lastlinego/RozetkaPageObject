import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()='Регистрация']")
    private WebElement signUpButton;

    @FindBy(xpath = "//a[text()='Войти в личный кабинет']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@class='input-text auth-input-text'][@name='login']")
    private WebElement signInPopUpEmail;

    @FindBy(xpath = "//div[@class='auth-f-i']//input[@type='password']")
    private WebElement signInPopUpPass;

    @FindBy(xpath = "//button[@type='submit'][contains(text(),'Войти')]")
    private WebElement signInPopUpButton;

    @FindBy(xpath = "//span[@id='header_user_menu_parent']")
    private WebElement myProfileButton;

    @FindBy(xpath = "//input[@class='rz-header-search-input-text passive']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='btn-link-i js-rz-search-button']")
    private WebElement searchButton;


    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public LoginPopUp clickSignInButton() {
        signInButton.click();
        return new LoginPopUp(driver);
    }

    public MainPage typeUserEmail(String userEmail) {
        signInPopUpEmail.sendKeys(userEmail);
        return this;
    }

    public MainPage typeUserPass(String userPass) {
        signInPopUpPass.sendKeys(userPass);
        return this;
    }

    public MyProfile clickSignInPopUpButton() {
        signInPopUpButton.click();
        return new MyProfile(driver);
    }

    public SearchResults typeInSearchField(String searchRequest) {
        searchField.sendKeys(searchRequest);
        return new SearchResults(driver);
    }

    public SearchResults clickSearchButton() {
        searchButton.click();
        return new SearchResults(driver);
    }

    public SearchResults searchSomething(String searchRequest) {
        this.typeInSearchField(searchRequest);
        this.clickSearchButton();
        return new SearchResults(driver);
    }

    public MyProfile clickMyProfileButton() throws InterruptedException {
        myProfileButton.click();
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


