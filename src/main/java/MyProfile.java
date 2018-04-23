import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyProfile {
    private WebDriver driver;
    WebElement wait;

    @FindBy(xpath = "//h1[contains(text(),'Личные данные')]")
    private WebElement heading;

    public MyProfile(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeadingText() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Личные данные')]")));
        return heading.getText();
    }
}
