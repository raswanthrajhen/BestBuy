package page;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;

public class ShopingCartPage extends ProjectSpecificationMethod {

	@FindBy(xpath="(//img[@alt='United States'])[1]")
	WebElement countryImageElement;
	
	@FindBy(xpath="//input[@class='search-input ']")
	WebElement searchInputElement;
	
	@FindBy(xpath="//button[@title='submit search']")
	WebElement submitSearchuttonElement;
	
	@FindBy(xpath="//a[text()='Apple - iPhone 15 Pro 256GB - Natural Titanium (AT&T)']")
	WebElement iphoneProElement;
		
	@FindBy(xpath="//button[@data-button-state=\"ADD_TO_PACKAGE_MOBILE\"]")
	WebElement addToCartElement;
	
	@FindBy(xpath="//button[@aria-label='Menu']")
	WebElement menuButtonElement;
	
	@FindBy(xpath="//button[text()='TV & Home Theater']")
	WebElement tvButtonElement;
	
	@FindBy(xpath="//button[text()='TVs by Size']")
	WebElement tvBySizeButtonElement;
	
	@FindBy(xpath="	//a[text()='85-Inch or Larger TVs']")
	WebElement largeTvButtonElement;
	
	@FindBy(xpath="//button[@data-button-state='ADD_TO_CART']")
	WebElement addToCartButtonElement;

	@FindBy(xpath="//button[text()='Brands']")
	WebElement breandCartButtonElement;
	
	@FindBy(xpath="//a[text()='Samsung']")
	WebElement samsingBreandButtonElement;
	
	@FindBy(xpath="	(//a[text()='Smartphones'])[1]")
	WebElement smartPhoneButtonElement;

	@FindBy(xpath="//a[text()='Learn about Galaxy Z Flip6']")
	WebElement learnAboutGalaxyElement;
	
	@FindBy(xpath="(//div[@class='fulfillment-add-to-cart-button'])[3]")
	WebElement addToCartPhoneElement;
	
	@FindBy(xpath="//span[text()='Cart']")
	WebElement cartCheckoutElement;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutElement;
	
	@FindBy(xpath="//button[text()='Continue as Guest']")
	WebElement continueAsGuestButton;
	
	@FindBy(xpath="//input[@name='emailAddress']")
	WebElement emailAddrsElement;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement phoneNumberElement;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-block btn-secondary']")
	WebElement continuePayElement;
	
	@FindBy(xpath="//input[@autocomplete='cc-number']")
	WebElement ccNumberElement;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstNameElement;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastNameElement;
	
	@FindBy(xpath="	//input[@name='addressLine1']")
	WebElement addressLineElement;

	@FindBy(xpath="//input[@name='postalCode']")
	WebElement postCodeElement;
	
	WebDriverWait wait;
	
	SoftAssert softAssert = new SoftAssert();
	
	JavascriptExecutor js;
	
	public ShopingCartPage(WebDriver driver){
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	
	public void shopingCartPageValidation() {
		clickElement(countryImageElement);
		sendKeyElements(searchInputElement,"iphone");
		clickElement(submitSearchuttonElement);
		clickElement(iphoneProElement);
		clickElement(addToCartElement);
		
	}
	
	public void manuShopingCartPageValidation() {
		clickElement(countryImageElement);
		clickElement(menuButtonElement);
		clickElement(tvButtonElement);	
		clickElement(tvBySizeButtonElement);	
		clickElement(largeTvButtonElement);	
		clickElement(addToCartButtonElement);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void manuBrandPageValidation() {
		clickElement(countryImageElement);
		clickElement(menuButtonElement);
		clickElement(breandCartButtonElement);
		clickElement(samsingBreandButtonElement);
		clickElement(smartPhoneButtonElement);
		clickElement(learnAboutGalaxyElement);
		wait.until(ExpectedConditions.visibilityOf(addToCartPhoneElement));
		scrollToElement(addToCartPhoneElement,js);
		WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartPhoneElement));
		Actions actions = new Actions(driver);
	    // Use the Actions class to click the element
	    actions.moveToElement(addToCartPhoneElement).click().perform();			
	}
	
	public void paymentInformationValidation() {
		clickElement(countryImageElement);
		clickElement(menuButtonElement);
		clickElement(tvButtonElement);	
		clickElement(tvBySizeButtonElement);	
		clickElement(largeTvButtonElement);	
		clickElement(addToCartButtonElement);
		clickElement(cartCheckoutElement);
		Actions actions = new Actions(driver);
	    // Use the Actions class to click the element
	    actions.moveToElement(checkOutElement).click().perform();
	    clickElement(continueAsGuestButton);
		sendKeyElements(emailAddrsElement,"Admin@123.com");
		sendKeyElements(phoneNumberElement,"9109109109");
		clickElement(continuePayElement);
		sendKeyElements(ccNumberElement,"9109109109091102");
		sendKeyElements(firstNameElement,"raswanth");
		sendKeyElements(lastNameElement,"rajhen");
		sendKeyElements(addressLineElement,"salem");
		sendKeyElements(postCodeElement,"salem");
			
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
