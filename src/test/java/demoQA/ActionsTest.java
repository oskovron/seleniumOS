package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest {

    @Test
    public void test(){
        driver.get("https://demoqa.com/");
        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        //Scroll into button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", formsButton);
        formsButton.click();

        WebElement interactionsLink = driver.findElement(By.xpath("//*[text()='Interactions']/parent::div"));
        js.executeScript("arguments[0].scrollIntoView(true);", interactionsLink);
        interactionsLink.click();

        WebElement droppableForm = driver.findElement(By.xpath("//*[@id='item-3']//*[text()='Droppable']"));
        js.executeScript("arguments[0].scrollIntoView(true);", droppableForm);
        droppableForm.click();

        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement droppableElement = driver.findElements(By.id("droppable")).get(0);
        WebElement droppedText = driver.findElements(By.xpath("//*[@id='droppable']/p")).get(0);

        Actions actions = new Actions(driver);
        actions.clickAndHold(draggableElement);
        actions.moveToElement(droppableElement);
        actions.release();
        actions.build().perform();

        Assert.assertEquals(droppedText.getText(), "Dropped!", "Not dropped.");

        actions.keyDown(Keys.CONTROL)
                .sendKeys(Keys.chord("A")).
                keyUp(Keys.CONTROL)
                .build().perform();
    }

    @Test
    public void ctrA(){
        driver.get("https://demoqa.com/");
        //doesn't work
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.CONTROL)
//                .sendKeys(Keys.chord("A")).
//                keyUp(Keys.CONTROL)
//                .build().perform();

        driver.findElement(By.xpath("//body"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    @Test
    public void ctrCctrV(){
        
    }

}
