package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.CreateAccountPage;
import page.HomePage;
import page.ShopingCartPage;
import page.SignInPage;

public class TC001_Signup extends ProjectSpecificationMethod{

	
	@Test(dataProvider="getData")
	public void createAccount(String[] data) {
		HomePage homePageObject=new HomePage(driver);
		CreateAccountPage createAccountPageObject=new CreateAccountPage(driver);
		homePageObject.homePageValidation();
		createAccountPageObject.createAccountPageValidation(data);	
	}
	
	@Test
	public void signIn() {
		HomePage homePageObject=new HomePage(driver);
		SignInPage signInPageObject=new SignInPage(driver);
		homePageObject.enterSignInpage();
		signInPageObject.SignInPageValidation();	
	}
		@Test
	public void validateTitle() {
		HomePage homePageObject=new HomePage(driver);
		homePageObject.homePageTitleValidation();
		homePageObject.bottomLinkValidation();	
	}
	
	@Test
	public void shopingCart() {
		ShopingCartPage shopingCartObject=new ShopingCartPage(driver);
		shopingCartObject.shopingCartPageValidation();
	}
	
	
	@Test
	public void menuShopingCart() {
		ShopingCartPage shopingCartObject=new ShopingCartPage(driver);
		shopingCartObject.manuBrandPageValidation();
	}
	
	@Test
	public void paymentInformation() {
		ShopingCartPage shopingCartObject=new ShopingCartPage(driver);
		shopingCartObject.paymentInformationValidation();
	}
	
}
