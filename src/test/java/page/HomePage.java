package page;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod{

	@FindBy(xpath="(//img[@alt='United States'])[1]")
	WebElement countryImageElement;
	
	@FindBy(xpath="//span[@class='v-p-right-xxs line-clamp']")
	WebElement accountElement;
	
	@FindBy(xpath="//a[text()='Create Account']")
	WebElement createAccountElement;
	
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement signInElement;
	
	@FindBy(xpath="(//div[@aria-label='Error'])[1]")
	WebElement errorLabelElement;
	
	@FindBy(xpath="//a[text()='Top Deals']")
	WebElement topDealLabelElement;
	
	@FindBy(xpath="//a[text()='Deal of the Day']")
	WebElement dealOfDayLabelElement;
	
	@FindBy(xpath="(//a[text()='Yes, Best Buy Sells That'])[1]")
	WebElement bestBuySellLabelElement;
	
	
	@FindBy(xpath="//a[text()='Accessibility']")
	WebElement accessibilityBottomLinkElement ;
	
	@FindBy(xpath="//a[text()='Terms & Conditions']")
	WebElement termsAndCondtBottomLinkElement ;
	
	@FindBy(xpath="//a[text()='Privacy']")
	WebElement privacyBottomLinkElement ;
	
	WebDriverWait wait;
	
	SoftAssert softAssert = new SoftAssert();
	
	JavascriptExecutor js;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	
	//Create User Account function  
	public CreateAccountPage homePageValidation() {
		clickElement(countryImageElement);
		clickElement(accountElement);
		clickElement(createAccountElement);
		return new CreateAccountPage(driver);
	}


	//User singIn Function
	public SignInPage enterSignInpage() {
		clickElement(countryImageElement);
		clickElement(accountElement);
		clickElement(signInElement);
		return new SignInPage(driver);
	}

	
	//Validate the Title of page
	public void homePageTitleValidation() {
		clickElement(countryImageElement);
		clickElement(topDealLabelElement);
		System.out.println(driver.getTitle());
		
		try {
			
			 softAssert.assertTrue(driver.getTitle().contains("Top Deals"), 
                     "Title does not contain the expected text = Top Deals");
		softAssert.assertAll();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		clickElement(dealOfDayLabelElement);
		
		try {
		 softAssert.assertTrue(driver.getTitle().contains("Deal of the Day"), 
                 "Title does not contain the expected text = Deal of the Day");
		softAssert.assertAll();
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		clickElement(bestBuySellLabelElement);

		try {
		 softAssert.assertTrue(driver.getTitle().contains("Yes, Best Buy Sells That"), 
                 "Title does not contain the expected text = Yes, Best Buy Sells That");
		softAssert.assertAll();
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
			
	}
	
	
	//Validate the bottom Link
	public void bottomLinkValidation() {
		scrollToElement(accessibilityBottomLinkElement,js);
		clickElement(accessibilityBottomLinkElement);	
		System.out.println(driver.getTitle());
		try {
			 softAssert.assertTrue(driver.getTitle().contains("Accessibility"), 
	                 "Title does not contain the expected text = Accessibility");
			softAssert.assertAll();
			System.out.println(driver.getTitle());
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		clickElement(termsAndCondtBottomLinkElement);
		try {
			System.out.println(driver.getTitle());
			 softAssert.assertTrue(driver.getTitle().contains("Terms and Conditions"), 
	                 "Title does not contain the expected text = Terms and Conditions");
			softAssert.assertAll();
		
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		clickElement(privacyBottomLinkElement);
		try {
			System.out.println(driver.getTitle());
			 softAssert.assertTrue(driver.getTitle().contains("Privacy Policy Hub - Best Buy"), 
	                 "Title does not contain the expected text = Privacy Policy Hub - Best Buy");
			softAssert.assertAll();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
	}
	
}
