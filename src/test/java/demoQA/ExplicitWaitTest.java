package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitTest extends BaseTest{

    @Test
    public void test(){
        driver.get("https://joinuplviv.com/");
        //This is explicit wait
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='av-siteloader']")));

        WebElement element = driver.findElement(By.xpath("//select[@ng-if='selectedCountry.name']"));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Дніпро");
    }

}
