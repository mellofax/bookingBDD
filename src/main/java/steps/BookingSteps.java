package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BookingListPage;
import pages.BookingPage;

public class BookingSteps {
    WebDriver driver;

    @Before
    public void SetUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("Navigate to online Booking page")
    public void navigateToOnlineBookingPage() {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }

    @When("Enter name of the Hotel {string}")
    public void enterNameOfHotel(String NameOfTheHotel) {
        BookingPage Page = new BookingPage(driver);
        Page.InsertNameOfHotel(NameOfTheHotel);
    }

    @Then("Press Search")
    public void press() {
        BookingListPage ListPage = new BookingListPage(driver);
        ListPage.ClickOnSearch();
    }

    @Then("Check that the hotel with name {string} is displayed on the page")
    public void checkThatTheHotelWithNameIsDisplayedOnThePage(String NameOfTheHotel) {
        BookingListPage ListPage = new BookingListPage(driver);
        Assert.assertEquals(ListPage.iWillSeeHotel(), NameOfTheHotel, "The name of the hotel was not found");
    }

    @Then("Check that the hotel's rating corresponds to {double}")
    public void checkThatTheHotelSRatingCorrespondsTo(double HotelRaiting) {
        BookingListPage ListPage = new BookingListPage(driver);
        Assert.assertEquals(java.util.Optional.of(ListPage.CheckRaiting()), java.util.Optional.of(HotelRaiting), "The rating does not match");
    }

}
