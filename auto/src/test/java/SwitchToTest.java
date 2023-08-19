import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwitchToTest {
    private WebDriver driver;

    @BeforeClass
    public void setupdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void smth4() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        WebElement typeBar = driver.findElement(By.id("tinymce"));

        Thread.sleep(1000);

        typeBar.clear();

        Thread.sleep(1000);

        typeBar.sendKeys("Here Goes");

        Thread.sleep(1000);


        driver.switchTo().defaultContent();


        WebElement alignCenterIcon = driver.findElement(By.xpath("//button[@title='Align center']"));
        alignCenterIcon.click();


        Thread.sleep(3000);


        driver.get("https://demoqa.com/alerts");

        WebElement alertClicker = driver.findElement(By.id("alertButton"));

        alertClicker.click();

        Thread.sleep(1000);

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alerts");
        }
    }


}
