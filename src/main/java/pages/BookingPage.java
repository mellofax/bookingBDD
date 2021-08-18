package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage {
    WebDriver driver;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }
    public void InsertNameOfHotel(String NameOfHotel)
    {
        driver.findElement(By.id("ss")).click();
        driver.findElement(By.id("ss")).sendKeys(NameOfHotel);
    }
}
