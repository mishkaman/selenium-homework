import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exceptions {
    private WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
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
        Thread.sleep(3000);

        driver.quit();


    }
    @Test
    public void NoAlertPresentExceptionExample() throws InterruptedException {
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
        Thread.sleep(3000);

        driver.quit();
    }
    @Test
    public void StaleElementReferenceExceptionExample() throws InterruptedException {
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
        Thread.sleep(3000);

        driver.quit();
    }
}


