import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class TestBaseChrome {
    private static ChromeDriverService service;
    public static WebDriver driver;

    @BeforeClass
    public static void createAndStartService () throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("driver","chromedriver"))
                .usingAnyFreePort()
                .build();
        service.start();
        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--kiosk");
        driver = new ChromeDriver(option);


    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @BeforeMethod
    public void setup () {
        driver.get("https://rozetka.com.ua/");
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

}
