import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfile {
    private WebDriver driver;

    public MyProfile(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//h1[contains(text(),'Личные данные')]");

    public String getHeadingText() {
        return driver.findElement(heading).getText();

    }

}
