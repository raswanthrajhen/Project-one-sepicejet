package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.UtilityClass;

public class ProjectSpacificationMethod extends UtilityClass {

	
	@BeforeClass
	@Parameters({"url","browser"})
	public void lunchingBrowser(@Optional("https://www.spicejet.com/") String url,@Optional("chrome")  String browser) throws Exception{
		browserLunch(url,browser);
	}
	
	@AfterClass
	public void closeBrowser(){
		browserTearDown();
	}
	
	@DataProvider(name = "getData")
	public String[][] getData() throws Exception {
		
		String[][] data = readExcel(sheetname);
		//System.out.print("data is " +data);
		return data;
	}
	
}
