package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class CreateAccountPage extends ProjectSpecificationMethod{
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstNameElement;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastNameElement;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailElement;
	
	@FindBy(xpath="//input[@name='fld-p1']")
	WebElement passwordElement;
	
	@FindBy(xpath="//input[@name='reenterPassword']")
	WebElement conformPasswordElement;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement mobileNumberElement;
	
	@FindBy(xpath="//button[text()='Create an Account']")
	WebElement CreateAnAccountElement;
	
	
	WebDriverWait wait;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	} 
	
	public void createAccountPageValidation(String[] datas) {
		sendKeyElements(firstNameElement,datas[0]);
		sendKeyElements(lastNameElement,datas[1]);
		sendKeyElements(emailElement,datas[2]);
		sendKeyElements(passwordElement,datas[3]);
		sendKeyElements(conformPasswordElement,datas[4]);
		sendKeyElements(mobileNumberElement,datas[5]);
		clickElement(CreateAnAccountElement);
	}
	
}
