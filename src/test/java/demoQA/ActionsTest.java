package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest extends BaseTest {
    JavascriptExecutor js;
    Actions actions;

    @Test
    public void test(){
        driver.get("https://demoqa.com/");
        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        //Scroll into button
        js = (JavascriptExecutor) driver;
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

        actions = new Actions(driver);
//        actions.clickAndHold(draggable);
//        actions.moveToElement(droppable);
        actions.dragAndDrop(draggableElement,droppableElement);
//        actions.release();
        actions.build().perform();

        Assert.assertEquals(droppedText.getText(), "Dropped!", "Not dropped.");

        actions.contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
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
    public void mouseHoverTest(){
//        driver.get("https://www.toolsqa.com/selenium-webdriver/mouse-hover-action/");
//        actions = new Actions(driver);
//        WebElement tutorialsMenuItem = driver.findElements(By.xpath("//*[text()='Tutorial']")).get(0);
//        actions.moveToElement(tutorialsMenuItem).perform();
//
//        WebElement qaPracticesSubMenuItem = driver.findElement(By.xpath("//*[text()='QA Practices']"));
//
//        Assert.assertEquals(qaPracticesSubMenuItem.getText(), "QA Practices", "menu not open.");


        driver.get("https://demoqa.com/slider/");
        System.out.println("demoqa webpage Displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Adding wait
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Instantiate Action Class
        Actions actions = new Actions(driver);
        //Retrieve WebElemnt 'slider' to perform mouse hover
        WebElement slider = driver.findElement(By.xpath("//*[@type='range']"));
        //Move mouse to x offset 50 i.e. in horizontal direction
        actions.moveToElement(slider,70,0).perform();
        slider.click();
        System.out.println("Moved slider in horizontal directions");

    }

    @Test
    public void ctrCctrV(){
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement hobbilesText = driver.findElement(By.xpath("//*[text()='Sports']"));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", hobbilesText);
        hobbilesText.sendKeys(Keys.chord(Keys.CONTROL, "c"));
        driver.findElement(By.xpath("//*[@placeholder='Current Address']"))
                .sendKeys(Keys.CONTROL, "v");

    }

    @Test
    public void ctrCctrV2(){
        driver.get("https://demoqa.com/text-box");
        WebElement text1 = driver.findElement(By.id("userName-label"));
        text1.sendKeys(Keys.CONTROL, "a");
        text1.sendKeys(Keys.CONTROL, "c");
    }

}
