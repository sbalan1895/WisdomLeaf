package SearchHotelPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPOM {

	WebDriver driver;

	public SearchHotelPOM(WebDriver driver) {

		this.driver= driver;

	}

	private By searchLocation= By.xpath("//select[@id='location']");

	public void selectLocation(String Location) {


		Select select = new Select(driver.findElement(searchLocation));
		select.selectByValue(Location);

	}

	public List<WebElement> getLocation() {

		Select select = new Select(driver.findElement(searchLocation));
		return select.getOptions();

	}


}
