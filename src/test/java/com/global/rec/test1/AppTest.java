package com.global.rec.test1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

	private static final String CHROMEDRIVER_PATH = "C:/Programs/selenium/drivers/chromedriver.exe";
	private static final String SITE_URL = "http://78.9.79.62/";
	private static final String MAIN_PAGE_TITLE = "What? Why? Where? - REC Dart Ladder";
	private static final String LOGIN_BUTTON_ID = "loginLink";
	private static final String LOGIN_PAGE_TITLE = "Log in - REC Dart Ladder";

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);

		driver = new ChromeDriver();
		driver.get(SITE_URL);
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void main_page_title() {
		assertEquals(MAIN_PAGE_TITLE, driver.getTitle());
	}

	@Test
	public void login_page_title() {
		WebElement loginButton = driver.findElement(By.id(LOGIN_BUTTON_ID));
		assertNotNull(loginButton);

		loginButton.click();
		assertEquals(LOGIN_PAGE_TITLE, driver.getTitle());
	}

	@Test
	public void login() {
		driver.get("http://78.9.79.62/Account/Login");

		WebElement username = driver.findElement(By.id("UserName"));
		WebElement password = driver.findElement(By.id("Password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/fieldset/input"));

		assertNotNull(username);
		assertNotNull(password);
		assertNotNull(loginButton);

		username.sendKeys("abaranowska");
		password.sendKeys("*");
		loginButton.click();

		WebElement logoutButton = driver.findElement(By.partialLinkText("Log off"));
		assertNotNull(logoutButton);
	}

}
