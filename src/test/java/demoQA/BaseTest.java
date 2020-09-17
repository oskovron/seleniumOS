package demoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Oksana\\gitStudy\\seleniumOS\\src\\test\\resources\\drivers\\windows\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "drivers/windows/geckodriver.exe");
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setupMethod() throws IllegalAccessException, InstantiationException {
//        Class<ChromeDriver> chromeDriverClass = ChromeDriver.class;
//        WebDriverManager.getInstance(chromeDriverClass).setup();
//        WebDriver driver = chromeDriverClass.newInstance();
    }

    protected void takeScreenshot() {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(
                    screenshot, new File(String.format("target/screenshots/screenshot%d.png", System.currentTimeMillis())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
