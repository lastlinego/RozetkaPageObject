import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    Actions actions;

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

    @FindBy(xpath = "//span[@id='header_user_menu_parent']/a[@name='profile']")
    private WebElement myProfileButton;

    @FindBy(xpath = "//input[@class='rz-header-search-input-text passive']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='btn-link-i js-rz-search-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='xhr'][contains(text(), 'Корзина')]")
    private WebElement cartButton;

    @FindBy(xpath = "//h2[@class='empty-cart-title inline sprite-side']")
    private WebElement cartHeading;

    @FindBy(xpath = "//html//div[@class='clearfix body-header-row-top']//li[2]")
    private WebElement creditButton;

    @FindBy(xpath = "//a[@href='https://rozetka.com.ua/computers-notebooks/c80253/']")
    private WebElement categoryNotebooksBtn;

    @FindBy(xpath = "//li[@class='f-menu-sub']//a[@href='https://rozetka.com.ua/notebooks/c80004/']")
    private WebElement notebooksBtn;


    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public CreditPage clickCreditButton() {
        creditButton.click();
        return new CreditPage(driver);
    }

    public MainPage clickCartButton() {
        cartButton.click();
        return this;
    }

    public String getCartHeading() {
        return cartHeading.getText();
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
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='header_user_menu_parent']/a[@name='profile']")));
        myProfileButton.click();
        return new MyProfile(driver);
    }

    public MyProfile login(String userEmail, String userPass) throws InterruptedException {
        this.typeUserEmail(userEmail);
        this.typeUserPass(userPass);
        this.clickSignInPopUpButton();
        return new MyProfile(driver);
    }

    public NotebooksPage clickNotebooksBtn() {
        actions = new Actions(driver);
        actions.moveToElement(categoryNotebooksBtn).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='f-menu-sub']//a[@href='https://rozetka.com.ua/notebooks/c80004/']")));
        notebooksBtn.click();
        return new NotebooksPage(driver);
    }
}


