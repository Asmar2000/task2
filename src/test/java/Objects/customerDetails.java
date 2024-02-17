package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class customerDetails {
    WebDriver driver;
    public customerDetails(WebDriver driver) {
        this.driver = driver;
    }
    public void selectSeat() {
        List<WebElement> flight = driver.findElements(By.xpath("// input [@value=\"Select Seats\"]"));
        WebElement firstFlight = flight.get(1);
        firstFlight.click();
        List<WebElement> seat = driver.findElements(By.xpath("//li  [@class=\"availSeatClassS\"]")); //select an available seat
        WebElement firstSeat = seat.get(0);
        firstSeat.click();
    }

    public void locationPoints() {
        WebElement boardingPoint = driver.findElement(By.xpath("// li [@class=\"p-2 Forward-boarding active1\"]"));
        boardingPoint.click();
        WebElement droppingPoint = driver.findElement(By.xpath("// li [@class=\"p-2 Forward-droping active1\"]"));
        droppingPoint.click();

    }

    public void passengerDetails(String number,String email, String name, String passengerGender, int passengerAge, String concessionType, int cardID) {
        //I am adding the mobile number as a string parameter because the mentioned number in the task is too long to be an integer or a long
        WebElement customerMobNumber = driver.findElement(By.name("mobileNo"));
        customerMobNumber.sendKeys(number);
        WebElement customerEmail = driver.findElement(By.name("email"));
        customerEmail.sendKeys(email);
        WebElement passengerName = driver.findElement(By.name("passengerName"));
        passengerName.sendKeys(name);
        WebElement gender = driver.findElement(By.name("genderCodeId"));
        Select genderType = new Select(gender);
        genderType.selectByVisibleText(passengerGender);
        WebElement age = driver.findElement(By.name("passengerAge"));
        age.sendKeys(String.valueOf(passengerAge));
        WebElement concession = driver.findElement(By.name("concessionIds"));
        Select concessionSelection = new Select(concession);
        concessionSelection.selectByVisibleText(concessionType);
        WebElement passengerCard = driver.findElement(By.name("cardNumbers"));
        passengerCard.sendKeys(String.valueOf(cardID));
    }
}
