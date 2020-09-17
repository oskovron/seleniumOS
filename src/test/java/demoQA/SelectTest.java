package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectTest extends BaseTest {

    @Test
    public void test(){
//        driver.get("https://joinuplviv.com/");
//        WebElement countryDropdown = driver.findElement(By.xpath("//*[@ng-if='selectedCountry.name']"));
//        Select select = new Select(countryDropdown);
//        select.selectByVisibleText("Харків");

        driver.get("http://demoqa.com");
        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", formsButton);
        formsButton.click();

        WebElement practiceForm = driver.findElement(By.xpath("//*[text()='Practice Form']"));
        practiceForm.click();
        WebElement selectStateDropdown = driver.findElement(By.xpath("//div[@id='state']//*[@width='20']"));
        js.executeScript("arguments[0].scrollIntoView(true);", selectStateDropdown);
        selectStateDropdown.click();

        WebElement inputField = driver.findElement(By.xpath("//*[@id='state']//input"));
        inputField.sendKeys("Raj");
        inputField.sendKeys(Keys.RETURN); //press ENTER
    }
}
