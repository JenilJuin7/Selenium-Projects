package TestSuite;

import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;

import Pages.HomePage;


public class SmokeTest extends HomePage
{
	@Test
	public void testing()
	{
		HomePage hd= new HomePage();
		hd.openUrl();
		hd.clickUpcomingBikes();
		hd.selectManufacturer();
	}

}
