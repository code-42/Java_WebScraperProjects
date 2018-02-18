package net.ed.SeleniumWebdriver;

/**
 * this program downloads a certain options file from cboe every 60 seconds
 * the text file is named quotedata.dat
 * 
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuoteTableDL {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "/Users/melocal/Applications/lib/chromedriver";
		System.setProperty(key, value);
		
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize chrome browser
		driver.manage().deleteAllCookies(); // exactly what it says
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// goto url
		String url = "http://www.cboe.com/delayedquote/quote-table-download";
		driver.get(url);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String txtTickerXpth = "//*[@id=\"ContentTop_C005_txtTicker\"]";
		// enter the ticker symbol
		String txtTickerID = "ContentTop_C005_txtTicker";
		String ticker = "MULE";
		driver.findElement(By.id(txtTickerID)).sendKeys(ticker);
		System.out.println("Entered ticker symbol");
		
		// sleep for 1 second
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// press the download button
		String downloadButtonXpath = "ContentTop_C005_cmdSubmit";
		driver.findElement(By.id(downloadButtonXpath)).sendKeys(Keys.ENTER);
		System.out.println("pressed ENTER key");
		
		// sleep for 61 seconds then loop
//		try {
//			Thread.sleep(61000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

	}


}
