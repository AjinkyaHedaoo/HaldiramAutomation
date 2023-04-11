package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreen(WebDriver driver,String testID) throws IOException{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-mm-dd HH-mm-ss");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		LocalDateTime date = LocalDateTime.now();
		File dest = new File ("test-output\\FailTestScreenShot"+testID+dtf+date+"jpej");
		FileHandler.copy(src, dest);
	}

	public static String getExelData(String Sheet, int row , int cell ) throws EncryptedDocumentException, IOException{
		String path ="src/main/resources/data/Haldiram.xlsx";
		FileInputStream file = new FileInputStream(path);
		 Workbook book = WorkbookFactory.create(file);
		 Sheet sheet =book.getSheet("haldiram");
		 Row row = sheet.getRow(0);
		 Cell cell =row.getCell(0);
		 try {
		 String data = cell.getStringCellValue();
		 }
		 catch(IllegalStateException e) {
			 double value = cell.getNumericCellValue();
			 String data = String.valueOf(cell.getNumericCellValue());
			 return data;
		 }
		
	}		 	
}

     
	
	


