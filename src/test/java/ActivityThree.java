import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ActivityThree {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Accessories']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Logitech MK270 Wireless Keyboard And Mouse Combo']"))).click();
        WebElement QTY = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product__select")));
        Select selectQuantity = new Select(QTY);
        selectQuantity.selectByVisibleText("5");

    }
}
