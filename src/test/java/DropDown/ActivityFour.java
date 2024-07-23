package DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityFour {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-testid='open-registration-form-button']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='First name']"))).sendKeys("John");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Last name']"))).sendKeys("Doe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Mobile number or email']"))).sendKeys("john.doe@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Re-enter email']"))).sendKeys("john.doe@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='New password']"))).sendKeys("John@123");
        WebElement birthMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("birthday_month")));
        Select birthMonthSelect = new Select(birthMonth);
        birthMonthSelect.selectByVisibleText("Jul");
        WebElement birthDay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("birthday_day")));
        Select birthDaySelect = new Select(birthDay);
        birthDaySelect.selectByVisibleText("22");
        WebElement birthYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("birthday_year")));
        Select birthYearSelect = new Select(birthYear);
        birthYearSelect.selectByVisibleText("2000");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Male']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("websubmit"))).click();
        String error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"reg_error_inner\"]"))).getText();
        if (error.equals("That email can’t be used. Try a different one or sign up with mobile number instead."))
            System.out.println("Test passed...");
        else System.out.println("Test failed");
        driver.quit();





    }
}
