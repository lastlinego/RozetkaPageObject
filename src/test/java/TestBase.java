import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBase {
    WebDriver driver;
    @BeforeClass
    public void setupe () {
        driver = new ChromeDriver();

        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown () {
//        driver.quit();
//        driver = null;
    }
}
