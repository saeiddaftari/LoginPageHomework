package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class login {

	WebDriver driver;
	// email text box finder
	@FindBy(how = How.ID, using = "email")
	private WebElement email;

	// absenden button finder
	@FindBy(how = How.ID, using = "newsletterFormSubmitBtn")
	private WebElement absendenButton;

	// error note finder
	@FindBy(how = How.ID, using = "email-error")
	private WebElement errorNote;

	// cookie pop-up finder
	@FindBy(how = How.CLASS_NAME, using = "consentForm__acceptButton")
	private WebElement cookiePopup;
	// cookie pop-up form finder
	@FindBy(how = How.XPATH, using = "//*[@class='consentForm__root']")
	private WebElement Popupform;
	// subscription note finder
	@FindBy(how = How.XPATH, using = "//*[@class='simpleText simpleText--gray simpleText--boldFont simpleText--size13']")
	private WebElement subscriptionNote;
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"responsive\\\"]/div[12]/footer/div[1]/div/div[5]/span[2]")
	private WebElement subscriptionNote2;
	@FindBy(how = How.XPATH, using = "//*[@class=\\\"-museo-light\\\"]")
	private WebElement subscriptionDone;

	public login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// set email address in email textbox

	public void setEmail(String emailAddress) {
		int x = cookiePopup.getLocation().x;
		int y = cookiePopup.getLocation().y;
		System.out.println(x);
		System.out.println(y);
		//cookiePopup.click();

		email.sendKeys(emailAddress);
		System.out.println("email address is: ");
		System.out.println(emailAddress);
	}

	// click on Absenden button
	public void clickAbsenden() {
		absendenButton.click();
	}

	// return the SubscriptionNote
	public String getError() {

		return errorNote.getText();
	}

	// return the SubscriptionNote
	public String getSubscriptionNote() {

		System.out.println("Subscription Note is:");

		return subscriptionNote.getAttribute("innerHTML");
	}

	// return successful note in final redirection
	public String printFinalNote() {

		return subscriptionDone.getText();
	}
}
