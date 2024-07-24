package WindowHandeling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://retail.tekschool-students.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String tab1 =  driver.getWindowHandle(); // store current tab id in a variable
        driver.findElement(By.linkText("Test Selenium")).click();
        Set<String> tabsId = driver.getWindowHandles(); // store all tabs IDs in a set
        // loop through the all tabs and switch to the tab other than the current tab
        for (String tab : tabsId){
            if (!tab.equals(tab1)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        driver.findElement(By.id("addBtn")).click();
        driver.close(); // close the tab
        driver.switchTo().window(tab1); // switch back to the main tab
        driver.findElement(By.id("signinLink")).click();

    }
}
