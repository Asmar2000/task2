package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class payment {
    WebDriver driver;
    public payment(WebDriver driver) {
        this.driver = driver;
    }
    public void bookTrip(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        WebElement checkTerms = wait.until(ExpectedConditions.elementToBeClickable(By.id("termsChk")));


        checkTerms.click();
        WebElement makePayment = driver.findElement(By.id("PgBtn"));
        makePayment.click();
    }

}
