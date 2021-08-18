package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingListPage {
    WebDriver driver;

    public BookingListPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ClickOnSearch()
    {
        driver.findElement(By.className("sb-searchbox__button")).click();
    }
    public String iWillSeeHotel()
    {
        return driver.findElement(new By.ByXPath("//span[contains(text(),'BonHotel')]")).getText();
    }
    public Double CheckRaiting()
    {
        Double Raiting = Double.parseDouble(driver.findElement(By.className("bui-review-score__badge")).getText());
        return Raiting;
    }
}
