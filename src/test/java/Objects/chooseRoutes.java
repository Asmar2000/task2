package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class chooseRoutes {
    WebDriver driver;

    public chooseRoutes(WebDriver driver) {
        this.driver = driver;
    }

    public void myRoute() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Chikkamagaluru -")));
        WebElement route = driver.findElement(By.partialLinkText("Chikkamagaluru -"));
        route.click();
        WebElement next = driver.findElement(By.xpath("//a[@title=\"Next\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(next).click().perform();

        WebElement chooseDay = driver.findElement(By.partialLinkText("10"));
        chooseDay.click();
    }

    public void searchResult() {
        WebElement searchResult = driver.findElement(By.xpath("// button [@class=\"btn btn-primary btn-lg btn-block btn-booking\"]"));
        searchResult.click();
    }
}