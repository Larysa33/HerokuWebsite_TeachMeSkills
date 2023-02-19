import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortableDataTablesTest extends BaseTest {
    private static final String TABLE1_ROW1_CELL1_TEXT = "Smith";
    private static final String TABLE2_ROW2_CELL1_TEXT = "Bach";
    private static final String TABLE2_HEADING_CELL3_TEXT = "Email";
    private static final String TABLE2_CELL_WITH_LINK_TEXT = "edit delete";

    @BeforeMethod(alwaysRun = true)
    public void getPage() {
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void Table1Raw1Cell1Test() {
        WebElement cellText = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        assertEquals(cellText.getText(), TABLE1_ROW1_CELL1_TEXT, "Text in the first cell is not as expected.");
        //assertEquals(cellText.getText(), TABLE1_ROW1_CELL1_TEXT, String.format("Text in the first cell is %d. Expected text is %d", firstRowFirstCell.getText(), ROW1_CELL1_TEXT));
    }

    @Test
    public void Table2Raw2Cell1Test() {
        WebElement cellText = driver.findElement(By.xpath("//table[2]//tr[2]//td[1]"));
        assertEquals(cellText.getText(), TABLE2_ROW2_CELL1_TEXT, "Text in the first cell is not as expected.");
    }

    @Test
    public void Table2HeadingCell3Test() {
        WebElement cellText = driver.findElement(By.xpath("//table[2]//th[3]"));
        assertEquals(cellText.getText(), TABLE2_HEADING_CELL3_TEXT, "Text in the first cell is not as expected.");
    }

    @Test
    public void Table2CellWithLinkTest() {
        WebElement cellText = driver.findElement(By.xpath("//table[2]//tr[1]//td[6]"));
        assertEquals(cellText.getText(), TABLE2_CELL_WITH_LINK_TEXT, "Text in the first cell is not as expected.");
    }

}
