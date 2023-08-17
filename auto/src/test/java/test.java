import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertTrue;

public class test {
    private WebDriver driver;

    @BeforeClass
    public void setupdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void testAlignCenterIcon() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("http://the-internet.herokuapp.com/iframe");

        // Find the iframe element
        WebElement iframe = driver.findElement(By.tagName("iframe"));

        // Switch to the iframe context
        driver.switchTo().frame(iframe);

        // Find and click the 'Align Center' icon
        WebElement alignCenterIcon = driver.findElement(By.xpath("//button[@id='mceu_15']"));
        alignCenterIcon.click();

        // Perform assertions
        assertTrue("Alignment was not centered.", isTextCenterAligned(driver));

        // Close the browser
        driver.quit();
    }

    private boolean isTextCenterAligned(WebDriver driver) {
        WebElement centeredText = driver.findElement(By.xpath("//p[@style='text-align: center;']"));
        return centeredText != null;
    }
}
