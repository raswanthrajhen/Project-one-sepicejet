package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UtilityClass {

	public  WebDriver driver;
	public static Properties prop;
	public String sheetname;
	
	public void  browserLunch(String url,String browser) throws Exception {
	
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("headless")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		} else {
			driver = new ChromeDriver();
		}
		
		// make the connection
		
		URL link = new URL(url);  
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000);
		httpURLConnection.connect();
		
		if(httpURLConnection.getResponseCode()== 200) {
			System.out.println(url +" - "+ httpURLConnection.getResponseMessage());
			driver.get(url);
		} else {
			System.out.println(url +" - "+ httpURLConnection.getResponseMessage());
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public static void readFromPropFile() throws Exception {
		
		FileReader file = new FileReader("E:\\guvi\\SpiceJet\\src\\main\\resources\\LoginData.properties");
		prop = new Properties();
		prop.load(file);
		
		//testing pupose
		/*System.out.println(" hi" +prop.getProperty("url"));
        System.out.println(prop.getProperty("browser"));
		*/
			
	}
	
	public void dropDown(WebElement dropdownElement,String value,String text) {
		  // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option from the dropdown by visible text
        dropdown.selectByVisibleText(text);
        
 		// Select by value attribute
 		dropdown.selectByValue(value);
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}
	public void  browserTearDown() {
		driver.quit();
	}
	
	public void datePicker(WebElement datePickerElement,WebElement month,WebElement year) {
		  
		clickElement(datePickerElement);
		Select selectMonth = new Select(month);
		Select selectYear = new Select(year);
	    selectMonth.selectByVisibleText("March");
	    selectYear.selectByVisibleText("2006");
		
	}
	
	
	public String screenShot(String name) throws IOException {
		
		String path ="E:\\guvi\\SpiceJet\\snap"+name+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
    
    public void switchToNewWindowOne(ArrayList<String> windows,Set<String> existingWindows ) {
    	// Switch to the new window
    	
        for (String window : windows) {
            if (!existingWindows.contains(window)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
    
    public void sendKeyElements(WebElement webElementskey ,String keyValues) {
    	webElementskey.sendKeys(keyValues);
    }
    
    public void scrollToElement(WebElement element,JavascriptExecutor jsExecutor ) {
         
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
    
    public void scrollToElementByCoordinates(WebElement element,JavascriptExecutor jsExecutor ) {
      //  = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(arguments[0], arguments[1]);", element.getLocation().getX(), element.getLocation().getY());
    }
    
	public static String[][] readExcel(String sheetname) throws Exception {
		
		XSSFWorkbook book = new XSSFWorkbook("E:\\guvi\\SpiceJet\\Sheet\\SpiceJet.xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		short columncount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowcount][columncount];
		for(int i = 1 ; i <= rowcount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for(int j = 0; j < columncount; j++) {
				
				XSSFCell cell = row.getCell(j);
				DataFormatter dft=new DataFormatter();
				String value =dft.formatCellValue(cell);
				data[i-1][j]=value;
			}
		}
		
		book.close();
		return data;
	}
    
    
}
