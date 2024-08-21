package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.UtilityClass;

public class ProjectSpecificationMethod extends UtilityClass{

	@BeforeMethod
	@Parameters({"url","browser"})
	public void browserLaunch(@Optional("https://www.bestbuy.com/") String url,@Optional("chrome")  String browser) throws Exception {
		browserLunch(url,browser);
	}
	
	@AfterMethod
	public void browserCloseBrowser() {
		browserTearDown();
	}
	
	@DataProvider(name = "getData")
	public String[][] getData() throws Exception {
		
		String[][] data = readExcel("BestBuy");
		//System.out.print("data is " +data);
		return data;
	}
	
}
