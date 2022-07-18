package com.qa.opencart.base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.CommonsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	
	private static String SENDER = "prashant.0542@gmail.com";
	private static String RECIPIENT = "prashant.0542@gmail.com";
	private static String SUBJECT = "Open Cart Test Execution Report " + LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
	private static String BODY_TEXT = "Please click on this latest Test Execution Report link:";


	DriverFactory df;
	protected Properties prop;
	public WebDriver driver;

	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected CommonsPage commPage;
	protected SearchResultsPage searchResultsPage;
	protected ProductInfoPage productInfoPage;
	protected RegisterPage regPage;

	protected SoftAssert softAssert;

	@Parameters({ "browser", "browserversion" })
	@BeforeTest
	public void setup(String browser, String browserVersion) {
		df = new DriverFactory();
		prop = df.init_prop();

		if (browser != null) {
			prop.setProperty("browser", browser);
			prop.setProperty("browserversion", browserVersion);
		}

		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite
	public void sendTestReports() {
	}

}
