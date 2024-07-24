package Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.insurance.tekschool-students.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='chakra-button css-ez23ye']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("supervisor");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("tek_supervisor");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Sign In']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[@href='/csr/plans']"))).click();
        for (int i = 1; i<= 4; i++){
            String xpath = "//table/tbody/tr" + "[" + i + "]" + "/td[3]";
            String price =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
            System.out.println(price);
        }

    }
}
