package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenshotTest extends BaseTest {

    @Test
    public void test(){
        takeScreenshot();
        driver.get("https://demoqa.com/");
        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        Assert.fail("Failed for screenshot");
    }
}
