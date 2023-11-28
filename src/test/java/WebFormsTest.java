import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebFormsTest {
    private WebDriver driver;

    @BeforeClass
    public void setupdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void webform() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        WebElement programmingLanguageOptions = driver.findElement(By.id("dropdowm-menu-1"));
        programmingLanguageOptions.click();

        WebElement javaOption = driver.findElement(By.xpath("//option[@value='java']"));
        javaOption.click();

        Thread.sleep(2000);

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        Thread.sleep(2000);

        WebElement yellowRadioButton = driver.findElement(By.xpath("//input[@value='yellow']"));
        yellowRadioButton.click();


        Select Dropdown = new Select(driver.findElement(By.id("fruit-selects")));
        List<WebElement> options = Dropdown.getOptions();

        for (WebElement option : options) {
            if (option.getText().equals("Orange")) {
                if (option.isEnabled()) {
                    System.out.println("Option is enabled");
                } else {
                    System.out.println("Option is not enabled");
                }
                break;
            }
        }

        driver.quit();
    }
}