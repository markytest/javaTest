package testPackage;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;

import junit.framework.TestResult;
import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;


public class myFirstAutomation {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private File file;
	private FileInputStream fileIn;
	public XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell movieCell;
	private XSSFCell scoreCell;
	private XSSFCell resultCell;
	public FileOutputStream fileOut;
	public File screenshot;
	private String EXCEL_PATH = "C://Users//Administrator//Desktop//Lectures//movieratings.xlsx";
	
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\MyJava\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://www.metacritic.com/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		file = new File(EXCEL_PATH);
			  FileInputStream fileIn = null;
			  try {
			   fileIn = new FileInputStream(file);
			  } catch (FileNotFoundException e2) {
			   e2.printStackTrace();
			  }
			   workbook = null;
			  try {
			   workbook = new XSSFWorkbook(fileIn);
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			  sheet = workbook.getSheetAt(0);		 
	}

	@Test
	public void testUntitled2() throws IOException{
		
		
		int lastRow = sheet.getLastRowNum();
		for (int i = 0; i < lastRow; i++) {
			row = sheet.getRow(i+1);
			movieCell = row.getCell(0);
			scoreCell = row.getCell(1);
			resultCell = row.getCell(2);
			
			
			try {
				fileOut = new FileOutputStream(EXCEL_PATH);
				
					try {
						resultCell = row.createCell(2);
						resultCell.setCellType(Cell.CELL_TYPE_STRING);
					} catch (Exception e) {
						System.out.println(e);
					}
					
			} 
			catch (Exception e) {
				// TODO: handle exception
			}
			
			String movieTitle = movieCell.getStringCellValue();
			System.out.println(movieTitle);
			String movieScore = scoreCell.getRawValue();
			String filename = "C:\\Users\\Administrator\\Desktop\\Lectures\\src\\" +movieTitle+ ".jpg";
			
	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(baseUrl);
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/header/nav[1]/div/div[3]/div/span")).click();
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/header/nav[3]/div/div/div[1]/form/div/input"))
					.clear();
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/header/nav[3]/div/div/div[1]/form/div/input"))
					.sendKeys(movieTitle);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/header/nav[3]/div/div/div[1]/form/div/input"))
			.sendKeys(Keys.RETURN);

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			boolean exist = driver.findElements(By.linkText(movieTitle)).size() != 0;
			
			screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			if (exist) {
				driver.findElement(By.linkText(movieTitle));
				System.out.println(movieTitle + " Found");
		
			}
			else {
				try {
					String testResult = (movieTitle +   " not found");
					FileUtils.copyFile(screenshot, new File(filename));
					System.out.println(testResult);
					resultCell.setCellValue(testResult);
		
				} catch (Exception e) {
					// TODO: handle exception
				}
				continue;
			}

			try {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				boolean scoreExist = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div[1]/div[2]/div[1]/ul/li[1]/div[2]/div/div[1]/span")).size() != 0;
				if(scoreExist){
					try{
						assertEquals(movieScore,driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div[1]/div[2]/div[1]/ul/li[1]/div[2]/div/div[1]/span")).getText());
					String testResult = movieTitle + " "+ movieScore + " "+ " score is correct!";
					FileUtils.copyFile(screenshot, new File(filename));
					resultCell.setCellValue(testResult);
						System.out.println(testResult);
					}
					catch (Error e){
					String TestResult = movieTitle + " score of " +movieScore+ " is not correct";
						System.out.println(TestResult);
						FileUtils.copyFile(screenshot, new File(filename));
						resultCell.setCellValue(TestResult);
						
						e.printStackTrace();
					}
				}
				
				else{
					String testResult = "Score doesnt exist yet.";
					
					System.out.println(testResult);
				continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				workbook.write(fileOut);
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@After
	public void tearDown() throws Exception {
		
	try {
		fileIn.close();
		} 
	catch (Exception e2) {
		e2.printStackTrace();
		}
		driver.quit();
		}
	}

