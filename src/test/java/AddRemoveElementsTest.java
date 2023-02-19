import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class AddRemoveElementsTest extends BaseTest {
    private static final int LEFT_DELETE_BUTTONS = 1;

    @Test
    public void AddRemoveElementsTest(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        deleteButton.click();
        deleteButton.click(); //увидеть сообщение об ошибке
        List<WebElement> displayedDeleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(displayedDeleteButtons.size(), LEFT_DELETE_BUTTONS, "Expected amount of displayed 'Delete' buttons is " + LEFT_DELETE_BUTTONS);
                //String.format("Amount of displayed 'Delete' buttons is %d. Expected amount is %d", displayedDeleteButtons.size(), LEFT_DELETE_BUTTONS));
    }
}
