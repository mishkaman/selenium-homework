import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exceptions {
    private WebDriver driver;

    @BeforeClass
    public void setupdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void TimeoutExceptionExample() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        driver.manage().window().maximize();

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();


        try {
            WebDriverWait wait = new WebDriverWait(driver, 4);


            wait.until(ExpectedConditions.alertIsPresent());


            driver.switchTo().alert().accept();
            System.out.println("Accepted");
        } catch (TimeoutException e) {
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }


    }
    @Test
    public void NoAlertPresentExceptionExample() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();



        try {
            WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
            alertButton.click();
            Alert alert = driver.switchTo().alert();
            alert.accept();



        } catch (NoAlertPresentException e) {
            System.out.println("NoAlertPresentException occurred: " + e.getMessage());
        }
    }
    @Test
    public void StaleElementReferenceExceptionExample() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();

        try {

            driver.navigate().refresh();
            timerAlertButton.click();

        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException occurred: " + e.getMessage());
        }
    }
}


