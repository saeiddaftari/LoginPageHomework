package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class tempMail {

	WebDriver driver;
	// temporary mail address finder
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[1]/div/div[1]/div")
	private WebElement tempAddress;
	// first mail finder
	@FindBy(how = How.XPATH, using = "//*[@class='message--container message--container-bold']")
	private WebElement topEmail;
	// confirm button finder
	@FindBy(how = How.XPATH, using = "//*[@class='cta1a']")
	private WebElement confirmButton;

	public tempMail(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// copy temporary email address
	public String getTempAddress() {
		
		return tempAddress.getText();

	}

	// open recent received email
	public void selectEmail() {
		topEmail.click();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(topEmail)).click();
	}

	// confirm the button
	public void confirmSubscription() {
		System.out.println("Registration Completed: \n" + confirmButton.getText());
		confirmButton.click();
	}
	
}
