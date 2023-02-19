import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DropDownTest extends BaseTest {
    Select dropDown;
    private List<WebElement> options;
    private WebElement firstOption;
    private WebElement secondOption;
    private WebElement thirdOption;

    @BeforeMethod
    public void dropDownSetUp() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        options = dropDown.getOptions();
        firstOption = options.get(0);
        secondOption = options.get(1);
        thirdOption = options.get(2);
    }

    //Проверка наличия всех опций на странице
    @Test
    public void whetherAllOptionsDisplayed() {
        assertEquals(firstOption.getText(), "Please select an option", "The option is not shown.");
        assertEquals(secondOption.getText(), "Option 1", "The option is not shown.");
        assertEquals(thirdOption.getText(), "Option 2", "The option is not shown.");
    }

    //Проверка что первый элемент недоступен и выбран
    @Test
    public void firstOptionTest() {
        if (firstOption.isDisplayed()) {
            assertFalse(firstOption.isEnabled(), "The option is not disabled.");
            assertTrue(firstOption.isSelected(), "The option is not selected.");
        } else {
            System.out.println("There's no such an option on the page.");
        }
    }

    //Выбрать второй элемент и проверить что он выбран
    @Test
    public void secondOptionTest() {
        if (secondOption.isDisplayed()) {
            assertFalse(secondOption.isSelected(), "The option is selected.");
            dropDown.selectByValue("1");
            assertTrue(secondOption.isSelected(), "The option is not selected.");
        } else {
            System.out.println("There's no such an option on the page.");
        }
    }

    //Выбрать третий элемент и проверить что он выбран
    @Test
    public void thirdOptionTest() {
        if (thirdOption.isDisplayed()) {
            assertFalse(thirdOption.isSelected(), "The option is selected.");
            dropDown.selectByValue("1");
            assertTrue(thirdOption.isSelected(), "The option is not selected.");
        } else {
            System.out.println("There's no such an option on the page.");
        }
    }

}
