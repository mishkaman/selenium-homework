import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebElementsTest {
    private WebDriver driver;

    @BeforeClass
    public void setupdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void hw2() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add Element')]"));

        Thread.sleep(2000);

        addButton.click();

        Thread.sleep(1000);

        addButton.click();

        Thread.sleep(1000);

        addButton.click();

        Thread.sleep(2000);

        WebElement lastDeleteButton = driver.findElement(By.xpath("(//button[contains(text(),'Delete')])[last()]"));
        System.out.println("Last Delete button: " + lastDeleteButton.getText());

        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[class^='added']"));
        if (!deleteButtons.isEmpty()) {
            WebElement lastDeleteButton2 = deleteButtons.get(deleteButtons.size() - 1);
            System.out.println("Last Delete button: " + lastDeleteButton.getText());
        } else {
            System.out.println("No 'Delete' buttons with class starting with 'added' found.");
        }

        WebElement lastDeleteButton3 = driver.findElement(By.xpath("//button[contains(@class, 'manually') and contains(text(), 'Delete')][last()]"));
        System.out.println("Last Delete button: " + lastDeleteButton.getText());

        Thread.sleep(2000);

        driver.get("http://the-internet.herokuapp.com/challenging_dom");

        WebElement elementToFind = driver.findElement(By.xpath("//td[text()='Apeirian9']/following-sibling::td[2]"));
        String loremValue = elementToFind.getText();
        System.out.println("Lorem value: " + loremValue);

        WebElement nextElement = elementToFind.findElement(By.xpath("following-sibling::td[1]"));
        String nextElementText = nextElement.getText();
        System.out.println("Next element : " + nextElementText);

        driver.quit();
    }
}
