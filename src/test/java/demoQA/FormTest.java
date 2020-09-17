package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FormTest extends BaseTest {

    @Test
    public void test1(){
        driver.get("https://demoqa.com");
        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        //Scroll into button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", formsButton);
        formsButton.click();

        WebElement practiceForm = driver.findElement(By.xpath("//*[text()='Practice Form']"));
        practiceForm.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Oksana");

        List<WebElement> elements = driver.findElements(By.id("hgfhf"));
        boolean isDisplayed = elements.size() > 0;
        System.out.println("Element is   displayed: " + isDisplayed);


    }
}
