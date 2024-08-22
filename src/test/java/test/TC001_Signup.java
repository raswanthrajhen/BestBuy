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
		try {
		HomePage homePageObject=new HomePage(driver);
		CreateAccountPage createAccountPageObject=new CreateAccountPage(driver);
		homePageObject.homePageValidation();
		createAccountPageObject.createAccountPageValidation(data);
	}
	catch(Exception ex){
		System.out.print("createAccount exception");
	}
	}
	
	@Test
	public void signIn() {
		try {
		HomePage homePageObject=new HomePage(driver);
		SignInPage signInPageObject=new SignInPage(driver);
		homePageObject.enterSignInpage();
		signInPageObject.SignInPageValidation();
	}
	catch(Exception ex){
		System.out.print("signIn exception");
	}
	}
		@Test
	public void validateTitle() {
			try {
		HomePage homePageObject=new HomePage(driver);
		homePageObject.homePageTitleValidation();
		homePageObject.bottomLinkValidation();	
		}
		catch(Exception ex){
			System.out.print("validateTitle exception");
		}
	}
	
	@Test
	public void shopingCart() {
		try {
		ShopingCartPage shopingCartObject=new ShopingCartPage(driver);
		shopingCartObject.shopingCartPageValidation();
	}
	catch(Exception ex){
		System.out.print("shopingCart exception");
	}
	}
	
	
	@Test
	public void menuShopingCart() {
		try {
		ShopingCartPage shopingCartObject=new ShopingCartPage(driver);
		shopingCartObject.manuBrandPageValidation();
		}
		catch(Exception ex){
			System.out.print("menuShopingCart exception");
		}
	}
	
	@Test
	public void paymentInformation() {
		try {
		ShopingCartPage shopingCartObject=new ShopingCartPage(driver);
		shopingCartObject.paymentInformationValidation();
		}
		catch(Exception ex){
			System.out.print("paymentInformation exception");
		}
	}
	
}
