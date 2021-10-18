package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static Select s;
	
	public static JavascriptExecutor js;
	

	
	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		

	}
	
	public static void maxiWindow() {
		driver.manage().window().maximize();

	}
	
	public static void launchUrl(String url) {
		driver.get(url);

	}
	
	public static void sleep(long sec) throws InterruptedException {
		Thread.sleep(sec);

	}
	
	public static void pageTitle() {
		String title = driver.getTitle();
		
		System.out.println("Title Name:"+title);

	}
	
	public static void pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		
		System.out.println("Url:"+currentUrl);

	}
	
	public static String gettingText(WebElement ele) {
		String attrtext = ele.getText();
		return attrtext;

	}
	
	public static String gettingAttribute(WebElement ele) {
		String att = ele.getAttribute("value");
       return att;
	}
	
	public static String excelRead(String fileName,String sheetName, int rowNo,int colNo) throws IOException {
		File file=new File("D:\\Frameworks\\POMFramework\\Excel\\"+fileName+".xlsx");
		
		FileInputStream fin=new FileInputStream(file);
		
		Workbook w=new XSSFWorkbook(fin);
		
		Sheet s=w.getSheet(sheetName);
		
		Row r=s.getRow(rowNo);
		
		Cell c=r.getCell(colNo);
		
		int cellType = c.getCellType();
		
		String value="";
		
		if (cellType==1) {
			
			value = c.getStringCellValue();
			
		}
		
		else if (DateUtil.isCellDateFormatted(c)) {
			
			Date d=c.getDateCellValue();
			
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
			
			value=sim.format(d);
			
		}
		
		else {
			double d = c.getNumericCellValue();
			
			long l=(long) d;
			
			value=String.valueOf(l);
		}
		
		return value;

	}
	
	public static void excelWrite(String fileName,String sheetName,String text, int rowNo,int colNo) throws IOException {
		
		
		File file=new File("D:\\Frameworks\\POMFramework\\Excel\\"+fileName+".xlsx");
		
        Workbook w=new XSSFWorkbook();
        
        Sheet s=w.createSheet(sheetName);
        
        Row r=s.createRow(rowNo);
        
        Cell c=r.createCell(colNo);
        
        c.setCellValue(text);
        
        FileOutputStream fout=new FileOutputStream(file);
        
        w.write(fout);
        
        System.out.println("Done successfully");
        
        

	}
	
	public static void excelUpdate(String fileName,String sheetName,String text,String text1, int rowNo,int colNo) throws IOException
	{
     File file=new File("D:\\Frameworks\\POMFramework\\Excel\\Test Data.xlsx");

     FileInputStream fin=new FileInputStream(file);

     Workbook w=new XSSFWorkbook(fin);

     Sheet s=w.getSheet(sheetName);

     Row r=s.getRow(rowNo);

     Cell c=r.getCell(colNo);
        
     String value = c.getStringCellValue();
     
     if (value.equals(text)) {
    	 
    	 c.setCellValue(text1);
		
	} 
     
     FileOutputStream fout=new FileOutputStream(file);
     
     w.write(fout);
     
     System.out.println("Update Successfully");
		
	}
	
	
	public static void fillText(WebElement ele,String text) {
		ele.sendKeys(text);

	}
	
	public static void btnClick(WebElement ele) {
		ele.click();

	}
	
	public static void selectText(WebElement ele,String text) {
		s=new Select(ele);
		s.selectByVisibleText(text);
	

	}
	
	public static void scrollDown(String text1) {
		
		WebElement scrollDown = driver.findElement(By.xpath(text1));
		
		js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);

	}

	
	public static void preOfElementLocated(String id,int Sec) {
		
		WebDriverWait w=new WebDriverWait(driver, Sec);
		w.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		

	}
	
	
	public static void clearText(WebElement ele) {
		ele.clear();

	}
	
	
	public static void scrollUp(String text) {
		WebElement scrollUp = driver.findElement(By.xpath(text));
		js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(false)", scrollUp);

	}
	
	
	
}
