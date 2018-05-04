import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class TesteBaseChrome {
    private static ChromeDriverService service;
    public static WebDriver driver;

    @BeforeClass
    public static void createAndStartService () throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Users/Sasha/IdeaProjects/pageobjectrozetka/driver/chromedriver"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @BeforeMethod
    public void setupe () {
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
    }

}
