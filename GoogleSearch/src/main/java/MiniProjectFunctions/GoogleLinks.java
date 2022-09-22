package MiniProjectFunctions;
import java.io.File;
import java.io.IOException;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.google.common.io.Files;

import Base.Base;


public class GoogleLinks extends Base {
		//opening the URL
		public void openUrl()
		{
			driver.get(" https://www.google.com/");
		}
		public void linkList()
		{
			  List<WebElement> links = driver.findElements(By.tagName("a"));
		      System.out.println("The number of links is " + links.size());
		      for(WebElement link:links)
		      {
		    	  System.out.println(link.getText() + " - " + link.getAttribute("href"));
		      }
			
		}
		public void clickSearchBox()
		{
			driver.findElement(By.name("q")).click();
		}
		public void typeSearchValue()
		{
			driver.findElement(By.name("q")).sendKeys("Cognizant");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		public void firstListSuggestions()
		{
			  List<WebElement> cognizant = driver.findElements(By.className("wM6W7d"));
			  System.out.println("The number of search options displayed is " + cognizant.size());
		      for(WebElement link:cognizant)
		      {
		    	  System.out.println(link.getText());
		      }
			
		}
		public void screenshot() throws IOException
		{
			TakesScreenshot capture = (TakesScreenshot) driver;
			File srcFile = capture.getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir")
					+ "/SS/SearchingOptions.png");
			Files.copy(srcFile, destFile);
		}
		public void clickSearch()
		{
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		}
		public void searchResults()
		{
			String result=driver.findElement(By.id("result-stats")).getText();
			System.out.println(result);
			
			
		}
		public void fullPageScreenshot() throws IOException
		{
			TakesScreenshot capture = (TakesScreenshot) driver;
			File srcFile = capture.getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir")
					+ "/SS/ImageSearch.png");
			Files.copy(srcFile, destFile);
		}
		
		public void closeBrowser()
		{
			driver.quit();
		}
		
		public static void main(String[] args) throws InterruptedException, IOException{
			GoogleLinks obj= new GoogleLinks();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Smile\\Pictures\\Team 5 - Main Project\\src\\test\\resources\\Drivers\\chromedriver.exe");
			GoogleLinks obj1= new GoogleLinks();
			obj1.driverSetup();
			obj1.openUrl();
			obj1.linkList();
			obj1.clickSearchBox();
			obj1.typeSearchValue();
			obj1.firstListSuggestions();
			obj1.screenshot();
			obj1.clickSearch();
			obj1.searchResults();
			obj1.fullPageScreenshot();
			obj1.closeBrowser();
		}

}
