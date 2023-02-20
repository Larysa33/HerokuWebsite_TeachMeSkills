import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class NotificationsTest extends BaseTest {

    @Test
    public void NotificationMessageTest() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.cssSelector("[href = '/notification_message']")).click();
        WebElement message = driver.findElement(By.id("flash"));
        List<String> responses = List.of("Action successful\n×", "Action unsuccesful, please try again\n×");
        assertTrue(responses.contains(message.getText().trim()));
    }
}
