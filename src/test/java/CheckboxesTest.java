import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class CheckboxesTest extends BaseTest {
    List<WebElement> elementsOfCheckbox;
    private WebElement firstCheckbox;
    private WebElement secondCheckbox;

    @BeforeClass
    public void checkboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        elementsOfCheckbox = driver.findElements(By.cssSelector("[type = checkbox]"));
        firstCheckbox = elementsOfCheckbox.get(0);
        secondCheckbox = elementsOfCheckbox.get(1);
    }

    @Test
    public void firstCheckboxTest() {
        if (firstCheckbox.isDisplayed()) {
            assertFalse(firstCheckbox.isSelected(), "First checkbox should be unchecked.");
            firstCheckbox.click();
            assertTrue(firstCheckbox.isSelected(), "First checkbox should be checked.");
        } else {
            System.out.println("There's no first checkbox on the page.");
        }
    }

    @Test
    public void secondCheckboxTest() {
        if (secondCheckbox.isDisplayed()) {
            assertTrue(secondCheckbox.isSelected(), "Second checkbox should be checked.");
            secondCheckbox.click();
            assertFalse(secondCheckbox.isSelected(), "Second checkbox should be unchecked.");
        } else {
            System.out.println("There's no second checkbox on the page.");
        }
    }

}
