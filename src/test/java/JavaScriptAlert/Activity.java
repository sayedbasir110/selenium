package JavaScriptAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://retail.tekschool-students.com/selenium/javascript-alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("promptBtn"))).click();
        // Option 2) using method alertIsPresent to wait for popping up the alert and declare it as an Alert variable
        Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Sayed Ali Basir");
        alert.accept();
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'You wrote')]"))).getText();
        System.out.println(message);
        driver.quit();
    }
}
