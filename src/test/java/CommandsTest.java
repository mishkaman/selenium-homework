import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CommandsTest {
    private WebDriver driver;

    @BeforeClass
    public void setupdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testOpenBrowserAndNavigate() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
        button.click();

        Thread.sleep(3000);

        WebElement inpField = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        inpField.sendKeys("bootcamp");

        Thread.sleep(3000);

        inpField.clear();

        Thread.sleep(2000);

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        int columnAY = columnA.getLocation().getY();
        int columnBY = columnB.getLocation().getY();

        if (columnAY == columnBY) {
            System.out.println("Y coordinates are the same");
        } else {
            System.out.println("Y coordinates aren't the same");
        }

        //System.out.println(columnAY == columnBY);

    }
}
