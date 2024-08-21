package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class SignInPage extends ProjectSpecificationMethod {

	@FindBy(xpath="//input[@name='fld-e']")
	WebElement emailElement;
	
	@FindBy(xpath="//input[@name='fld-p1']")
	WebElement passwordElement;
	
	@FindBy(xpath="(//div[@aria-label='Error'])[1]")
	WebElement errorLabelElement;
	
	@FindBy(xpath="(//button[text()='Sign In'])[1]")
	WebElement signInButtonElement;
	
	WebDriverWait wait;
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public void SignInPageValidation() {
		sendKeyElements(emailElement,"raswanthrajhen@gmail.com");
		sendKeyElements(passwordElement,"Admin@123");
		clickElement(signInButtonElement);	
		wait.until(ExpectedConditions.visibilityOf(errorLabelElement));
	}
	
	
	
}
