package testMethods;

import Objects.chooseRoutes;
import Objects.payment;
import Objects.customerDetails;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TCs {
    WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        Dimension taskDimension = new Dimension(1024, 768); //set the window size to 1024 x 768 as mentioned in the task
        driver.manage().window().setSize(taskDimension);
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @Test
    public void desiredRoutes(){
        chooseRoutes test = new chooseRoutes(driver);
        test.myRoute();
        Assert.assertTrue(driver.getCurrentUrl().contains( "https://ksrtc.in/oprs-web/guest/home.do?h=1"));
        Assert.assertTrue(driver.getPageSource().contains("Chikkamagaluru -"));
        test.searchResult();
        //assert that url contains the expected substring
        Assert.assertTrue(driver.getCurrentUrl().contains("/avail/"));

    }
    @Test
    public void tripDetails(){
        customerDetails test = new customerDetails(driver);
        payment check = new payment(driver);
        test.selectSeat();
        test.locationPoints();
        test.passengerDetails("6789125987", "mahmoudlotfy@mailinator.com", "Mahmoud Lotfy", "MALE", 25, "GENERAL PUBLIC", 123456789);
        check.bookTrip();
        Assert.assertTrue(driver.getCurrentUrl().contains("/booking/revamp/paxInfo"));
        //assert on title
        Assert.assertEquals(driver.getTitle(), "KSRTC Official Website for Online Bus Ticket Booking - KSRTC.in");
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }


}
