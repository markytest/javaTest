package testPackage;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.TestResult;

import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;

public class poiStatic {
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
	private FileOutputStream fileOut;
	private String EXCEL_PATH = "C://Users//Administrator//Desktop//Lectures//movieratings.xlsx";

	@Before

	public void setUp() throws Exception {
		file = new File(EXCEL_PATH);
		fileIn = new FileInputStream(file);
		workbook = null;
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(2);
		resultCell = row.getCell(0);
	}

	@Test
	public void testUntitled2(){
	String CellContent = resultCell.getStringCellValue();
		CellContent = "HOLYYYY";
		
		try {
			fileOut = new FileOutputStream(EXCEL_PATH);
			
			if(resultCell !=null){
				try {
					resultCell = row.createCell(0);
					resultCell.setCellType(Cell.CELL_TYPE_STRING);
					resultCell.setCellValue(CellContent);
					System.out.println(CellContent);
				} catch (Exception e) {
					System.out.println(e);
				}
			
		}
			System.out.println("bumaba sa try ");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
			System.out.println("bumaba sa catch");
		}
	
	}
	@After
	public void tearDown() throws Exception {
		
		workbook.write(fileOut);

		fileOut.close();
	}
}

