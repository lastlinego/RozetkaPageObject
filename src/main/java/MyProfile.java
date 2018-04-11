import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyProfile {
    private WebDriver driver;

    public MyProfile(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[contains(text(),'Личные данные')]")
    private WebElement heading;

    public String getHeadingText() throws InterruptedException {
        Thread.sleep(1500);
        return heading.getText();

    }

}
