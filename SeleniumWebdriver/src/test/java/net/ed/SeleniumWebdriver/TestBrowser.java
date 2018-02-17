package net.ed.SeleniumWebdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBrowser {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}
	
	@Test
	public void BrowserToGoogle() {
		driver.get("https:google.com");
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

}
