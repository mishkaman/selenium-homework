import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AutoComplete {
    private WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    public void smth4() throws InterruptedException {
        driver.get("https://www.google.com/");


        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Automation");

        Thread.sleep(2000);

        List<WebElement> suggestions = driver.findElements(By.className("sbct"));

        for (WebElement suggestion : suggestions){
            System.out.println(suggestion.getText());
        }

        WebElement wantedOption = suggestions.get(suggestions.size()-3);

        wantedOption.click();

        Thread.sleep(2000);

    }
    @AfterTest
    public void leave(){
        driver.quit();
    }
}
