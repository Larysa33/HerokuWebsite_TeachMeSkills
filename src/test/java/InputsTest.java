import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InputsTest extends BaseTest {
    private WebElement input;

    @BeforeClass
    public void getInputField() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        input = driver.findElement(By.tagName("input"));
    }

    @BeforeMethod(alwaysRun = true)
    public void clearField() {
        input.clear();
    }

    @Test
    public void ArrowsInputTest() {
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "-1", "Check the inputted value.");
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "0", "Check the inputted value.");
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "1", "Check the inputted value.");
    }

    @Test
    public void checkDecimalDigitsInput() {
        input.sendKeys("9.289");
        assertEquals(input.getAttribute("value"), "9.289", "Check the inputted value.");
    }

    @Test
    public void LatinLettersInputTest() {
        input.sendKeys("abcd");
        assertEquals(input.getAttribute("value"), "abcd", "Check the inputted value.");
    }

    @Test
    public void CyrillicLettersInputTest() {
        input.sendKeys("абвг");
        assertEquals(input.getAttribute("value"), "abcd", "Check the inputted value.");
    }

    @Test
    public void SpecialSymbolsTest() {
        input.sendKeys("*#!?");
        assertEquals(input.getAttribute("value"), "*#!?", "Check the inputted value.");
    }
}
