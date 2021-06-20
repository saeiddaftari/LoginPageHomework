package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.login;
import pages.tempMail;

public class ConfirmSubscription {
	WebDriver driver;
	login loginObject;
	tempMail tempMailObject;
	String tempEmailAddress;

	@Given("I open a temporary mail web page in chrome")
	public void i_open_a_temporary_mail_web_page_in_chrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		tempMailObject = new tempMail(driver);
		driver.get("https://cryptogmail.com/");
		driver.manage().window().maximize();
	}

	@When("I get the email address")
	public void i_get_the_email_address() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tempEmailAddress = tempMailObject.getTempAddress();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("I enter the email address in the input field")
	public void i_enter_the_email_address_in_the_input_field() {
		loginObject = new login(driver);
		driver.navigate().to("https://www.hoeffner.de/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// type the email address
		loginObject.setEmail(tempEmailAddress);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("I press absenden button of newsletter form")
	public void i_press_absenden_button_of_newsletter_form() {
		loginObject.clickAbsenden();
	}

	@Then("I receive an email asking to confirm my email address")
	public void i_receive_an_email_asking_to_confirm_my_email_address() {
		driver.navigate().to("https://cryptogmail.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor jsexec = (JavascriptExecutor) driver;
		jsexec.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@When("I open the mail")
	public void i_open_the_mail() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tempMailObject.selectEmail();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("there is a link to finish registration")
	public void there_is_a_link_to_finish_registration() {
		System.out.println("\nI opened the registration mail\n");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("I click Jetzt Anmeldung abschliessen button")
	public void i_click_jetzt_anmeldung_abschliessen_button() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		tempMailObject.confirmSubscription();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("I am redirected to page of confirming subscription")
	public void i_am_redirected_to_page_of_confirming_subscription() {
		Set<String> windowhandles = driver.getWindowHandles();

		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		driver.switchTo().window(childwindow);

		if (driver.getCurrentUrl().equals("https://www.hoeffner.de/nl-anmeldung")) {
			System.out.println("window redirected successfully to hoeffner webpage");
		} else {
			System.out.println("The Window is not redirected to the expected web page\nIt's redirected to: ");
			System.out.println(driver.getCurrentUrl());
		}
		driver.close();
	}

	@Given("I open a temporary mail web page in firefox")
	public void i_open_a_temporary_mail_web_page_in_firefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		tempMailObject = new tempMail(driver);
		driver.get("https://cryptogmail.com/");
		driver.manage().window().maximize();
	}

	@Given("I open a temporary mail web page in edge")
	public void i_open_a_temporary_mail_web_page_in_edge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		tempMailObject = new tempMail(driver);
		driver.get("https://cryptogmail.com/");
		driver.manage().window().maximize();
	}
}
